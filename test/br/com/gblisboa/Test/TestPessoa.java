package br.com.gblisboa.Test;

import Tarefa_Stream.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class TestPessoa {
    @Test
    public void testListMulheres(){
        List<Pessoa> pessoaList = new Pessoa().cadastrandoPessoa();//criando uma list puxando as pessoas que foram cadastradas nesse método
        Stream<Pessoa> pessasListStream = pessoaList.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"));//criando a stream onde da lista de pessoas seleciono as que somente tem mulheres para depois serem testadas
        Assert.assertArrayEquals(pessoaList.stream().//chamando o método da classe Assert onde passo nos parâmetros desse método, oque eu espero no teste, e no outro parâmetro passo a stream feita anteriormente só com as mulheres.
                        filter(pessoa -> pessoa.getSexo().equals("Feminino")).toArray()
                , pessasListStream.toArray());
    }
}
