
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Unida {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public Unida(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select NUUNI, CEUNI, NEUNI, MAUNI, MOUNI, ANUNI, CAUNI, PLUNI, PRUNI, FUUNI, STUNI, FEUNI, USUNI "
                    + "   from UNIDA42 where STUNI = 'SI' order by NUUNI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[13];
                for(int i=0; i<13; i++){
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
    
    public void LlenarCveempresa(JComboBox Listacveempresa){
        try{
            String sql="select CVEMP from EMPRE04 where STEMP = 'SI' order by CVEMP";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveempresa.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos(String clave){
        Object[] datos=new Object[1];
        try{
            String sql="select NOEMP from EMPRE04 where CVEMP='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
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
    
    public void Agregar(String numuni, String cveemp, String nomemp, String marca, String modelo, String año, String capa,
                        String placas, String propie, String ultimo, String usuario){
        try{
           String sql="execute AgregarUnida ?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numuni);
           cmd.setString(2, cveemp);
           cmd.setString(3, nomemp);
           cmd.setString(4, marca);
           cmd.setString(5, modelo);
           cmd.setString(6, año);
           cmd.setString(7, capa);
           cmd.setString(8, placas);
           cmd.setString(9, propie);
           cmd.setString(10, ultimo);
           cmd.setString(11, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String numuni, String cveemp, String nomemp, String marca, String modelo, String año, String capa,
                           String placas, String propie, String ultimo, String usuario){
        try{
           String sql="execute ActualizarUnida ?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, numuni);
           cmd.setString(2, cveemp);
           cmd.setString(3, nomemp);
           cmd.setString(4, marca);
           cmd.setString(5, modelo);
           cmd.setString(6, año);
           cmd.setString(7, capa);
           cmd.setString(8, placas);
           cmd.setString(9, propie);
           cmd.setString(10, ultimo);
           cmd.setString(11, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(String numuni, String cveemp, String nomemp, String usuario){
        try{
            String sql= "update UNIDA42 set STUNI='NO', FEUNI=getdate(), USUNI='"+usuario+"' "
                    + "   where NUUNI='"+numuni+"' and CEUNI='"+cveemp+"' and NEUNI='"+nomemp+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BusNumero(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUUNI, CEUNI, NEUNI, MAUNI, MOUNI, ANUNI, CAUNI, PLUNI, PRUNI, FUUNI, STUNI, FEUNI, USUNI "
                    + "   from UNIDA42 where NUUNI like '%"+palabraactual+"%' and STUNI = 'SI' order by NUUNI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[13];
                for(int i=0; i<13; i++){
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
    
    public void BusMarca(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUUNI, CEUNI, NEUNI, MAUNI, MOUNI, ANUNI, CAUNI, PLUNI, PRUNI, FUUNI, STUNI, FEUNI, USUNI "
                    + "   from UNIDA42 where MAUNI like '%"+palabraactual+"%' and STUNI = 'SI' order by NUUNI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[13];
                for(int i=0; i<13; i++){
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
    
    public void BusPlacas(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUUNI, CEUNI, NEUNI, MAUNI, MOUNI, ANUNI, CAUNI, PLUNI, PRUNI, FUUNI, STUNI, FEUNI, USUNI "
                    + "   from UNIDA42 where PLUNI like '%"+palabraactual+"%' and STUNI = 'SI' order by NUUNI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[13];
                for(int i=0; i<13; i++){
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
