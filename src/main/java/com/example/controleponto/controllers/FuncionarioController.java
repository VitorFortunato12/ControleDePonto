package com.example.controleponto.controllers;

import com.example.controleponto.models.Funcionario;
import com.example.controleponto.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.criarFuncionario(funcionario);
    }

    @PostMapping("/login")
    public Optional<Funcionario> login(@RequestBody LoginDTO loginDTO) {
        return funcionarioService.autenticar(loginDTO.getEmail(), loginDTO.getSenha());
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> buscarPorId(@PathVariable String id){
        return funcionarioService.buscarPorId(id);
    }
}
