
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cEscolA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cEscolA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TNESC_A, INESC_A, TEESC_A, ACESC_A, CEESC_A, ESESC_A, PAESC_A, OBESC_A, STESC_A, FEESC_A, USESC_A"
                    + "   from ESCOL30A where RFESC_A = '"+rfcActual+"' and STESC_A = 'SI' order by TNESC_A";
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