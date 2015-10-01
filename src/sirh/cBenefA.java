
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cBenefA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cBenefA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TPBEN_A, APBEN_A, AMBEN_A, NOBEN_A, FNBEN_A, SEBEN_A, POBEN_A, OBBEN_A, STBEN_A, FEBEN_A, USBEN_A"
                    + "   from BENEF26A where RFBEN_A = '"+rfcActual+"' and STBEN_A = 'SI' order by TPBEN_A";
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
