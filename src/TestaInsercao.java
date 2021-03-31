import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES ('Mouse', 'Mouse sem fio Logitech')",
                Statement.RETURN_GENERATED_KEYS); //retornar o id gerado

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }


    }
}
