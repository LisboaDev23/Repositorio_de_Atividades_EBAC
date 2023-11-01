package javaTest;

import org.junit.Test;
import src.main.java.dao.EmpresarioDAO;
import src.main.java.dao.FabricaDAO;
import src.main.java.dao.IEmpresarioDAO;
import src.main.java.dao.IFabricaDAO;
import src.main.java.domain.Empresario;
import src.main.java.domain.Fabrica;
import src.main.java.domain.Produto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class FabricaTest {

    private IFabricaDAO fabricaDAO;
    private IEmpresarioDAO empresarioDAO;

    public FabricaTest(){
        fabricaDAO = new FabricaDAO();
        empresarioDAO = new EmpresarioDAO();
    }
    @Test
    public void cadastrar(){
        Fabrica fabrica = criandoEmpresario(19134960309L);
        fabrica = fabricaDAO.cadastrar(fabrica);
        assertNotNull(fabrica);
        assertNotNull(fabrica.getId());

    }

    private static Fabrica criandoFabrica(Empresario empresario){
        Fabrica fabrica = new Fabrica();
        fabrica.setEmpresario(empresario);
        fabrica.setNome("Fábrica de Chocolates");
        fabrica.setProdutos(addProdutosFabrica(fabrica));
        return fabrica;
    }

    private static List<Produto> addProdutosFabrica(Fabrica fabrica){
        List<Produto>produtos = new ArrayList<>();
        Produto neuguebauer = new Produto();
        neuguebauer.setNome("Chocolate Neuguebauer");
        neuguebauer.setPreco(4.99);
        neuguebauer.setCodigo(98958L);
        neuguebauer.setFabrica(fabrica);
        neuguebauer.setDataFabricacao("05/12/2022");
        produtos.add(neuguebauer);

        Produto lacta = new Produto();
        lacta.setNome("Chocolate Lacta");
        lacta.setPreco(7.99);
        lacta.setCodigo(95895L);
        lacta.setFabrica(fabrica);
        lacta.setDataFabricacao("02/08/2022");
        produtos.add(lacta);
        return produtos;
    }

    private Fabrica criandoEmpresario(Long cnpj){
        Empresario gabriel = new Empresario();
        gabriel.setNome("Gabriel Pereira Lisboa");
        gabriel.setCnpj(cnpj);
        Fabrica fabrica = criandoFabrica(gabriel);
        gabriel.setFabrica(fabrica);
        return fabrica;
    }
}
