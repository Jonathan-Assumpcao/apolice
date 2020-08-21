package com.seguradora.sistema.api.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguradora.sistema.api.documents.Cliente;
import com.seguradora.sistema.api.response.Response;
import com.seguradora.sistema.api.services.ClienteService;
import com.seguradora.sistema.api.validation.CadastrarClienteValidacao;
import com.seguradora.sistema.api.validation.ResponseValidacao;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Response<List<Cliente>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteService.listarTodos()));
	}
	
	@GetMapping(path = "/{cpf}")
	public ResponseEntity<Response<Cliente>> listarPorCPF(@PathVariable(name = "cpf") String cpf){
		try {
			return ResponseEntity.ok(new Response<Cliente>(this.clienteService.listarPorCPF(cpf)));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new Response<Cliente>(e.getMessage()));
		}
	}
	
	@PostMapping
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result){
		try {
			cliente.validar(new CadastrarClienteValidacao(cliente));		
			cliente.validar(new ResponseValidacao(result));
			return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new Response<Cliente>(e.getMessage()));
		}
	}
	
	@PutMapping(path = "/{cpf}")
	public ResponseEntity<Response<Cliente>> atualizar(@PathVariable(name ="cpf") String cpf,
				@Valid @RequestBody Cliente cliente, BindingResult result){
		try {
			cliente.setCpf(cpf);
			return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
		}catch(NullPointerException e) {
			return ResponseEntity.badRequest().body(new Response<Cliente>("CPF nao vinculado a nenhum cliente"));
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void remover(@PathVariable(name ="id") String id) {
		this.clienteService.remover(id);
	}

}
