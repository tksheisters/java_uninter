package br.com.springboot.bo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Categoria;
import br.com.springboot.model.Produto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProdutoBOTest {
	@Autowired
	private ProdutoBO bo;

	@Test
	@Order(1)
	public void insere() {
		Produto produto = new Produto();
		produto.setNome("testeeeeeeeeeeee");
		produto.setCategoria(Categoria.CELULARES);
		produto.setAtivo(true);
		bo.insere(produto);
	}

	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Produto produto = bo.pesquisaPeloId(1L);
		System.out.println(produto);
	}

	@Test
	@Order(3)
	public void atualiza() {
		Produto produto = bo.pesquisaPeloId(1L);
		produto.setNome("teaessateta");
		produto.setCategoria(Categoria.MOVEIS);
		bo.atualiza(produto);
	}

	@Test
	@Order(4)
	public void inativa() {
		Produto produto = bo.pesquisaPeloId(1L);
		bo.inativa(produto);
	}

	@Test
	@Order(5)
	public void ativa() {
		Produto produto = bo.pesquisaPeloId(1L);
		bo.ativa(produto);
	}

	@Test
	@Order(6)
	public void remove() {
		Produto produto = bo.pesquisaPeloId(1L);
		bo.remove(produto);
	}
}
