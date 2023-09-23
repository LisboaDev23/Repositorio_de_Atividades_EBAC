package TarefaReflections;

import java.lang.annotation.Annotation;

@Tabela("Tabela Anotação")
//atribuindo o value que é o nome da tabela, lá no Target onde passei o TYPE, para ser usado na classe
public class MostrandoAnotacao {
    public MostrandoAnotacao(){

    }
    public static void main(String[] args) {
        MostrandoAnotacao mostrandoAnotacao = new MostrandoAnotacao();

    }
    public void getValor(Class<?> classe){
        Annotation[] annotations = classe.getClass().getAnnotations();
        for (Annotation annotation : annotations){
            if (classe.isAnnotationPresent(Tabela.class)){
                Tabela tabela = classe.getAnnotation(Tabela.class);
                String valorAnotacao = tabela.value();
                System.out.println(valorAnotacao);
            }
        }
    }
    @Tabela("Usando anotação no método")
    public String propriedadeDeClasse;
//usando minha annotation na propriedade de classe é na própria classe pois lá no Target passei para ser usado na FIELD, propriedade de classe
}