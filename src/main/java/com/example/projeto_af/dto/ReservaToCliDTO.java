package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import com.example.projeto_af.model.Veiculo;

public class ReservaToCliDTO {

    private long            codigo;
    private Veiculo         veiculo;
    private LocalDateTime   dataInicio;
    private LocalDateTime   dataEntrega;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    
}
