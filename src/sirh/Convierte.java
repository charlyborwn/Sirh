
package sirh;

import java.sql.*;
import javax.swing.JComboBox;

public class Convierte {
    Connection cn;

    public Convierte(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarRfc(JComboBox Listarfc){
        try{
            String sql="select RFTRA_A from TRABA36A where STTRA_A = 'SI' order by RFTRA_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listarfc.addItem(rs.getString(i+1));
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
        Object[] datos=new Object[6];
        try{
            String sql="select NOTRA_A+' '+APTRA_A+' '+AMTRA_A, CUTRA_A, FNTRA_A, SETRA_A, NATRA_A, PATRA_A"
                    + "   from TRABA36A "
                    + "  where RFTRA_A='"+clave+"' and STTRA_A='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<6; i++){
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
    
    public Object[] Verifica(Integer clave){
        Object[] datos1=new Object[1];
        try{
            String sql="select NUTRA from TRABA36 where NUTRA="+clave+" and STTRA='SI'";
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
    
    public void CambTraba(Integer numtra, String rfc, String fingreso, String hoy, String usuario){
        try{
            String sql= "INSERT INTO TRABA36 "
                    +  "(NUTRA, RFTRA, CUTRA, SSTRA, FSTRA, APTRA, AMTRA, NOTRA, PATRA, "
                    +  " FNTRA, SETRA, NATRA, FITRA, FPTRA, FUTRA, FRTRA, "
                    +  " OBTRA, STTRA, FETRA, USTRA) "
                    +  " SELECT "+numtra+", RFTRA_A, CUTRA_A, 'VIABLE', '"+hoy+"', APTRA_A, AMTRA_A, NOTRA_A, PATRA_A,"
                    +  "       FNTRA_A, SETRA_A, NATRA_A, '"+fingreso+"', '"+fingreso+"', '"+fingreso+"', '"+fingreso+"', "
                    +  "       OBTRA_A, STTRA_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM TRABA36A WHERE RFTRA_A = '"+rfc+"' AND STTRA_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrTraba(String rfc){
        try{
            String sql= "UPDATE TRABA36A set STTRA_A='NO' where RFTRA_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambDatos(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO DATOS28 "
                    +  "(NTDAT, CADAT, REDAT, NEDAT, NIDAT, CODAT, MDDAT, LODAT, CPDAT, "
                    + "  ESDAT, PADAT, TDDAT, TCDAT, CEDAT, MNDAT, LNDAT, ENDAT, PNDAT, "
                    + "  RGDAT, ECDAT, TSDAT, KGDAT, FKDAT, EMDAT, FMDAT, A1DAT, "
                    + "  A2DAT, CCDAT, VCDAT, PPDAT, VPDAT, ZADAT, VZDAT, R1DAT, PSDAT, "
                    + "  PFDAT, R2DAT, RSDAT, RADAT, STDAT, FEDAT, USDAT) "
                    + " SELECT "+numtra+", CADAT_A, REDAT_A, NEDAT_A, NIDAT_A, CODAT_A, MDDAT_A, LODAT_A, CPDAT_A, "
                    + "        ESDAT_A, PADAT_A, TDDAT_A, TCDAT_A, CEDAT_A, MNDAT_A, LNDAT_A, ENDAT_A, PNDAT_A, "
                    + "        RGDAT_A, ECDAT_A, TSDAT_A, KGDAT_A, FKDAT_A, EMDAT_A, FMDAT_A, A1DAT_A, "
                    + "        A2DAT_A, CCDAT_A, 0, PPDAT_A, 0, ZADAT_A, 0, R1DAT_A, PSDAT_A, "
                    + "        PFDAT_A, R2DAT_A, RSDAT_A, RADAT_A, STDAT_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM DATOS28A WHERE RFDAT_A = '"+rfc+"' AND STDAT_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrDatos(String rfc){
        try{
            String sql= "UPDATE DATOS28A set STDAT_A='NO' where RFDAT_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambBenef(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO BENEF26 "
                    +  "(NTBEN, TPBEN, APBEN, AMBEN, NOBEN, FNBEN, "
                    + "  SEBEN, POBEN, OBBEN, STBEN, FEBEN, USBEN) "
                    + " SELECT "+numtra+", TPBEN_A, APBEN_A, AMBEN_A, NOBEN_A, FNBEN_A, "
                    + "        SEBEN_A, POBEN_A, OBBEN_A, STBEN_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM BENEF26A WHERE RFBEN_A = '"+rfc+"' AND STBEN_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrBenef(String rfc){
        try{
            String sql= "UPDATE BENEF26A set STBEN_A='NO' where RFBEN_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambDocum(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO DOCUM29 "
                    +  "(NTDOC, TDDOC, CADOC, DEDOC, INDOC, TEDOC, "
                    + "  PADOC, OBDOC, STDOC, FEDOC, USDOC) "
                    + " SELECT "+numtra+", TDDOC_A, CADOC_A, DEDOC_A, INDOC_A, TEDOC_A, "
                    + "        PADOC_A, OBDOC_A, STDOC_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM DOCUM29A WHERE RFDOC_A = '"+rfc+"' AND STDOC_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrDocum(String rfc){
        try{
            String sql= "UPDATE DOCUM29A set STDOC_A='NO' where RFDOC_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambEscol(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO ESCOL30 "
                    +  "(NTESC, TNESC, INESC, TEESC, ACESC, CEESC, "
                    + "  ESESC, PAESC, OBESC, STESC, FEESC, USESC) "
                    + " SELECT "+numtra+", TNESC_A, INESC_A, TEESC_A, ACESC_A, CEESC_A, "
                    + "        ESESC_A, PAESC_A, OBESC_A, STESC_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM ESCOL30A WHERE RFESC_A = '"+rfc+"' AND STESC_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrEscol(String rfc){
        try{
            String sql= "UPDATE ESCOL30A set STESC_A='NO' where RFESC_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambExper(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO EXPER31 "
                    +  "(NTEXP, INEXP, TEEXP, CSEXP, CEEXP, EMEXP, CAEXP, COEXP, MDEXP, "
                    + "  LOEXP, CPEXP, ESEXP, PAEXP, TDEXP, JIEXP, CJEXP, TCEXP, MAEXP, "
                    + "  PTEXP, OBEXP, STEXP, FEEXP, USEXP) "
                    + " SELECT "+numtra+", INEXP_A, TEEXP_A, CSEXP_A, CEEXP_A, EMEXP_A, CAEXP_A, COEXP_A, MDEXP_A, "
                    + "        LOEXP_A, CPEXP_A, ESEXP_A, PAEXP_A, TDEXP_A, JIEXP_A, CJEXP_A, TCEXP_A, MAEXP_A, "
                    + "        PTEXP_A, OBEXP_A, STEXP_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM EXPER31A WHERE RFEXP_A = '"+rfc+"' AND STEXP_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrExper(String rfc){
        try{
            String sql= "UPDATE EXPER31A set STEXP_A='NO' where RFEXP_A='"+rfc+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void CambFamil(Integer numtra, String rfc, String hoy, String usuario){
        try{
            String sql= "INSERT INTO FAMIL32 "
                    +  "(NTFAM, TPFAM, APFAM, AMFAM, NOFAM, VIFAM, SEFAM, FNFAM, OFFAM, "
                    + "  CAFAM, COFAM, MDFAM, LOFAM, CPFAM, ESFAM, PAFAM, TDFAM, TCFAM, "
                    + "  CEFAM, TIFAM, PTFAM, OBFAM, STFAM, FEFAM, USFAM) "
                    + " SELECT "+numtra+", TPFAM_A, APFAM_A, AMFAM_A, NOFAM_A, VIFAM_A, SEFAM_A, FNFAM_A, OFFAM_A, "
                    + "        CAFAM_A, COFAM_A, MDFAM_A, LOFAM_A, CPFAM_A, ESFAM_A, PAFAM_A, TDFAM_A, TCFAM_A, "
                    + "        CEFAM_A, TIFAM_A, PTFAM_A, OBFAM_A, STFAM_A, '"+hoy+"', '"+usuario+"' "
                    +  "   FROM FAMIL32A WHERE RFFAM_A = '"+rfc+"' AND STFAM_A = 'SI'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BorrFamil(String rfc){
        try{
            String sql= "UPDATE FAMIL32A set STFAM_A='NO' where RFFAM_A='"+rfc+"'";
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
