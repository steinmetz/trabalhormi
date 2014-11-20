
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Banco {
    
    private Connection conn;
    private Statement stmt;
    
    public Banco() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/trabalho?user=steinmetz&password=steinmetz");
        this.stmt = this.conn.createStatement();
    }
    public void desconecta() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!\n Erro:" + ex.getMessage());
        }
    }
    public Funcionario login(String nome, String senha) throws SQLException {
        Funcionario f = null;
        ResultSet rs = this.stmt.executeQuery("SELECT * FROM funcionario WHERE login='"+nome+"' AND senha='"+senha+"'");
        if(!rs.next()){
          return null;
        } else{
          f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"), rs.getString("login"), rs.getString("senha"), rs.getInt("loja_id"));
        } 
        return f;
    }

//    public ResultSet executeSql(String sql) {
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            Connection conn = null;
//            conn =
//                    DriverManager.getConnection("jdbc:mysql://db4free.net:3306/trabalho?"
//                    + "user=steinmetz&password=steinmetz");
//
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        } finally {
//            if (rs != null) {
//                try {
////                    rs.close();
//                } catch (SQLException sqlEx) {
//                }
//                rs = null;
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException sqlEx) {
//                }
//                stmt = null;
//            }
//        }
//        return rs;
//    }
}
