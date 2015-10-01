
package sirh;

import java.sql.*;


public class Acceso {

    private static String claveUsuario;
    public static String getClaveUsuario() {
        return claveUsuario;
    }

    public static void setClaveUsuario(String aClaveUsuario) {
        claveUsuario = aClaveUsuario;
    }
    
    private static String nombreUsuario;
    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String aNombreUsuario) {
        nombreUsuario = aNombreUsuario;
    }

    private static String empresaUsuario;
    public static String getEmpresaUsuario() {
        return empresaUsuario;
    }

    public static void setEmpresaUsuario(String aEmpresaUsuario) {
        empresaUsuario = aEmpresaUsuario;
    }

    private static String grupoUsuario;
    public static String getGrupoUsuario() {
        return grupoUsuario;
    }

    public static void setGrupoUsuario(String aGrupoUsuario) {
        grupoUsuario = aGrupoUsuario;
    }

    private static String nivelUsuario;
    public static String getNivelUsuario() {
        return nivelUsuario;
    }

    public static void setNivelUsuario(String aNivelUsuario) {
        nivelUsuario = aNivelUsuario;
    }
    
        Connection cn;
            
    public Acceso(){
        Conexion con=new Conexion();
        cn=con.getConexion();    
    }

    public Object[] Datos(String usuactual, String conactual){
        Object[] datos=new Object[5];
        try{
            String sql="select CVUSU, NOUSU, NEUSU, GRUSU, NAUSU "
                    + "   from USUAR24 "
                    + "  where CVUSU = '"+usuactual+"' and PAUSU = '"+conactual+"' and STUSU = 'SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                 for(int i=0; i<5; i++){
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
