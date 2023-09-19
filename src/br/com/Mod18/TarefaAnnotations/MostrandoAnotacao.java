package br.com.Mod18.TarefaAnnotations;
@Tabela("Tabela Anotação")
//atribuindo o value que é o nome da tabela
public class MostrandoAnotacao {
    @Tabela("Usando anotação no método")
    private String propriedadeDeClasse;
    //usando minha annotation na propriedade de classe é na própria classe.
}
