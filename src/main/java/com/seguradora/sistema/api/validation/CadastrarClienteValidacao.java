package com.seguradora.sistema.api.validation;

import com.seguradora.sistema.api.documents.Cliente;

public class CadastrarClienteValidacao implements Validacao {
	
	private Cliente cliente;
	
	public CadastrarClienteValidacao(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void executar() {
		String cpf = this.cliente.getCpf();
		this.cliente.setCpf(cpf.replaceAll("[.-]", ""));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
