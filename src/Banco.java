
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        rs.close();
        return f;
    }
    ArrayList<Produto> ListarProdutos(String idLoja) throws SQLException {
        ArrayList<Produto> p = new ArrayList<Produto>();
        ResultSet rs = this.stmt.executeQuery("SELECT p.* FROM produto AS p INNER JOIN estoque AS e ON e.produto_id = p.id WHERE e.loja_id = "+idLoja+" AND quantidade > 0");
        while (rs.next()) {                
            p.add(new Produto(rs.getInt("id"), rs.getString("nome")));
        } 
        rs.close();
        return p;
    }
    Venda itemVenda(String s) throws SQLException {
        Venda v = null;
        ResultSet rs = this.stmt.executeQuery("SELECT p.id, p.nome, e.valor, e.quantidade FROM produto AS p INNER JOIN estoque AS e ON e.produto_id = p.id WHERE p.nome = '"+s+"'");
        while (rs.next()) { 
            v = new Venda(rs.getInt("id"), rs.getString("nome"), rs.getFloat("valor"), rs.getInt("quantidade"), 0);
        } 
        rs.close();
        return v;
    }
    void vender(ArrayList<Venda> it, int idLoja, String V) throws SQLException {
        
        
        try {
            float total = 0;
            for (int i = 0 ; i < it.size() ; i++){
                total = total + it.get(i).getValor();
            }
            //inserir a venda
            this.stmt.executeUpdate("INSERT INTO venda (valor_tot, quantidade_total, funcionario) VALUES ("
                    + "\"" + total + "\","
                    + "\"" + it.size() + "\","
                    + "\"" + V + "\")");
            //inserir os item na venda
            for (int i = 0 ; i < it.size() ; i++){
                this.stmt.executeUpdate("INSERT INTO itensVenda (venda_id, produto_id, descricaoProduto, quantidade, valor) VALUES ("
                        + "\"1\","
                        + "\"" + it.get(i).getId() + "\","
                        + "\"" + it.get(i).getNome() + "\","
                        + "\"" + it.get(i).getQuantidadeVendida()+ "\","
                        + "\"" + it.get(i).getValor() + "\")");
                int qtd = it.get(i).getQuantidade() - it.get(i).getQuantidadeVendida();
                //dar baixa no estoque
                this.stmt.executeUpdate("UPDATE estoque SET quantidade = "+qtd+" WHERE produto_id = "
                        +it.get(i).getId()+" AND loja_id = "+idLoja);
            }
            // log
            String msg = "Venda realizada com sucesso pelo funcionario "+V;
            this.stmt.executeUpdate("INSERT INTO log (descricao,loja_id) VALUES ("
                    + "\"" + msg + "\","
                    + "\"" + idLoja + "\")");
        } catch (SQLException ex) {
            String msg = "Erro ao processar venda pelo funcionario "+V;
            this.stmt.executeUpdate("INSERT INTO log (descricao,loja_id) VALUES ("
                    + "\"" + msg + "\","
                    + "\"" + idLoja + "\")");
        }
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
