package com.example.projeto_af.service;

import java.util.List;
import java.util.Optional;

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
    public Veiculo getClienteByCodigo(long codigo) {
        Optional <Veiculo> op = repositorio.getVeiculoByCodigo(codigo);
        return op.orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não cadastrado"));
    }

    //Atualiza os dados do veiculo
    public Veiculo update(Veiculo veiculo) {
        getClienteByCodigo(veiculo.getCodigo());
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

    
}
