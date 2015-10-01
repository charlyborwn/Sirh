
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Exper {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Exper(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, Integer numActual){
        try{
            String sql="select EMEXP, CEEXP, INEXP, TEEXP, CSEXP, JIEXP, CJEXP, PTEXP, STEXP, FEEXP, USEXP"
                    + "   from EXPER31 where NTEXP = "+numActual+" and STEXP = 'SI' order by INEXP";
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
    
    public Object[] Comple(Integer numActual, String empActual, String carActual){
        Object[] datos1=new Object[11];
        try{
            String sql="select PAEXP, ESEXP, MDEXP, LOEXP, COEXP, CAEXP, CPEXP, TDEXP, TCEXP, MAEXP, OBEXP"
                    + "   from EXPER31"
                    + "  where NTEXP = "+numActual+" "
                    + "    and EMEXP = '"+empActual+"' "
                    + "    and CEEXP = '"+carActual+"' "
                    + "    and STEXP = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<11; i++){
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
    
    public void Agregar(Integer numtra, String empresa, String cargo, String finicio, String ftermino, String causa, String pais, String estado,
                        String mundel, String pobla, String colonia, String calle, Integer codigo, String telefono, String jefe,
                        String carjefe, String celjefe, String corjefe, String path, String observa, String usuario){
        try{
           String sql="execute AgregarExper ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, empresa);
           cmd.setString(3, cargo);
           cmd.setString(4, finicio);
           cmd.setString(5, ftermino);
           cmd.setString(6, causa);
           cmd.setString(7, pais);
           cmd.setString(8, estado);
           cmd.setString(9, mundel);
           cmd.setString(10, pobla);
           cmd.setString(11, colonia);
           cmd.setString(12, calle);
           cmd.setInt(13, codigo);
           cmd.setString(14, telefono);
           cmd.setString(15, jefe);
           cmd.setString(16, carjefe);
           cmd.setString(17, celjefe);
           cmd.setString(18, corjefe);
           cmd.setString(19, path);
           cmd.setString(20, observa);
           cmd.setString(21, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numtra, String empresa, String cargo, String finicio, String ftermino, String causa, String pais, String estado,
                        String mundel, String pobla, String colonia, String calle, Integer codigo, String telefono, String jefe,
                        String carjefe, String celjefe, String corjefe, String path, String observa, String usuario){
        try{
           String sql="execute ActualizarExper ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
           cmd.setString(2, empresa);
           cmd.setString(3, cargo);
           cmd.setString(4, finicio);
           cmd.setString(5, ftermino);
           cmd.setString(6, causa);
           cmd.setString(7, pais);
           cmd.setString(8, estado);
           cmd.setString(9, mundel);
           cmd.setString(10, pobla);
           cmd.setString(11, colonia);
           cmd.setString(12, calle);
           cmd.setInt(13, codigo);
           cmd.setString(14, telefono);
           cmd.setString(15, jefe);
           cmd.setString(16, carjefe);
           cmd.setString(17, celjefe);
           cmd.setString(18, corjefe);
           cmd.setString(19, path);
           cmd.setString(20, observa);
           cmd.setString(21, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numtra, String empresa, String cargo, String usuario){
        try{
            String sql= "update EXPER31A set STEXP='NO',FEEXP=getdate(), USEXP = '"+usuario+"' " 
                    + "   where NTEXP="+numtra+" and EMEXP = '"+empresa+"' and CEEXP = '"+cargo+"'";
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
