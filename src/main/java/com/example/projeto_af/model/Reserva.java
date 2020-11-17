package com.example.projeto_af.model;

import java.util.Date;


public class Reserva {
    private long codigo;
    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataInicio;
    private Date dataEntrega;

    public Reserva() {
    }

    public Reserva(long codigo, Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataEntrega) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.veiculo = veiculo;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", codigo=" + codigo + ", dataEntrega=" + dataEntrega + ", dataInicio="
                + dataInicio + ", veiculo=" + veiculo + "]";
    }
}
