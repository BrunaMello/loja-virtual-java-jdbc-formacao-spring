package br.com.alura.jdbc;

import java.sql.*;

public class TestaInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        //colocar o connection dentro dos parenteses no try ja faz com que ele feche automaticamente sem precisar explicitar no codigo
        try (Connection connection = connectionFactory.recuperarConexao()) {

            //retirar o poder de commit do JDBC para o programador controlar a trasacao do inicio ao fim
            connection.setAutoCommit(false);

            //colocar o prepare statemente dentro dos parenteses no try ja faz com que ele feche automaticamente sem precisar explicitar no codigo
            try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                adicionarVariavel("SmartTV", "45 polegadas", stm);
                adicionarVariavel("Radio", " radio bateria", stm);

                //caomitar manualmente
                connection.commit();


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Roolback executado");
                //desfazer toda a transacao manualmente
                connection.rollback();
            }

        }

    }

    private static void adicionarVariavel(String nome, String desc, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, desc);

        stm.execute();

       try (ResultSet rst = stm.getGeneratedKeys()){
           while (rst.next()){
               Integer id = rst.getInt(1);
               System.out.println("O ID criado foi: " + id);
           }
       }

    }
}
