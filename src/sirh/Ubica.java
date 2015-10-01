
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Ubica {
    Connection cn;

    public Ubica(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from UBICA23 where STUBI = 'SI' order by PAUBI, ESUBI, MDUBI, POUBI, COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[8];
                for(int i=0; i<8; i++){
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

    public void Agregar(String pais, String estado, String municipio, String poblacion, String colonia, String usuario){
        try{
           String sql="execute AgregarUbica ?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, pais);
           cmd.setString(2, estado);
           cmd.setString(3, municipio);
           cmd.setString(4, poblacion);
           cmd.setString(5, colonia);
           cmd.setString(6, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String pais, String estado, String municipio, String poblacion, String colonia, String usuario){
        try{
           String sql="execute ActualizarUbica ?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, pais);
           cmd.setString(2, estado);
           cmd.setString(3, municipio);
           cmd.setString(4, poblacion);
           cmd.setString(5, colonia);
           cmd.setString(6, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String pais, String estado, String municipio, String poblacion, String colonia, String usuario){
        try{
            String sql= "update UBICA23 set STUBI='NO',FEUBI=getdate(), USUBI='"+usuario+"'"
                    + "   where PAUBI='"+pais+"' "
                    + "     and ESUBI='"+estado+"' "
                    + "     and MDUBI='"+municipio+"' "
                    + "     and POUBI='"+poblacion+"' "
                    + "     and COUBI='"+colonia+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }

    public void BusquedaEstado(DefaultTableModel modelo, String palabraestado){
        try{
            String sql="select * from UBICA23 "
                    + "  where ESUBI like '%"+palabraestado+"%' "
                    + "    and STUBI = 'SI' "
                    + "  order by PAUBI, ESUBI, MDUBI, POUBI, COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[8];
                for(int i=0; i<8; i++){
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
    
    public void BusquedaMunicipio(DefaultTableModel modelo, String palabramunicipio){
        try{
            String sql="select * from UBICA23 "
                    + "  where MDUBI like '%"+palabramunicipio+"%' "
                    + "    and STUBI = 'SI' "
                    + "  order by PAUBI, ESUBI, MDUBI, POUBI, COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[8];
                for(int i=0; i<8; i++){
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
    
    public void BusquedaPoblacion(DefaultTableModel modelo, String palabrapoblacion){
        try{
            String sql="select * from UBICA23 "
                    + "  where POUBI like '%"+palabrapoblacion+"%' "
                    + "    and STUBI = 'SI' "
                    + "  order by PAUBI, ESUBI, MDUBI, POUBI, COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[8];
                for(int i=0; i<8; i++){
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
    
    public void BusquedaColonia(DefaultTableModel modelo, String palabracolonia){
        try{
            String sql="select * from UBICA23 "
                    + "  where COUBI like '%"+palabracolonia+"%' "
                    + "    and STUBI = 'SI' "
                    + "  order by PAUBI, ESUBI, MDUBI, POUBI, COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[8];
                for(int i=0; i<8; i++){
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
