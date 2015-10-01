
package sirh;

import java.sql.*;

public class cDatosA {
 
    private static String rfcUsuario;
    public static String getRfcUsuario() {
        return rfcUsuario;
    }

    public static void setRfcUsuario(String aRfcUsuario) {
        rfcUsuario = aRfcUsuario;
    }

    Connection cn;

    public cDatosA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public Object[] Datos(String rfcactual){
        Object[] datos=new Object[39];
        try{
            String sql="select * from DATOS28A where RFDAT_A = '"+rfcactual+"' and STDAT_A='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<39; i++){
                    datos[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos;
    }
}
