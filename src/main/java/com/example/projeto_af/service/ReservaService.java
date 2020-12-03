package com.example.projeto_af.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.ReservaDTO;
import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.model.Reserva;
import com.example.projeto_af.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repositorio;

    @Autowired
    private ClienteService clienteServico;

    @Autowired
    private VeiculoService veiculoServico;
    

    //Tansforma uma ReservaDTO em Reserva
    public Reserva fromDTO(ReservaDTO dto) {
        Reserva reserva = new Reserva(dto.getVeiculo(), dto.getCliente(), dto.getDataInicio(), dto.getDataEntrega());
        return reserva;
    }

    //Retorna uma lista com todas as reservas
    public List<Reserva> getAllReservas() {
        return repositorio.getAllReservas();
    }
    
    public Reserva getReservaByCodigo(long codigo) {
        Optional <Reserva> op = repositorio.getReservaByCodigo(codigo);
        return op.orElseThrow( ()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não existe"));
	}
    
    public Reserva salvar(long id_cliente, long id_veiculo, Reserva reserva) {
        if  (     !(reserva.getDataInicio().isAfter(LocalDateTime.now())) && 
                (reserva.getDataInicio().getDayOfWeek().equals(DayOfWeek.SUNDAY)) && 
                (reserva.getDataEntrega().getDayOfWeek().equals(DayOfWeek.SUNDAY))
            )
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reserva não pode ser processada");
        } else {
            clienteServico.getClienteByCodigo(id_cliente);
            veiculoServico.getVeiculoByCodigo(id_veiculo);
            return repositorio.salvar(reserva);
        }
    }
    
    public boolean isReservado(Cliente cli) {
        return false;
    }

	public List<ReservaDTO> toListDTO(ArrayList<Reserva> reservas) {
		return null;
	}
      
}
