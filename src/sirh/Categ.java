
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Categ {
    Connection cn;

    public Categ(){
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
            String sql="select * from CATEG01 where STCAT = 'SI' order by CVCAT";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[9];
                for(int i=0; i<9; i++){
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

    public void Agregar(String categoria, String cveempresa, String empresa, String codigo, Float sueldo, String descripcion, String usuario){
        try{
           String sql="execute AgregarCateg ?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, categoria);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, codigo);
           cmd.setFloat(5, sueldo);
           cmd.setString(6, descripcion);
           cmd.setString(7, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String categoria, String cveempresa, String empresa, String codigo, Float sueldo, String descripcion, String usuario){
        try{
           String sql="execute ActualizarCateg ?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, categoria);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, codigo);
           cmd.setFloat(5, sueldo);
           cmd.setString(6, descripcion);
           cmd.setString(7, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String categoria, String usuario){
        try{
            String sql= "update CATEG01 set STCAT='NO',FECAT=getdate(), STCAT='"+usuario+"' where CVCAT='"+categoria+"'";
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
            String sql="select * from CATEG01 where NOCAT like '%"+palabraactual+"%' and STCAT = 'SI' order by CVCAT";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[9];
                for(int i=0; i<9; i++){
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
