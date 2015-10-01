
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Famil {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Famil(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select TPFAM, APFAM, AMFAM, NOFAM, VIFAM, SEFAM, FNFAM, TIFAM, PTFAM, STFAM, FEFAM, USFAM"
                    + "   from FAMIL32 where NTFAM = "+numActual+" and STFAM = 'SI' order by TPFAM";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[12];
                for(int i=0; i<12; i++){
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
        Object[] datos1=new Object[12];
        try{
            String sql="select OFFAM, PAFAM, ESFAM, MDFAM, LOFAM, COFAM, CAFAM, CPFAM, TDFAM, TCFAM, CEFAM, OBFAM"
                    + "   from FAMIL32"
                    + "  where NTFAM = '"+numActual+"' "
                    + "    and APFAM = '"+patActual+"' "
                    + "    and AMFAM = '"+matActual+"' "
                    + "    and NOFAM = '"+nomActual+"' "
                    + "    and STFAM = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<12; i++){
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

    public void LlenarTipo(JComboBox Listatipo){
        try{
            String sql="select NOTIP from TIPAR19 where STTIP = 'SI' order by NOTIP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listatipo.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarSino(JComboBox Listasino){
        try{
            String sql="select CVSIN from SI_NO13";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasino.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarSexo(JComboBox Listasexo){
        try{
            String sql="select NOSEX from SEXOO12 where STSEX = 'SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasexo.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarPais(JComboBox Listapais){
        try{
            String sql="select PAUBI from UBICA23 where STUBI = 'SI' group by PAUBI order by PAUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listapais.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarEstado(JComboBox Listaestado, String pais){
        try{
            String sql="select ESUBI from UBICA23 where STUBI = 'SI' and PAUBI = '"+pais+"' group by ESUBI order by ESUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaestado.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarMundel(JComboBox Listamundel, String pais, String estado){
        try{
            String sql="select MDUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+pais+"' "
                    + "    and ESUBI = '"+estado+"' "
                    + "  group by MDUBI order by MDUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listamundel.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarPobla(JComboBox Listapobla, String pais, String estado, String mundel){
        try{
            String sql="select POUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+pais+"' "
                    + "    and ESUBI = '"+estado+"' "
                    + "    and MDUBI = '"+mundel+"' "
                    + "  group by POUBI order by POUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listapobla.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarColonia(JComboBox Listacolonia, String pais, String estado, String mundel, String pobla){
        try{
            String sql="select COUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+pais+"' "
                    + "    and ESUBI = '"+estado+"' "
                    + "    and MDUBI = '"+mundel+"' "
                    + "    and POUBI = '"+pobla+"' "
                    + "  group by COUBI order by COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacolonia.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarTidoc(JComboBox Listatidoc){
        try{
            String sql="select NOTID from TIDOC18 where STTID='SI' order by NOTID";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listatidoc.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void Agregar(Integer numtra, String tipo, String paterno, String materno, String nombre, String vive, String sexo, String fnacim,
                        String ocupa, String pais, String estado, String mundel, String pobla, String colonia, String calle, Integer codigo,
                        String telefono, String celular, String correo, String tidoc, String path, String observa, String usuario){
        try{
           String sql="execute AgregarFamil ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, tipo);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, vive);
           cmd.setString(7, sexo);
           cmd.setString(8, fnacim);
           cmd.setString(9, ocupa);
           cmd.setString(10, pais);
           cmd.setString(11, estado);
           cmd.setString(12, mundel);
           cmd.setString(13, pobla);
           cmd.setString(14, colonia);
           cmd.setString(15, calle);
           cmd.setInt(16, codigo);
           cmd.setString(17, telefono);
           cmd.setString(18, celular);
           cmd.setString(19, correo);
           cmd.setString(20, tidoc);
           cmd.setString(21, path);
           cmd.setString(22, observa);
           cmd.setString(23, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numtra, String tipo, String paterno, String materno, String nombre, String vive, String sexo, String fnacim,
                        String ocupa, String pais, String estado, String mundel, String pobla, String colonia, String calle, Integer codigo,
                        String telefono, String celular, String correo, String tidoc, String path, String observa, String usuario){
        try{
           String sql="execute ActualizarFamil ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, tipo);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, vive);
           cmd.setString(7, sexo);
           cmd.setString(8, fnacim);
           cmd.setString(9, ocupa);
           cmd.setString(10, pais);
           cmd.setString(11, estado);
           cmd.setString(12, mundel);
           cmd.setString(13, pobla);
           cmd.setString(14, colonia);
           cmd.setString(15, calle);
           cmd.setInt(16, codigo);
           cmd.setString(17, telefono);
           cmd.setString(18, celular);
           cmd.setString(19, correo);
           cmd.setString(20, tidoc);
           cmd.setString(21, path);
           cmd.setString(22, observa);
           cmd.setString(23, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numtra, String paterno, String materno, String nombre, String usuario){
        try{
            String sql= "update FAMIL32 set STFAM='NO',FEFAM=getdate(), USFAM = '"+usuario+"' " 
                    + "   where NTFAM="+numtra+" and APFAM = '"+paterno+"' and AMFAM = '"+materno+"' and NOFAM = '"+nombre+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
}
