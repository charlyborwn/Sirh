
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Usuar {
    Connection cn;

    public Usuar(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarCveempresa(JComboBox Listacveempresa){
        try{
            String sql="select CVEMP from EMPRE04 where STEMP = 'SI' order by CVEMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveempresa.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from USUAR24 where STUSU = 'SI' order by NOUSU";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[10];
                for(int i=0; i<10; i++){
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

    public void Agregar(String clave, String nombre, String pass, String cveempresa, String empresa, String grupo, String nivel, String usuario){
        try{
           String sql="execute AgregarUsuar ?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, nombre);
           cmd.setString(3, pass);
           cmd.setString(4, cveempresa);
           cmd.setString(5, empresa);
           cmd.setString(6, grupo);
           cmd.setString(7, nivel);
           cmd.setString(8, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String clave, String nombre, String pass, String cveempresa, String empresa, String grupo, String nivel, String usuario){
        try{
           String sql="execute ActualizarUsuar ?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, nombre);
           cmd.setString(3, pass);
           cmd.setString(4, cveempresa);
           cmd.setString(5, empresa);
           cmd.setString(6, grupo);
           cmd.setString(7, nivel);
           cmd.setString(8, usuario);
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
            String sql= "update USUAR24 set STUSU='NO',FEUSU=getdate(), USUSU='"+usuario+"' where CVUSU='"+clave+"'";
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
            String sql="select * from USUAR24 where NOUSU like '%"+palabraactual+"%' and STUSU = 'SI' order by NOUSU";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[10];
                for(int i=0; i<10; i++){
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
    
    public Object[] Datos(String clave){
        Object[] datos=new Object[1];
        try{
            String sql="select NOEMP from EMPRE04 where CVEMP='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos;
    }
}
