package com.example.controleponto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Document(collection = "funcionarios")
public class Funcionario {

    @Id
    private String id;
// mongodb+srv://vitorfortunato456:rRLYMTtFv3z6WV7J@cluster0.napaook.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0 string conexao atlas
    private String nome;

    private TipoFuncionario cargo;

    private String email;

    private String senha;


    public Funcionario() {
    }

    public Funcionario(String id, String nome, TipoFuncionario cargo, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(TipoFuncionario cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
