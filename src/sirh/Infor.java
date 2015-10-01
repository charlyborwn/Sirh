
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Infor {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;

    public Infor(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from INFOR39 where STINF = 'SI' order by FIINF DESC";
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
    
    public void LlenarTipo(JComboBox Listatipo){
        try{
            String sql="select DETIN from TIINF38 where STTIN = 'SI' order by DETIN";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listatipo.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarCveemp(JComboBox Listacveemp){
        try{
            String sql="select CVEMP from EMPRE04 where STEMP = 'SI' order by CVEMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveemp.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void Agregar(String tipo, String fecha, String clave, String empresa, String resumen, String path, String usuario){
        try{
           String sql="execute AgregarInfor ?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, tipo);
           cmd.setString(2, fecha);
           cmd.setString(3, clave);
           cmd.setString(4, empresa);
           cmd.setString(5, resumen);
           cmd.setString(6, path);
           cmd.setString(7, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String tipo, String fecha, String clave, String empresa, String resumen, String path, String usuario){
        try{
           String sql="execute ActualizarInfor ?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, tipo);
           cmd.setString(2, fecha);
           cmd.setString(3, clave);
           cmd.setString(4, empresa);
           cmd.setString(5, resumen);
           cmd.setString(6, path);
           cmd.setString(7, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String tipo, String fecha, String empresa, String usuario){
        try{
            String sql= "update INFOR39 set STINF='NO', FEINF=getdate(), USINF='"+usuario+"' "
                    + "   where TIINF='"+tipo+"' and FIINF='"+fecha+"' and CEINF='"+empresa+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
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
