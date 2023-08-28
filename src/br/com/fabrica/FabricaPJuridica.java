package br.com.fabrica;

public class FabricaPJuridica extends Fabrica{

    @Override
    Carro carroSelecionado(String codigo) {
        if ("0159".equals(codigo)){
            return new FerrariV8("vermelha", 300, 2023);
        }
        else {
            return new FerrariV2("Preta", 250, 2022);
        }
    }
}
