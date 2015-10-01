
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cDocumA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cDocumA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TDDOC_A, CADOC_A, DEDOC_A, INDOC_A, TEDOC_A, PADOC_A, OBDOC_A, STDOC_A, FEDOC_A, USDOC_A"
                    + "   from DOCUM29A where RFDOC_A = '"+rfcActual+"' and STDOC_A = 'SI' order by TDDOC_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[10];
                for(int i=0; i<10; i++){
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
