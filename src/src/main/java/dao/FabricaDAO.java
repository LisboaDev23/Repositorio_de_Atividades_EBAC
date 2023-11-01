package src.main.java.dao;

import src.main.java.domain.Empresario;
import src.main.java.domain.Fabrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FabricaDAO implements IFabricaDAO{

    @Override
    public Fabrica cadastrar(Fabrica fabrica) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(fabrica);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return fabrica;
    }

//    public Empresario consultar(Long idEmpresario){
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("GabrielExemploJPA");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Fabrica> query = builder.createQuery(Fabrica.class);
//        Root<Fabrica> root = query.from(Fabrica.class);
//        query.select(root);
//
//        TypedQuery<Fabrica> typedQuery =
//                entityManager.createQuery(query);
//        Integer fabricas = typedQuery.getFirstResult();
//        Empresario empresario = fabricas;
//
//        entityManager.close();
//        entityManagerFactory.close();
//    }

    @Override
    public Boolean excluir(Fabrica fabrica) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        fabrica = entityManager.merge(fabrica);
        entityManager.remove(fabrica);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;    }

    @Override
    public List<Fabrica> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fabrica> query = builder.createQuery(Fabrica.class);
        Root<Fabrica> root = query.from(Fabrica.class);
        query.select(root);

        TypedQuery<Fabrica> typedQuery =
                entityManager.createQuery(query);
        List<Fabrica> fabricas = typedQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return fabricas;
    }
}
