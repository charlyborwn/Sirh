
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Empre {
    Connection cn;

    public Empre(){
        Conexion con=new Conexion();
        cn=con.getConexion();
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
    
    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from EMPRE04 where STEMP = 'SI' order by OREMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[15];
                for(int i=0; i<15; i++){
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

    public void Agregar(String clave, String nombre, String grupo, Integer orden, String giro, String pais, String estado,
                        String mundel, String pobla, String colonia, Integer codpos, String calle, String usuario){
        try{
           String sql="execute AgregarEmpre ?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, nombre);
           cmd.setString(3, grupo);
           cmd.setInt(4, orden);
           cmd.setString(5, giro);
           cmd.setString(6, pais);
           cmd.setString(7, estado);
           cmd.setString(8, mundel);
           cmd.setString(9, pobla);
           cmd.setString(10, colonia);
           cmd.setInt(11, codpos);
           cmd.setString(12, calle);
           cmd.setString(13, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String clave, String nombre, String grupo, Integer orden, String giro, String pais, String estado,
                           String mundel, String pobla, String colonia, Integer codpos, String calle, String usuario){
        try{
           String sql="execute ActualizarEmpre ?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, clave);
           cmd.setString(2, nombre);
           cmd.setString(3, grupo);
           cmd.setInt(4, orden);
           cmd.setString(5, giro);
           cmd.setString(6, pais);
           cmd.setString(7, estado);
           cmd.setString(8, mundel);
           cmd.setString(9, pobla);
           cmd.setString(10, colonia);
           cmd.setInt(11, codpos);
           cmd.setString(12, calle);
           cmd.setString(13, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String clave, String usuario){
        try{
            String sql= "update EMPRE04 set STEMP='NO',FEEMP=getdate(), USEMP='"+usuario+"' where CVEMP='"+clave+"'";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }

    public void Busqueda(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select * from EMPRE04 where NOEMP like '%"+palabraactual+"%' and STEMP = 'SI' order by OREMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[15];
                for(int i=0; i<15; i++){
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
