package com.rideapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Conexión exitosa a la API");
    }
}