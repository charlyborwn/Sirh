
package sirh;

import java.sql.*;
import javax.swing.JComboBox;

public class Datos {
    
    private static Integer numTrabaja;
    public static Integer getNumTrabaja() {
        return numTrabaja;
    }

    public static void setNumTrabaja(Integer aNumTrabaja) {
        numTrabaja = aNumTrabaja;
    }

    Connection cn;

    public Datos(){
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
    
    public Object[] Datos(Integer numactual){
        Object[] datos=new Object[45];
        try{
            String sql="select * from DATOS28 where NTDAT = "+numactual+" and STDAT='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<45; i++){
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
    
    public void Agregar(Integer numtra, String padom, String esdom, String mddom, String podom, String codom, String calle, String exterior,
                        String interior, String referencias, Integer codigo, String telefono, String celular, String correo, String panac,
                        String esnac, String mdnac, String ponac, String religion, String civil, String sangre, Float peso, String fpeso,
                        Float estatura, String festatura, String extra1, String extra2, String camisa, Integer vcamisa, String fcamisa,
                        String pantalon, Integer vpantalon, String fpantalon, String zapatos, Integer vzapatos, String fzapatos, String recom1,
                        String miem1, String fam1, String recom2, String miem2, String fam2, String usuario){
        try{
           String sql="execute AgregarDatos ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
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
           cmd.setInt(29, vcamisa);
           cmd.setString(30, fcamisa);
           cmd.setString(31, pantalon);
           cmd.setInt(32, vpantalon);
           cmd.setString(33, fpantalon);
           cmd.setString(34, zapatos);
           cmd.setInt(35, vzapatos);
           cmd.setString(36, fzapatos);
           cmd.setString(37, recom1);
           cmd.setString(38, miem1);
           cmd.setString(39, fam1);
           cmd.setString(40, recom2);
           cmd.setString(41, miem2);
           cmd.setString(42, fam2);
           cmd.setString(43, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }

    public void Actualizar(Integer numtra, String padom, String esdom, String mddom, String podom, String codom, String calle, String exterior,
                        String interior, String referencias, Integer codigo, String telefono, String celular, String correo, String panac,
                        String esnac, String mdnac, String ponac, String religion, String civil, String sangre, Float peso, String fpeso,
                        Float estatura, String festatura, String extra1, String extra2, String camisa, Integer vcamisa, String fcamisa,
                        String pantalon, Integer vpantalon, String fpantalon, String zapatos, Integer vzapatos, String fzapatos, String recom1,
                        String miem1, String fam1, String recom2, String miem2, String fam2, String usuario){
        try{
           String sql="execute ActualizarDatos ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numtra);
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
           cmd.setInt(29, vcamisa);
           cmd.setString(30, fcamisa);
           cmd.setString(31, pantalon);
           cmd.setInt(32, vpantalon);
           cmd.setString(33, fpantalon);
           cmd.setString(34, zapatos);
           cmd.setInt(35, vzapatos);
           cmd.setString(36, fzapatos);
           cmd.setString(37, recom1);
           cmd.setString(38, miem1);
           cmd.setString(39, fam1);
           cmd.setString(40, recom2);
           cmd.setString(41, miem2);
           cmd.setString(42, fam2);
           cmd.setString(43, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }        
    }

    public void Eliminar(Integer numactual, String usuario){
        try{
            String sql= "update DATOS28 set STDAT='NO',FEDAT=getdate(), USDAT='"+usuario+"' where NTDAT="+numactual+" ";
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
