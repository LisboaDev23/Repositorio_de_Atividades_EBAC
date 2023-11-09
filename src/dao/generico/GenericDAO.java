package dao.generico;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import dao.persistence.Persistente;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;

public class GenericDAO <T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {
	
	//propriedades que serão responsáveis por fazer a conexão com o hibernate
	
		protected EntityManagerFactory entityManagerFactory;
		
		protected EntityManager entityManager;
		
		//essa propriedade e responsável por dizer qual o nome da classe
		private Class<T> persistenteClass;
		//propriedade para dizer de qual persistencia ela será conectada
		private String persistenceUnitName;	
		
		public GenericDAO(Class<T> persistenceClass, String persistenceUnitName) {
			//construtor que irá ...
			this.persistenteClass = persistenceClass;
			this.persistenceUnitName = persistenceUnitName;
		}

		@Override
		public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
			abrirConexao();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			fecharConexao();
			return entity;
		}

		@Override
		public Boolean excluir(T entity) throws DAOException {
			// TODO Auto-generated method stub
			abrirConexao();
			entity = entityManager.merge(entity);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			fecharConexao();
			return true;
		}

		@Override
		public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
			abrirConexao();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			fecharConexao();
			return entity;
		}

		@Override
		public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
			abrirConexao();
			T entity = entityManager.find(this.persistenteClass, id);
			entityManager.getTransaction().commit();
			fecharConexao();
			return entity;
		}

		@Override
		public Collection buscarTodos() throws DAOException {
			abrirConexao();
			List<T> objetosCadastrados = entityManager.createQuery(getSelectSql(),this.persistenteClass).getResultList();
			fecharConexao();
			return objetosCadastrados;
		}
		
		protected void abrirConexao() {
			entityManagerFactory= Persistence.createEntityManagerFactory(persistenceUnitName);
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();		
		}
		protected void fecharConexao() {
			// TODO Auto-generated method stub
			entityManager.close();
			entityManagerFactory.close();
		}
		
		private String getSelectSql() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT obj FROM ");
			sb.append(this.persistenteClass.getSimpleName());
			sb.append(" obj");
			return sb.toString();
		}

}
