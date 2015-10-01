
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Tapri {
    Connection cn;

    public Tapri(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from TAPRI16 where STTAP = 'SI' order by DETAP";
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
           String sql="execute AgregarTapri ?,?";
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
           String sql="execute ActualizarTapri ?,?";
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
            String sql= "update TAPRI16 set STTAP='NO',FETAP=getdate(), USTAP='"+usuario+"' where DETAP='"+descripcion+"'";
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
            String sql="select * from TAPRI16 where DETAP like '%"+palabraactual+"%' and STTAP = 'SI' order by DETAP";
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
