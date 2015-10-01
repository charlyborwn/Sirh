
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cFamil {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cFamil(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select TPFAM, APFAM, AMFAM, NOFAM, VIFAM, SEFAM, FNFAM, TIFAM, PTFAM, STFAM, FEFAM, USFAM"
                    + "   from FAMIL32 where NTFAM = "+numActual+" and STFAM = 'SI' order by TPFAM";
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
    
    public Object[] Comple(Integer numActual, String patActual, String matActual, String nomActual){
        Object[] datos1=new Object[12];
        try{
            String sql="select OFFAM, PAFAM, ESFAM, MDFAM, LOFAM, COFAM, CAFAM, CPFAM, TDFAM, TCFAM, CEFAM, OBFAM"
                    + "   from FAMIL32"
                    + "  where RFFAM = "+numActual+" "
                    + "    and APFAM = '"+patActual+"' "
                    + "    and AMFAM = '"+matActual+"' "
                    + "    and NOFAM = '"+nomActual+"' "
                    + "    and STFAM = 'SI' ";
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
