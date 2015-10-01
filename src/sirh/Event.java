
package sirh;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Event {
    Connection cn;
    
    public Event(){
        Conexion con=new Conexion();
        cn=con.getConexion();
    }

    public void LlenarDatos(DefaultTableModel modelo){
        try{
            String sql="select NUEVE, NEEVE, FCEVE, HOEVE, UNEVE, RUEVE, DEEVE, STEVE, FEEVE, USEVE "
                    + "   from EVENT43 where STEVE = 'SI' order by NUEVE DESC";
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
    
    public Object[] Comple(Integer numactual){
        Object[] datos=new Object[10];
        try{
            String sql="select CEEVE, MAEVE, MOEVE, PLEVE, ROEVE, RDEVE, RFEVE, NCEVE, TCEVE, REEVE "
                    + "   from EVENT43"
                    + "  where NUEVE = "+numactual+" "
                    + "    and STEVE ='SI'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<10; i++){
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
    
    public void LlenarCveunidad(JComboBox Listacveunidad){
        try{
            String sql="select NUUNI from UNIDA42 where STUNI = 'SI' order by NUUNI";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveunidad.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos2(String clave){
        Object[] datos2=new Object[3];
        try{
            String sql="select MAUNI, MOUNI, PLUNI from UNIDA42 where NUUNI='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<3; i++){
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
    
    public void LlenarCveruta(JComboBox Listacveruta){
        try{
            String sql="select NURUT from RUTAS41 where STRUT = 'SI' order by NURUT";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveruta.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos3(String clave){
        Object[] datos3=new Object[2];
        try{
            String sql="select LORUT, LDRUT from RUTAS41 where NURUT='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<2; i++){
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
    
    public void LlenarCvechofer(JComboBox Listacveruta){
        try{
            String sql="select RFCHO from CHOFE40 where STCHO = 'SI' order by RFCHO";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<1; i++){
                    Listacveruta.addItem(rs.getString(i+1));
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Object[] Datos4(String clave){
        Object[] datos4=new Object[2];
        try{
            String sql="select NOCHO+' '+APCHO+' '+AMCHO, TCCHO from CHOFE40 where RFCHO='"+clave+"'";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
                for(int i=0; i<2; i++){
                    datos4[i]=rs.getString(i+1);
                }
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return datos4;
    }
    
    public void Agregar(String cveemp, String nomemp, String feceve, String horeve, String numuni, String maruni, String moduni,
                        String plauni, String numrut, String orirut, String desrut, String rfccho, String nomcho, String celcho,
                        String deseve, String reseve, String usuario){
        try{
           String sql="execute AgregarEvent ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setString(1, cveemp);
           cmd.setString(2, nomemp);
           cmd.setString(3, feceve);
           cmd.setString(4, horeve);
           cmd.setString(5, numuni);
           cmd.setString(6, maruni);
           cmd.setString(7, moduni);
           cmd.setString(8, plauni);
           cmd.setString(9, numrut);
           cmd.setString(10, orirut);
           cmd.setString(11, desrut);
           cmd.setString(12, rfccho);
           cmd.setString(13, nomcho);
           cmd.setString(14, celcho);
           cmd.setString(15, deseve);
           cmd.setString(16, reseve);
           cmd.setString(17, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Actualizar(Integer numeve, String cveemp, String nomemp, String feceve, String horeve, String numuni, String maruni,
                           String moduni, String plauni, String numrut, String orirut, String desrut, String rfccho, String nomcho,
                           String celcho, String deseve, String reseve, String usuario){
        try{
           String sql="execute ActualizarEvent ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
           PreparedStatement cmd=cn.prepareCall(sql);
           cmd.setInt(1, numeve);
           cmd.setString(2, cveemp);
           cmd.setString(3, nomemp);
           cmd.setString(4, feceve);
           cmd.setString(5, horeve);
           cmd.setString(6, numuni);
           cmd.setString(7, maruni);
           cmd.setString(8, moduni);
           cmd.setString(9, plauni);
           cmd.setString(10, numrut);
           cmd.setString(11, orirut);
           cmd.setString(12, desrut);
           cmd.setString(13, rfccho);
           cmd.setString(14, nomcho);
           cmd.setString(15, celcho);
           cmd.setString(16, deseve);
           cmd.setString(17, reseve);
           cmd.setString(18, usuario);
           cmd.execute();
           cmd.close();
           cn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());            
        }
    }
    
    public void Eliminar(Integer numeve, String cveemp, String nomemp, String usuario){
        try{
            String sql= "update EVENT43 set STEVE='NO', FEEVE=getdate(), USEVE='"+usuario+"' "
                    + "   where NUEVE="+numeve+" and CEEVE='"+cveemp+"' and NEEVE='"+nomemp+"' ";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.execute();
            cmd.close();
            cn.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());              
        }
    }
    
    public void BusNum(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUEVE, NEEVE, FCEVE, HOEVE, UNEVE, RUEVE, DEEVE, STEVE, FEEVE, USEVE "
                    + "   from EVENT43 where NUEVE like '%"+palabraactual+"%' and STEVE = 'SI' order by NUEVE";
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
    
    public void BusEmp(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUEVE, NEEVE, FCEVE, HOEVE, UNEVE, RUEVE, DEEVE, STEVE, FEEVE, USEVE "
                    + "   from EVENT43 where NEEVE like '%"+palabraactual+"%' and STEVE = 'SI' order by NUEVE";
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
    
    public void BusDes(DefaultTableModel modelo, String palabraactual){
        try{
            String sql="select NUEVE, NEEVE, FCEVE, HOEVE, UNEVE, RUEVE, DEEVE, STEVE, FEEVE, USEVE "
                    + "   from EVENT43 where DEEVE like '%"+palabraactual+"%' and STEVE = 'SI' order by NUEVE";
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
    
}
