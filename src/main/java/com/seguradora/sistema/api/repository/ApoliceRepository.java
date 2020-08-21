package com.seguradora.sistema.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.seguradora.sistema.api.documents.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice, String>{

}
