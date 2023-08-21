package br.com.lisboa.dao;

import br.com.lisboa.domain.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameMapDAO implements IGameDAO {
    //lembrando que toda classe que herda da interface, deve atribuir todos os métodos dessa interface
    private Map<Long, Game>map;
    /*salvando o game na colleção Map, lembrando que a chave vai ser
    o código do jogo que é do tipo Long, e o valor em si é o Game
     */
    public GameMapDAO(){
        this.map = new HashMap<>();
    }
    /*colocando o método construtor para criarmos(instanciar) o objeto que
    é uma coleção, o map.
     */
    @Override
    public Boolean cadastrar(Game game) {
        //definindo a primeira condição caso o usuário coloque um código de um jogo que já exista na memória
        if (this.map.containsKey(game.getCodigo())){
            return false;
        } //se no map já houver o código vai retornar uma informação negando o cadastro
        //declarando agr caso não entre nesse if, que irá pegar nesse map, o código e o game

        this.map.put(game.getCodigo(),game);
        //put que irá pedir a chave e o objeto, e depois retornará como game cadastrado
        return true;
    }

    @Override
    public void excluir(Long codigo) {
        //declarando a primeira variável que vai pegar o game cadastrado no map pelo código
        Game gamecadastrado = this.map.get(codigo);
        /*declarando a primeira condição do método excluir que se a variável gameCadastrado for
         diferente de nula ou seja, tiver o código do game na memória, ele deleta o game
         */
        if (gamecadastrado != null){
            this.map.remove(gamecadastrado.getCodigo());
        }
    }

    @Override
    public void alterar(Game game) {
        /*de primeira, declaramos outra váriavel mas no mesmo sentido do
        método anterior, apenas para representação do próprio jogo
         */
        Game gamecadastrado = this.map.get(game.getCodigo());
        //
        if (gamecadastrado != null){
            gamecadastrado.setCodigo(game.getCodigo());
            gamecadastrado.setNome(game.getNome());
            gamecadastrado.setPreco(game.getPreco());
        }
    }

    @Override
    public Game consultar(Long codigo) {
        return this.map.get(codigo);
    }

    @Override
    public Collection<Game> buscarTodos() {
        return this.map.values();
    }
}
