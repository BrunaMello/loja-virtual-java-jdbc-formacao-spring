import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoComProduto {

    public static void main(String[] args) {

        Produto comoda = new Produto("comoda", "comoda vertical");

        try(Connection connection = new ConnectionFactory().recuperarConexao()){

            //adicionar um produto na tabela
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);

            //listar todos os produtos da tabela
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(comoda);
    }
}
