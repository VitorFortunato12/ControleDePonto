package com.example.controleponto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Document(collection = "pontos")
public class Ponto {

    @Id
    private String id;

    private String funcionarioId;
    private LocalDate data;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private Boolean aprovado;

    public Ponto() {
    }

    public Ponto(String id, LocalDate data, LocalTime horaEntrada, LocalTime horaSaida, Boolean aprovado) {
        this.id = id;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.aprovado = aprovado;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public LocalTime getHoraSaida() {
        return horaSaida;
    }
    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
    public Boolean getAprovado() {
        return aprovado;
    }
    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

}
