import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "Mouse";
        String desc = "Testa Mouse";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        stm.setString(1, nome);
        stm.setString(2, desc);

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }


    }
}
