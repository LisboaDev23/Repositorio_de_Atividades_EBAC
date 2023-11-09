package dao.generico;

import java.io.Serializable;
import java.util.Collection;

import dao.persistence.Persistente;
import domain.Marca;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;

public interface IGenericDAO <T extends Persistente, E extends Serializable>{
	
	public T cadastrar (T entity) throws TipoChaveNaoEncontradaException, DAOException;
	//método genérico onde vai cadastrar o tipo que será passado e para cadastrar deve ser passada o mesmo tipo, a entidade, e ela deve lançar essas exceptions
	
	public Boolean excluir(T entity) throws DAOException;
	
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	
	public T consultar(E id)throws MaisDeUmRegistroException, TableException, DAOException; 
	//para que a consulta seja feita, ele não deve pedir a entidade em si, deverá ser pedido o id dele para ser consultado
	public Collection<T>buscarTodos() throws DAOException;


	
}
