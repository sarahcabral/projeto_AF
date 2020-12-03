package com.example.projeto_af.service;

import java.util.List;
import java.util.Optional;

import com.example.projeto_af.dto.ReservaToVeiDTO;
import com.example.projeto_af.dto.VeiculoDTO;
import com.example.projeto_af.model.Veiculo;
import com.example.projeto_af.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repositorio;

    //Pega todos os veiculos
    public List<Veiculo> getAllVeiculos() {
        return repositorio.getAllVeiculos();
    }

    //Pega um veiculo pelo código
    public Veiculo getVeiculoByCodigo(long codigo) {
        Optional <Veiculo> op = repositorio.getVeiculoByCodigo(codigo);
        return op.orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não cadastrado"));
    }

    //Atualiza os dados do veiculo
    public Veiculo update(Veiculo veiculo) {
        getVeiculoByCodigo(veiculo.getCodigo());
        return repositorio.update(veiculo);
    }

    //Salva os dados do veiculo
    public Veiculo salvar(Veiculo veiculo) {
        return repositorio.salvar(veiculo);
    }

    //Tansforma uma VeiculoDTO em Veiculo
    public Veiculo fromDTO(VeiculoDTO dto) {
        Veiculo veiculo = new Veiculo(dto.getModelo(), dto.getValorDiaria());
        return veiculo;
    }

    //Remove um veiculo através de seu codigo
    public void removeByCodigo(long codigo) {
        Veiculo veiculo = getVeiculoByCodigo(codigo);
        if(veiculo != null){                        //Verifica se o veiculo existe
            if(isReservado(veiculo) == false ){     //Verifica se está reservado
                repositorio.remove(veiculo);
            } 
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O Cliente possui reservas em andamento - Não é possivel excluir o mesmo");
        }
    }
    
    //Verifica se o veiculo está reservado
    private boolean isReservado(Veiculo veiculo) {
        return repositorio.isReserva(veiculo);
    }

}
