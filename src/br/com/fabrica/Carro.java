package br.com.fabrica;

public abstract class Carro {
    private String cor;
    private Integer velocidade;
    private Integer ano;

    public Carro(String cor, Integer velocidade, Integer ano) {
        this.cor = cor;
        this.velocidade = velocidade;
        this.ano = ano;
    }

    public void ligar(){
        System.out.println("Carro ligado");
    }
    public void acelerar(){
        System.out.println("Carro acelerando a "+ velocidade);
    }
    public void frear(){
        System.out.println("Carro parando");
    }
    public void desligar(){
        System.out.println("Carro desligado");
    }


}
