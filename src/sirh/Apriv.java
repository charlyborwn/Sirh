
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Apriv {
    
    private static String path1Usuario;
    public static String getPath1Usuario() {
        return path1Usuario;
    }

    public static void setPath1Usuario(String aPath1Usuario) {
        path1Usuario = aPath1Usuario;
    }
    
    private static String path2Usuario;
    public static String getPath2Usuario() {
        return path2Usuario;
    }

    public static void setPath2Usuario(String aPath2Usuario) {
        path2Usuario = aPath2Usuario;
    }
    
    Connection cn;
    
    public Apriv(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual, String conActual){
        try{
            String sql="select TIAPR, FAAPR, HAAPR, FTAPR, HTAPR"
                    + "   from APRIV25 "
                    + "  where NTAPR = "+numActual+" "
                    + "    and NUAPR = '"+conActual+"' "
                    + "    and STAPR = 'SI' "
                    + "  order by FAAPR DESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[5];
                for(int i=0; i<5; i++){
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
    
    public Object[] Comple(Integer numActual, String conActual, String tipActual, String feiActual, String hoiActual,
                           String fetActual, String hotActual){
        Object[] datos1=new Object[12];
        try{
            String sql="select P1APR, JUAPR, DJAPR, P2APR, REAPR, FRAPR, HRAPR, VPAPR, OBAPR, STAPR, FEAPR, USAPR"
                    + "   from APRIV25 "
                    + "  where NTAPR = "+numActual+" "
                    + "    and NUAPR = '"+conActual+"' "
                    + "    and TIAPR = '"+tipActual+"' "
                    + "    and FAAPR = '"+feiActual+"' "
                    + "    and HAAPR = '"+hoiActual+"' "
                    + "    and FTAPR = '"+fetActual+"' "
                    + "    and HTAPR = '"+hotActual+"' "
                    + "    and STAPR = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<12; i++){
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
    
    public void LlenarCausa(JComboBox Listacausa){
        try{
            String sql="select DETAP from TAPRI16 where STTAP = 'SI' order by DETAP";
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
    
    public void Agregar(Integer numtra, String nomtra, String rfctra, String patfot, String stacon, String fstcon, String numcon,
                        String cveemp, String nomemp, String cvedep, String nomdep, String cvesec, String nomsec, String cvecat,
                        String nomcat, Float suecat, String cvetur, String nomtur, String cvetip, String nomtip, String fecini,
                        String fecter, String tipapr, String finapr, String hinapr, String fteapr, String hteapr, String patgen,
                        String justif, String datjus, String patjus, String reanud, String fecrea, String horrea, String pervac,
                        String observa, String usuario){
        try{
           String sql="execute AgregarApriv ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, nomtra);
           cmd.setString(3, rfctra);
           cmd.setString(4, patfot);
           cmd.setString(5, stacon);
           cmd.setString(6, fstcon);
           cmd.setString(7, numcon);
           cmd.setString(8, cveemp);
           cmd.setString(9, nomemp);
           cmd.setString(10, cvedep);
           cmd.setString(11, nomdep);
           cmd.setString(12, cvesec);
           cmd.setString(13, nomsec);
           cmd.setString(14, cvecat);
           cmd.setString(15, nomcat);
           cmd.setFloat(16, suecat);
           cmd.setString(17, cvetur);
           cmd.setString(18, nomtur);
           cmd.setString(19, cvetip);
           cmd.setString(20, nomtip);
           cmd.setString(21, fecini);
           cmd.setString(22, fecter);
           cmd.setString(23, tipapr);
           cmd.setString(24, finapr);
           cmd.setString(25, hinapr);
           cmd.setString(26, fteapr);
           cmd.setString(27, hteapr);
           cmd.setString(28, patgen);
           cmd.setString(29, justif);
           cmd.setString(30, datjus);
           cmd.setString(31, patjus);
           cmd.setString(32, reanud);
           cmd.setString(33, fecrea);
           cmd.setString(34, horrea);
           cmd.setString(35, pervac);
           cmd.setString(36, observa);
           cmd.setString(37, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numtra, String nomtra, String rfctra, String patfot, String stacon, String fstcon, String numcon,
                           String cveemp, String nomemp, String cvedep, String nomdep, String cvesec, String nomsec, String cvecat,
                           String nomcat, Float suecat, String cvetur, String nomtur, String cvetip, String nomtip, String fecini,
                           String fecter, String tipapr, String finapr, String hinapr, String fteapr, String hteapr, String patgen,
                           String justif, String datjus, String patjus, String reanud, String fecrea, String horrea, String pervac,
                           String observa, String usuario){
        try{
           String sql="execute ActualizarApriv ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, nomtra);
           cmd.setString(3, rfctra);
           cmd.setString(4, patfot);
           cmd.setString(5, stacon);
           cmd.setString(6, fstcon);
           cmd.setString(7, numcon);
           cmd.setString(8, cveemp);
           cmd.setString(9, nomemp);
           cmd.setString(10, cvedep);
           cmd.setString(11, nomdep);
           cmd.setString(12, cvesec);
           cmd.setString(13, nomsec);
           cmd.setString(14, cvecat);
           cmd.setString(15, nomcat);
           cmd.setFloat(16, suecat);
           cmd.setString(17, cvetur);
           cmd.setString(18, nomtur);
           cmd.setString(19, cvetip);
           cmd.setString(20, nomtip);
           cmd.setString(21, fecini);
           cmd.setString(22, fecter);
           cmd.setString(23, tipapr);
           cmd.setString(24, finapr);
           cmd.setString(25, hinapr);
           cmd.setString(26, fteapr);
           cmd.setString(27, hteapr);
           cmd.setString(28, patgen);
           cmd.setString(29, justif);
           cmd.setString(30, datjus);
           cmd.setString(31, patjus);
           cmd.setString(32, reanud);
           cmd.setString(33, fecrea);
           cmd.setString(34, horrea);
           cmd.setString(35, pervac);
           cmd.setString(36, observa);
           cmd.setString(37, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numActual, String conActual, String tipActual, String feiActual, String hoiActual,
                         String fetActual, String hotActual, String usuario){
        try{
            String sql= "update APRIV25 set STAPR='NO', FEAPR=getdate(), USAPR= '"+usuario+"' "
                    + "   where NTAPR = "+numActual+" "
                    + "     and NUAPR = '"+conActual+"' "
                    + "     and TIAPR = '"+tipActual+"' "
                    + "     and FAAPR = '"+feiActual+"' "
                    + "     and HAAPR = '"+hoiActual+"' "
                    + "     and FTAPR = '"+fetActual+"' "
                    + "     and HTAPR = '"+hotActual+"' "
                    + "     and STAPR = 'SI' ";
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
