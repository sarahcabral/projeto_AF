package com.example.projeto_af.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.model.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    
    private long nextcod = 1;
    private List<Cliente> clientes = new ArrayList<Cliente>();

    //Retornar todos os clientes cadastrados
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    //Retornar o cliente pelo codigo, se não existir retorna null - empty
    public Optional<Cliente> getClienteByCodigo(long codigo) {
        for(Cliente aux : clientes)
        {
            if(aux.getCodigo() == codigo)
            return Optional.of(aux);
        } 
        return Optional.empty();
    }

    //Salva o cliente introduzindo o id automaticamente
    public Cliente salvar(Cliente cliente) {
        cliente.setCodigo(nextcod++);
        clientes.add(cliente);
        return cliente;
    }

    //Faz update de um cliente, possivelmente atualizando seu modelo ou valor diario
    public Cliente update(Cliente cliente) {
        Cliente aux = getClienteByCodigo(cliente.getCodigo()).get();
        if(aux != null)
        {
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
        }
        return aux;
    }

    //Remove um cliente
    public void remove(Cliente cliente)
    {
        clientes.remove(cliente);
    }

    //Verifica se existem reservas em andamento - TRUE É RESERVADO - FALSE É LIVRE PARA APAGAR
	public boolean isReserva(Cliente cliente) {
        for(Reserva r : cliente.getReservas()) {
            if(r.getDataEntrega().isAfter(LocalDateTime.now()) == true)
                return true;
        }
        return false;
    }

}



