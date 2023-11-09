package dao.generico;

import java.io.Serializable;

import dao.persistence.Persistente;

public abstract class GenericDB3DAO <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E>{

	public GenericDB3DAO(Class<T> persistenceClass) {
		super(persistenceClass, "MySQL");
	}

}
