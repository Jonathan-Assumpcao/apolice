package com.seguradora.sistema.api.documents;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.seguradora.sistema.api.validation.Validacao;

@Document
public class Cliente {
	@CPF
	@Id	
	private String cpf;
	private String nome;
	private String cidade;
	private String uf;
	
	@NotEmpty
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@NotEmpty
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@NotEmpty
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void validar(Validacao valida) throws Exception{
		valida.executar();
	}

}
