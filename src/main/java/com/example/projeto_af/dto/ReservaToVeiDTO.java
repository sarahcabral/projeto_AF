package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import com.example.projeto_af.model.Cliente;

public class ReservaToVeiDTO {

    private long            codigo;
    private Cliente         cliente;
    private LocalDateTime   dataInicio;
    private LocalDateTime   dataEntrega;

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
    
}
