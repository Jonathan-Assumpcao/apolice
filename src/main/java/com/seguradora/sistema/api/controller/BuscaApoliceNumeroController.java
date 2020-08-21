package com.seguradora.sistema.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguradora.sistema.api.documents.Apolice;
import com.seguradora.sistema.api.response.Response;
import com.seguradora.sistema.api.services.ApoliceService;

@RestController
@RequestMapping(path="api/buscaapolice")
public class BuscaApoliceNumeroController {
	
	@Autowired
	private ApoliceService apoliceService;
	
	
	@GetMapping(path="/{numero}")
	public ResponseEntity<Response<Apolice>> getPorNumero(@PathVariable String numero){
		return ResponseEntity.ok(new Response<Apolice>(this.apoliceService.buscarPorNumero(numero)));
	}

}
