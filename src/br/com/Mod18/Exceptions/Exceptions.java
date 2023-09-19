package br.com.Mod18.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exceptions {
    /*exception ou exceção é quando um evento não esperado ocorre no sistema em tempo de execução do programa
    Geralmente o sistema captura alguma exceção e quando isso acontece o fluxo de código fica interrompido
    Para conseguir capturar uma exceção, é preciso um tratamento prévio, e o uso desses tratamentos são
    importantes nos sistemas porque auxilia e, falhas como comunicação, leitura e escrita dos arquivos,
    entrada de dados inválidos entre outros. Interessante ressaltar que o finally é sempre posto nos tratamentos
    de exceções. Toda classe que é uma Exception tem seu nome terminado em Exception.
     */
    public static void metodoException(){
        Integer codigo = null;
        Integer codigoNovo = null;
        try {
            //código de tentativa aqui
            codigoNovo = codigo;
            //logo irá dar erro pois o código normal está definido como nulo
        } catch (Exception e){
            //captura o erro sobre o fato de estar nulo e vou tratá-lo aqui
            System.out.println("código inválido!");
            //defino um valor nesse codigo normal para que seja executado novamente a aplicação
            codigo = 0;
            //e agora atribuo novamente o código normal ao código que deve ser escaneado.
            codigoNovo = codigo;
            throw e;
        } finally {
            //o código inserido no finally indica que ele sempre será executado caso entre no catch ou não
            codigo = codigoNovo;
        }
        System.out.println("código antigo " + codigo);
        System.out.println("código novo "+ codigoNovo);
    }

    /*Deve-se utilizar uma checked Exceptions(uma categoria de Exceptions) quando houver
    um erro recuperável(erro recuperável é o erro que conseguimos tratar aqui na aplicação, erro não recuperável
    é aquele erro que não depende diretamente da nossa aplicaçaõ) ou um requisito de negócio importante.
    */
    /*Unchacked exception é usada quando não houver recuperação, dessa forma elas nunca devem ser tratadas, por
    exemplo quando o servidor cai, ou quando a memória desse servidor é usada em excesso, já o RuntimeException
    é usado para erros que seu aplicativo não pode recuperar.
     */
    /*Cláusula throw/throws - uma ação que lança uma exceção, em alguns momentos pode existir exceções que não podem
    ser tratadas no mesmo método onde foi gerada essa exceção, então nesse caso é necessário lançar a exceção para
    um nível acima na pilha, o throws ficará na assinatura do método indicando que ele poderá lançar uma execeção,
    já o throw fica dentro da aplicação do método onde nela será aplicada a variável do tipo Exception.
     */
    public static void addCodigo() throws CodigoException{ //esse throws indica que esse método ele lança essa exceção CogigoException
        List<Integer> codigosList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira um código");
        Integer codigo = scanner.nextInt();
        codigosList.add(codigo);
        System.out.println("Insira um novo código: ");
        Integer codigoInserido = scanner.nextInt();
        if (codigosList.get(0).equals(codigoInserido)){
            CodigoException erro = new CodigoException("Código já existe no banco de dados.");
            throw erro;
        } /*se ele entrar nessa condição e der o erro, a aplicação é parada e joga a variável erro pra quem
            está chamando essa exceção que nesse caso é o CódigoException
         */
        else {
            codigosList.add(codigoInserido);
            System.out.println("Código adicionado com sucesso");
            System.out.println(codigosList);
        }
    }
    public static void addCodigo1() throws CodigoException{
        List<Integer> codigosLista1 = new ArrayList<>();
        codigosLista1.add(10);
        if (codigosLista1.get(0)>9){
            CodigoException erro = new CodigoException("Código não aceita número acima de 9.");
            throw erro;
        } else {
            System.out.println("Codigo adicionado!");
            System.out.println(codigosLista1);
        }
    }

    public static void exemploTratamentoException() throws CodigoException{
        String nome = null;
        String nome2 = null;
        try {
            nome2 = nome.toLowerCase();
        } catch (NullPointerException e){
            System.out.println("O número está nulo, iremos atribuir um novo valor a ele ");
            nome = "Gabriel";
            nome2 = nome.toLowerCase();
        } finally {
            System.out.println("MÉTODO exemploTratamentoException");
        }  /*- O código finally é útil para executar qualquer código que
        precise ser executado mesmo se houver uma exceção.
        */
        System.out.println(nome2);
    }

    public static void exemploParandoSistema(){
        try {
            Integer n3 = 1;
            Integer n1 = null;
            Integer n2 = null;
            n2 = (int) n1.longValue();
        } catch (NullPointerException e){
            throw new RuntimeException("Sistema falho");
        }
    }





}