package model.facade.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.ClienteDao;
import model.domain.Cliente;

@WebService(serviceName = "ws/cliente")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class ClienteFacadeImpl {

	ClienteDao clienteDao;

	@WebMethod
	public List<Cliente> getClientes() {

		return clienteDao.getClientes(new Cliente());
	}

	@WebMethod(operationName = "getClientesParametro")
	public List<Cliente> getClientes(Cliente cliente) {
		return clienteDao.getClientes(cliente);
	}

	@WebMethod
	public Cliente salvar(Cliente cliente) {
		return clienteDao.salvar(cliente);
	}

	@WebMethod
	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}

	@WebMethod
	public void excluir(Cliente cliente) {
		clienteDao.excluir(cliente);
	}
}
