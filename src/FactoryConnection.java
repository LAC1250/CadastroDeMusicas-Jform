
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
    public static Connection getConnection(){
      String url = "jdbc:postgresql://localhost/trablp3?user=postgres&password=postgres";
        Connection conn; 
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex){
          ex.printStackTrace();
          conn = null;
        }
        return conn;
    }  
}
