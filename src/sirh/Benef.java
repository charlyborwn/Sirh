
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Benef {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Benef(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select TPBEN, APBEN, AMBEN, NOBEN, FNBEN, SEBEN, POBEN, OBBEN, STBEN, FEBEN, USBEN"
                    + "   from BENEF26 where NTBEN = "+numActual+" and STBEN = 'SI' order by TPBEN";
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
    
    public void Agregar(Integer numtra, String tipo, String paterno, String materno, String nombre, String fnac, 
                        String sexo, Float porcentaje, String observa, String usuario){
        try{
           String sql="execute AgregarBenef ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
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
    
    public void Actualizar(Integer numtra, String tipo, String paterno, String materno, String nombre, String fnac, 
                        String sexo, Float porcentaje, String observa, String usuario){
        try{
           String sql="execute ActualizarBenef ?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
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
    
    public void Eliminar(Integer numtra, String paterno, String materno, String nombre, String usuario){
        try{
            String sql= "update BENEF26 set STBEN='NO',FEBEN=getdate(), USBEN= '"+usuario+"' "
                    + "   where NTBEN="+numtra+" and APBEN = '"+paterno+"' and AMBEN = '"+materno+"' and NOBEN = '"+nombre+"'";
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
