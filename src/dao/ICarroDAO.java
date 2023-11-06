package dao;

import domain.Carro;

import java.util.List;

public interface ICarroDAO {

    public Carro cadastrar(Carro carro);
    public Boolean excluir(Carro carro);
    public List<Carro> buscarTodos();
}
