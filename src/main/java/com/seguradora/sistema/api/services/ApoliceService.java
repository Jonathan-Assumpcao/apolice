package com.seguradora.sistema.api.services;

import java.util.List;
import com.seguradora.sistema.api.documents.Apolice;

public interface ApoliceService {
	
	List<Apolice> listarTodas() throws Exception;
	
	Apolice cadastrar(Apolice apolice)throws Exception;
	
	Apolice atualizar(Apolice apolice) throws Exception;
	
	void remove(String numero) throws Exception;
	
	Apolice buscarPorNumero(String numero) throws Exception;
	
	
}
