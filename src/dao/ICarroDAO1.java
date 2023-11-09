package dao;

import dao.generico.IGenericDAO;
import dao.persistence.Persistente;

public interface ICarroDAO1 <T extends Persistente> extends IGenericDAO<T,Long>{

}
