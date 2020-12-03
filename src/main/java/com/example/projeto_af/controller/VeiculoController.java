package com.example.projeto_af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.projeto_af.dto.ReservaToVeiDTO;
import com.example.projeto_af.dto.VeiculoDTO;
import com.example.projeto_af.model.Veiculo;
import com.example.projeto_af.service.ReservaService;
import com.example.projeto_af.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoServico;

    @Autowired
    private ReservaService reservaServico;


    @GetMapping
    public List<Veiculo> getVeiculos() {
        return veiculoServico.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getClienteByCodigo(@PathVariable long id) {
        Veiculo veiculo = veiculoServico.getVeiculoByCodigo(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody VeiculoDTO novoVeiculo, HttpServletRequest request,
            UriComponentsBuilder builder) {
        Veiculo veiculo = veiculoServico.salvar(veiculoServico.fromDTO(novoVeiculo));
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + veiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id) {
        veiculoServico.removeByCodigo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable long id, @Valid @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoServico.fromDTO(veiculoDTO);
        veiculo.setCodigo(id);
        veiculo = veiculoServico.update(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/{id}/reservas")
    public List<ReservaToVeiDTO> getReservasCliente(@PathVariable long id) {
        Veiculo veiculo = veiculoServico.getVeiculoByCodigo(id);
        return reservaServico.toListVeiDTO(veiculo.getReservas());
    }
}
