package com.rideapp.controller;

import com.rideapp.model.Pago;
import com.rideapp.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        List<Pago> pagos = pagoService.getAllPagos();
        return ResponseEntity.ok(pagos);
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        Pago createdPago = pagoService.createPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Pago pago = pagoService.getPagoById(id);
        return ResponseEntity.ok(pago);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Pago>> getPagosByUsuario(@PathVariable Long usuarioId) {
        List<Pago> pagos = pagoService.getPagosByUsuarioId(usuarioId);
        return ResponseEntity.ok(pagos);
    }

    @PostMapping("/{id}/procesar")
    public ResponseEntity<Pago> procesarPago(@PathVariable Long id) {
        Pago pago = pagoService.procesarPago(id);
        return ResponseEntity.ok(pago);
    }
}