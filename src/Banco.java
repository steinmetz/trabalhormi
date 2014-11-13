
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

    public ResultSet executeSql(String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            
            
            

            Connection conn = null;
            conn =
                    DriverManager.getConnection("jdbc:mysql://db4free.net:3306/trabalho?"
                    + "user=steinmetz&password=steinmetz");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
                stmt = null;
            }
        }
        return rs;
    }
}
