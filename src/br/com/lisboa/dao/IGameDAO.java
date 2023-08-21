package br.com.lisboa.dao;

import br.com.lisboa.domain.Game;

import java.util.Collection;

public interface IGameDAO {
    //declarar o método cadastrar,excluir,alterar e consultar, lembrando que o acesso deve ser pelo código do jogo
    //lembrar de importar a classe Game que recebe o seu objeto game
    public Boolean cadastrar(Game game);
    public void excluir (Long codigo);
    public void alterar(Game game);
    public Game consultar(Long codigo);
    //para consultar o código do jogo, esse método retorna a classe Game
    public Collection<Game> buscarTodos();
    //método buscarTodos ele retorna uma Collection da classe Game

    /*após todos esses processos de criação da interface, vamos criar
    as implementações desta interface
     */

}
