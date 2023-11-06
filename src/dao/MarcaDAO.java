package dao;

import domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MarcaDAO implements IMarcaDAO{
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return marca;
    }

    @Override
    public Boolean excluir(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public List<Marca> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("GabrielExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //essa linha de baixo sempre será feita, padrão para podermos fazer uma consulta totalmente programada com o Criteria
        CriteriaBuilder construtor = entityManager.getCriteriaBuilder();
        //criando uma variavel construtora do Criteria, onde ela vai receber o metodo do gerenciador de entidades que será responsável por pegar o construtor dessa Criteria.
        CriteriaQuery<Marca> consulta = construtor.createQuery(Marca.class);
        /*Aqui vou criar uma variavel do tipo Criteria que vai fazer a consulta passando o tipo de objeto que será feito a consulta, e nessa variavel eu chamo o metodo do
        construtor que vai criar a query, e eu passo qual classe-tabela será feito a consulta
         */
        Root<Marca> selectFrom = consulta.from(Marca.class);//essa variável do tipo root, é caracterizado por representar o select*from, nesse caso eu chamo a query que foi criada, e passo a classe-tabela que irá ser feita a busca
        consulta.select(selectFrom);//chamando o metodo da query onde vou fazer o select passando a variável que é responsável por fazer o from;

        TypedQuery<Marca> consultaTipada =
                entityManager.createQuery(consulta);
        List<Marca> marcas = consultaTipada.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return marcas;
    }
}
