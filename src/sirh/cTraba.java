
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class cTraba {
    
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
    
    Connection cn;
    
    
    public cTraba(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void BusNom(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUTRA, APTRA, AMTRA, NOTRA from TRABA36"
                    + "  where NOTRA like '%"+palabraactual+"%' and STTRA = 'SI' order by NOTRA";
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
    
    public void BusNum(DefaultTableModel modelo, String numactual){
        try{
            String sql="select NUTRA, APTRA, AMTRA, NOTRA from TRABA36"
                    + "  where NUTRA like '%"+numactual+"%' and STTRA = 'SI' order by NUTRA";
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
            String sql="select NUTRA, APTRA, AMTRA, NOTRA from TRABA36"
                    + "  where APTRA like '%"+palabraactual+"%' and STTRA = 'SI' order by APTRA";
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
            String sql="select NUTRA, APTRA, AMTRA, NOTRA from TRABA36"
                    + "  where AMTRA like '%"+palabraactual+"%' and STTRA = 'SI' order by AMTRA";
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
   
    public Object[] Comple(Integer numActual, String patActual, String matActual, String nomActual){
        Object[] datos1=new Object[20];
        try{
            String sql="select * from TRABA36 "
                    + "  where NUTRA = "+numActual+" "
                    + "    and APTRA = '"+patActual+"' "
                    + "    and AMTRA = '"+matActual+"' "
                    + "    and NOTRA = '"+nomActual+"' "
                    + "    and STTRA = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<20; i++){
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
