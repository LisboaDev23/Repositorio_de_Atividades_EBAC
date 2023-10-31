package src.main.java.dao;

import src.main.java.domain.Empresario;
import src.main.java.domain.Fabrica;

import java.util.List;

public interface IEmpresarioDAO {
    public Empresario cadastrar(Empresario empresario);
    public Boolean excluir(Empresario empresario);
    public List<Empresario> buscarTodos();
}
