package dao;

import dao.generico.GenericDB2DAO;
import dao.generico.GenericDB3DAO;
import domain.Carro;
import domain.Carro2;

public class CarroDAO2 extends GenericDB3DAO<Carro, Long> implements ICarroDAO1<Carro>{

	public CarroDAO2() {
		super(Carro.class);
	}

}
