
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Ticon {
    Connection cn;

    public Ticon(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from TICON17 where STTIC = 'SI' order by CVTIC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[5];
                for(int i=0; i<5; i++){
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

    public void Agregar(String clave, String descripcion, String usuario){
        try{
           String sql="execute AgregarTicon ?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, descripcion);
           cmd.setString(3, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String clave, String descripcion, String usuario){
        try{
           String sql="execute ActualizarTicon ?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, descripcion);
           cmd.setString(3, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String clave, String usuario){
        try{
            String sql= "update TICON17 set STTIC='NO',FETIC=getdate(), USTIC='"+usuario+"' where CVTIC='"+clave+"'";
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
            String sql="select * from TICON17 where NOTIC like '%"+palabraactual+"%' and STTIC = 'SI' order by CVTIC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[5];
                for(int i=0; i<5; i++){
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
