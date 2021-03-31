import java.sql.*;

public class TestaConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        con.close();


    }

}
