package TarefaReflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAnotacao {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        getAnotacao();
    }
        public static void getAnotacao() throws NoSuchMethodException, NoSuchFieldException {
        Class<?> classe = MostrandoAnotacao.class;
        Annotation[] anotacao = (Annotation[]) classe.getAnnotations();
        Tabela anotacaoField = classe.getDeclaredField("propriedadeDeClasse").getAnnotation(Tabela.class);
        Tabela anotacoes = classe.getAnnotation(Tabela.class);
        for (Annotation annotation : anotacao){
            String valor = anotacoes.value();
            String valorPropriedade = anotacaoField.value();
            System.out.println(valor);
            System.out.println(valorPropriedade);
        }



    }
}
