package br.com.gbLisboa.Stream;

import java.util.List;
import java.util.Objects;

public class Jogo {
    private String nome;
    private Integer codigo;
    private String genero;
    public Jogo(){

    }

    public Jogo(String nome, Integer codigo, String genero) {
        this.nome = nome;
        this.codigo = codigo;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Jogo> addJogos(){
        Jogo fifa = new Jogo("FIFA 24", 3558, "Esportes");
        Jogo cod = new Jogo("Call of Duty", 7445, "FPS");
        Jogo bf = new Jogo("Battlefield", 8556, "FPS");
        return List.of(fifa,cod,bf); //retorno desse método é uma lista onde está adicionado esses jogos
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return Objects.equals(nome, jogo.nome) && Objects.equals(codigo, jogo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo);
    }
}
