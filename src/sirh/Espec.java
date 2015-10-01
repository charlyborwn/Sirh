
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Espec {
    Connection cn;

    
    public Espec(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from ESPEC05 where STESP = 'SI' order by NOESP";
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

    public void Agregar(String espec, String usuario){
        try{
           String sql="execute AgregarEspec ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, espec);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String espec, String usuario){
        try{
           String sql="execute ActualizarEspec ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, espec);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }
    
    public void Eliminar(String espec, String usuario){
        try{
            String sql= "update ESPEC05 set STESP='NO',FEESP=getdate(), USESP='"+usuario+"' where NOESP='"+espec+"'";
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
            String sql="select * from ESPEC05 where NOESP like '%"+palabraactual+"%' and STESP = 'SI' order by NOESP";
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


