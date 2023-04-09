package br.com.springboot.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.ProdutoDAO;
import br.com.springboot.model.Produto;

@Service
public class ProdutoBO implements CRUD<Produto, Long> {
	@Autowired
	private ProdutoDAO produtoDAO;

	@Override
	public Produto pesquisaPeloId(Long id) {
		return produtoDAO.pesquisaPeloId(id);
	}

	@Override
	public List<Produto> lista() {
		return produtoDAO.lista();
	}

	@Override
	public void insere(Produto produto) {
		produtoDAO.insere(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		produtoDAO.atualiza(produto);
	}

	@Override
	public void remove(Produto produto) {
		produtoDAO.remove(produto);
	}

	public void inativa(Produto produto) {
		produto.setAtivo(false);
		produtoDAO.atualiza(produto);
	}

	public void ativa(Produto produto) {
		produto.setAtivo(true);
		produtoDAO.atualiza(produto);
	}

}
