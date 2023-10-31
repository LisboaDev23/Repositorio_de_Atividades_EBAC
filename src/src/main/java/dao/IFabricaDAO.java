package src.main.java.dao;

import src.main.java.domain.Fabrica;
import src.main.java.domain.Produto;

import java.util.List;

public interface IFabricaDAO {

    public Fabrica cadastrar(Fabrica fabrica);
    public Boolean excluir(Fabrica fabrica);
    public List<Fabrica> buscarTodos();
}
