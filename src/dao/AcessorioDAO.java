package dao;

import domain.Acessorio;
import domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AcessorioDAO implements IAcessorioDAO{
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return acessorio;
    }

    @Override
    public Boolean excluir(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        acessorio = entityManager.merge(acessorio);
        entityManager.remove(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public List<Acessorio> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder construtor = entityManager.getCriteriaBuilder();
        CriteriaQuery<Acessorio> consulta = construtor.createQuery(Acessorio.class);
        Root<Acessorio> selectFrom = consulta.from(Acessorio.class);
        consulta.select(selectFrom);

        TypedQuery<Acessorio> consultaTipada =
                entityManager.createQuery(consulta);
        List<Acessorio> acessorios = consultaTipada.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return acessorios;
    }
}
