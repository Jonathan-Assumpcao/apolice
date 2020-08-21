package com.seguradora.sistema.api.services;

import java.util.List;

import com.seguradora.sistema.api.documents.Cliente;

public interface ClienteService {
	
	List<Cliente> listarTodos();
	
	Cliente listarPorCPF(String cpf);
	
	Cliente cadastrar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	void remover(String cpf);
	
	
}
