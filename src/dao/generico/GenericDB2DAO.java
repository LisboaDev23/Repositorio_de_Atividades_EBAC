package dao.generico;

import java.io.Serializable;

import dao.persistence.Persistente;

public abstract class GenericDB2DAO <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E>{

	public GenericDB2DAO(Class<T> persistenceClass) {
		super(persistenceClass, "GabrielExemploJPA2");
	}

}
