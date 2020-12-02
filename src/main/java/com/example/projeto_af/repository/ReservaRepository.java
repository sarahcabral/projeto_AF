package com.example.projeto_af.repository;

import java.util.ArrayList;
import java.util.Optional;
import com.example.projeto_af.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaRepository {
    
    private long nextcod = 1;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    //Retornar todos as reservas cadastrados
    public ArrayList<Reserva> getAllReservas() {
        return reservas;
    }

    //Retornar a reserva pelo codigo, se não existir retorna null - empty
    public Optional<Reserva> getClienteByCodigo(long codigo) {
        for(Reserva aux : reservas)
        {
            if(aux.getCodigo() == codigo)
            return Optional.of(aux);
        } 
        return Optional.empty();
    }

    //Salva a reserva introduzindo o id automaticamente
    public Reserva salvar(Reserva reserva) {
        reserva.setCodigo(nextcod++);
        reservas.add(reserva);
        return reserva;
    }

    //Verifica se existem reservas em andamento
	/*public boolean isReserva() {
        
        for(Cliente c: clientes) {

            if(cliente.getReservas())
        }
        
        return false;
    }*/
    
}
