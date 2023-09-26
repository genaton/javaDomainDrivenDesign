package br.com.alura.escola.dominio.aluno;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import br.com.alura.escola.dominio.aluno.NumeroMaximoDeTelefoneException;

class TelefoneTest {

	@Test
	void naoDeveriaCriarTelefoneComDDDsInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(null, "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("", "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("1", "123456789"));
	}

	@Test
	void naoDeveriaCriarTelefoneComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", ""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("11", "123"));
	}

	@Test
	void deveriaPermitirCriarTelefoneComDDDENumerosValidos() {
		String ddd = "11";
		String numero = "123456789";
		Telefone telefone = new Telefone(ddd, numero);
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
		
	}
	@Test
	void alunoNaoDeveriaTerMaisDeDoisNumerosDeTelefone(){
		Aluno aluno = new Aluno(new CPF("123.456.789-00"), "Fulano", new Email("fulano@email.com"));

		Telefone primeiroTelefone = new Telefone("00", "00000000");
		Telefone segundoTelefone = new Telefone("11", "11111111");
		Telefone terceiroTelefone = new Telefone("22", "22222222");

		assertThrows(NumeroMaximoDeTelefoneException.class, () -> {
			aluno.adicionarTelefone(primeiroTelefone.getDdd(), primeiroTelefone.getNumero());
			aluno.adicionarTelefone(segundoTelefone.getDdd(), segundoTelefone.getNumero());
			aluno.adicionarTelefone(terceiroTelefone.getDdd(), terceiroTelefone.getNumero());
		}) ;

	}

}
