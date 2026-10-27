package com.labtech.reservas.service.impl;

import com.labtech.reservas.model.Usuario;
import com.labtech.reservas.repository.UsuarioRepository;
import com.labtech.reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public Usuario saveUsuario(Usuario usuario) {
        usuario.setId(null);
        if (usuario.getAtivo() == null) {
            usuario.setAtivo(true);
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existente = findById(id);
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setTelefone(usuario.getTelefone());
        existente.setSenha(usuario.getSenha());
        if (usuario.getAtivo() != null) {
            existente.setAtivo(usuario.getAtivo());
        }
        return usuarioRepository.save(existente);
    }

    public void deleteUsuario(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
