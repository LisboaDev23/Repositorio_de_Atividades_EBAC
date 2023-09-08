package br.com.gblisboa;

public class Civic<T> extends Carro{

    Civic (){

    }
    Civic(T nome, T codigo) {
        super(nome, codigo);
    }

    @Override
    public void testDrive() {
        System.out.println("Fazendo o teste drive do Civic");
    }
}
