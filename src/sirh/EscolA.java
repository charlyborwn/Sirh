
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class EscolA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public EscolA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TNESC_A, INESC_A, TEESC_A, ACESC_A, CEESC_A, ESESC_A, PAESC_A, OBESC_A, STESC_A, FEESC_A, USESC_A"
                    + "   from ESCOL30A where RFESC_A = '"+rfcActual+"' and STESC_A = 'SI' order by TNESC_A";
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
    
    public void Agregar(String rfc, String tipo, String finicio, String ftermino, Float años, String certificado, String espec,
                        String path, String observa, String usuario){
        try{
           String sql="execute AgregarEscolA ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
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
    
    public void Actualizar(String rfc, String tipo, String finicio, String ftermino, Float años, String certificado, String espec,
                        String path, String observa, String usuario){
        try{
           String sql="execute ActualizarEscolA ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
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
    
    public void Eliminar(String rfc, String tipo, String usuario){
        try{
            String sql= "update ESCOL30A set STESC_A='NO',FEESC_A=getdate(), USESC_A='"+usuario+"' "
                    + "   where RFESC_A='"+rfc+"' and TNESC_A = '"+tipo+"'";
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