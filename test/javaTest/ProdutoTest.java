package javaTest;

import org.junit.Test;
import src.main.java.dao.IProdutoDAO;
import src.main.java.dao.ProdutoDAO;
import src.main.java.domain.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
        private IProdutoDAO produtoDAO;

        public ProdutoTest(){
            produtoDAO = new ProdutoDAO();
        }
        @Test
        public void cadastrarTest(){
            Produto produto = new Produto();
            produto.setNome("Notebook Acer Nitro 5 version 3");
            produto.setCodigo(9985642235894L);
            produto.setDataFabricacao("15/10/2023");
            produto.setPreco(4580D);

            produto = produtoDAO.cadastrar(produto);

            assertNotNull(produto);
            assertNotNull(produto.getId());
        }

        @Test
        public void excluirTest(){
            Produto produto = new Produto();
            produto.setNome("Notebook DELL G15 version 2");
            produto.setCodigo(9866521874459L);
            produto.setDataFabricacao("08/07/2023");
            produto.setPreco(5800D);

            produto = produtoDAO.cadastrar(produto);
            Boolean verdade = produtoDAO.excluir(produto);
            assertTrue(verdade);

        }

        @Test
        public void buscarTodosTest(){
            Produto produto = new Produto();
            produto.setNome("Notebook DELL G15 version 2");
            produto.setCodigo(333L);
            produto.setDataFabricacao("08/07/2023");
            produto.setPreco(5800D);

            Produto produto2 = new Produto();
            produto.setNome("Notebook I3 Lenovo Gaming");
            produto.setCodigo(932L);
            produto.setDataFabricacao("14/08/2023");
            produto.setPreco(3800D);

            produto = produtoDAO.cadastrar(produto);
            produto2 = produtoDAO.cadastrar(produto2);

            List<Produto>produtos= new ArrayList<>();
            produtos.add(produto);
            produtos.add(produto2);

            List<Produto> produtosCadastrados = produtoDAO.buscarTodos();

            assertEquals(produtos,produtosCadastrados);
        }
    }

