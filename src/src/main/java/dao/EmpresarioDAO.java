package src.main.java.dao;

import src.main.java.domain.Empresario;
import src.main.java.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmpresarioDAO implements IEmpresarioDAO {


    @Override
    public Empresario cadastrar(Empresario empresario) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(empresario);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return empresario;
    }

    @Override
    public Boolean excluir(Empresario empresario) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        empresario = entityManager.merge(empresario);
        entityManager.remove(empresario);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public List<Empresario> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Empresario> query = builder.createQuery(Empresario.class);
        Root<Empresario> root = query.from(Empresario.class);
        query.select(root);

        TypedQuery<Empresario> typedQuery =
                entityManager.createQuery(query);
        List<Empresario> empresarios = typedQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return empresarios;
    }
}
