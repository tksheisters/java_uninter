package br.com.springboot.bo;

import java.time.LocalDate;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {
	@Autowired
	private ClienteBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("Matheus");
		cliente.setCpf("09332411900");
		cliente.setDataDeNascimento(LocalDate.of(2000, 1, 29));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("1234567890");
		cliente.setCelular("12345678901");
		cliente.setEmail("email@email.com");
		cliente.setAtivo(true);
		bo.insere(cliente);
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setCpf("09332411955");
		bo.atualiza(cliente);
	}
	
	@Test
	@Order(4)
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.inativa(cliente);
	}
	
	@Test
	@Order(5)
	public void ativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.ativa(cliente);
	}
	
	@Test
	@Order(6)
	public void remove() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.remove(cliente);
	}
}
