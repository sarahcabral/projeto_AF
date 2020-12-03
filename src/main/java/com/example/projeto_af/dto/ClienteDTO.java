package com.example.projeto_af.dto;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

    @NotBlank(message = "Nome do Cliente é OBRIGATÓRIO!")
    @Length(min=4,max = 200, message = "Nome mínimo de 4 e o máximo de 200 caracteres!")
    private String nome;

    @NotBlank(message = "Nome do Cliente é OBRIGATÓRIO!")
    @Length(min=4,max = 200, message = "Nome mínimo de 4 e o máximo de 200 caracteres!")
    private String endereco;

    @NotBlank(message = "CPF é OBRIGATÓRIO!")
    @Length(min=10,max = 14, message = "CPF mínimo de 4 e o máximo de 14 caracteres!")
    private int cpf;

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

}