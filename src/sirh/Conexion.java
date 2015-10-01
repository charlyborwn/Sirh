
package sirh;

import java.sql.*;

public class Conexion {

    public static Connection getConexion(){
    
        Connection con=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://sirh.dyndns.org\\SQLEXPRESS:1433;" +
                    "databaseName=SIRH_Prueba;user=sa;password=Power1;";
                    con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+cE.toString());
        }
        return con;
    }
}
