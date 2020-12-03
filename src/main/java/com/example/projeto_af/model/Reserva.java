package com.example.projeto_af.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Reserva {
    private long            codigo;
    private Cliente         cliente;
    private Veiculo         veiculo;
    private LocalDateTime   dataInicio;
    private LocalDateTime   dataEntrega;

    public Reserva(LocalDateTime dataInicio, LocalDateTime dataEntrega) {
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    @JsonGetter
    public static double totalReserva(Veiculo veiculo, LocalDateTime inicio, LocalDateTime fim) {
        double soma = veiculo.getValorDiaria()*(fim.compareTo(inicio));
        return soma;
    }

    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", codigo=" + codigo + ", dataEntrega=" + dataEntrega + ", dataInicio="
                + dataInicio + ", veiculo=" + veiculo + "]";
    }
/*
    "dataPedido": "20/11/2020@10:00:01",
    "dataEntrega": "20/12/2020",
*/


}
