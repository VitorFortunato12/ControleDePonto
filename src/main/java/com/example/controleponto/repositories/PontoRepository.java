package com.example.controleponto.repositories;

import com.example.controleponto.models.Ponto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface PontoRepository extends MongoRepository<Ponto,String> {
    List<Ponto> findByFuncionarioId(String funcionarioId);
    List<Ponto> findByAprovadoFalse();
}
