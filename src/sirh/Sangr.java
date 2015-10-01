
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Sangr {
    Connection cn;

    public Sangr(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from SANGR21 where STSAN = 'SI' order by CVSAN";
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

    public void Agregar(String sangre, String usuario){
        try{
           String sql="execute AgregarSangr ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, sangre);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String sangre, String usuario){
        try{
           String sql="execute ActualizarSangr ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, sangre);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String sangre, String usuario){
        try{
            String sql= "update SANGR21 set STSAN='NO',FESAN=getdate(), USSAN='"+usuario+"' where CVSAN='"+sangre+"'";
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
            String sql="select * from SANGR21 where CVSAN like '%"+palabraactual+"%' and STSAN = 'SI' order by CVSAN";
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
