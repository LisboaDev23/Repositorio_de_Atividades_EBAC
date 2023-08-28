package br.com.fabrica;

public class Cliente {
    private String codigo;
    private boolean pessoaFisica;
    private boolean pessoaJuridica;

    public Cliente(String codigo, boolean pessoaFisica, boolean pessoaJuridica) {
        this.codigo = codigo;
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isPessoaFisica() {
        return pessoaFisica;
    }

    public boolean isPessoaJuridica() {
        return pessoaJuridica;
    }
}
