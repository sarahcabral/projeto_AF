package com.example.projeto_af.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class VeiculoDTO {

    @NotBlank(message = "Modelo do veiculo é OBRIGATÓRIO")
    private String  modelo;
    @Positive(message = "Valor da diaria não pode ser NULA ou NEGATIVA")
    private double  valorDiaria;


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
    
}
