package com.example.projeto_af.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.example.projeto_af.model.Veiculo;


public class VeiculoRepository {
    
    private int nextcod = 1;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();


//Retornar todos os veiculos cadastrados
    public ArrayList<Veiculo> getAllVeiculos() {
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
}

