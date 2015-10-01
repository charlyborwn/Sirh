
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Comit {
    Connection cn;

    public Comit(){
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

    public void LlenarTrabajador(JComboBox Listatrabajador){
        try{
            String sql="select NUTRA from TRABA36 where STTRA = 'SI' order by NUTRA";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listatrabajador.addItem(rs.getString(i+1));
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
            String sql="select * from COMIT08 where STCOM = 'SI' order by ORCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[14];
                for(int i=0; i<14; i++){
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

    public void Agregar(String clave, String cveempresa, String empresa, String nombre, int orden, int trabajador, String nomtra, String telof1, String telof2, String celular, String correo, String usuario){
        try{
           String sql="execute AgregarComit ?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, nombre);
           cmd.setInt(5, orden);
           cmd.setInt(6, trabajador);
           cmd.setString(7, nomtra);
           cmd.setString(8, telof1);
           cmd.setString(9, telof2);
           cmd.setString(10, celular);
           cmd.setString(11, correo);
           cmd.setString(12, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String clave, String cveempresa, String empresa, String nombre, int orden, int trabajador, String nomtra, String telof1, String telof2, String celular, String correo, String usuario){
        try{
           String sql="execute ActualizarComit ?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, cveempresa);
           cmd.setString(3, empresa);
           cmd.setString(4, nombre);
           cmd.setInt(5, orden);
           cmd.setInt(6, trabajador);
           cmd.setString(7, nomtra);
           cmd.setString(8, telof1);
           cmd.setString(9, telof2);
           cmd.setString(10, celular);
           cmd.setString(11, correo);
           cmd.setString(12, usuario);
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
            String sql= "update COMIT08 set STCOM='NO', FECOM=getdate(), STCOM= '"+usuario+"' where CVCOM='"+clave+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }

    public void BusquedaPersona(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select * from COMIT08 where NPCOM like '%"+palabraactual+"%' and STCOM = 'SI' order by ORCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[14];
                for(int i=0; i<14; i++){
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

    public void BusquedaCargo(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select * from COMIT08 where NCCOM like '%"+palabraactual+"%' and STCOM = 'SI' order by ORCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[14];
                for(int i=0; i<14; i++){
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

    public void BusquedaEmpresa(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select * from COMIT08 where NOCOM like '%"+palabraactual+"%' and STCOM = 'SI' order by ORCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[14];
                for(int i=0; i<14; i++){
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
    
    public Object[] Datos1(String trabaja){
        Object[] datos1=new Object[1];
        try{
            String sql="select NOTRA+' '+APTRA+' '+AMTRA from TRABA36 where NUTRA="+trabaja+"";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos1[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos1;
    }
}
