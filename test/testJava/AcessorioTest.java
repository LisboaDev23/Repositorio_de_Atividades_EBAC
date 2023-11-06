package testJava;
import static org.junit.Assert.*;

import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AcessorioTest {
    //definir as propriedades de interface DAO para poder instanciar elas como DAO.
    private IMarcaDAO marcaDAO;
    private ICarroDAO carroDAO;
    private IAcessorioDAO acessorioDAO;

    //definir o construtor onde nele eu irei instanciar esses objetos como DAO para fazer a conexão com o BD
    public AcessorioTest(){
        marcaDAO = new MarcaDAO();
        carroDAO = new CarroDAO();
        acessorioDAO = new AcessorioDAO();
    }
    @Test
    public void cadastrarTest(){
        Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);

        Carro carro = new Carro();
        carro.setNome("Ferrari GTX 3060");
        carro.setCodigo(65589544L);
        carro.setMarca(marca);
        carro.setAnoFabricacao(2022);
        carro.setPreco(880000.00);
        carro=carroDAO.cadastrar(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Retrovisores");
        acessorio.setCodigo(5888745654488L);
        acessorio.setTipoAcessorio("Segurança e essencial");
        acessorio.setPreco(3000.00);
        acessorio.setCarro(carro);
        acessorio = acessorioDAO.cadastrar(acessorio);

        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());
    }

    @Test
    public void excluirTest(){
        Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);

        Carro carro = new Carro();
        carro.setNome("Ferrari GTX 3060");
        carro.setCodigo(65589544L);
        carro.setMarca(marca);
        carro.setAnoFabricacao(2022);
        carro.setPreco(880000.00);
        carro=carroDAO.cadastrar(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Retrovisores");
        acessorio.setCodigo(5888745654488L);
        acessorio.setTipoAcessorio("Segurança e essencial");
        acessorio.setPreco(3000.00);
        acessorio.setCarro(carro);
        acessorio = acessorioDAO.cadastrar(acessorio);

        Boolean trueAcessorio = acessorioDAO.excluir(acessorio);
        Boolean trueCarro = carroDAO.excluir(carro);
        Boolean trueMarca = marcaDAO.excluir(marca);

        assertTrue(trueMarca);
        assertTrue(trueCarro);
        assertTrue(trueAcessorio);
    }

    @Test
    public void buscarTodosTest(){
        Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);

        Carro carro = new Carro();
        carro.setNome("Ferrari GTX 3060");
        carro.setCodigo(65589544L);
        carro.setMarca(marca);
        carro.setAnoFabricacao(2022);
        carro.setPreco(880000.00);
        carro=carroDAO.cadastrar(carro);

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Retrovisores");
        acessorio.setCodigo(5888745654488L);
        acessorio.setTipoAcessorio("Segurança e essencial");
        acessorio.setPreco(3000.00);
        acessorio.setCarro(carro);
        acessorio = acessorioDAO.cadastrar(acessorio);

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Rodas Traseiras");
        acessorio1.setCodigo(988556552L);
        acessorio1.setTipoAcessorio("Mobilidade e essencial");
        acessorio1.setPreco(55000.00);
        acessorio1.setCarro(carro);
        acessorio1 = acessorioDAO.cadastrar(acessorio1);

        List<Acessorio> acessorioList = new ArrayList<>();
        acessorioList.add(acessorio);
        acessorioList.add(acessorio1);

        List<Acessorio> acessoriosCadastrados = acessorioDAO.buscarTodos();

        assertEquals(acessorioList,acessoriosCadastrados);

    }
}
