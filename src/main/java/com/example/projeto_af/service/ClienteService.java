package com.example.projeto_af.service;

import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.ClienteDTO;
import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;
/*
    @Autowired
    private ReservaService reservaService;
*/
    //Pega todos os clientes
    public List<Cliente> getAllClientes() {
        return repositorio.getAllClientes();
    }

    //Pega um cliente pelo código
    public Cliente getClienteByCodigo(long codigo) {
        Optional <Cliente> op = repositorio.getClienteByCodigo(codigo);
        return op.orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não cadastrado"));
    }

    //Tansforma uma ClienteDTO em Cliente
    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente(dto.getNome(),dto.getEndereco(), dto.getCpf());
        return cliente;
    }

    //Atualiza os dados do cliente
    public Cliente update(Cliente cliente) {
        getClienteByCodigo(cliente.getCodigo());
        return repositorio.update(cliente);
    }

    //Salva os dados do cliente
    public Cliente salvar(Cliente cliente) {
        return repositorio.salvar(cliente);
    }

    public void removeByCodigo(long codigo) {
        Cliente cliente = getClienteByCodigo(codigo);
        if(cliente != null){
            if(isReservado(cliente) == false ){
                repositorio.remove(cliente);
            } 
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O Cliente possui reservas em andamento - Não é possivel excluir o mesmo");
        }
    }

    
    public boolean isReservado(Cliente cliente) {
        return repositorio.isReserva(cliente);
    }

    
}
