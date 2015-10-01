
package sirh;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Sexo {
    Connection cn;

    public Sexo(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select * from SEXOO12 where STSEX = 'SI' order by NOSEX";
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

    public void Agregar(String sexo, String usuario){
        try{
           String sql="execute AgregarSexo ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, sexo);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String sexo, String usuario){
        try{
           String sql="execute ActualizarSexo ?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, sexo);
           cmd.setString(2, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String sexo, String usuario){
        try{
            String sql= "update SEXOO12 set STSEX='NO',FESEX=getdate(), USSEX='"+usuario+"' where NOSEX='"+sexo+"'";
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
            String sql="select * from SEXOO12 where NOSEX like '%"+palabraactual+"%' and STSEX = 'SI' order by NOSEX";
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
