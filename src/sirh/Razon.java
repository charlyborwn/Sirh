
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Razon {
    Connection cn;

    public Razon(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from RAZON02 where STRAZ = 'SI' order by DERAZ";
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

    public void Agregar(String razon, String usuario){
        try{
           String sql="execute AgregarRazon ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, razon);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String razon, String usuario){
        try{
           String sql="execute ActualizarRazon ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, razon);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String razon, String usuario){
        try{
            String sql= "update RAZON02 set STRAZ='NO',FERAZ=getdate(), USRAZ='"+usuario+"' where DERAZ='"+razon+"'";
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
            String sql="select * from RAZON02 where DERAZ like '%"+palabraactual+"%' and STRAZ = 'SI' order by DERAZ";
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
}


