package br.com.Mod18.Exceptions;
//toda classe Exception deve ter o nome Exception no final e sua classe deve extender Exception
public class CodigoException extends Exception {

    public CodigoException(String mensagem) {
        super(mensagem);
        /*sempre passar o super que referencia a classe pai Exception onde no construtor passa uma
        mensagem, da mesma forma deve ser passado no construtor da classe de Exceção.
         */
    }
    //construtor onde vou passar a mensagem de Exceção de Código

}
