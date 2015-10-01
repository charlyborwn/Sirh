
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Tidoc {
    Connection cn;

    public Tidoc(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from TIDOC18 where STTID = 'SI' order by NOTID";
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

    public void Agregar(String descripcion, String usuario){
        try{
           String sql="execute AgregarTidoc ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, descripcion);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String descripcion, String usuario){
        try{
           String sql="execute ActualizarTidoc ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, descripcion);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String descripcion, String usuario){
        try{
            String sql= "update TIDOC18 set STTID='NO',FETID=getdate(), USTID='"+usuario+"' where NOTID='"+descripcion+"'";
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
            String sql="select * from TIDOC18 where NOTID like '%"+palabraactual+"%' and STTID = 'SI' order by NOTID";
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
