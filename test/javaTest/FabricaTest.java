package javaTest;

import org.junit.Test;
import src.main.java.dao.EmpresarioDAO;
import src.main.java.dao.FabricaDAO;
import src.main.java.dao.IEmpresarioDAO;
import src.main.java.dao.IFabricaDAO;
import src.main.java.domain.Empresario;
import src.main.java.domain.Fabrica;

public class FabricaTest {

    private IFabricaDAO fabricaDAO;
    private IEmpresarioDAO empresarioDAO;

    public FabricaTest(){
        fabricaDAO = new FabricaDAO();
        empresarioDAO = new EmpresarioDAO();
    }
    @Test
    public void cadastrar(){

    }










//
//    private Fabrica criandoFabrica(Empresario empresario){
//        Fabrica fabrica = new Fabrica();
//        fabrica.setEmpresario(empresario);
//        fabrica.setNome("Fábrica de Computadores ACER");
//        fabrica.setProdutos();
//    }
}
