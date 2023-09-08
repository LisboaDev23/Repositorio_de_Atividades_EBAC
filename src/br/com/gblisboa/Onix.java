package br.com.gblisboa;

public class Onix<T> extends Carro{
    Onix(){

    }
    Onix(T nome, T codigo) {
        super(nome, codigo);
    }

    @Override
    public void testDrive() {
        System.out.println("Fazendo o test drive do Onix");
    }

}
