
package sirh;

import java.sql.*;
import javax.swing.JComboBox;

public class DatosA {
    
    private static String rfcUsuario;
    public static String getRfcUsuario() {
        return rfcUsuario;
    }

    public static void setRfcUsuario(String aRfcUsuario) {
        rfcUsuario = aRfcUsuario;
    }

    Connection cn;

    public DatosA(){
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

    public void LlenarPanac(JComboBox Listapanac){
        try{
            String sql="select PAUBI from UBICA23 where STUBI = 'SI' group by PAUBI order by PAUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listapanac.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarEsnac(JComboBox Listaesnac, String panac){
        try{
            String sql="select ESUBI from UBICA23 where STUBI = 'SI' and PAUBI = '"+panac+"' group by ESUBI order by ESUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaesnac.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarMdnac(JComboBox Listamdnac, String panac, String esnac){
        try{
            String sql="select MDUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+panac+"' "
                    + "    and ESUBI = '"+esnac+"' "
                    + "  group by MDUBI order by MDUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listamdnac.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarPonac(JComboBox Listaponac, String panac, String esnac, String mdnac){
        try{
            String sql="select POUBI from UBICA23 "
                    + "  where STUBI = 'SI' "
                    + "    and PAUBI = '"+panac+"' "
                    + "    and ESUBI = '"+esnac+"' "
                    + "    and MDUBI = '"+mdnac+"' "
                    + "  group by POUBI order by POUBI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listaponac.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarReligion(JComboBox Listareligion){
        try{
            String sql="select NOREL from RELIG11 where STREL = 'SI' order by NOREL";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listareligion.addItem(rs.getString(i+1));
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

    public void LlenarSangre(JComboBox Listasangre){
        try{
            String sql="select CVSAN from SANGR21 where STSAN = 'SI' order by CVSAN";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasangre.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void LlenarSino(JComboBox Listasino){
        try{
            String sql="select CVSIN from SI_NO13";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listasino.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos(String rfcactual){
        Object[] datos=new Object[39];
        try{
            String sql="select * from DATOS28A where RFDAT_A = '"+rfcactual+"' and STDAT_A='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<39; i++){
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
    
    public void Agregar(String rfc, String padom, String esdom, String mddom, String podom, String codom, String calle, String exterior, String interior,
                        String referencias, Integer codigo, String telefono, String celular, String correo, String panac, String esnac, String mdnac,
                        String ponac, String religion, String civil, String sangre, Float peso, String fpeso, Float estatura, String festatura,
                        String extra1, String extra2, String camisa, String pantalon, String zapatos, String recom1, String miem1, String fam1,
                        String recom2, String miem2, String fam2, String usuario){
        try{
           String sql="execute AgregarDatosA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, padom);
           cmd.setString(3, esdom);
           cmd.setString(4, mddom);
           cmd.setString(5, podom);
           cmd.setString(6, codom);
           cmd.setString(7, calle);
           cmd.setString(8, exterior);
           cmd.setString(9, interior);
           cmd.setString(10, referencias);
           cmd.setInt(11, codigo);
           cmd.setString(12, telefono);
           cmd.setString(13, celular);
           cmd.setString(14, correo);
           cmd.setString(15, panac);
           cmd.setString(16, esnac);
           cmd.setString(17, mdnac);
           cmd.setString(18, ponac);
           cmd.setString(19, religion);
           cmd.setString(20, civil);
           cmd.setString(21, sangre);
           cmd.setFloat(22, peso);
           cmd.setString(23, fpeso);
           cmd.setFloat(24, estatura);
           cmd.setString(25, festatura);
           cmd.setString(26, extra1);
           cmd.setString(27, extra2);
           cmd.setString(28, camisa);
           cmd.setString(29, pantalon);
           cmd.setString(30, zapatos);
           cmd.setString(31, recom1);
           cmd.setString(32, miem1);
           cmd.setString(33, fam1);
           cmd.setString(34, recom2);
           cmd.setString(35, miem2);
           cmd.setString(36, fam2);
           cmd.setString(37, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(String rfc, String padom, String esdom, String mddom, String podom, String codom, String calle, String exterior, String interior,
                           String referencias, Integer codigo, String telefono, String celular, String correo, String panac, String esnac, String mdnac,
                           String ponac, String religion, String civil, String sangre, Float peso, String fpeso, Float estatura, String festatura,
                           String extra1, String extra2, String camisa, String pantalon, String zapatos, String recom1, String miem1, String fam1,
                           String recom2, String miem2, String fam2, String usuario){
        try{
           String sql="execute ActualizarDatosA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, rfc);
           cmd.setString(2, padom);
           cmd.setString(3, esdom);
           cmd.setString(4, mddom);
           cmd.setString(5, podom);
           cmd.setString(6, codom);
           cmd.setString(7, calle);
           cmd.setString(8, exterior);
           cmd.setString(9, interior);
           cmd.setString(10, referencias);
           cmd.setInt(11, codigo);
           cmd.setString(12, telefono);
           cmd.setString(13, celular);
           cmd.setString(14, correo);
           cmd.setString(15, panac);
           cmd.setString(16, esnac);
           cmd.setString(17, mdnac);
           cmd.setString(18, ponac);
           cmd.setString(19, religion);
           cmd.setString(20, civil);
           cmd.setString(21, sangre);
           cmd.setFloat(22, peso);
           cmd.setString(23, fpeso);
           cmd.setFloat(24, estatura);
           cmd.setString(25, festatura);
           cmd.setString(26, extra1);
           cmd.setString(27, extra2);
           cmd.setString(28, camisa);
           cmd.setString(29, pantalon);
           cmd.setString(30, zapatos);
           cmd.setString(31, recom1);
           cmd.setString(32, miem1);
           cmd.setString(33, fam1);
           cmd.setString(34, recom2);
           cmd.setString(35, miem2);
           cmd.setString(36, fam2);
           cmd.setString(37, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(String rfc, String usuario){
        try{
            String sql= "update DATOS28A set STDAT_A='NO',FEDAT_A=getdate(), USDAT_A='"+usuario+"' where RFDAT_A='"+rfc+"'";
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
