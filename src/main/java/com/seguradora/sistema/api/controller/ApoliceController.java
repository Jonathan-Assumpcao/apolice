package com.seguradora.sistema.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguradora.sistema.api.documents.Apolice;
import com.seguradora.sistema.api.response.Response;
import com.seguradora.sistema.api.services.ApoliceService;
import com.seguradora.sistema.api.validation.ResponseValidacao;

@RestController
@RequestMapping(path = "/api/apolices")
public class ApoliceController {

	@Autowired
	private ApoliceService apoliceService;
	
	@GetMapping
	public ResponseEntity<Response<List<Apolice>>>listarTodas() {
		return ResponseEntity.ok(new Response<List<Apolice>>(this.apoliceService.listarTodas()));
	}
	
	@PostMapping
	public ResponseEntity<Response<Apolice>> cadastrar(@Valid @RequestBody Apolice apolice, BindingResult result){
		try {
			apolice.validar(new ResponseValidacao(result));
			return ResponseEntity.ok(new Response<Apolice>(this.apoliceService.cadastrar(apolice)));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new Response<Apolice>(e.getMessage()));
		}
	}
	
	@PutMapping(path="/{numero}")
	public ResponseEntity<Response<Apolice>> atualizar(@PathVariable String numero, 
			@Valid @RequestBody Apolice apolice, BindingResult result){
		try {
			apolice.validar(new ResponseValidacao(result));
			
			return ResponseEntity.ok(new Response<Apolice>(this.apoliceService.atualizar(apolice)));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new Response<Apolice>(e.getMessage()));
		}
	}
	
	public ApoliceService getApoliceService() {
		return apoliceService;
	}

	public void setApoliceService(ApoliceService apoliceService) {
		this.apoliceService = apoliceService;
	}

}
