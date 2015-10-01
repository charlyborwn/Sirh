
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cApriv {
    
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
    
    public cApriv(){
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
    
}
