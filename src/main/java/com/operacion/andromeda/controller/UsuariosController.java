package com.operacion.andromeda.controller;



import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.operacion.andromeda.model.UsuariosModel;
import com.operacion.andromeda.service.UsuariosService;

@RestController
public class UsuariosController {
    private final UsuariosService usuariosService;
	
	public UsuariosController(@Autowired UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
	@GetMapping("/usuarios")
	public ArrayList<UsuariosModel> obtenerTodosUsuarios(){
		return (ArrayList<UsuariosModel>) usuariosService.obtenerTodosUsuarios();	
	}

	@PostMapping("/usuarios")
    public UsuariosModel guardarUsuario(@RequestBody UsuariosModel usuariosModel) {
    	return usuariosService.guardarUsuario(usuariosModel);
    }
	
	@DeleteMapping(path = "/usuarios/{id}")
	public boolean eliminarUsuario(@PathVariable("id") Integer id) {
		return usuariosService.eliminarUsuario(id);
	}
	
	@GetMapping(path = "/usuarios/{id}")
	public Optional<UsuariosModel> encontrarUsuario(@PathVariable("id") Integer id) {
		return usuariosService.encontrarUsuario(id);
	}
	
	@GetMapping(path = "/usuarios/email/{email_cliente}")
	public Optional<UsuariosModel> findByCorreoContaining(@PathVariable("email_cliente") String email_cliente) {
		return usuariosService.findByCorreoContaining(email_cliente);
	}
}