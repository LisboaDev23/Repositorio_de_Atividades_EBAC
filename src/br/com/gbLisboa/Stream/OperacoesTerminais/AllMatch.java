package br.com.gbLisboa.Stream.OperacoesTerminais;

import br.com.gbLisboa.Stream.Jogo;

import java.util.List;

public class AllMatch {
    public static void main(String[] args) {
        List<Jogo> jogoList = new Jogo().addJogos();
        Boolean resultado = jogoList.stream()
                .allMatch(jogo -> jogo.getGenero().equals("FPS"));/*uso o allMatch para fazer uma verificação se todos os jogos
                dessa lista são do genero FPS,e guardo ela numa variável booleana */
        System.out.println(resultado);
    }
}
