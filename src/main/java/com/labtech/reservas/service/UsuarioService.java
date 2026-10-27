package com.labtech.reservas.service;

import com.labtech.reservas.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public Usuario saveUsuario(Usuario usuario);

    public Usuario updateUsuario(Integer id, Usuario usuario);

    public void deleteUsuario(Integer id);
}
