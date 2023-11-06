package testJava;

import dao.*;
import domain.Marca;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MarcaTest {

    private IMarcaDAO marcaDAO;

    public MarcaTest(){
        marcaDAO = new MarcaDAO();
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
    }

    @Test
    public void excluirTest(){
        Marca marca = new Marca();
        marca.setNome("FORD");
        marca.setPais("EUA");
        marca.setAnoCriacao(1903);
        marca.setRankMercado(60);
        marca = marcaDAO.cadastrar(marca);
        Boolean verdade = marcaDAO.excluir(marca);
        assertTrue(verdade);
    }

    @Test
    public void buscarTodosTest(){
        Marca marca = new Marca();
        marca.setNome("FORD");
        marca.setPais("EUA");
        marca.setAnoCriacao(1903);
        marca.setRankMercado(60);


        Marca marca1 = new Marca();
        marca1.setNome("LAMBORGHINI");
        marca1.setPais("ITALIA");
        marca1.setAnoCriacao(1963);
        marca1.setRankMercado(6);


        marca = marcaDAO.cadastrar(marca);
        marca1 = marcaDAO.cadastrar(marca1);

        List<Marca>marcas = new ArrayList<>();
        marcas.add(marca);
        marcas.add(marca1);
        List<Marca>marcasCadastradas = marcaDAO.buscarTodos();
        assertEquals(marcas,marcasCadastradas);
    }
}
