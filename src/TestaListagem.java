import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        //criando query
        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTOS");

        //gerando o select (em formato boolean)
        stm.execute();

        //transformando o boolean em lista
        ResultSet rst = stm.getResultSet();

        //lendo todos os itens da lista
        while (rst.next()){
            //pegar o conteudo da coluna (pode ser por label-nomedacoluna- ou index-numerocol-)
            Integer id = rst.getInt("ID");
            //imprimir o que foi resgatado no item anterior
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String desc = rst.getString("DESCRICAO");
            System.out.println(desc);
        }


        con.close();


    }
}
