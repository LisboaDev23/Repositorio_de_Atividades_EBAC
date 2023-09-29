package br.com.gbLisboa.Stream.OperacoesIntermediarias;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filter {
    public static void main(String[] args) {
        List<Jogo> jogosList = new Jogo().addJogos();
        Stream<Jogo>jogosFps = jogosList.stream().filter(jogo ->jogo.getGenero().equals("FPS"));//essa forma estou passando a expressão lambda diretamente pelo parâmetro

        Predicate<Jogo> jogoFps1 = jogo-> jogo.getGenero().equals("FPS");//dessa outra forma estou passando a expressão lambda dentro de uma variável do tipo Predicate
        Stream<Jogo> jogoStream = jogosList.stream().filter(jogoFps1);//passando a variável Predicate dentro do meu parâmetro filter().

        Predicate<Jogo> jogoFps2 = new Predicate<Jogo>() {//outra forma de fazer um predicate instanciando ele e criando uma classe anônima, NÃO RECOMENDADO
            @Override
            public boolean test(Jogo jogo) {
                return jogo.getGenero().equals("FPS");
            }
        };
        Stream<Jogo>jogoStream1 = jogosList.stream().filter(jogoFps2); //utilizando o predicate fazendo ele de forma instanciada.
    }
}
