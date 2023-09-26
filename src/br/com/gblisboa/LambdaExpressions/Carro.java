package br.com.gblisboa.LambdaExpressions;

public class Carro {


    private String nome;

    public Integer getPreco() {
        return preco;
    }

    private Integer preco;

    public String getNome() {
        return nome;
    }
    public Carro(){

    }
    public Carro(String nome, Integer preco){
        this.nome = nome;
        this.preco = preco;
    }
    public static void mostraPreco(Carro carro){
        System.out.println(carro.getPreco());
    }

    public static void main(String[] args) {
        Carro onix = new Carro("Onix", 10);
        /*definindo uma expressão lambda onde só digo o tipo da variável e denomino ela, passo o parâmetro(sem dizer o tipo dela) dessa
        expressão de acordo com o método que a interface implementa e faz toda a funcinalidade da expressão lambda após o sinal -> .
        e não foi preciso abrir chaves {}.
         */
        ITurnOn ligandoCarro= (carro) -> System.out.println("Ligando "+carro.getNome());
        ligandoCarro.on(onix); //chamando o método pelo nome de sua variavel.
        //Aqui a única diferença é que estou passando o tipo do objeto (Carro Carro), e sem precisar abrir chaves tbm.
        ITurnOn ligandoCarro1= (Carro carro) ->{
           ITurnOn carroPreco = Carro::mostraPreco;//chamando o metodo da classe Carro utilizando dois pontos duas vezes ::;
            carroPreco.on(onix);
        };
        ligandoCarro1.on(onix);

        /*definindo a variavel do tipo da interface igual anteriormente e dando seu nome, depois defino o nome do
        objeto que será utilizado como exemplo quando aquele método for chamado, e depois definindo o escopo do
        método em chaves{}. Só é necessário abrir chaves quando o método precisar de mais de uma linha.
         */
        ITurnOn reiniciarCarro = carro -> {
            System.out.println("reiniciando carro");
        };
        reiniciarCarro.on(onix);


    }
}
