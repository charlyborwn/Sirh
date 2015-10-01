
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cPrypr {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cPrypr(){
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
    
    
}
