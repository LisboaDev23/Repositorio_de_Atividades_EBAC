package br.com.Mod18.TarefaAnnotations;

import java.lang.annotation.*;

//Meta-anotações
@Documented //anotação será disponibilizada na documentação JAVA DOC
@Retention(RetentionPolicy.RUNTIME)//dúvida: oque é o RetetionPolicy? -Runtime sei que é no tempo de execução!
@Target({ElementType.TYPE, ElementType.FIELD}) /*definindo que minha anotação pode ser passada na propia classe
ou interface, e na minha propriedade de classe*/

public @interface Tabela {
    //definindo o valor que essa anotação pede
    String value();
}
