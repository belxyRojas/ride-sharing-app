package com.rideapp.service;

import com.rideapp.model.Pago;
import com.rideapp.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pago createPago(Pago pago) {
        pago.setReferenciaTransaccion(generateTransactionReference());
        return pagoRepository.save(pago);
    }

    public Pago getPagoById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public List<Pago> getPagosByUsuarioId(Long usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }

    public Pago procesarPago(Long id) {
        Pago pago = getPagoById(id);
        pago.setEstado("COMPLETADO");
        pago.setFechaPago(LocalDateTime.now());
        return pagoRepository.save(pago);
    }

    private String generateTransactionReference() {
        return "TX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}