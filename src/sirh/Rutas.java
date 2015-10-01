
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Rutas {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Rutas(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select NURUT, CERUT, NERUT, LORUT, LDRUT, PARUT, OBRUT, STRUT, FERUT, USRUT "
                    + "   from RUTAS41 where STRUT = 'SI' order by NURUT";
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
    
    public void Agregar(String numrut, String cveemp, String nomemp, String lugori, String lugdes, String path, String observa, String usuario){
        try{
           String sql="execute AgregarRutas ?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numrut);
           cmd.setString(2, cveemp);
           cmd.setString(3, nomemp);
           cmd.setString(4, lugori);
           cmd.setString(5, lugdes);
           cmd.setString(6, path);
           cmd.setString(7, observa);
           cmd.setString(8, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String numrut, String cveemp, String nomemp, String lugori, String lugdes, String path, String observa, String usuario){
        try{
           String sql="execute ActualizarRutas ?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numrut);
           cmd.setString(2, cveemp);
           cmd.setString(3, nomemp);
           cmd.setString(4, lugori);
           cmd.setString(5, lugdes);
           cmd.setString(6, path);
           cmd.setString(7, observa);
           cmd.setString(8, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(String numrut, String cveemp, String nomemp, String usuario){
        try{
            String sql= "update RUTAS41 set STRUT='NO', FERUT=getdate(), USRUT='"+usuario+"' "
                    + "   where NURUT='"+numrut+"' and CERUT='"+cveemp+"' and NERUT='"+nomemp+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BusNumero(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NURUT, CERUT, NERUT, LORUT, LDRUT, PARUT, OBRUT, STRUT, FERUT, USRUT "
                    + "   from RUTAS41 where NURUT like '%"+palabraactual+"%' and STRUT = 'SI' order by NURUT";
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
    
    public void BusEmpresa(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NURUT, CERUT, NERUT, LORUT, LDRUT, PARUT, OBRUT, STRUT, FERUT, USRUT "
                    + "   from RUTAS41 where NERUT like '%"+palabraactual+"%' and STRUT = 'SI' order by NURUT";
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
    
    public void BusOrigen(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NURUT, CERUT, NERUT, LORUT, LDRUT, PARUT, OBRUT, STRUT, FERUT, USRUT "
                    + "   from RUTAS41 where LORUT like '%"+palabraactual+"%' and STRUT = 'SI' order by NURUT";
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
    
    public void BusDestino(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NURUT, CERUT, NERUT, LORUT, LDRUT, PARUT, OBRUT, STRUT, FERUT, USRUT "
                    + "   from RUTAS41 where LDRUT like '%"+palabraactual+"%' and STRUT = 'SI' order by NURUT";
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
    
}
