package br.com.gblisboa;

public class Porshe <T> extends Carro{
    Porshe(){

    }
    Porshe(T nome, T codigo) {
        super(nome, codigo);
    }

    @Override
    public void testDrive() {
        System.out.println("Fazendo o teste drive da Porshe");
    }
}
