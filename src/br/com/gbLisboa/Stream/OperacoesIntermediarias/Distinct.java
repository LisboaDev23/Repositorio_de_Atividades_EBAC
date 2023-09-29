package br.com.gbLisboa.Stream.OperacoesIntermediarias;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        List<Jogo> jogoList = new Jogo().addJogos();
        jogoList.stream().distinct();
    }
}
