
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Civil {
    Connection cn;

    public Civil(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from CIVIL06 where STCIV = 'SI' order by NOCIV";
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

    public void Agregar(String civil, String usuario){
        try{
           String sql="execute AgregarCivil ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, civil);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String civil, String usuario){
        try{
           String sql="execute ActualizarCivil ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, civil);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }
    
    public void Eliminar(String civil, String usuario){
        try{
            String sql= "update CIVIL06 set STCIV='NO', FECIV=getdate(), STCIV= '"+usuario+"' where NOCIV='"+civil+"'";
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
            String sql="select * from CIVIL06 where NOCIV like '%"+palabraactual+"%' and STCIV = 'SI'order by NOCIV";
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


