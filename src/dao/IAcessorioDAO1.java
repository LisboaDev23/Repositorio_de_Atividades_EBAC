package dao;

import dao.generico.IGenericDAO;
import dao.persistence.Persistente;

public interface IAcessorioDAO1 <T extends Persistente> extends IGenericDAO<T,Long>{

}
