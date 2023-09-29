package br.com.gbLisboa.Stream.Tarefa_Stream;

import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String sexo;
    public Pessoa(){

    }
    public Pessoa(String nome, String sexo){
        this.nome=nome;
        this.sexo=sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public List<Pessoa> cadastrandoPessoa(){
        Pessoa pessoa1 = new Pessoa("Gabriel Lisboa", "Masculino");
        Pessoa pessoa2 = new Pessoa("Iasmim Bessa","Feminino" );
        Pessoa pessoa3 = new Pessoa("Pedro Colares", "Masculino");
        Pessoa pessoa4 = new Pessoa("Neta Bessa","Feminino");
        Pessoa pessoa5 = new Pessoa("Patrícia Feitosa", "Feminino");
        return List.of(pessoa1,pessoa2,pessoa3,pessoa4,pessoa5);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(sexo, pessoa.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sexo);
    }
}
