
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Sanci {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Sanci(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual, String conActual){
        try{
            String sql="select CUSAN, FHSAN, SGSAN, CVSAN, NPSAN"
                    + "   from SANCI35 "
                    + "  where NTSAN = "+numActual+" "
                    + "    and NUSAN = '"+conActual+"' "
                    + "    and STSAN = 'SI' "
                    + "  order by CUSAN";
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
    
    public Object[] Comple(Integer numActual, String conActual, String cauActual, String fecActual, String sanActual, String cveActual,
                           String nomcveActual){
        Object[] datos1=new Object[9];
        try{
            String sql="select DHSAN, HHSAN, DISAN, FISAN, FTSAN, PTSAN, STSAN, FESAN, USSAN"
                    + "   from SANCI35 "
                    + "  where NTSAN = "+numActual+" "
                    + "    and NUSAN = '"+conActual+"' "
                    + "    and CUSAN = '"+cauActual+"' "
                    + "    and FHSAN = '"+fecActual+"' "
                    + "    and SGSAN = '"+sanActual+"' "
                    + "    and CVSAN = '"+cveActual+"' "
                    + "    and NPSAN = '"+nomcveActual+"' "
                    + "    and STSAN = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<9; i++){
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
    
    public void LlenarComite(JComboBox Listacomite){
        try{
            String sql="select NTCOM from COMIT08 where STCOM = 'SI' order by NTCOM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacomite.addItem(rs.getString(i+1));
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
            String sql="select NPCOM from COMIT08 where NTCOM='"+clave2+"' and STCOM='SI'";
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
    
    public void Agregar(Integer numtra, String nomtra, String rfctra, String patfot, String stacon, String fstcon, String numcon,
                        String cveemp, String nomemp, String cvedep, String nomdep, String cvesec, String nomsec, String cvecat,
                        String nomcat, Float suecat, String cvetur, String nomtur, String cvetip, String nomtip, String fecini,
                        String fecter, String causa, String hechos, String fechec, String horhec, String sangen, Integer diasan,
                        String finsan, String ftesan, String cveaut, String nomaut, String path, String usuario){
        try{
           String sql="execute AgregarSanci ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
           cmd.setString(23, causa);
           cmd.setString(24, hechos);
           cmd.setString(25, fechec);
           cmd.setString(26, horhec);
           cmd.setString(27, sangen);
           cmd.setInt(28, diasan);
           cmd.setString(29, finsan);
           cmd.setString(30, ftesan);
           cmd.setString(31, cveaut);
           cmd.setString(32, nomaut);
           cmd.setString(33, path);
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
                           String fecter, String causa, String hechos, String fechec, String horhec, String sangen, Integer diasan,
                           String finsan, String ftesan, String cveaut, String nomaut, String path, String usuario){
        try{
           String sql="execute ActualizarSanci ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
           cmd.setString(23, causa);
           cmd.setString(24, hechos);
           cmd.setString(25, fechec);
           cmd.setString(26, horhec);
           cmd.setString(27, sangen);
           cmd.setInt(28, diasan);
           cmd.setString(29, finsan);
           cmd.setString(30, ftesan);
           cmd.setString(31, cveaut);
           cmd.setString(32, nomaut);
           cmd.setString(33, path);
           cmd.setString(34, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numActual, String conActual, String cauActual, String fecActual, String sanciActual,
                         String autorizaActual, String nomActual, String usuario){
        try{
            String sql= "update SANCI35 set STSAN='NO', FESAN=getdate(), USSAN= '"+usuario+"' "
                    + "   where NTSAN = "+numActual+" "
                    + "     and NUSAN = '"+conActual+"' "
                    + "     and CUSAN = '"+cauActual+"' "
                    + "     and FHSAN = '"+fecActual+"' "
                    + "     and SGSAN = '"+sanciActual+"' "
                    + "     and CVSAN = '"+autorizaActual+"' "
                    + "     and NPSAN = '"+nomActual+"' "
                    + "     and STSAN = 'SI' ";
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
