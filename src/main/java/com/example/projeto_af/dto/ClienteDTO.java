package com.example.projeto_af.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

    @NotBlank(message = "Nome do Cliente é OBRIGATÓRIO!")
    @Length(min=4,max = 200, message = "Nome mínimo de 4 e o máximo de 200 caracteres!")
    private String nome;

    @NotBlank(message = "Nome do Cliente é OBRIGATÓRIO!")
    @Length(min=4,max = 200, message = "Nome mínimo de 4 e o máximo de 200 caracteres!")
    private String endereco;

    @NotNull(message = "CPF é OBRIGATÓRIO!")
    @Length(min=10,max = 11, message = "CPF possui deve possuir de 10 a 11 dígitos")
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}