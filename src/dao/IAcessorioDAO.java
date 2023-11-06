package dao;

import domain.Acessorio;

import java.util.List;

public interface IAcessorioDAO {
    public Acessorio cadastrar(Acessorio acessorio);
    public Boolean excluir (Acessorio acessorio);
    public List<Acessorio> buscarTodos();
}
