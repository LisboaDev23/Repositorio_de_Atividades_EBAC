package br.com.atividadeMod13;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridica extends Pessoa{
    private Long cpnj;
    private String nomeEmpresa;

    public Long getCpnj() {
        return cpnj;
    }

    public void setCpnj(Long cpnj) {
        this.cpnj = cpnj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
