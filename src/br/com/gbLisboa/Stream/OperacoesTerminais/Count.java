package br.com.gbLisboa.Stream.OperacoesTerminais;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<Jogo> jogoList = new Jogo().addJogos();
        jogoList.stream().
                filter(jogo -> jogo.getNome().startsWith("F"))
                .count();//fazendo uma filtragem dos jogos que começam com a letra F, e aí faço o count();

        //a operação terminal count retorna um long, então devemos definir um método count guardado num long
        Long count = jogoList.stream().
                filter(jogo -> jogo.getNome().startsWith("F"))
                .count();
        System.out.println(count);
    }
}
