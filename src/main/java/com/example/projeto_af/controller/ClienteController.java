package com.example.projeto_af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.projeto_af.dto.ClienteDTO;
import com.example.projeto_af.dto.ReservaDTO;
import com.example.projeto_af.model.Cliente;
import com.example.projeto_af.model.Reserva;
import com.example.projeto_af.service.ClienteService;
import com.example.projeto_af.service.ReservaService;

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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteServico;

    @Autowired
    private ReservaService reservaServico;


    @GetMapping
    public List<Cliente> getClientes() {
        return clienteServico.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteByCodigo(@PathVariable long id) {
        Cliente cli = clienteServico.getClienteByCodigo(id);
        return ResponseEntity.ok(cli);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteDTO novoCliente, HttpServletRequest request,
            UriComponentsBuilder builder) {

        Cliente cli = clienteServico.salvar(clienteServico.fromDTO(novoCliente));
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cli.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id) {
        clienteServico.removeByCodigo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteServico.fromDTO(clienteDTO);
        cliente.setCodigo(id);
        cliente = clienteServico.update(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}/reservas")
    public List<ReservaDTO> getReservasCliente(@PathVariable long id) {
        Cliente cli = clienteServico.getClienteByCodigo(id);
        return reservaServico.toListDTO(cli.getPedidos());
    }

    @PostMapping("/{id_cliente}/veiculos/{id_veiculo}")
    public ResponseEntity<Void> salvar(@PathVariable long id_cliente, @RequestBody Reserva reserva, HttpServletRequest request,
            UriComponentsBuilder builder) {

        pedido = reservaServico.salvar(id, pedido);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + reserva.getNumero()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
    
}
