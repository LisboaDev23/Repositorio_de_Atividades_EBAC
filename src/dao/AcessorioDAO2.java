package dao;

import dao.generico.GenericDB2DAO;
import dao.generico.GenericDB3DAO;
import domain.Acessorio;
import domain.Acessorio2;

public class AcessorioDAO2 extends GenericDB3DAO<Acessorio, Long> implements IAcessorioDAO1<Acessorio>{

	public AcessorioDAO2() {
		super(Acessorio.class);
	}

}
