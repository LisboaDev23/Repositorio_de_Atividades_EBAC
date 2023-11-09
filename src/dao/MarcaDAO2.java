package dao;

import dao.generico.GenericDB2DAO;
import dao.generico.GenericDB3DAO;
import domain.Marca;
import domain.Marca2;

public class MarcaDAO2 extends GenericDB3DAO<Marca, Long> implements IMarcaDAO1<Marca>{
	public MarcaDAO2() {
		super(Marca.class);
	}

}
