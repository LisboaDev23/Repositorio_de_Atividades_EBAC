package dao;

import dominio.Jogo;

import java.util.Collection;

public interface IJogoDAO {
    /*INTERFACE REFERENTE A TODOS OS MÉTODOS QUE SERÃO RESPONSÁVEIS POR FAZER AS FUNCIONALIDADES DO CLIENTE,
    LEMBRANDO QUE TODAS AS CLASSES QUE IMPLEMENTAREM ESSA INTERFACE DEVERÃO IMPLEMENTAR SEUS MÉTODOS .
     */
    public Boolean cadastrar(Jogo jogo);
    public void alterar(Jogo jogo);
    public void excluir(Jogo jogo);
    public Jogo consultar(Integer codigo);
    public Collection<Jogo> allGames();

}
