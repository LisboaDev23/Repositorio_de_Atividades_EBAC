package br.com.fabrica;

import javax.lang.model.util.ElementScanner6;

public class Aplicacao {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("0159",false,true);
        Fabrica fabrica = getFabrica(cliente1);
        Carro carro = fabrica.criarCarro(cliente1.getCodigo());
    }
    public static Fabrica getFabrica (Cliente cliente){
        if (cliente.isPessoaFisica()){
            return new FabricaPFisica();
        }
        else {
            return new FabricaPJuridica();
        }

    }
}
