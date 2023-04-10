package br.com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.springboot.model.Produto;

@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Produto pesquisaPeloId(Long id) {
		return entityManager.find(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> lista() {
		Query query = entityManager.createQuery("Select p from Produto p");
		return (List<Produto>) query.getResultList();
	}

	@Override
	public void insere(Produto produto) {
		entityManager.persist(produto);
	}

	@Override
	public void atualiza(Produto produto) {
		entityManager.merge(produto);
	}

	@Override
	public void remove(Produto produto) {
		entityManager.remove(produto);
	}

}
