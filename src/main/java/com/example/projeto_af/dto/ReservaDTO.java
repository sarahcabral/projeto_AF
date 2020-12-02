package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ReservaDTO {

    private Veiculo         veiculo;
    private Cliente         cliente;
    private LocalDateTime   dataInicio;
    private LocalDateTime   dataEntrega;

    

	public ReservaDTO() {
	}

	public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    @JsonGetter
    public static double totalReserva(Veiculo veiculo, LocalDateTime inicio, LocalDateTime fim) {
        double soma = veiculo.getValorDiaria()*(fim.compareTo(inicio));
        return soma;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    
}
