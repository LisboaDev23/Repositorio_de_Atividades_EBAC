/**
 * 
 */
package br.com.rpires.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.rpires.dao.jdbc.ConnectionFactory;
import br.com.rpires.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO implements IClienteDAO {

	@Override
	public Cliente alterar(Cliente cliente) throws Exception {
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() throws Exception {
		return null;
	}

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO CLIENTES (ID, NOME, CPF, IDADE, ID_PRODUTO) VALUES (nextval('SQ_PRODUTOS'),?,?,?,?)";
			stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setLong(2,cliente.getCpf());
			stm.setInt(3,cliente.getIdade());
			stm.setLong(4,cliente.getIdProduto());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Cliente consultar(Long cpf) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM CLIENTES WHERE CPF = ?";
			stm = connection.prepareStatement(sql);
			stm.setLong(1,cpf);
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setIdade(rs.getInt("idade"));
				cliente.setIdProduto(rs.getLong("id_produto"));

			}
			return cliente;
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public Integer excluir(Cliente cliente) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM CLIENTES WHERE CPF = ?";
			stm = connection.prepareStatement(sql);
			stm.setLong(1, cliente.getCpf());
			return stm.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

}
