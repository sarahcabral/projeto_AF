package com.example.projeto_af.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cliente {
    private long    codigo;
    private String  nome;
    private String  endereco;
    private int     cpf;

    @JsonIgnore
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public Cliente() {
    }

    public Cliente(long codigo, int cpf) {
        this.codigo = codigo;
        this.cpf = cpf;
    }

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    
    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", cpf=" + cpf + ", endereco=" + endereco + ", nome=" + nome + "]";
    }

    
}
