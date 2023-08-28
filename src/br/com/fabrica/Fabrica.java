package br.com.fabrica;

public abstract class Fabrica {
    public Carro criarCarro (String codigo){
        Carro carro = carroSelecionado(codigo);
        carro = startCarro(carro);
        return carro;
    }
    public Carro startCarro(Carro carro){
        carro.ligar();
        carro.acelerar();
        carro.frear();
        carro.desligar();
        return carro;
    }
    abstract Carro carroSelecionado(String codigo);


}
