package src.main.java.dao;

import src.main.java.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO{

    @Override
    public Produto cadastrar(Produto produto) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return produto;
    }

    @Override
    public Boolean excluir(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        query.select(root);

        TypedQuery<Produto> typedQuery =
                entityManager.createQuery(query);
        List<Produto> produtos = typedQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return produtos;
    }
}
