package com.seguradora.sistema.api.services;

import java.util.List;
import com.seguradora.sistema.api.documents.Apolice;

public interface ApoliceService {
	
	List<Apolice> listarTodas();
	
	Apolice cadastrar(Apolice apolice);
	
	Apolice atualizar(Apolice apolice);
	
	void remove(String numero);
	
	Apolice buscarPorNumero(String numero);
	
	
}
