package model.facade;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import model.domain.Cliente;

public interface ClienteFacade {

	Cliente salvar(Cliente cliente);

	void atualizarCliente(Cliente cliente);

	List<Cliente> getClientes();

	List<Cliente> getClientes(Integer codigo);

	void deletarCliente(Integer codigo);
	/*
	 * private Cliente getCliente(Integer codigo) throws
	 * ClienteNaoEncontradoException{ for (Cliente cliente: clientes) { if
	 * (cliente.getCodigo().equals(codigo)) { return cliente; } } throw new
	 * ClienteNaoEncontradoException(codigo); }
	 */

}