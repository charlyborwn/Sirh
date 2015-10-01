
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Strab {
    Connection cn;

    public Strab(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from STRAB15 where STSTR = 'SI' order by DESTR";
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

    public void Agregar(String statustrabajador, String usuario){
        try{
           String sql="execute AgregarStrab ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, statustrabajador);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String statustrabajador, String usuario){
        try{
           String sql="execute ActualizarStrab ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, statustrabajador);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String statustrabajador, String usuario){
        try{
            String sql= "update STRAB15 set STSTR='NO',FESTR=getdate(), USSTR='"+usuario+"' where DESTR='"+statustrabajador+"'";
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
            String sql="select * from STRAB15 where DESTR like '%"+palabraactual+"%' and STSTR = 'SI' order by DESTR";
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
