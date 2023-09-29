package br.com.gbLisboa.Stream.OperacoesIntermediarias;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;
import java.util.stream.Stream;

public class Limit {
    public static void main(String[] args) {
        List<Jogo> jogosList = new Jogo().addJogos();
        Stream<Jogo> jogoStream = jogosList.stream().limit(1);/*declarando o limire máximo de elemento na lista de j
        ogos onde ela irá retornar a lista de jogo mostrando apenas o primeiro elemento */

    }
}
