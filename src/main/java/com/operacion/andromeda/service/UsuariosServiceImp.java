package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operacion.andromeda.model.UsuariosModel;
import com.operacion.andromeda.repository.UsuariosRepository;

@Service
public class UsuariosServiceImp implements UsuariosService {
	private final UsuariosRepository usuariosRepository;
	
	public UsuariosServiceImp(@Autowired UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}
	@Override
	public List<UsuariosModel> obtenerTodosUsuarios(){
		return (List<UsuariosModel>) usuariosRepository.findAll();
	}
	@Override
	public UsuariosModel guardarUsuario(UsuariosModel usuariosModel) {
		return usuariosRepository.save(usuariosModel);
	}
	@Override
	public boolean eliminarUsuario(Integer id) {
		try {
			usuariosRepository.deleteById(id);
			return true;
		} catch(Exception error) {
			return false;
		}
	}
	
	@Override
	public Optional<UsuariosModel> encontrarUsuario(Integer id) {
		try {
			return usuariosRepository.findById(id);
		}catch (Exception error) {
			return Optional.empty();
		}
	}
	
	@Override
	public Optional<UsuariosModel> findByCorreoContaining (String email_cliente) {
		try {
			return usuariosRepository.findByCorreoContaining(email_cliente);
		}catch (Exception error) {
			return Optional.empty();
		}
	}	
}