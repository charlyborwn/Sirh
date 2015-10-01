
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Contr {
 
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
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    private static String rfcTrabaja;
    public static String getRfcTrabaja() {
        return rfcTrabaja;
    }

    public static void setRfcTrabaja(String aRfcTrabaja) {
        rfcTrabaja = aRfcTrabaja;
    }
    
    private static String patTrabaja;
    public static String getPatTrabaja() {
        return patTrabaja;
    }

    public static void setPatTrabaja(String aPatTrabaja) {
        patTrabaja = aPatTrabaja;
    }
    
    private static String stcTrabaja;
    public static String getStcTrabaja() {
        return stcTrabaja;
    }

    public static void setStcTrabaja(String aStcTrabaja) {
        stcTrabaja = aStcTrabaja;
    }
    
    private static String fesTrabaja;
    public static String getFesTrabaja() {
        return fesTrabaja;
    }

    public static void setFesTrabaja(String aFesTrabaja) {
        fesTrabaja = aFesTrabaja;
    }
    
    private static String ncoTrabaja;
    public static String getNcoTrabaja() {
        return ncoTrabaja;
    }

    public static void setNcoTrabaja(String aNcoTrabaja) {
        ncoTrabaja = aNcoTrabaja;
    }
    
    private static String cemTrabaja;
    public static String getCemTrabaja() {
        return cemTrabaja;
    }

    public static void setCemTrabaja(String aCemTrabaja) {
        cemTrabaja = aCemTrabaja;
    }
    
    private static String nemTrabaja;
    public static String getNemTrabaja() {
        return nemTrabaja;
    }

    public static void setNemTrabaja(String aNemTrabaja) {
        nemTrabaja = aNemTrabaja;
    }
    
    private static String cdeTrabaja;
    public static String getCdeTrabaja() {
        return cdeTrabaja;
    }

    public static void setCdeTrabaja(String aCdeTrabaja) {
        cdeTrabaja = aCdeTrabaja;
    }
    
    private static String ndeTrabaja;
    public static String getNdeTrabaja() {
        return ndeTrabaja;
    }

    public static void setNdeTrabaja(String aNdeTrabaja) {
        ndeTrabaja = aNdeTrabaja;
    }
    
    private static String cseTrabaja;
    public static String getCseTrabaja() {
        return cseTrabaja;
    }

    public static void setCseTrabaja(String aCseTrabaja) {
        cseTrabaja = aCseTrabaja;
    }
    
    private static String nseTrabaja;
    public static String getNseTrabaja() {
        return nseTrabaja;
    }

    public static void setNseTrabaja(String aNseTrabaja) {
        nseTrabaja = aNseTrabaja;
    }
    
    private static String ccaTrabaja;
    public static String getCcaTrabaja() {
        return ccaTrabaja;
    }

    public static void setCcaTrabaja(String aCcaTrabaja) {
        ccaTrabaja = aCcaTrabaja;
    }
    
    private static String ncaTrabaja;
    public static String getNcaTrabaja() {
        return ncaTrabaja;
    }

    public static void setNcaTrabaja(String aNcaTrabaja) {
        ncaTrabaja = aNcaTrabaja;
    }
    
    private static Float sxdTrabaja;
    public static Float getSxdTrabaja() {
        return sxdTrabaja;
    }

    public static void setSxdTrabaja(Float aSxdTrabaja) {
        sxdTrabaja = aSxdTrabaja;
    }
    
    private static String ctuTrabaja;
    public static String getCtuTrabaja() {
        return ctuTrabaja;
    }

    public static void setCtuTrabaja(String aCtuTrabaja) {
        ctuTrabaja = aCtuTrabaja;
    }
    
    private static String ntuTrabaja;
    public static String getNtuTrabaja() {
        return ntuTrabaja;
    }

    public static void setNtuTrabaja(String aNtuTrabaja) {
        ntuTrabaja = aNtuTrabaja;
    }
    
    private static String ctiTrabaja;
    public static String getCtiTrabaja() {
        return ctiTrabaja;
    }

    public static void setCtiTrabaja(String aCtiTrabaja) {
        ctiTrabaja = aCtiTrabaja;
    }
    
    private static String ntiTrabaja;
    public static String getNtiTrabaja() {
        return ntiTrabaja;
    }

    public static void setNtiTrabaja(String aNtiTrabaja) {
        ntiTrabaja = aNtiTrabaja;
    }
    
    private static String finTrabaja;
    public static String getFinTrabaja() {
        return finTrabaja;
    }

    public static void setFinTrabaja(String aFinTrabaja) {
        finTrabaja = aFinTrabaja;
    }
    
    private static String fteTrabaja;
    public static String getFteTrabaja() {
        return fteTrabaja;
    }

    public static void setFteTrabaja(String aFteTrabaja) {
        fteTrabaja = aFteTrabaja;
    }
    
    Connection cn;
    
    public Contr(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public Object[] Datos(Integer traactual){
        Object[] datos=new Object[6];
        try{
            String sql="select NUTRA, NOTRA+' '+APTRA+' '+AMTRA, RFTRA, SSTRA, FSTRA, PATRA "
                    + "   from TRABA36"
                    + "  where NUTRA = "+traactual+" and STTRA='SI'";
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
    
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select NUCTO, SSCTO, NECTO, NOCTO, NSCTO, CACTO, TTCTO, NCCTO, INCTO, TECTO"
                    + "   from CONTR27 where NTCTO = "+numActual+" and STCTO = 'SI' order by NUCTO DESC";
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
    
    public Object[] Comple(Integer numActual, String conActual){
        Object[] datos1=new Object[15];
        try{
            String sql="select FSCTO, CVCTO, NDCTO, CSCTO, CCCTO, SXCTO, TUCTO, TCCTO, SCCTO, SPCTO, PACTO, OBCTO, STCTO, FECTO, USCTO"
                    + "   from CONTR27"
                    + "  where NTCTO = "+numActual+" "
                    + "    and NUCTO = '"+conActual+"' "
                    + "    and STCTO = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<15; i++){
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
    
    public void LlenarStacon(JComboBox Listastacon){
        try{
            String sql="select DESTC from STCON14 where STSTC = 'SI' order by DESTC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listastacon.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarEmpresa(JComboBox Listaempresa){
        try{
            String sql="select CVEMP from EMPRE04 where STEMP = 'SI' order by CVEMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaempresa.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarDepartamento(JComboBox Listadepartamento){
        try{
            String sql="select NUDEP from DEPAR03 where STDEP = 'SI' order by NUDEP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listadepartamento.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarCategoria(JComboBox Listacategoria){
        try{
            String sql="select CVCAT from CATEG01 where STCAT = 'SI' order by CVCAT";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacategoria.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarTurno(JComboBox Listaturno){
        try{
            String sql="select CVTUR from TURNO22 where STTUR = 'SI' order by CVTUR";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaturno.addItem(rs.getString(i+1));
                }
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
            String sql="select CVTIC from TICON17 where STTIC = 'SI' order by CVTIC";
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
    
    public void LlenarSuper(JComboBox Listasuper){
        try{
            String sql="select NTCOM from COMIT08 where STCOM = 'SI' order by NTCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasuper.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Empresa(String clave2){
        Object[] datos2=new Object[1];
        try{
            String sql="select NOEMP from EMPRE04 where CVEMP='"+clave2+"' and STEMP='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos2[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos2;
    }
    
    public Object[] Depto(String clave3){
        Object[] datos3=new Object[3];
        try{
            String sql="select NODEP, CSDEP, NSDEP from DEPAR03 where NUDEP='"+clave3+"' and STDEP='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<3; i++){
                    datos3[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos3;
    }
    
    public Object[] Categ(String clave4){
        Object[] datos4=new Object[2];
        try{
            String sql="select NOCAT, SXCAT from CATEG01 where CVCAT='"+clave4+"' and STCAT='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<2; i++){
                    datos4[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos4;
    }
    
    public Object[] Turno(String clave5){
        Object[] datos5=new Object[1];
        try{
            String sql="select NOTUR from TURNO22 where CVTUR='"+clave5+"' and STTUR='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos5[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos5;
    }
    
    public Object[] Tipo(String clave6){
        Object[] datos6=new Object[1];
        try{
            String sql="select NOTIC from TICON17 where CVTIC='"+clave6+"' and STTIC='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos6[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos6;
    }
    
    public Object[] Super(String clave7){
        Object[] datos7=new Object[1];
        try{
            String sql="select NPCOM from COMIT08 where NTCOM='"+clave7+"' and STCOM='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos7[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos7;
    }

    public void Agregar(Integer numer, String nombre, String rfc, String sttra, String fsttra, String pathfoto, String stacon, String fstcon,
                        String numcon, String cveemp, String nomemp, String numdepto, String nomdepto, String cvesec, String nomsec,
                        String cvecat, String nomcat, Float sueldo, String cvetur, String nomtur, String cvecon, String nomcon, String feini,
                        String feter, String cvesuper, String nomsuper, String path, String observa, String usuario){
        try{
           String sql="execute AgregarContr ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numer);
           cmd.setString(2, nombre);
           cmd.setString(3, rfc);
           cmd.setString(4, sttra);
           cmd.setString(5, fsttra);
           cmd.setString(6, pathfoto);
           cmd.setString(7, stacon);
           cmd.setString(8, fstcon);
           cmd.setString(9, numcon);
           cmd.setString(10, cveemp);
           cmd.setString(11, nomemp);
           cmd.setString(12, numdepto);
           cmd.setString(13, nomdepto);
           cmd.setString(14, cvesec);
           cmd.setString(15, nomsec);
           cmd.setString(16, cvecat);
           cmd.setString(17, nomcat);
           cmd.setFloat(18, sueldo);
           cmd.setString(19, cvetur);
           cmd.setString(20, nomtur);
           cmd.setString(21, cvecon);
           cmd.setString(22, nomcon);
           cmd.setString(23, feini);
           cmd.setString(24, feter);
           cmd.setString(25, cvesuper);
           cmd.setString(26, nomsuper);
           cmd.setString(27, path);
           cmd.setString(28, observa);
           cmd.setString(29, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numer, String nombre, String rfc, String sttra, String fsttra, String pathfoto, String stacon, String fstcon,
                        String numcon, String cveemp, String nomemp, String numdepto, String nomdepto, String cvesec, String nomsec,
                        String cvecat, String nomcat, Float sueldo, String cvetur, String nomtur, String cvecon, String nomcon, String feini,
                        String feter, String cvesuper, String nomsuper, String path, String observa, String usuario){
        try{
           String sql="execute ActualizarContr ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numer);
           cmd.setString(2, nombre);
           cmd.setString(3, rfc);
           cmd.setString(4, sttra);
           cmd.setString(5, fsttra);
           cmd.setString(6, pathfoto);
           cmd.setString(7, stacon);
           cmd.setString(8, fstcon);
           cmd.setString(9, numcon);
           cmd.setString(10, cveemp);
           cmd.setString(11, nomemp);
           cmd.setString(12, numdepto);
           cmd.setString(13, nomdepto);
           cmd.setString(14, cvesec);
           cmd.setString(15, nomsec);
           cmd.setString(16, cvecat);
           cmd.setString(17, nomcat);
           cmd.setFloat(18, sueldo);
           cmd.setString(19, cvetur);
           cmd.setString(20, nomtur);
           cmd.setString(21, cvecon);
           cmd.setString(22, nomcon);
           cmd.setString(23, feini);
           cmd.setString(24, feter);
           cmd.setString(25, cvesuper);
           cmd.setString(26, nomsuper);
           cmd.setString(27, path);
           cmd.setString(28, observa);
           cmd.setString(29, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numer, String numcon, String usuario){
        try{
            String sql= "update CONTR27 set STCTO='NO', FECTO=getdate(), USCTO='"+usuario+"' "
                    + "   where NTCTO="+numer+" and NUCTO='"+numcon+"'";
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
