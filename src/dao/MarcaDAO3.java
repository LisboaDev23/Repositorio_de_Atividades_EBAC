package dao;

import dao.generico.GenericDB3DAO;
import domain.Marca2;

public class MarcaDAO3 extends GenericDB3DAO<Marca2, Long> implements IMarcaDAO1<Marca2>{

	public MarcaDAO3() {
		super(Marca2.class);
}

}
