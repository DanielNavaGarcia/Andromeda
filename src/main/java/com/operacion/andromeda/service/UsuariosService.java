package com.operacion.andromeda.service;

import com.operacion.andromeda.model.UsuariosModel;
import java.util.List;
import java.util.Optional;

public interface UsuariosService {
	List<UsuariosModel> obtenerTodosUsuarios();
	UsuariosModel guardarUsuario(UsuariosModel usuariosModel);
	boolean eliminarUsuario(Integer id);
	Optional<UsuariosModel> encontrarUsuario(Integer id);
	Optional<UsuariosModel> findByCorreoContaining (String email_cliente);
}