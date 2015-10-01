
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Escol {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Escol(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select TNESC, INESC, TEESC, ACESC, CEESC, ESESC, PAESC, OBESC, STESC, FEESC, USESC"
                    + "   from ESCOL30 where NTESC = "+numActual+" and STESC = 'SI' order by TNESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[11];
                for(int i=0; i<11; i++){
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
            String sql="select NIEST from ESTUD10 where STEST = 'SI' order by OREST";
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
    
    public void LlenarEspec(JComboBox Listaespec){
        try{
            String sql="select NOESP from ESPEC05 where STESP = 'SI' order by NOESP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaespec.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarSino(JComboBox Listasino){
        try{
            String sql="select CVSIN from SI_NO13";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasino.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void Agregar(Integer numtra, String tipo, String finicio, String ftermino, Float años, String certificado, String espec,
                        String path, String observa, String usuario){
        try{
           String sql="execute AgregarEscol ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, tipo);
           cmd.setString(3, finicio);
           cmd.setString(4, ftermino);
           cmd.setFloat(5, años);
           cmd.setString(6, certificado);
           cmd.setString(7, espec);
           cmd.setString(8, path);
           cmd.setString(9, observa);
           cmd.setString(10, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numtra, String tipo, String finicio, String ftermino, Float años, String certificado, String espec,
                        String path, String observa, String usuario){
        try{
           String sql="execute ActualizarEscol ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, tipo);
           cmd.setString(3, finicio);
           cmd.setString(4, ftermino);
           cmd.setFloat(5, años);
           cmd.setString(6, certificado);
           cmd.setString(7, espec);
           cmd.setString(8, path);
           cmd.setString(9, observa);
           cmd.setString(10, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numtra, String tipo, String usuario){
        try{
            String sql= "update ESCOL30 set STESC='NO',FEESC=getdate(), USESC='"+usuario+"' "
                    + "   where NTESC="+numtra+" and TNESC = '"+tipo+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
}