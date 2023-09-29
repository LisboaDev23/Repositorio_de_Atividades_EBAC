package br.com.gbLisboa.Stream.OperacoesIntermediarias;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;
import java.util.stream.Stream;

public class Map {
    public static void main(String[] args) {
        List<Jogo> mapListJogos = new Jogo().addJogos();
       Stream<Integer>codigoJogos = mapListJogos.stream()
                .filter(jogo -> jogo.getGenero().equals("FPS"))
                .map(Jogo::getCodigo);/*utilizando o map dessa forma onde só passo o tipo do objeto sem precisar definir o nome de
                sua variável e usar o reference :: para chamar o método de sua classe*/

    }
}
