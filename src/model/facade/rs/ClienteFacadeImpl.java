package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.ClienteDao;
import model.domain.Cliente;
import model.facade.ClienteFacade;

@Path("/cliente")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClienteFacadeImpl implements ClienteFacade {

	@Inject
	private ClienteDao clienteDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.facade.rs.ClienteFacade#salvar(model.domain.Cliente)
	 */
	@Override
	@POST
	public Cliente salvar(Cliente cliente) {
		cliente = clienteDao.salvar(cliente);
		return cliente;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.facade.rs.ClienteFacade#atualizarCliente(model.domain.Cliente)
	 */
	@Override
	@PUT
	public void atualizarCliente(Cliente cliente) {
		cliente = clienteDao.salvar(cliente);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.facade.rs.ClienteFacade#getClientes()
	 */
	@Override
	@GET
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.facade.rs.ClienteFacade#getClientes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Cliente> getClientes(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		return clienteDao.getClientes(cliente);
	}

	/*
	 * @PUT public Cliente atualizarCliente(Cliente cliente) { int pos =
	 * clientes.indexOf(cliente); if (pos >= 0) { clientes.set(pos,cliente);
	 * return cliente; } throw new WebApplicationException(404); }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.facade.rs.ClienteFacade#deletarCliente(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarCliente(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		clienteDao.excluir(cliente);
	}
	/*
	 * private Cliente getCliente(Integer codigo) throws
	 * ClienteNaoEncontradoException{ for (Cliente cliente: clientes) { if
	 * (cliente.getCodigo().equals(codigo)) { return cliente; } } throw new
	 * ClienteNaoEncontradoException(codigo); }
	 */
}
