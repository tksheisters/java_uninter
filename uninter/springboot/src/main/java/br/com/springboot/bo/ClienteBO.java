package br.com.springboot.bo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.ClienteDAO;
import br.com.springboot.model.Cliente;

@Service
public class ClienteBO implements CRUD<Cliente, Long>{
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public Cliente pesquisaPeloId(Long id) {
		return clienteDAO.pesquisaPeloId(id);
	}

	@Override
	public List<Cliente> lista() {
		return clienteDAO.lista();
	}

	@Override
	public void insere(Cliente cliente) {
		clienteDAO.insere(cliente);
	}

	@Override
	public void atualiza(Cliente cliente) {
		clienteDAO.atualiza(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		clienteDAO.remove(cliente);
	}
	
	public void inativa(Cliente cliente) {
		cliente.setAtivo(false);
		clienteDAO.atualiza(cliente);
	}
	
	public void ativa(Cliente cliente) {
		cliente.setAtivo(true);
		clienteDAO.atualiza(cliente);
	}

}
