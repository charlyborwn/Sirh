
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cFamilA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cFamilA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TPFAM_A, APFAM_A, AMFAM_A, NOFAM_A, VIFAM_A, SEFAM_A, FNFAM_A, TIFAM_A, PTFAM_A, STFAM_A, FEFAM_A, USFAM_A"
                    + "   from FAMIL32A where RFFAM_A = '"+rfcActual+"' and STFAM_A = 'SI' order by TPFAM_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[12];
                for(int i=0; i<12; i++){
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
    
    public Object[] Comple(String rfcActual, String patActual, String matActual, String nomActual){
        Object[] datos1=new Object[12];
        try{
            String sql="select OFFAM_A, PAFAM_A, ESFAM_A, MDFAM_A, LOFAM_A, COFAM_A, CAFAM_A, CPFAM_A, TDFAM_A, TCFAM_A, CEFAM_A, OBFAM_A"
                    + "   from FAMIL32A"
                    + "  where RFFAM_A = '"+rfcActual+"' "
                    + "    and APFAM_A = '"+patActual+"' "
                    + "    and AMFAM_A = '"+matActual+"' "
                    + "    and NOFAM_A = '"+nomActual+"' "
                    + "    and STFAM_A = 'SI' ";
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
