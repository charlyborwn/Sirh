
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Tiinf {
    Connection cn;

    public Tiinf(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from TIINF38 where STTIN = 'SI' order by DETIN";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
                    datos[i]=rs.getString(i+1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void Agregar(String tipo, String usuario){
        try{
           String sql="execute AgregarTiinf ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, tipo);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String tipo, String usuario){
        try{
           String sql="execute ActualizarTiinf ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, tipo);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String tipo, String usuario){
        try{
            String sql= "update TIINF38 set STTIN='NO', FETIN=getdate(), USTIN='"+usuario+"' where DETIN='"+tipo+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }

    public void Busqueda(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select * from TIINF38 where DETIN like '%"+palabraactual+"%' and STTIN = 'SI' order by DETIN";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
                    datos[i]=rs.getString(i+1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}


