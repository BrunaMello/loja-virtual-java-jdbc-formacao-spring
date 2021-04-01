package br.com.alura.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    //configuracao do pool de conexoes
    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("#Root123");

        //configurar conexoes maximas disponiveis
        comboPooledDataSource.setMaxPoolSize(15);


        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException {
        //chamando a conexao do construtor acima
        return this.dataSource.getConnection();
    };
}
