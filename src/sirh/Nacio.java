
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Nacio {
    Connection cn;

    public Nacio(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from NACIO09 where STNAC = 'SI' order by NONAC";
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

    public void Agregar(String nacio, String usuario){
        try{
           String sql="execute AgregarNacio ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nacio);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String nacio, String usuario){
        try{
           String sql="execute ActualizarNacio ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nacio);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String nacio, String usuario){
        try{
            String sql= "update NACIO09 set STNAC='NO',FENAC=getdate(), USNAC='"+usuario+"' where NONAC='"+nacio+"'";
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
            String sql="select * from NACIO09 where NONAC like '%"+palabraactual+"%' and STNAC = 'SI' order by NONAC";
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
