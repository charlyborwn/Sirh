
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cSanci {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cSanci(){
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
    
}
