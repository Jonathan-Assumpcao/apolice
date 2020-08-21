package com.seguradora.sistema.api.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataValidacao implements Validacao {
	
	private String exp;
	private String data;
	
	public DataValidacao(String data,String exp) {
		this.exp = exp;
		this.data = data;
	}

	@Override
	public void executar() throws Exception {
		try {
			SimpleDateFormat sdt = new SimpleDateFormat(this.exp);
			sdt.parse(this.data);
		}catch(ParseException e) {
			throw new Exception("Data inválida");
		}
	}

}
