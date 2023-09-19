package br.com.Mod18.Exceptions;

public class App {
    public static void main(String[] args)  {
       excecao();
    }
    /*o erro que estávamos persistindo pelo fato de não estarmos conseguindo chamar o método que executa a exceção
    foi solucionado da seguinte maneira, colocamos o método de exceção na própria classe de aplicação, com isso,
    no método onde iremos aplicar a exceção,fazemos o try e tentamos chamar o método da classe Exception chamado addCodigo onde nela
    criamos uma List de inteiros e instaciamos um objeto do tipo Scanner, nesse metodo solicitamos
    um código e o adicionamos nessa lista, solicitamos novamente um código e se for igual ao primeiro
    código selecionado, instanciamos um objeto (erro) do tipo da exceção (CodigoException) e no construtor
    dessa Exceção ela pede uma mensagem de erro, por fim eu lanço a exceção usando o throw seguido com
    o nome do novo objeto que foi instanciado na classe da exceção (erro), caso ele não entre nessa
    exceção, execute o resto da lógica do método. Voltando para a classe de aplicação e voltando para o método que
    executa, após fazer o try, no catch vamos passar a exceção do tipo que criamos chamada e, e nela printamos
    a mensagem de erro concatenando com a mensagem que é feita no método da exceção que está sendo passado.
     */
    private static void excecao(){
        try {
            Exceptions.addCodigo();
        } catch (CodigoException e){
            System.out.println("ERRO " + e.getMessage());
        }
    }
}
