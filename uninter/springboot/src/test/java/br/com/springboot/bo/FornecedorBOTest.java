package br.com.springboot.bo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Fornecedor;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class FornecedorBOTest {
	@Autowired
	private FornecedorBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFantasia("Nome fantasia");
		fornecedor.setRazaoSocial("razao social");
		fornecedor.setCnpj("00000000000000");
		fornecedor.setTelefone("1234567890");
		fornecedor.setCelular("12345678901");
		fornecedor.setEmail("email@email.com");
		fornecedor.setAtivo(true);
		bo.insere(fornecedor);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		System.out.println(fornecedor);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		fornecedor.setNomeFantasia("adhfldhsflja");
		bo.atualiza(fornecedor);
	}
	
	@Test
	@Order(4)
	public void inativa() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.inativa(fornecedor);
	}
	
	@Test
	@Order(5)
	public void ativa() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.ativa(fornecedor);
	}
	
	@Test
	@Order(6)
	public void remove() {
		Fornecedor fornecedor = bo.pesquisaPeloId(1L);
		bo.remove(fornecedor);
	}
}
