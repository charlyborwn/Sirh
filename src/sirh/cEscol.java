
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cEscol {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cEscol(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select TNESC, INESC, TEESC, ACESC, CEESC, ESESC, PAESC, OBESC, STESC, FEESC, USESC"
                    + "   from ESCOL30 where NTESC = "+numActual+" and STESC = 'SI' order by TNESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[11];
                for(int i=0; i<11; i++){
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

}