package br.com.gblisboa;

import java.util.ArrayList;
import java.util.List;

public abstract class Carro <T>{

    public static void main(String[] args) {
        Civic civic = new Civic();
        civic.testDrive();
        Porshe porshe = new Porshe();
        porshe.testDrive();
        Onix onix = new Onix();
        onix.testDrive();
        List<Onix> onixList = new ArrayList<Onix>();
        onixList.add(new Onix("onix1", 25889));
        processCarros(onixList);
        /*List<? extends Carro> carros = new ArrayList<>();
        carros.add(new Civic("Civic1",5088));
        Dúvida de como utilizar o extends com wildcard pq não estou conseguindo adicionar
        um Civic, já que Civic é uma extensão de Carros ||PFVR ME TIRA ESSA DÚVIDA TUTOR :)
         */
    }
    private T nome;
    private T codigo;

    Carro (T nome, T codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    public Carro() {

    }
    public abstract void testDrive();
    public static void processCarros(List<?> carros){
        for (Object o : carros){
            System.out.println(o);
        }
    }
    public static void processCarros2(List<? extends Carro>carros){
        for (Object o : carros){
            System.out.println(o);
        }
    }

    public List<Carro> addCarro (){
        List<Carro> carros = new ArrayList<>();
        carros.add(new Civic("Civic", 2899));
        carros.add(new Onix("Onix", 4568));
        carros.add(new Porshe("Porshe Caiene", 9833));
        return carros;

    }
    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
