package com.seguradora.sistema.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguradora.sistema.api.documents.Cliente;
import com.seguradora.sistema.api.repository.ClienteRepository;
import com.seguradora.sistema.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorCPF(String cpf) throws NullPointerException{
		try {
			return this.clienteRepository.findById(cpf).get();
		}catch(NullPointerException e) {
			throw new NullPointerException("Nenhum item encontrado");
		}
	}

	@Override
	public Cliente cadastrar(Cliente cliente){
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		if(!this.clienteRepository.existsById(cliente.getCpf()))
			return null;
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void remover(String cpf) {
		this.clienteRepository.deleteById(cpf);
	}

}
