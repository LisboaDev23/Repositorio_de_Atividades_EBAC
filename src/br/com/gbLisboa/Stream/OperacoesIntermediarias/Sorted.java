package br.com.gbLisboa.Stream.OperacoesIntermediarias;

import br.com.gbLisboa.Stream.Jogo;

import java.util.Comparator;
import java.util.List;

public class Sorted {
    public static void main(String[] args) {
        List<Jogo> jogoList = new Jogo().addJogos();
        jogoList.stream()
                .filter(jogo -> jogo.getGenero().equals("FPS"))
                .sorted(Comparator.comparing(Jogo::getNome));/*usando o sorted ele ordena o critério usando a classe
                Comparator chamando o método comparing e passando a classe e o seu respectivo método */

    }
}
