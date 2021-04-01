package br.com.alura.jdbc;

import java.sql.*;


public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTOS WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        //contar quantas linhas foram modificadas
        Integer linhasmodificadas = stm.getUpdateCount();

        System.out.println("QTD linha modificadas: " + linhasmodificadas);


    }

}
