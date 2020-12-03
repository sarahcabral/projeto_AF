package com.example.projeto_af.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.VeiculoDTO;
import com.example.projeto_af.model.Reserva;
import com.example.projeto_af.model.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {
    
    private long nextcod = 1;
    private List<Veiculo> veiculos = new ArrayList<Veiculo>();


    //Retornar todos os veiculos cadastrados
    public List<Veiculo> getAllVeiculos() {
        return veiculos;
    }
    //Retornar o veiculo pelo codigo, se não existir retorna null - empty
    public Optional <Veiculo> getVeiculoByCodigo(Long codigo) {
        for(Veiculo aux : veiculos)
        {
            if(aux.getCodigo() == codigo)
            return Optional.of(aux);
        }
        return Optional.empty();
    }

    //Salva o veiculo introduzindo o id automaticamente
    public Veiculo salvar(Veiculo veiculo) {
        veiculo.setCodigo(nextcod++);
        veiculos.add(veiculo);
        return veiculo;
    }

    //Faz update de um veiculo, possivelmente atualizando seu modelo ou valor diario
    public Veiculo update(Veiculo veiculo) {
        Veiculo aux = getVeiculoByCodigo(veiculo.getCodigo()).get();
        if(aux != null)
        {
            aux.setModelo(veiculo.getModelo());
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    //Remove um veiculo
    public void remove(Veiculo veiculo)
    {
        veiculos.remove(veiculo);
    }

    //Tansforma uma VeiculoDTO em Veiculo
    public Veiculo fromDTO(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo(dto.getModelo(),dto.getValorDiaria());
        return veiculo;
    }

    //Verifica se existem reservas em andamento - TRUE É RESERVADO - FALSE É LIVRE PARA APAGAR
	public boolean isReserva(Veiculo veiculo) {
		for(Reserva r : veiculo.getReservas()) {
            if(r.getDataEntrega().isAfter(LocalDateTime.now()) == true)
                return true;
        }
        return false;
	}
}

