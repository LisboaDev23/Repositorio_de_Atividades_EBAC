package br.com.gbLisboa.Stream.OperacoesTerminais;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;
import java.util.stream.Stream;

public class ForEach {
    public static void main(String[] args) {
        List<Jogo> jogoList = new Jogo().addJogos();
        jogoList.stream().forEach(jogo -> System.out.println(jogo.getNome()));
        //fazendo o forEach pela stream passando um consumer como parâmetro do forEach onde ele vai pegar o nome desse jogo
        jogoList.stream()
                .filter(jogo -> jogo.getGenero().equals("FPS"))
                .forEach(jogo -> System.out.println(jogo.getNome()));

    }
}