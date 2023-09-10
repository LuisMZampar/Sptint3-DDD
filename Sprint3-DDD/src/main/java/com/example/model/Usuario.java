package com.example.model;

public class Usuario {
    private String email;
    private String cpf;
    private String senha;
    private String nome;

    public Usuario(int id, String email, String cpf, String senha, String nome) {
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    // Getters e setters para as propriedades do usuário


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
