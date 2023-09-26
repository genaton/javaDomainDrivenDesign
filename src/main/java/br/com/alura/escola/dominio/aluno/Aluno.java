package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha;
	
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

//	public void adicionarTelefone(String ddd, String numero) {
//		this.telefones.add(new Telefone(ddd, numero));
//	}

	//Refatora o metodo com nova regra de negocios: Aluno nao pode ter mais do que dois telefones:

	public void adicionarTelefone(String ddd, String numero) {
		if(telefones.size() == 2) {
			throw new IllegalArgumentException("Numero maximo de telefones já cadastrado");
//			throw new NumeroMaximoDeTelefoneException();
		}
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public String getCpf() {
		return cpf.getNumero();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}
	
}






