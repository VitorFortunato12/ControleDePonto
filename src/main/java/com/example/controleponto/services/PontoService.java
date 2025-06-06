package com.example.controleponto.services;

import com.example.controleponto.models.Funcionario;
import com.example.controleponto.models.Ponto;
import com.example.controleponto.repositories.FuncionarioRepository;
import com.example.controleponto.repositories.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PontoService {

    @Autowired
    private PontoRepository pontoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Ponto baterEntrada(String funcionarioId) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcionarioId);
        if (funcionarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario nao encontrado");
        }

        Funcionario usuario = funcionarioOptional.get();

        // Verifica se já tem um ponto para hoje sem saída registrada
        LocalDate hoje = LocalDate.now();
        List<Ponto> pontosHoje = pontoRepository.findByFuncionarioId(funcionarioId).stream()
                .filter(p -> p.getData().equals(hoje))
                .toList();

        for (Ponto p : pontosHoje) {
            if (p.getHoraEntrada() != null && p.getHoraSaida() == null) {
                throw new RuntimeException("Já existe ponto de entrada registrado e saída pendente para hoje");
            }
        }
        Ponto ponto = new Ponto();
        ponto.setFuncionarioId(usuario.getId());
        ponto.setData(hoje);
        ponto.setHoraEntrada(LocalTime.now());
        ponto.setAprovado(false); // aguarda aprovação do chefe

        return pontoRepository.save(ponto);
    }

    public Ponto baterSaida(String funcionarioId){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcionarioId);

        if (funcionarioOptional.isEmpty()){
            throw new RuntimeException("Usuario nao encontrado");
        }

        Funcionario funcionario = funcionarioOptional.get();
        LocalDate hoje = LocalDate.now();

        Optional<Ponto> pontoAbertoOpt = pontoRepository.findByFuncionarioId(funcionarioId).stream()
                .filter(p -> p.getData().equals(hoje) && p.getHoraSaida() == null)
                .findFirst();

        if (pontoAbertoOpt.isEmpty()){
            throw new RuntimeException("Nenhum ponto de entrada aberto para hoje");
        }

        Ponto ponto = pontoAbertoOpt.get();
        ponto.setHoraSaida(LocalTime.now());
        ponto.setAprovado(false); // aguardando aprovação do chefe

        return pontoRepository.save(ponto);
    }

    public List<Ponto> listarPorFuncionario(String funcionarioId){
        return pontoRepository.findByFuncionarioId(funcionarioId);
    }

    public List<Ponto> listarPendentes(){
        return pontoRepository.findByAprovadoFalse();
    }

    public void aprovarPonto(String pontoId) {
        Optional<Ponto> pontoOpt = pontoRepository.findById(pontoId);
        if (pontoOpt.isEmpty()) {
            throw new RuntimeException("Ponto não encontrado");
        }
        Ponto ponto = pontoOpt.get();
        ponto.setAprovado(true);
        pontoRepository.save(ponto);
    }

    public void rejeitarPonto(String pontoId) {
        Optional<Ponto> pontoOpt = pontoRepository.findById(pontoId);
        if (pontoOpt.isEmpty()) {
            throw new RuntimeException("Ponto não encontrado");
        }
        // Se quiser rejeitar, pode remover ou marcar de outra forma
        pontoRepository.deleteById(pontoId);
    }
}
