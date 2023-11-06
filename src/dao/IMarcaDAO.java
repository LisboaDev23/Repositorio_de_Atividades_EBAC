package dao;

import domain.Marca;

import java.util.List;

public interface IMarcaDAO {
    public Marca cadastrar (Marca marca);
    public Boolean excluir (Marca marca);
    public List<Marca> buscarTodos();
}
