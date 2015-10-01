
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cContr {
    
    private static Integer numTrabaja;
    public static Integer getNumTrabaja() {
        return numTrabaja;
    }

    public static void setNumTrabaja(Integer aNumTrabaja) {
        numTrabaja = aNumTrabaja;
    }
    
    private static String nomTrabaja;
    public static String getNomTrabaja() {
        return nomTrabaja;
    }

    public static void setNomTrabaja(String aNomTrabaja) {
        nomTrabaja = aNomTrabaja;
    }
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    private static String ncoTrabaja;
    public static String getNcoTrabaja() {
        return ncoTrabaja;
    }

    public static void setNcoTrabaja(String aNcoTrabaja) {
        ncoTrabaja = aNcoTrabaja;
    }
    
    Connection cn;
    
    public cContr(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusNum(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NTCTO, NNCTO, RFCTO, SHCTO, FHCTO, PFCTO, NUCTO from CONTR27"
                    + "  where NTCTO like '%"+palabraactual+"%' and STCTO = 'SI' order by NTCTO";
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
    
    public void BusNom(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NTCTO, NNCTO, RFCTO, SHCTO, FHCTO, PFCTO, NUCTO from CONTR27"
                    + "  where NNCTO like '%"+palabraactual+"%' and STCTO = 'SI' order by NNCTO";
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
    
    public void BusContra(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NTCTO, NNCTO, RFCTO, SHCTO, FHCTO, PFCTO, NUCTO from CONTR27"
                    + "  where NUCTO like '%"+palabraactual+"%' and STCTO = 'SI' order by NUCTO";
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
    
    public void LlenarDatos(DefaultTableModel modelo1, Integer numActual){
        try{
            String sql="select NUCTO, SSCTO, NECTO, NOCTO, NSCTO, CACTO, TTCTO, NCCTO, INCTO, TECTO"
                    + "   from CONTR27 where NTCTO = "+numActual+" and STCTO = 'SI' order by NUCTO DESC";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[10];
                for(int i=0; i<10; i++){
                    datos[i]=rs.getString(i+1);
                }
                modelo1.addRow(datos);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Comple(String conActual){
        Object[] datos1=new Object[15];
        try{
            String sql="select FSCTO, CVCTO, NDCTO, CSCTO, CCCTO, SXCTO, TUCTO, TCCTO, SCCTO, SPCTO, PACTO, OBCTO, STCTO, FECTO, USCTO"
                    + "   from CONTR27 "
                    + "  where NUCTO = '"+conActual+"' "
                    + "    and STCTO = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<15; i++){
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
