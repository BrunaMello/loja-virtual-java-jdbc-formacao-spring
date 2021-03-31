import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/loja_virtual";

        return DriverManager.getConnection(URL, "root", "#Root123");
    };
}
