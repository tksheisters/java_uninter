package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.FornecedorDAO;
import br.com.springboot.model.Fornecedor;

@Service
public class FornecedorBO implements CRUD<Fornecedor, Long>{
	
	@Autowired
	private FornecedorDAO fornecedorDAO;

	@Override
	public Fornecedor pesquisaPeloId(Long id) {
		return fornecedorDAO.pesquisaPeloId(id);
	}

	@Override
	public List<Fornecedor> lista() {
		return fornecedorDAO.lista();
	}

	@Override
	public void insere(Fornecedor fornecedor) {
		fornecedorDAO.insere(fornecedor);
		
	}

	@Override
	public void atualiza(Fornecedor fornecedor) {
		fornecedorDAO.atualiza(fornecedor);
		
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		fornecedorDAO.remove(fornecedor);
		
	}
	
	public void ativa(Fornecedor fornecedor) {
		fornecedor.setAtivo(true);
		fornecedorDAO.atualiza(fornecedor);
	}
	
	public void inativa(Fornecedor fornecedor) {
		fornecedor.setAtivo(false);
		fornecedorDAO.atualiza(fornecedor);
	}
}
