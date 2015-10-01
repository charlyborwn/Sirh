
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cExper {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cExper(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select EMEXP, CEEXP, INEXP, TEEXP, CSEXP, JIEXP, CJEXP, PTEXP, STEXP, FEEXP, USEXP"
                    + "   from EXPER31 where NTEXP = "+numActual+" and STEXP = 'SI' order by INEXP";
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
    
    public Object[] Comple(Integer numActual, String empActual, String carActual){
        Object[] datos1=new Object[11];
        try{
            String sql="select PAEXP, ESEXP, MDEXP, LOEXP, COEXP, CAEXP, CPEXP, TDEXP, TCEXP, MAEXP, OBEXP"
                    + "   from EXPER31"
                    + "  where NTEXP = "+numActual+" "
                    + "    and EMEXP = '"+empActual+"' "
                    + "    and CEEXP = '"+carActual+"' "
                    + "    and STEXP = 'SI' ";
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
