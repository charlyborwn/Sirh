
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cTrabaA {
    
    private static String rfcUsuario;
    public static String getRfcUsuario() {
        return rfcUsuario;
    }

    public static void setRfcUsuario(String aRfcUsuario) {
        rfcUsuario = aRfcUsuario;
    }
    
    private static String nomTrabaja;
    public static String getNomTrabaja() {
        return nomTrabaja;
    }

    public static void setNomTrabaja(String aNomTrabaja) {
        nomTrabaja = aNomTrabaja;
    }
    
    Connection cn;
    
    
    public cTrabaA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusNom(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFTRA_A, APTRA_A, AMTRA_A, NOTRA_A from TRABA36A"
                    + "  where NOTRA_A like '%"+palabraactual+"%' and STTRA_A = 'SI' order by NOTRA_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
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
    
    public void BusRfc(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFTRA_A, APTRA_A, AMTRA_A, NOTRA_A from TRABA36A"
                    + "  where RFTRA_A like '%"+palabraactual+"%' and STTRA_A = 'SI' order by RFTRA_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
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
    
    public void BusPat(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFTRA_A, APTRA_A, AMTRA_A, NOTRA_A from TRABA36A"
                    + "  where APTRA_A like '%"+palabraactual+"%' and STTRA_A = 'SI' order by APTRA_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
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
    
    public void BusMat(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFTRA_A, APTRA_A, AMTRA_A, NOTRA_A from TRABA36A"
                    + "  where AMTRA_A like '%"+palabraactual+"%' and STTRA_A = 'SI' order by AMTRA_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[4];
                for(int i=0; i<4; i++){
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
   
    public Object[] Comple(String rfcActual, String patActual, String matActual, String nomActual){
        Object[] datos1=new Object[13];
        try{
            String sql="select * from TRABA36A "
                    + "  where RFTRA_A = '"+rfcActual+"' "
                    + "    and APTRA_A = '"+patActual+"' "
                    + "    and AMTRA_A = '"+matActual+"' "
                    + "    and NOTRA_A = '"+nomActual+"' "
                    + "    and STTRA_A = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<13; i++){
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
