package br.com.atividadeMod13;

import java.time.LocalDate;

public class Programa {
    public static void main (String args[]){
        PessoaFisica pessoaFisica1 = new PessoaFisica();
        pessoaFisica1.setNome("Gabriel Lisboa");
        pessoaFisica1.setCpf(19134960309l);
        pessoaFisica1.setFiliacaoMae("Eva Wilma Pereira Lisboa");
        pessoaFisica1.setFiliacaoPai("Isaias Lisboa da Silva");
        System.out.println("Nome " + pessoaFisica1.getNome()+" CPF: " + pessoaFisica1.getCpf() + " sua mãe é " + pessoaFisica1.getFiliacaoMae() + " seu pai é " + pessoaFisica1.getFiliacaoPai() );

        PessoaJuridica pessoaJuridica1 = new PessoaJuridica();
        pessoaJuridica1.setNome("Iasmim Bessa");
        pessoaJuridica1.setCpnj(11853988000166l);


        System.out.println("Nome " + pessoaJuridica1.getNome() + "o CNPJ de sua empresa é " + pessoaJuridica1.getCpnj());
    }
}
