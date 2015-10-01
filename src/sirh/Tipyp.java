
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Tipyp {
    Connection cn;

    public Tipyp(){
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
            String sql="select * from TIPYP20 where STPYP = 'SI' order by NOPYP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[6];
                for(int i=0; i<6; i++){
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

    public void Agregar(String nombre, String clave, String empresa, String usuario){
        try{
           String sql="execute AgregarTipyp ?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nombre);
           cmd.setString(2, clave);
           cmd.setString(3, empresa);
           cmd.setString(4, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String nombre, String clave, String empresa, String usuario){
        try{
           String sql="execute ActualizarTipyp ?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, nombre);
           cmd.setString(2, clave);
           cmd.setString(3, empresa);
           cmd.setString(4, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String razon, String usuario){
        try{
            String sql= "update TIPYP20 set STPYP='NO',FEPYP=getdate(), USPYP='"+usuario+"' where NOPYP='"+razon+"'";
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
            String sql="select * from TIPYP20 where NOPYP like '%"+palabraactual+"%' and STPYP = 'SI' order by NOPYP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[6];
                for(int i=0; i<6; i++){
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
