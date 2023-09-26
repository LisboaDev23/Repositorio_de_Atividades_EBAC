package br.com.gblisboa.LambdaExpressions;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class ExpressoesLambdas {
    public static void main(String[] args) {
        //fazendo o lambda com interface tipada
        IntBinaryOperator operadorBinario = (int x, int y) -> {
            return x * y;
        };
        int resultado = operadorBinario.applyAsInt(10,10);
//        System.out.println(resultado);

        //fazendo lambda com interface generica
        BiFunction<Double, Double, Integer> somaLamb = (Double x, Double y) -> {
            Integer transformaDouble1 = x.intValue();
            Integer transformaDouble2 = y.intValue();
            return transformaDouble2*transformaDouble1;
        };
        Integer applyLambda = somaLamb.apply(99.99, 85.99);
        System.out.println(applyLambda);

        //chamando a expressao lambda do método
        chamada((String nome, String operacao)->{
            return "Operacao concluída"
                    +"NOME: " + nome
                    +"Operação: " + operacao;
        });
    }

    private static String chamada(BiFunction<String,String,String>chamada){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu nome");
        String nomeUsuario = scanner.nextLine();
        System.out.println(nomeUsuario+ " Qual operação você deseja realizar?");
        String operacao = scanner.nextLine();
        if (operacao.equals("soma")){
            System.out.println("Digite o primeiro numero para realizar a soma");
            Integer n1 = scanner.nextInt();
            System.out.println("Digite o segundo numero para realizar a soma");
            Integer n2 = scanner.nextInt();
             soma(n1, n2,(Integer a, Integer b)->{
                 System.out.println("O resultado da soma desses dois números é");
                 Integer soma =a+b;
                 return soma;
            });
        } if (operacao.equals("subtração")){
            System.out.println("Digite o primeiro numero para realizar a subtração");
            Integer n1 = scanner.nextInt();
            System.out.println("Digite o segundo numero para realizar a subtração");
            Integer n2 = scanner.nextInt();
            subtracao(n1,n2,(Integer a, Integer b)->{
                Integer subtracao = a-b;
                System.out.println("O resultado da subtração desses dois números é ");
                return subtracao;
            });

        }
        return "ERRO";
    }
    private static void soma(Integer x, Integer y, BiFunction<Integer, Integer, Integer>funcao){
        System.out.println(funcao.apply(x,y));
    }
    private static void subtracao(Integer x, Integer y,BiFunction<Integer,Integer,Integer> funcao){
        System.out.println(funcao.apply(x,y));
    }
}
