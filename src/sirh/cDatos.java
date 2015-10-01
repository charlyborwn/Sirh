
package sirh;

import java.sql.*;

public class cDatos {
 
    private static Integer numTrabaja;
    public static Integer getNumTrabaja() {
        return numTrabaja;
    }

    public static void setNumTrabaja(Integer aNumTrabaja) {
        numTrabaja = aNumTrabaja;
    }
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }

    Connection cn;

    public cDatos(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public Object[] Datos(Integer numactual){
        Object[] datos=new Object[45];
        try{
            String sql="select * from DATOS28 where NTDAT = "+numactual+" and STDAT='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<45; i++){
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
