package br.com.fabrica;

public class FabricaPFisica extends Fabrica{
    @Override
    Carro carroSelecionado(String codigo) {
        if ("0235".equals(codigo)){
            return new Lamborgini("Laranja", 350, 2020);
        }
        else {
            return null;
        }
    }
}
