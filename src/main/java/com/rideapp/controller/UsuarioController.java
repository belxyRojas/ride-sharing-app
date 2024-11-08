package com.rideapp.controller;

import com.rideapp.model.Usuario;
import com.rideapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario createdUser = usuarioService.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario updatedUser = usuarioService.updateUser(id, usuario);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}