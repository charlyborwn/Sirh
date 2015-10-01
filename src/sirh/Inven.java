
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Inven {
    Connection cn;

    public Inven(){
        Conexion con=new Conexion();
        cn=con.getConexion();
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
    
    public void LlenarDatos1(DefaultTableModel modelo1, String nomempresa){
        try{
            String sql="select CEINV, NEINV, FIINV, ARINV, MOINV, TAINV, CAINV"
                    + "   from INVEN37 "
                    + "  where TIINV = 'ENTRADA' "
                    + "    and NEINV= '"+nomempresa+"' "
                    + "    and STINV = 'SI' order by ARINV, MOINV, FIINV";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos1=new Object[7];
                for(int i=0; i<7; i++){
                    datos1[i]=rs.getString(i+1);
                }
                modelo1.addRow(datos1);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void Agregar1(String cveemp, String nomemp, String fecmov, String tipmov, String desart, String modart, String talla,
                        Integer cant, Integer numtra, String nomtra, String usuario){
        try{
           String sql="execute AgregarInven ?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, cveemp);
           cmd.setString(2, nomemp);
           cmd.setString(3, fecmov);
           cmd.setString(4, tipmov);
           cmd.setString(5, desart);
           cmd.setString(6, modart);
           cmd.setString(7, talla);
           cmd.setInt(8, cant);
           cmd.setInt(9, numtra);
           cmd.setString(10, nomtra);
           cmd.setString(11, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar1(String cveemp, String fmov, String tipmov, String desart, String modart, String talla, Integer cant, String usuario){
        try{
            String sql= "update INVEN37 set STINV='NO', FEINV=getdate(), USINV='"+usuario+"' "
                    + "   where CEINV='"+cveemp+"' and FIINV = '"+fmov+"' and TIINV = '"+tipmov+"' and ARINV ='"+desart+"' "
                    + "     and MOINV = '"+modart+"' and TAINV='"+talla+"' and CAINV = "+cant+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void Eliminar2(String cveemp, String fmov, String tipmov, String desart, String modart, String talla, Integer cant, 
                          Integer numtraba, String usuario){
        try{
            String sql= "update INVEN37 set STINV='NO', FEINV=getdate(), USINV='"+usuario+"' "
                    + "   where CEINV = '"+cveemp+"' and FIINV = '"+fmov+"' and TIINV = '"+tipmov+"' and ARINV = '"+desart+"' "
                    + "     and MOINV = '"+modart+"' and TAINV ='"+talla+"' and CAINV = "+cant+"  and NTINV = "+numtraba+" ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public Object[] Datos1(String clave){
        Object[] datos1=new Object[1];
        try{
            String sql="select NOEMP from EMPRE04 where CVEMP='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos1[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos1;
    }
    
    public void LlenarCvetrabajador(JComboBox Listatrabajador){
        try{
            String sql="select NUTRA from TRABA36 where STTRA = 'SI' order by NUTRA";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listatrabajador.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void LlenarDatos2(DefaultTableModel modelo2, String nomempresa){
        try{
            String sql="select CEINV, NEINV, FIINV, ARINV, MOINV, TAINV, CAINV, NTINV, NNINV"
                    + "   from INVEN37 "
                    + "  where TIINV = 'SALIDA' "
                    + "    and NEINV= '"+nomempresa+"' "
                    + "    and STINV = 'SI' order by NTINV";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                Object[] datos2=new Object[9];
                for(int i=0; i<9; i++){
                    datos2[i]=rs.getString(i+1);
                }
                modelo2.addRow(datos2);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos2(Integer clave){
        Object[] datos2=new Object[1];
        try{
            String sql="select NOTRA+' '+APTRA+' '+AMTRA from TRABA36 where NUTRA="+clave+"";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos2[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos2;
    }
    
    public void ActCrear(Integer numtrab, Integer articulo, String talla, String fecha, Integer cantidad, String usuario){
        switch(articulo){
            case 1:
                try{
                String sql= "update DATOS28 "
                        + "     set VCDAT=VCDAT+"+cantidad+", CCDAT = '"+talla+"', FCDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
            case 2:
                try{
                String sql= "update DATOS28 "
                        + "     set VPDAT=VPDAT+"+cantidad+", PPDAT = '"+talla+"', FPDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
            case 3:
                try{
                String sql= "update DATOS28 "
                        + "     set VZDAT=VZDAT+"+cantidad+", ZADAT = '"+talla+"', FZDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
        }
    }
    
    public void ActEliminar(Integer numtrab, Integer articulo, String talla, String fecha, Integer cantidad, String usuario){
        switch(articulo){
            case 1:
                try{
                String sql= "update DATOS28 "
                        + "     set VCDAT=VCDAT-"+cantidad+", CCDAT = '"+talla+"', FCDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
            case 2:
                try{
                String sql= "update DATOS28 "
                        + "     set VPDAT=VPDAT-"+cantidad+", PPDAT = '"+talla+"', FPDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
            case 3:
                try{
                String sql= "update DATOS28 "
                        + "     set VZDAT=VZDAT-"+cantidad+", ZADAT = '"+talla+"', FZDAT='"+fecha+"', FEDAT=getdate(), USDAT='"+usuario+"' "
                        + "   where NTDAT="+numtrab+" and STDAT='SI'";
                PreparedStatement cmd=cn.prepareCall(sql);
                cmd.execute();
                cmd.close();
                cn.close();
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());              
                }
                break;
        }
    }
    
    public Object[] Datos3(String cveemp, String desart, String modart, String talla){
        Object[] datos3=new Object[1];
        try{
            String sql="select SUM(CAINV)"
                    + "   from INVEN37 "
                    + "  where CEINV = '"+cveemp+"' and ARINV = '"+desart+"' and MOINV = '"+modart+"' "
                    + "    and TAINV = '"+talla+"' and STINV = 'SI' ";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    datos3[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos3;
    }
    
}