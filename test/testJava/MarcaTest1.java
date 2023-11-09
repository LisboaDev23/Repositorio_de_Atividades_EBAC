package testJava;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.IMarcaDAO1;
import dao.MarcaDAO1;
import dao.MarcaDAO2;
import domain.Marca;
import domain.Marca2;
import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;

public class MarcaTest1 {
	private IMarcaDAO1<Marca> marcaDAO;
	private IMarcaDAO1<Marca> marcaDAO2;
	
	public MarcaTest1() {
		this.marcaDAO = new MarcaDAO1();
		this.marcaDAO2 = new MarcaDAO2();
	}
	
	@Test
	public void cadastrar() throws TipoChaveNaoEncontradaException, DAOException {
		Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);
        
        Marca marca1 = new Marca();
        marca1.setNome("FERRARI");
        marca1.setPais("ITALIA");
        marca1.setAnoCriacao(1939);
        marca1.setRankMercado(1);
        marca1 = marcaDAO2.cadastrar(marca1);

        assertNotNull(marca);
        assertNotNull(marca.getId());
        
        assertNotNull(marca1);
        assertNotNull(marca1.getId());
        
        marcaDAO.excluir(marca);
        marcaDAO2.excluir(marca1);
	}
     

	@Test
	public void excluir () throws TipoChaveNaoEncontradaException, DAOException  {
		Marca marca = new Marca();
        marca.setNome("FERRARI");
        marca.setPais("ITALIA");
        marca.setAnoCriacao(1939);
        marca.setRankMercado(1);
        marca = marcaDAO.cadastrar(marca);
        
        Marca marca1 = new Marca();
        marca1.setNome("FERRARI");
        marca1.setPais("ITALIA");
        marca1.setAnoCriacao(1939);
        marca1.setRankMercado(1);
        marca1 = marcaDAO2.cadastrar(marca1);
        
        Boolean verdade = marcaDAO.excluir(marca);
        Boolean verdade2 = marcaDAO2.excluir(marca1);
        
        assertTrue(verdade);
        assertTrue(verdade2);
        
	}
}
