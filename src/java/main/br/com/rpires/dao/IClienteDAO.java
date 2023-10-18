/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;

import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO {

	public Cliente alterar (Cliente cliente) throws Exception;

	public List<Cliente> buscarTodos() throws Exception;
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(Long cpf) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;
}
