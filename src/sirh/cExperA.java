
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cExperA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cExperA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select EMEXP_A, CEEXP_A, INEXP_A, TEEXP_A, CSEXP_A, JIEXP_A, CJEXP_A, PTEXP_A, STEXP_A, FEEXP_A, USEXP_A"
                    + "   from EXPER31A where RFEXP_A = '"+rfcActual+"' and STEXP_A = 'SI' order by INEXP_A";
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
    
    public Object[] Comple(String rfcActual, String empActual, String carActual){
        Object[] datos1=new Object[11];
        try{
            String sql="select PAEXP_A, ESEXP_A, MDEXP_A, LOEXP_A, COEXP_A, CAEXP_A, CPEXP_A, TDEXP_A, TCEXP_A, MAEXP_A, OBEXP_A"
                    + "   from EXPER31A"
                    + "  where RFEXP_A = '"+rfcActual+"' "
                    + "    and EMEXP_A = '"+empActual+"' "
                    + "    and CEEXP_A = '"+carActual+"' "
                    + "    and STEXP_A = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<11; i++){
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
