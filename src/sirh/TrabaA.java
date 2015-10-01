
package sirh;

import java.sql.*;
import javax.swing.JComboBox;

public class TrabaA {
    
    private static String rfcUsuario;
    public static String getRfcUsuario() {
        return rfcUsuario;
    }

    public static void setRfcUsuario(String aRfcUsuario) {
        rfcUsuario = aRfcUsuario;
    }
    
    private static String nomTrabaja;
    public static String getNomTrabaja() {
        return nomTrabaja;
    }

    public static void setNomTrabaja(String aNomTrabaja) {
        nomTrabaja = aNomTrabaja;
    }
    
    Connection cn;

    public TrabaA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    
    public void LlenarSexo(JComboBox Listasexo){
        try{
            String sql="select NOSEX from SEXOO12 where STSEX = 'SI' order by NOSEX";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasexo.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarNacion(JComboBox Listanacion){
        try{
            String sql="select NONAC from NACIO09 where STNAC = 'SI' order by NONAC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listanacion.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos(String rfcactual){
        Object[] datos=new Object[12];
        try{
            String sql="select RFTRA_A, CUTRA_A, APTRA_A, AMTRA_A, NOTRA_A, PATRA_A,"
                    + "        FNTRA_A, SETRA_A, NATRA_A, OBTRA_A, FETRA_A, USTRA_A"
                    + "   from TRABA36A"
                    + "  where RFTRA_A = '"+rfcactual+"' and STTRA_A='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<12; i++){
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
    
    public void Agregar(String rfc, String curp, String paterno, String materno, String nombre, String path, String nacim, String sexo, String nacion, String observa, String usuario){
        try{
           String sql="execute AgregarTrabaA ?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, curp);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, path);
           cmd.setString(7, nacim);
           cmd.setString(8, sexo);
           cmd.setString(9, nacion);
           cmd.setString(10, observa);
           cmd.setString(11, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String rfc, String curp, String paterno, String materno, String nombre, String path, String nacim, String sexo, String nacion, String observa, String usuario){
        try{
           String sql="execute ActualizarTrabaA ?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, curp);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, path);
           cmd.setString(7, nacim);
           cmd.setString(8, sexo);
           cmd.setString(9, nacion);
           cmd.setString(10, observa);
           cmd.setString(11, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }
    
    public void Eliminar01(String rfc, String usuario){
        try{
            String sql= "update TRABA36A set STTRA_A='NO', FETRA_A=getdate(), USTRA_A='"+usuario+"' where RFTRA_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
        public void Eliminar02(String rfc, String usuario){
        try{
            String sql= "update BENEF26A set STBEN_A='NO', FEBEN_A=getdate(), USBEN_A='"+usuario+"' where RFBEN_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar03(String rfc, String usuario){
        try{
            String sql= "update DATOS28A set STDAT_A='NO', FEDAT_A=getdate(), USDAT_A='"+usuario+"' where RFDAT_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar04(String rfc, String usuario){
        try{
            String sql= "update DOCUM29A set STDOC_A='NO', FEDOC_A=getdate(), USDOC_A='"+usuario+"' where RFDOC_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar05(String rfc, String usuario){
        try{
            String sql= "update ESCOL30A set STESC_A='NO', FEESC_A=getdate(), USESC_A='"+usuario+"' where RFESC_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar06(String rfc, String usuario){
        try{
            String sql= "update EXPER31A set STEXP_A='NO', FEEXP_A=getdate(), USEXP_A='"+usuario+"' where RFEXP_A="+rfc+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar07(String rfc, String usuario){
        try{
            String sql= "update FAMIL32A set STFAM_A='NO', FEFAM_A=getdate(), USFAM_A='"+usuario+"' where RFFAM_A="+rfc+" ";
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
