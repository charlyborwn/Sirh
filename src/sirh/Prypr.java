
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Prypr {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Prypr(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual, String conActual){
        try{
            String sql="select TPPRY, BEPRY, PAPRY, FIPRY, SAPRY, FPPRY"
                    + "   from PRYPR34 "
                    + "  where NTPRY = "+numActual+" "
                    + "    and NUPRY = '"+conActual+"' "
                    + "    and STPRY = 'SI' "
                    + "  order by TPPRY";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[6];
                for(int i=0; i<6; i++){
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
    
    public Object[] Comple(Integer numActual, String conActual, String tipActual, String benActual, String parActual,
                           String finActual, String aprActual, String freActual){
        Object[] datos1=new Object[8];
        try{
            String sql="select SOPRY, CRPRY, IMPRY, DPPRY, PTPRY, STPRY, FEPRY, USPRY"
                    + "   from PRYPR34 "
                    + "  where NTPRY = "+numActual+" "
                    + "    and NUPRY = '"+conActual+"' "
                    + "    and TPPRY = '"+tipActual+"' "
                    + "    and BEPRY = '"+benActual+"' "
                    + "    and PAPRY = '"+parActual+"' "
                    + "    and FIPRY = '"+finActual+"' "
                    + "    and SAPRY = '"+aprActual+"' "
                    + "    and FPPRY = '"+freActual+"' "
                    + "    and STPRY = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<8; i++){
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
    
    public void LlenarTipo(JComboBox Listacausa, String empresa){
        try{
            String sql="select NOPYP from TIPYP20 where STPYP = 'SI' and NEPYP = '"+empresa+"' order by NOPYP";
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
    
    public void LlenarPariente(JComboBox Listatipo){
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
    
    public void Agregar(Integer numtra, String nomtra, String rfctra, String patfot, String stacon, String fstcon, String numcon,
                        String cveemp, String nomemp, String cvedep, String nomdep, String cvesec, String nomsec, String cvecat,
                        String nomcat, Float suecat, String cvetur, String nomtur, String cvetip, String nomtip, String fecini,
                        String fecter, String tippry, String benpry, String parpry, String finpry, String sappry, String fprpry,
                        String solpry, String recpry, Float imppry, Integer diapry, String patpry, String usuario){
        try{
           String sql="execute AgregarPrypr ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
           cmd.setString(23, tippry);
           cmd.setString(24, benpry);
           cmd.setString(25, parpry);
           cmd.setString(26, finpry);
           cmd.setString(27, sappry);
           cmd.setString(28, fprpry);
           cmd.setString(29, solpry);
           cmd.setString(30, recpry);
           cmd.setFloat(31, imppry);
           cmd.setInt(32, diapry);
           cmd.setString(33, patpry);
           cmd.setString(34, usuario);
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
                           String fecter, String tippry, String benpry, String parpry, String finpry, String sappry, String fprpry,
                           String solpry, String recpry, Float imppry, Integer diapry, String patpry, String usuario){
        try{
           String sql="execute ActualizarPrypr ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
           cmd.setString(23, tippry);
           cmd.setString(24, benpry);
           cmd.setString(25, parpry);
           cmd.setString(26, finpry);
           cmd.setString(27, sappry);
           cmd.setString(28, fprpry);
           cmd.setString(29, solpry);
           cmd.setString(30, recpry);
           cmd.setFloat(31, imppry);
           cmd.setInt(32, diapry);
           cmd.setString(33, patpry);
           cmd.setString(34, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numActual, String conActual, String tipActual, String benActual, String parActual,
                         String finActual, String aprActual, String freActual, String usuario){
        try{
            String sql= "update PRYPR34 set STPRY='NO', FEPRY=getdate(), USPRY= '"+usuario+"' "
                    + "   where NTPRY = "+numActual+" "
                    + "     and NUPRY = '"+conActual+"' "
                    + "     and TPPRY = '"+tipActual+"' "
                    + "     and BEPRY = '"+benActual+"' "
                    + "     and PAPRY = '"+parActual+"' "
                    + "     and FIPRY = '"+finActual+"' "
                    + "     and SAPRY = '"+aprActual+"' "
                    + "     and FPPRY = '"+freActual+"' "
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
