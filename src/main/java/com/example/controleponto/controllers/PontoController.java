package com.example.controleponto.controllers;

import com.example.controleponto.models.Ponto;
import com.example.controleponto.services.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pontos")
@CrossOrigin(origins = "*")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @PostMapping("/entrada/{funcionarioId}")
    public Ponto baterEntrada(@PathVariable("funcionarioId") String funcionarioId){
        return pontoService.baterEntrada(funcionarioId);
    }

    @PostMapping("/saida/{funcionarioId}")
    public Ponto baterSaida(@PathVariable("funcionarioId") String funcionarioId){
        return pontoService.baterSaida(funcionarioId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Ponto> listarPorUsuario(@PathVariable String usuarioId) {
        return pontoService.listarPorFuncionario(usuarioId);
    }

    @GetMapping("/pendentes")
    public List<Ponto> listarPendentes() {
        return pontoService.listarPendentes();
    }

    @PutMapping("/aprovar/{pontoId}")
    public void aprovarPonto(@PathVariable String pontoId) {
        pontoService.aprovarPonto(pontoId);
    }

    @DeleteMapping("/rejeitar/{pontoId}")
    public void rejeitarPonto(@PathVariable String pontoId) {
        pontoService.rejeitarPonto(pontoId);
    }
}
