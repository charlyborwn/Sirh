
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cExistencias {
    
    Connection cn;
    
    public cExistencias(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusArticulo(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select CEINV, NEINV, ARINV, MOINV, TAINV, SUM(CAINV)"
                    + "   from INVEN37 "
                    + "  where ARINV like '%"+palabraactual+"%' and STINV = 'SI' "
                    + "  group by CEINV, NEINV, ARINV, MOINV, TAINV "
                    + "  order by CEINV, ARINV";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[6];
                for(int i=0; i<6; i++){
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
            String sql="select CEINV, NEINV, ARINV, MOINV, TAINV, SUM(CAINV)"
                    + "   from INVEN37 "
                    + "  where NEINV like '%"+palabraactual+"%' and STINV = 'SI' "
                    + "  group by CEINV, NEINV, ARINV, MOINV, TAINV "
                    + "  order by CEINV, ARINV";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[6];
                for(int i=0; i<6; i++){
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
