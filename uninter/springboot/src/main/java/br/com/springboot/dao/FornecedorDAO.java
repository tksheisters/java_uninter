package br.com.springboot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.springboot.model.Fornecedor;

@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Fornecedor pesquisaPeloId(Long id) {
		return entityManager.find(Fornecedor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> lista() {
		Query query = entityManager.createQuery("Select c from Fornecedor c");
		return (List<Fornecedor>) query.getResultList();
	}

	@Override
	public void insere(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);
	}

	@Override
	public void atualiza(Fornecedor fornecedor) {
		entityManager.merge(fornecedor);
	}

	@Override
	public void remove(Fornecedor fornecedor) {
		entityManager.remove(fornecedor);
	}

}
