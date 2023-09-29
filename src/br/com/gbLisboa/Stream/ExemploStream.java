package br.com.gbLisboa.Stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class ExemploStream {
    public static void main(String[] args) {
        /*definindo primeiramente uma lista para trabalharmos com as streams, definindo uma lista de
        inteiros e utilizando o método List.of para adicionar os elementos nessa lista
         */
        List<Integer> integerList =  List.of(0,1,2,3,4,5,6,7,8,9,10);
        //criando a primeira Stream utilizando a lista de inteiros definida acima chamando o nome dessa lista.stream.
        Stream<Integer> integerStream = integerList.stream();
        /*criando Stream de outra forma, definindo a variável Stream e criando a lista pelo List.of
         e definindo seus elementos e depois o .stream();
         */
        Stream<Integer> listStream = List.of(0,1,2,3,4,5,6,7,8,9,10).stream();
        //importante lembrar que List é apenas um tipo de Collection, podemos trabalhar com outras
        Stream<String> setStream = Set.of("Gabriel", "Iasmim", "Marcos", "Letícia").stream();
        //a implementação no tipo Map deve ser feita de forma diferente
        Map<Integer,String> jogos = Map.of(1, "FIFA");//1°-Definir a coleção
        //no Map consigo retornar seu valor a partir da coleção, seja ela a chave ou o seu valor
        Stream<Integer>chaveJogo = jogos.keySet().stream();/*definindo a Stream do tipo Integer(pois esse é o tipo da chave)fazendo
        o stream do map a partir da sua chave*/
        Stream<String>valorJogo = jogos.values().stream();//definindo o Stream que pega pelo valor do jogo

        //é possível tbm criar uma Stream diretamente e assim colocar logo os seus valores dessa forma:
        Stream<Object> streamExemplo= Stream.of("Random", 78, 55.99);
        /* O .of recebe um valor genérico, então nele pode passar qualquer tipo de dado, agora quando passamos esses valores em
        uma variável,se torna necessário o encapsulamento desses dados
         */



    }
}
