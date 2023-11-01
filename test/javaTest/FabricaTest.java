package javaTest;

import org.junit.Test;
import src.main.java.dao.*;
import src.main.java.domain.Empresario;
import src.main.java.domain.Fabrica;
import src.main.java.domain.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FabricaTest {

    private IFabricaDAO fabricaDAO;
    private IEmpresarioDAO empresarioDAO;
    private IProdutoDAO produtoDAO;

    public FabricaTest(){
        fabricaDAO = new FabricaDAO();
        empresarioDAO = new EmpresarioDAO();
        produtoDAO = new ProdutoDAO();

    }
    @Test
    public void cadastrar(){
//        Empresario gabriel = criandoEmpresario();
        Fabrica fabrica = criandoFabrica();
//        gabriel = empresarioDAO.cadastrar(gabriel);
        fabrica = fabricaDAO.cadastrar(fabrica);
        assertNotNull(fabrica);
        assertNotNull(fabrica.getId());

    }

    private static Fabrica criandoFabrica(){
        Fabrica fabrica = new Fabrica();
//        fabrica.setEmpresario(como passar o empresário já cadastrado // tentar chamar o metodo consultar passando o id do empresario);
        fabrica.setNome("Fábrica de Chocolates");
//        fabrica.setProdutos(addProdutosFabrica(fabrica));
        return fabrica;
    }

    private static List<Produto> addProdutosFabrica(){
        List<Produto>produtos = new ArrayList<>();
        Produto neuguebauer = new Produto();
        neuguebauer.setNome("Chocolate Neuguebauer");
        neuguebauer.setPreco(4.99);
        neuguebauer.setCodigo(98958L);
//        neuguebauer.setFabrica(fabrica);
        neuguebauer.setDataFabricacao("05/12/2022");
        produtos.add(neuguebauer);

        Produto lacta = new Produto();
        lacta.setNome("Chocolate Lacta");
        lacta.setPreco(7.99);
        lacta.setCodigo(95895L);
//        lacta.setFabrica(fabrica);
        lacta.setDataFabricacao("02/08/2022");
        produtos.add(lacta);
        return produtos;
    }

    private Empresario criandoEmpresario(){
        Empresario gabriel = new Empresario();
        gabriel.setNome("Gabriel Pereira Lisboa");
        gabriel.setCnpj(19134960309L);
        return gabriel;
    }
}
