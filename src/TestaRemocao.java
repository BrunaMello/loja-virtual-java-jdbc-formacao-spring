import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        Statement stm = con.createStatement();
        stm.execute("DELETE FROM PRODUTOS WHERE ID > 3");

        //contar quantas linhas foram modificadas
        Integer linhasmodificadas = stm.getUpdateCount();

        System.out.println("QTD linha modificadas: " + linhasmodificadas);


    }

}
