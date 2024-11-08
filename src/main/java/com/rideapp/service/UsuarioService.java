package com.rideapp.service;

import com.rideapp.model.Usuario;
import com.rideapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario updateUser(Long id, Usuario usuario) {
        Usuario existingUser = getUserById(id);
        existingUser.setNombre(usuario.getNombre());
        existingUser.setEmail(usuario.getEmail());
        existingUser.setTelefono(usuario.getTelefono());
        existingUser.setPassword(usuario.getPassword());
        return usuarioRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}