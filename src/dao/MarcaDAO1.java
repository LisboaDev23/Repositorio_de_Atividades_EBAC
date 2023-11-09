package dao;

import dao.generico.GenericDB1DAO;
import domain.Marca;

public class MarcaDAO1 extends GenericDB1DAO<Marca, Long> implements IMarcaDAO1<Marca>{

	public MarcaDAO1() {
		super(Marca.class);
	}
}
