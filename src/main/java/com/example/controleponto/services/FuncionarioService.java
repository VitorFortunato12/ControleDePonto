package com.example.controleponto.services;

import com.example.controleponto.models.Funcionario;
import com.example.controleponto.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorEmail(String email){
        return funcionarioRepository.findByEmail(email);
    }

    public Optional<Funcionario> buscarPorId(String id){
        return funcionarioRepository.findById(id);
    }

    public Optional<Funcionario> autenticar(String email, String senha){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByEmail(email);
        if(funcionarioOptional.isPresent()){
            Funcionario funcionario = funcionarioOptional.get();

            if(funcionarioOptional.isPresent()){
                return Optional.of(funcionario);
            }
        }
        return Optional.empty();
    }
}
