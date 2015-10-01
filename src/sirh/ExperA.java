
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class ExperA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public ExperA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select EMEXP_A, CEEXP_A, INEXP_A, TEEXP_A, CSEXP_A, JIEXP_A, CJEXP_A, PTEXP_A, STEXP_A, FEEXP_A, USEXP_A"
                    + "   from EXPER31A where RFEXP_A = '"+rfcActual+"' and STEXP_A = 'SI' order by INEXP_A";
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
    
    public Object[] Comple(String rfcActual, String empActual, String carActual){
        Object[] datos1=new Object[11];
        try{
            String sql="select PAEXP_A, ESEXP_A, MDEXP_A, LOEXP_A, COEXP_A, CAEXP_A, CPEXP_A, TDEXP_A, TCEXP_A, MAEXP_A, OBEXP_A"
                    + "   from EXPER31A"
                    + "  where RFEXP_A = '"+rfcActual+"' "
                    + "    and EMEXP_A = '"+empActual+"' "
                    + "    and CEEXP_A = '"+carActual+"' "
                    + "    and STEXP_A = 'SI' ";
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
    
    public void Agregar(String rfc, String empresa, String cargo, String finicio, String ftermino, String causa, String pais, String estado,
                        String mundel, String pobla, String colonia, String calle, Integer codigo, String telefono, String jefe,
                        String carjefe, String celjefe, String corjefe, String path, String observa, String usuario){
        try{
           String sql="execute AgregarExperA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
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
    
    public void Actualizar(String rfc, String empresa, String cargo, String finicio, String ftermino, String causa, String pais, String estado,
                        String mundel, String pobla, String colonia, String calle, Integer codigo, String telefono, String jefe,
                        String carjefe, String celjefe, String corjefe, String path, String observa, String usuario){
        try{
           String sql="execute ActualizarExperA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
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
    
    public void Eliminar(String rfc, String empresa, String cargo, String usuario){
        try{
            String sql= "update EXPER31A set STEXP_A='NO',FEEXP_A=getdate(), USEXP_A = '"+usuario+"' " 
                    + "   where RFEXP_A='"+rfc+"' and EMEXP_A = '"+empresa+"' and CEEXP_A = '"+cargo+"'";
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
