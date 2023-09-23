package Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppReflection {
    public static void main(String[] args) {
        //definindo uma váriavel de classe pra pegar a pessoa
        Class classe = Pessoa.class; //Pessoa.class significa eu pegar a própria classe que estou passando
        System.out.println(classe);

        Pessoa pessoa = new Pessoa(); //instanciando normalmente
        Class classe1 = pessoa.getClass(); //pega a classe do objeto instanciado acima.
        System.out.println(classe1);

        //instanciando um novo objeto via reflection, dessa forma preciso pegar um construtor da classe
        /*Constructor constructorPessoa = classe.getConstructor(); *Fazendo somente dessa forma ele ia
        pedir pra fazer o tratamento da exceção pois somente assim a reflection poderia não achar esse construtor,
        ou poderia lançar o erro no proprio metodo main para conseguir instancia-lo dessa forma
         */
        try {
            Constructor constructorPessoa = classe.getConstructor();//construtor definido, agora vamos instanciar um objeto nele
            Pessoa pessoa1 = (Pessoa) constructorPessoa.newInstance();/*para fazermos a instância é necessário fazer o casting do construtorPessoa,
            pois ela é do tipo Constructor e vamos converte-lo para Pessoa,e dessa forma fazer a instância, nesse caso ele pede
            um monte de cláusula, mas depois ver mais sobre.
            */
            System.out.println(constructorPessoa);
            System.out.println(pessoa1);
            //vamos agr pegar as propriedades dessa classe, dessa forma vamos aproveitar do tratamento aqui nesse try mesmo
            Field[] propriedades = pessoa1.getClass().getDeclaredFields(); //declarando uma variável do tipo Field(propriedades) que é um array de propriedades
            for (Field propriedade : propriedades){//fazendo o foreach pra mostrar cada propriedade dessa lista de propriedades
                Class<?> tipoPropriedade = propriedade.getType(); //cada propriedade que for percorrida vai pegar o tipo dessa propriedade, se é String, Double etc.
                //defini uma variável do tipo Class que pode ser qualquer tipo usando o wildcard, e essa variável vai pegar o tipo dessa propriedade
                String nome = propriedade.getName();//cada propriedade que for percorrida vai pegar o nome dessa propriedade
                //defini uma variável do tipo String que vai representar o nome dessa propriedade
                System.out.println(tipoPropriedade);
                System.out.println(nome);
            }

            Method[] metodosPessoa = pessoa1.getClass().getDeclaredMethods();
            for (Method metodo : metodosPessoa){
                Class<?> tipoMetodo = metodo.getReturnType();
                String mostraMetodo = metodo.getName();
                System.out.println(tipoMetodo);
                System.out.println(mostraMetodo);
            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
