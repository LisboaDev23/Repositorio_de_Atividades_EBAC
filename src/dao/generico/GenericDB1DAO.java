package dao.generico;

import java.io.Serializable;

import dao.persistence.Persistente;


public abstract class GenericDB1DAO <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E>{

	public GenericDB1DAO(Class<T> persistenceClass) {
		super(persistenceClass, "GabrielExemploJPA");
	}

}
