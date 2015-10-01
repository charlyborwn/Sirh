
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Estud {
    Connection cn;

    public Estud(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from ESTUD10 where STEST = 'SI' order by OREST";
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

    public void Agregar(String nivel, Integer orden, String usuario){
        try{
           String sql="execute AgregarEstud ?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nivel);
           cmd.setInt(2, orden);
           cmd.setString(3, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String nivel, Integer orden, String usuario){
        try{
           String sql="execute ActualizarEstud ?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nivel);
           cmd.setInt(2, orden);
           cmd.setString(3, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String nivel, String usuario){
        try{
            String sql= "update ESTUD10 set STEST='NO',FEEST=getdate(), USEST='"+usuario+"' where NIEST='"+nivel+"'";
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
            String sql="select * from ESTUD10 where NIEST like '%"+palabraactual+"%' and STEST = 'SI' order by OREST";
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
