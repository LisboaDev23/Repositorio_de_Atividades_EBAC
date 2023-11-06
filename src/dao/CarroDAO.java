package dao;

import domain.Acessorio;
import domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarroDAO implements ICarroDAO{
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }

    @Override
    public Boolean excluir(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        carro = entityManager.merge(carro);
        entityManager.remove(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public List<Carro> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder construtor = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> consulta = construtor.createQuery(Carro.class);
        Root<Carro> selectFrom = consulta.from(Carro.class);
        consulta.select(selectFrom);

        TypedQuery<Carro> consultaTipada =
                entityManager.createQuery(consulta);
        List<Carro> carros = consultaTipada.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return carros;    }
}
