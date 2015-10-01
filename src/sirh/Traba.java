
package sirh;

import java.sql.*;
import javax.swing.JComboBox;

public class Traba {
    
    private static Integer numTrabaja;
    public static Integer getNumTrabaja() {
        return numTrabaja;
    }

    public static void setNumTrabaja(Integer aNumTrabaja) {
        numTrabaja = aNumTrabaja;
    }
    
    private static String nomTrabaja;
    public static String getNomTrabaja() {
        return nomTrabaja;
    }

    public static void setNomTrabaja(String aNomTrabaja) {
        nomTrabaja = aNomTrabaja;
    }
    
    Connection cn;

    public Traba(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarStatus(JComboBox Listastatus){
        try{
            String sql="select DESTR from STRAB15 where STSTR = 'SI' order by DESTR";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listastatus.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
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
    
    public Object[] Datos(Integer traactual){
        Object[] datos=new Object[19];
        try{
            String sql="select NUTRA, RFTRA, CUTRA, SSTRA, FSTRA, APTRA, AMTRA, NOTRA, PATRA, FNTRA, "
                    + "        SETRA, NATRA, FITRA, FPTRA, FUTRA, FRTRA, OBTRA, FETRA, USTRA"
                    + "   from TRABA36"
                    + "  where NUTRA = "+traactual+" and STTRA='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<19; i++){
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
    
    public void Agregar(Integer numtra, String rfc, String curp, String statra, String fsta, String paterno, String materno, String nombre,
                        String path, String nacim, String sexo, String nacion, String fing, String fpla, String fult, String frei, 
                        String observa, String usuario){
        try{
           String sql="execute AgregarTraba ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, rfc);
           cmd.setString(3, curp);
           cmd.setString(4, statra);
           cmd.setString(5, fsta);
           cmd.setString(6, paterno);
           cmd.setString(7, materno);
           cmd.setString(8, nombre);
           cmd.setString(9, path);
           cmd.setString(10, nacim);
           cmd.setString(11, sexo);
           cmd.setString(12, nacion);
           cmd.setString(13, fing);
           cmd.setString(14, fpla);
           cmd.setString(15, fult);
           cmd.setString(16, frei);
           cmd.setString(17, observa);
           cmd.setString(18, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(Integer numtra, String rfc, String curp, String statra, String fsta, String paterno, String materno, String nombre,
                           String path, String nacim, String sexo, String nacion, String fing, String fpla, String fult, String frei, 
                           String observa, String usuario){
        try{
           String sql="execute ActualizarTraba ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, rfc);
           cmd.setString(3, curp);
           cmd.setString(4, statra);
           cmd.setString(5, fsta);
           cmd.setString(6, paterno);
           cmd.setString(7, materno);
           cmd.setString(8, nombre);
           cmd.setString(9, path);
           cmd.setString(10, nacim);
           cmd.setString(11, sexo);
           cmd.setString(12, nacion);
           cmd.setString(13, fing);
           cmd.setString(14, fpla);
           cmd.setString(15, fult);
           cmd.setString(16, frei);
           cmd.setString(17, observa);
           cmd.setString(18, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar01(Integer numtra, String usuario){
        try{
            String sql= "update TRABA36 set STTRA='NO', FETRA=getdate(), USTRA='"+usuario+"' where NUTRA="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
        public void Eliminar02(Integer numtra, String usuario){
        try{
            String sql= "update BENEF26 set STBEN='NO', FEBEN=getdate(), USBEN='"+usuario+"' where NTBEN="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar03(Integer numtra, String usuario){
        try{
            String sql= "update DATOS28 set STDAT='NO', FEDAT=getdate(), USDAT='"+usuario+"' where NTDAT="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar04(Integer numtra, String usuario){
        try{
            String sql= "update DOCUM29 set STDOC='NO', FEDOC=getdate(), USDOC='"+usuario+"' where NTDOC="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar05(Integer numtra, String usuario){
        try{
            String sql= "update ESCOL30 set STESC='NO', FEESC=getdate(), USESC='"+usuario+"' where NTESC="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar06(Integer numtra, String usuario){
        try{
            String sql= "update EXPER31 set STEXP='NO', FEEXP=getdate(), USEXP='"+usuario+"' where NTEXP="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar07(Integer numtra, String usuario){
        try{
            String sql= "update FAMIL32 set STFAM='NO', FEFAM=getdate(), USFAM='"+usuario+"' where NTFAM="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar08(Integer numtra, String usuario){
        try{
            String sql= "update APRIV25 set STAPR='NO', FEAPR=getdate(), USAPR='"+usuario+"' where NTAPR="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar09(Integer numtra, String usuario){
        try{
            String sql= "update CONTR27 set STCTO='NO', FECTO=getdate(), USCTO='"+usuario+"' where NTCTO="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar10(Integer numtra, String usuario){
        try{
            String sql= "update PRYPR34 set STPRY='NO', FEPRY=getdate(), USPRY='"+usuario+"' where NTPRY="+numtra+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar11(Integer numtra, String usuario){
        try{
            String sql= "update SANCI35 set STSAN='NO', FESAN=getdate(), USSAN='"+usuario+"' where NTSAN="+numtra+" ";
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
