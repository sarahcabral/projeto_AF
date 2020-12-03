package com.example.projeto_af.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ReservaDTO {

    @NotBlank(message = "Campo OBRIGATÓRIO")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime   dataInicio;
    @NotBlank(message = "Campo OBRIGATÓRIO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime   dataEntrega;

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
