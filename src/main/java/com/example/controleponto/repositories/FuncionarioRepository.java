package com.example.controleponto.repositories;

import com.example.controleponto.models.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface FuncionarioRepository extends MongoRepository<Funcionario,String> {
    Optional<Funcionario> findByEmail(String email);
}
