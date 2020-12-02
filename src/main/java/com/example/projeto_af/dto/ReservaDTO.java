package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.model.Veiculo;

public class ReservaDTO {

    private Veiculo         veiculo;
    private Cliente         cliente;
    private LocalDateTime   dataInicio;
    private LocalDateTime   dataEntrega;
    private double          totalReserva;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }
    

}
