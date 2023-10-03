package Tarefa_Stream;

import java.util.List;
import java.util.stream.Stream;

public class AppStream {
    public static void main(String[] args) {
        List<Pessoa> pessoaList = new Pessoa().cadastrandoPessoa();
        Stream<Pessoa> pessasListStream = pessoaList.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"));
        pessasListStream.forEach(pessoa -> System.out.println(pessoa.getNome()));
    }
}
