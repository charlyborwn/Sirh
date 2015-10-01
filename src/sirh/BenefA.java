
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class BenefA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public BenefA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TPBEN_A, APBEN_A, AMBEN_A, NOBEN_A, FNBEN_A, SEBEN_A, POBEN_A, OBBEN_A, STBEN_A, FEBEN_A, USBEN_A"
                    + "   from BENEF26A where RFBEN_A = '"+rfcActual+"' and STBEN_A = 'SI' order by TPBEN_A";
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
            String sql="select NOTIP from TIPAR19 where STTIP = 'SI' order by NOTIP";
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
    
    public void LlenarSexo(JComboBox Listacausa){
        try{
            String sql="select NOSEX from SEXOO12 where STSEX = 'SI' order by NOSEX";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacausa.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void Agregar(String rfc, String tipo, String paterno, String materno, String nombre, String fnac, 
                        String sexo, Float porcentaje, String observa, String usuario){
        try{
           String sql="execute AgregarBenefA ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, tipo);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, fnac);
           cmd.setString(7, sexo);
           cmd.setFloat(8, porcentaje);
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
    
    public void Actualizar(String rfc, String tipo, String paterno, String materno, String nombre, String fnac, 
                        String sexo, Float porcentaje, String observa, String usuario){
        try{
           String sql="execute ActualizarBenefA ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, tipo);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, fnac);
           cmd.setString(7, sexo);
           cmd.setFloat(8, porcentaje);
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
    
    public void Eliminar(String rfc, String paterno, String materno, String nombre, String usuario){
        try{
            String sql= "update BENEF26A set STBEN_A='NO',FEBEN_A=getdate(), USBEN_A= '"+usuario+"' "
                    + "   where RFBEN_A='"+rfc+"' and APBEN_A = '"+paterno+"' and AMBEN_A = '"+materno+"' and NOBEN_A = '"+nombre+"'";
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
