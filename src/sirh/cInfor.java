
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cInfor {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public cInfor(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusTipo(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select TIINF, FIINF, NEINF, RCINF, PAINF, FEINF, USINF from INFOR39 "
                    + "  where TIINF like '%"+palabraactual+"%' and STINF = 'SI' order by FIINF DESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[7];
                for(int i=0; i<7; i++){
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
    
    public void BusEmpresa(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select TIINF, FIINF, NEINF, RCINF, PAINF, FEINF, USINF from INFOR39 "
                    + "  where NEINF like '%"+palabraactual+"%' and STINF = 'SI' order by FIINF DESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[7];
                for(int i=0; i<7; i++){
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
    
    public void BusResumen(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select TIINF, FIINF, NEINF, RCINF, PAINF, FEINF, USINF from INFOR39 "
                    + "  where RCINF like '%"+palabraactual+"%' and STINF = 'SI' order by FIINF DESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[7];
                for(int i=0; i<7; i++){
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
