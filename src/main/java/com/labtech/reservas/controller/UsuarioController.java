package com.labtech.reservas.controller;

import com.labtech.reservas.common.response.ApiResponse;
import com.labtech.reservas.dto.UsuarioDto;
import com.labtech.reservas.model.Usuario;
import com.labtech.reservas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Usuario>>> findAll() {

        return ResponseEntity.ok(ApiResponse.of(usuarioService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> findById(@PathVariable Integer id) {

        return ResponseEntity.ok(ApiResponse.of(usuarioService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Usuario>> create(@Valid @RequestBody UsuarioDto dto) {

        Usuario usuario = toEntity(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(usuarioService.saveUsuario(usuario)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Usuario>> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDto dto) {

        Usuario usuario = toEntity(dto);

        return ResponseEntity.ok(ApiResponse.of(usuarioService.updateUsuario(id, usuario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        usuarioService.deleteUsuario(id);

        return ResponseEntity.noContent().build();
    }

    private Usuario toEntity(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());
        usuario.setSenha(dto.senha());
        usuario.setAtivo(dto.ativo());
        return usuario;
    }
}
