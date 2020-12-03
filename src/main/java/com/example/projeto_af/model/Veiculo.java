package com.example.projeto_af.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Veiculo {
    private long    codigo;
    private String  modelo;
    private double  valorDiaria;
    
    @JsonIgnore
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public Veiculo() {
    }

    public Veiculo(String modelo, double valorDiaria) {
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }
    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Veiculo [codigo=" + codigo + ", modelo=" + modelo + ", valorDiaria=" + valorDiaria + "]";
    }  

}
