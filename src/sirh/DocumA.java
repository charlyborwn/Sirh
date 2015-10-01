
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class DocumA {
    
    private static String pathUsuario;
    public static String getPathUsuario() {
        return pathUsuario;
    }

    public static void setPathUsuario(String aPathUsuario) {
        pathUsuario = aPathUsuario;
    }
    
    Connection cn;
    
    public DocumA(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
 
    public void LlenarDatos(DefaultTableModel modelo, String rfcActual){
        try{
            String sql="select TDDOC_A, CADOC_A, DEDOC_A, INDOC_A, TEDOC_A, PADOC_A, OBDOC_A, STDOC_A, FEDOC_A, USDOC_A"
                    + "   from DOCUM29A where RFDOC_A = '"+rfcActual+"' and STDOC_A = 'SI' order by TDDOC_A";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos=new Object[10];
                for(int i=0; i<10; i++){
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

    public void LlenarTipo(JComboBox Listatipo){
        try{
            String sql="select NOTID from TIDOC18 where STTID = 'SI' order by NOTID";
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
    
    public void LlenarCausa(JComboBox Listacausa){
        try{
            String sql="select DERAZ from RAZON02 where STRAZ = 'SI' order by DERAZ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacausa.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void Agregar(String rfc, String tipo, String caracte, String causa, String finicio, String ftermino, String path,
                        String observa, String usuario){
        try{
           String sql="execute AgregarDocumA ?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, tipo);
           cmd.setString(3, caracte);
           cmd.setString(4, causa);
           cmd.setString(5, finicio);
           cmd.setString(6, ftermino);
           cmd.setString(7, path);
           cmd.setString(8, observa);
           cmd.setString(9, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String rfc, String tipo, String caracte, String causa, String finicio, String ftermino, String path,
                        String observa, String usuario){
        try{
           String sql="execute ActualizarDocumA ?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, tipo);
           cmd.setString(3, caracte);
           cmd.setString(4, causa);
           cmd.setString(5, finicio);
           cmd.setString(6, ftermino);
           cmd.setString(7, path);
           cmd.setString(8, observa);
           cmd.setString(9, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(String rfc, String tipo, String usuario){
        try{
            String sql= "update DOCUM29A set STDOC_A='NO',FEDOC_A=getdate(), USDOC_A='"+usuario+"' "
                    + "   where RFDOC_A='"+rfc+"' and TDDOC_A = '"+tipo+"'";
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
