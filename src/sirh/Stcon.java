
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Stcon {
    Connection cn;

    public Stcon(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from STCON14 where STSTC = 'SI' order by DESTC";
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

    public void Agregar(String statuscontrato, String usuario){
        try{
           String sql="execute AgregarStcon ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, statuscontrato);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String statuscontrato, String usuario){
        try{
           String sql="execute ActualizarStcon ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, statuscontrato);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String statuscontrato, String usuario){
        try{
            String sql= "update STCON14 set STSTC='NO',FESTC=getdate(), USSTC='"+usuario+"' where DESTC='"+statuscontrato+"'";
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
            String sql="select * from STCON14 where DESTC like '%"+palabraactual+"%' and STSTC = 'SI' order by DESTC";
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
