package br.com.lisboa.domain;

import java.util.Objects;

public class Game {
    //definindo os atributos
    private Long codigo;
    private String nome;
    private Double preco;
    //depois de definir os atributos, fazer os construtores
    public  Game(){

    }
    public Game(String nome){

    }
    public Game(String nome, String codigo){

    }
    public Game(String codigo, String nome, String preco){
        this.nome=nome;
        this.codigo=Long.valueOf(codigo.trim());
        this.preco=Double.valueOf(preco.trim());
    //lembrar de observar a utilização dessa mudança da forma do atributo
    }
    //depois de fazer o método construtor, declarar os métodos getter and setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    /*depois de declarar os métodos getters and setters, declarar o equals e
    hash cod para não repetir informações que não podem ser repetidas
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(nome, game.nome) && Objects.equals(codigo, game.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo);
    }
    /*após aplicar o método equals e hashCode, aplicamos o método toString para
    converter as informações para String e serem visualizadas no console
     */

    @Override
    public String toString() {
        return "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
    //ao fim de tudo isso, vamos criar a interface responsavel por criar o cadastro do cliente

