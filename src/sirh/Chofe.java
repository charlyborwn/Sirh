
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Chofe {
    Connection cn;
    
    public Chofe(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }
    
    public void LlenarPadom(JComboBox Listapadom){
        try{
            String sql="select PAUBI from UBICA23 where STUBI = 'SI' group by PAUBI order by PAUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listapadom.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarEsdom(JComboBox Listaesdom, String padom){
        try{
            String sql="select ESUBI from UBICA23 where STUBI = 'SI' and PAUBI = '"+padom+"' group by ESUBI order by ESUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaesdom.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarMddom(JComboBox Listamddom, String padom, String esdom){
        try{
            String sql="select MDUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+padom+"' "
                    + "    and ESUBI = '"+esdom+"' "
                    + "  group by MDUBI order by MDUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listamddom.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarPodom(JComboBox Listapodom, String padom, String esdom, String mddom){
        try{
            String sql="select POUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+padom+"' "
                    + "    and ESUBI = '"+esdom+"' "
                    + "    and MDUBI = '"+mddom+"' "
                    + "  group by POUBI order by POUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listapodom.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarCodom(JComboBox Listacodom, String padom, String esdom, String mddom, String podom){
        try{
            String sql="select COUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+padom+"' "
                    + "    and ESUBI = '"+esdom+"' "
                    + "    and MDUBI = '"+mddom+"' "
                    + "    and POUBI = '"+podom+"' "
                    + "  group by COUBI order by COUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacodom.addItem(rs.getString(i+1));
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
            String sql="select NOSEX from SEXOO12 where STSEX = 'SI' order by NOSEX";
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
    
    public void LlenarCivil(JComboBox Listacivil){
        try{
            String sql="select NOCIV from CIVIL06 where STCIV = 'SI' order by NOCIV";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacivil.addItem(rs.getString(i+1));
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
            String sql="select RFCHO, CUCHO, APCHO, AMCHO, NOCHO, STCHO, FECHO, USCHO "
                    + "   from CHOFE40 where STCHO = 'SI' order by RFCHO";
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
    
    public Object[] Comple(String rfcactual, String paterno, String materno, String nombre){
        Object[] datos=new Object[16];
        try{
            String sql="select SECHO, FNCHO, GMCHO, ECCHO, PACHO, ESCHO, MDCHO, LOCHO, "
                    + "        COCHO, CACHO, NECHO, NICHO, CPCHO, TDCHO, TCCHO, CECHO "
                    + "   from CHOFE40"
                    + "  where RFCHO = '"+rfcactual+"' "
                    + "    and APCHO = '"+paterno+"' "
                    + "    and AMCHO = '"+materno+"' "
                    + "    and NOCHO = '"+nombre+"' "
                    + "    and STCHO ='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<16; i++){
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

    public void Agregar(String rfccho, String curcho, String paterno, String materno, String nombre, String sexo, String nacim, String grado,
                        String civil, String pais, String estado, String mundel, String pobla, String colonia, String calle, String numext,
                        String numint, Integer codpos, String teldom, String telcel, String correo, String usuario){
        try{
           String sql="execute AgregarChofe ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfccho);
           cmd.setString(2, curcho);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, sexo);
           cmd.setString(7, nacim);
           cmd.setString(8, grado);
           cmd.setString(9, civil);
           cmd.setString(10, pais);
           cmd.setString(11, estado);
           cmd.setString(12, mundel);
           cmd.setString(13, pobla);
           cmd.setString(14, colonia);
           cmd.setString(15, calle);
           cmd.setString(16, numext);
           cmd.setString(17, numint);
           cmd.setInt(18, codpos);
           cmd.setString(19, teldom);
           cmd.setString(20, telcel);
           cmd.setString(21, correo);
           cmd.setString(22, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(String rfccho, String curcho, String paterno, String materno, String nombre, String sexo, String nacim, String grado,
                           String civil, String pais, String estado, String mundel, String pobla, String colonia, String calle, String numext,
                           String numint, Integer codpos, String teldom, String telcel, String correo, String usuario){
        try{
           String sql="execute ACtualizarChofe ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfccho);
           cmd.setString(2, curcho);
           cmd.setString(3, paterno);
           cmd.setString(4, materno);
           cmd.setString(5, nombre);
           cmd.setString(6, sexo);
           cmd.setString(7, nacim);
           cmd.setString(8, grado);
           cmd.setString(9, civil);
           cmd.setString(10, pais);
           cmd.setString(11, estado);
           cmd.setString(12, mundel);
           cmd.setString(13, pobla);
           cmd.setString(14, colonia);
           cmd.setString(15, calle);
           cmd.setString(16, numext);
           cmd.setString(17, numint);
           cmd.setInt(18, codpos);
           cmd.setString(19, teldom);
           cmd.setString(20, telcel);
           cmd.setString(21, correo);
           cmd.setString(22, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(String rfccho, String usuario){
        try{
            String sql= "update CHOFE40 set STCHO='NO', FECHO=getdate(), USCHO='"+usuario+"' "
                    + "   where RFCHO='"+rfccho+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BusRfc(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFCHO, CUCHO, APCHO, AMCHO, NOCHO, STCHO, FECHO, USCHO "
                    + "   from CHOFE40 where RFCHO like '%"+palabraactual+"%' and STCHO = 'SI' order by RFCHO";
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
    
    public void BusPat(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFCHO, CUCHO, APCHO, AMCHO, NOCHO, STCHO, FECHO, USCHO "
                    + "   from CHOFE40 where APCHO like '%"+palabraactual+"%' and STCHO = 'SI' order by RFCHO";
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
    
    public void BusMat(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFCHO, CUCHO, APCHO, AMCHO, NOCHO, STCHO, FECHO, USCHO "
                    + "   from CHOFE40 where AMCHO like '%"+palabraactual+"%' and STCHO = 'SI' order by RFCHO";
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
    
    public void BusNom(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select RFCHO, CUCHO, APCHO, AMCHO, NOCHO, STCHO, FECHO, USCHO "
                    + "   from CHOFE40 where NOCHO like '%"+palabraactual+"%' and STCHO = 'SI' order by RFCHO";
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
