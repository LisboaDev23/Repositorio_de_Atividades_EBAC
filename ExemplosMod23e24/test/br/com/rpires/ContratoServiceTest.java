package br.com.rpires;

import br.com.rpires.dao.ContratoDao;
import br.com.rpires.dao.IContratoDao;
import br.com.rpires.dao.mocks.ContratoDaoMock;
import br.com.rpires.service.ContratoService;
import br.com.rpires.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author rodrigo.pires
 */
public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
    @Test
    public void buscarTest(){
        IContratoDao daoBuscar = new ContratoDaoMock();//1°-Crio uma variável do tipo da interface do banco de dados, e instancio o objeto do tipo Mock, para fazer o teste
        IContratoService serviceBuscar = new ContratoService(daoBuscar); /*2°-Crio uma variável do tipo da interface de serviço, onde nela instancio o objeto do
        ContratoService e passo o objeto que seu construtor espera onde nele poderá chamar o método desejado*/
        String retornoBuscar = serviceBuscar.buscar();//3°-Crio uma variável String onde nela vou guardar o valor do método do objeto instanciado nos serviço
        Assert.assertEquals("Busca solicitada", retornoBuscar);//4°-Depois chamar o Assert e o seu método para fazermos a verificação no teste
    }
    @Test
    public void excluirTest(){
        IContratoDao daoExcluir = new ContratoDaoMock();
        IContratoService serviceExcluir = new ContratoService(daoExcluir);
        String retornoExcluir = serviceExcluir.excluir();
        Assert.assertEquals("Excluído com sucesso", retornoExcluir);
    }
    @Test
    public void atualizarTest(){
        IContratoDao daoAtualizar = new ContratoDaoMock();
        IContratoService serviceAtualizar = new ContratoService(daoAtualizar);
        String retornoAtualizar = serviceAtualizar.atualizar();
        Assert.assertEquals("Atualizado com sucesso", retornoAtualizar);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    //TODO
    //Fazer métodos de buscar, excluir e atualizar
}
