package src.main.java.dao;

import src.main.java.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Produto cadastrar(Produto produto);
    public Boolean excluir(Produto produto);
    public List<Produto> buscarTodos();
}
