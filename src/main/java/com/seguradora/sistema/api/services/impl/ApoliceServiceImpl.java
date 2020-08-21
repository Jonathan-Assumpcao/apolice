package com.seguradora.sistema.api.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguradora.sistema.api.documents.Apolice;
import com.seguradora.sistema.api.repository.ApoliceRepository;
import com.seguradora.sistema.api.services.ApoliceService;

@Service
public class ApoliceServiceImpl implements ApoliceService {
	
	@Autowired
	private ApoliceRepository apoliceRepository;

	@Override
	public List<Apolice> listarTodas(){
		return this.apoliceRepository.findAll();
	}

	@Override
	public Apolice cadastrar(Apolice apolice) {
		apolice.setNumero(this.gerarNumeroApolice().toString());
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public Apolice atualizar(Apolice apolice){
		return this.apoliceRepository.save(apolice);
	}

	@Override
	public void remove(String numero) {
		this.apoliceRepository.deleteById(numero);
	}

	@Override
	public Apolice buscarPorNumero(String numero) throws NullPointerException {
		try {
			return this.apoliceRepository.findById(numero).get();
		}catch(Exception e) {
			throw new NullPointerException("Busca nao encotnrada");
		}
	}

	public ApoliceRepository getApoliceRepository() {
		return apoliceRepository;
	}

	public void setApoliceRepository(ApoliceRepository apoliceRepository) {
		this.apoliceRepository = apoliceRepository;
	}
	
	private Integer gerarNumeroApolice() {
		Random gerador = new Random();
		Integer tamanho = gerador.nextInt(999999999);
		while(this.apoliceRepository.existsById(tamanho.toString())) {
			tamanho++;
		}
		
		return tamanho;
	}
}
