package com.example.projeto_af.controller;

import java.util.List;
import com.example.projeto_af.model.Reserva;
import com.example.projeto_af.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaServico;

    @GetMapping
    public List<Reserva> getReservas() {
        return reservaServico.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaByCodigo(@PathVariable long id) {
        Reserva reserva = reservaServico.getReservaByCodigo(id);
        return ResponseEntity.ok(reserva);
    }
}
