package dao;

import dao.generico.GenericDB1DAO;
import domain.Carro;

public class CarroDAO1 extends GenericDB1DAO<Carro, Long> implements ICarroDAO1<Carro>{

	public CarroDAO1() {
		super(Carro.class);
	}

}
