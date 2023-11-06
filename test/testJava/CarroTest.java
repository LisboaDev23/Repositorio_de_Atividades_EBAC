package testJava;

import dao.*;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarroTest {
    //propriedades para podermos instanciar como objetos do DAO onde irão conectar com o banco de dados
    private IMarcaDAO marcaDAO;
    private ICarroDAO carroDAO;

    public CarroTest(){
        marcaDAO = new MarcaDAO();
        carroDAO = new CarroDAO();
    }

    @Test
    public void cadastrarTest(){
        Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);
        assertNotNull(marca);
        assertNotNull(marca.getId());

        Carro carro = new Carro();
        carro.setNome("Ferrari GTX 3060");
        carro.setCodigo(65589544L);
        carro.setMarca(marca);
        carro.setAnoFabricacao(2022);
        carro.setPreco(880000.00);
        carro=carroDAO.cadastrar(carro);
        assertNotNull(carro);
        assertNotNull(carro.getId());
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

        Boolean trueExcluirCarro = carroDAO.excluir(carro);
        Boolean trueExcluirMarca = marcaDAO.excluir(marca);

        assertTrue(trueExcluirCarro);
        assertTrue(trueExcluirMarca);
    }
    @Test
    public void buscarTodosTest(){
        Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);

        Marca marca1 = new Marca();
        marca1.setNome("LAMBORGHINI");
        marca1.setPais("ITALIA");
        marca1.setAnoCriacao(1969);
        marca1.setRankMercado(4);
        marca1 = marcaDAO.cadastrar(marca1);

        Carro carro = new Carro();
        carro.setNome("Ferrari GTX 3060");
        carro.setCodigo(65589544L);
        carro.setMarca(marca);
        carro.setAnoFabricacao(2022);
        carro.setPreco(880000.00);
        carro=carroDAO.cadastrar(carro);

        Carro carro1 = new Carro();
        carro1.setNome("Lamborghini 4060 TI");
        carro1.setCodigo(8955384455L);
        carro1.setMarca(marca1);
        carro1.setAnoFabricacao(2022);
        carro1.setPreco(880000.00);
        carro1=carroDAO.cadastrar(carro1);

        List<Carro> carros = new ArrayList<>();
        carros.add(carro);
        carros.add(carro1);

        List<Carro> carrosCadastrados;
        carrosCadastrados = carroDAO.buscarTodos();
        assertEquals(carros,carrosCadastrados);

    }
}
