
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cSalidas {
    
    Connection cn;
    
    public cSalidas(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusArticulo(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select CEINV, NEINV, FIINV, ARINV, MOINV, TAINV, CAINV, NTINV, NNINV, FEINV, USINV"
                    + "   from INVEN37 "
                    + "  where ARINV like '%"+palabraactual+"%' and TIINV = 'SALIDA' and STINV = 'SI' order by CEINV, FIINV";
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
    
    public void BusEmpresa(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select CEINV, NEINV, FIINV, ARINV, MOINV, TAINV, CAINV, NTINV, NNINV, FEINV, USINV"
                    + "   from INVEN37 "
                    + "  where NEINV like '%"+palabraactual+"%' and TIINV = 'SALIDA' and STINV = 'SI' order by CEINV, FIINV";
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
    
    public void BusTrabaja(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select CEINV, NEINV, FIINV, ARINV, MOINV, TAINV, CAINV, NTINV, NNINV, FEINV, USINV"
                    + "   from INVEN37 "
                    + "  where NTINV like '%"+palabraactual+"%' and TIINV = 'SALIDA' and STINV = 'SI' order by CEINV, FIINV";
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
