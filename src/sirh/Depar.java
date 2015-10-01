
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Depar {
    Connection cn;

    public Depar(){
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
            String sql="select * from DEPAR03 where STDEP = 'SI' order by NUDEP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[12];
                for(int i=0; i<12; i++){
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

    public void Agregar(String numero, String cveempresa, String empresa, String codigo, String nombre, String seccion, String codseccion, String subseccion, String nomseccion, String usuario){
        try{
           String sql="execute AgregarDepar ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numero);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, codigo);
           cmd.setString(5, nombre);
           cmd.setString(6, seccion);
           cmd.setString(7, codseccion);
           cmd.setString(8, subseccion);
           cmd.setString(9, nomseccion);
           cmd.setString(10, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String numero, String cveempresa, String empresa, String codigo, String nombre, String seccion, String codseccion, String subseccion, String nomseccion, String usuario){
        try{
           String sql="execute ActualizarDepar ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numero);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, codigo);
           cmd.setString(5, nombre);
           cmd.setString(6, seccion);
           cmd.setString(7, codseccion);
           cmd.setString(8, subseccion);
           cmd.setString(9, nomseccion);
           cmd.setString(10, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String numero, String usuario){
        try{
            String sql= "update DEPAR03 set STDEP='NO',FEDEP=getdate(), USDEP='"+usuario+"' where NUDEP='"+numero+"'";
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
            String sql="select * from DEPAR03 where NODEP like '%"+palabraactual+"%' and STDEP = 'SI' order by NODEP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[12];
                for(int i=0; i<12; i++){
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
