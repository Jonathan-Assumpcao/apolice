package com.seguradora.sistema.api.validation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;


public class ResponseValidacao implements Validacao{
	private BindingResult result;
	
	public ResponseValidacao(BindingResult result) {
		this.result = result;
	}

	@Override
	public void executar() throws Exception {
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
			
			throw new Exception(errors.toString());
		}		
	}


}
