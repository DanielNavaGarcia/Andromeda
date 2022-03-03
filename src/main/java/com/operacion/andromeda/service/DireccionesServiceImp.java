package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operacion.andromeda.model.DireccionesModel;
import com.operacion.andromeda.repository.DireccionesRepository;

@Service
public class DireccionesServiceImp implements DireccionesService{

	private final DireccionesRepository direccionesRepository;
	
	public DireccionesServiceImp(@Autowired DireccionesRepository direccionesRepository) {
		this.direccionesRepository = direccionesRepository;
	}

	public List<DireccionesModel> obtenerTodasDirecciones() {
		return (List<DireccionesModel>) direccionesRepository.findAll();
	}

	public DireccionesModel guardarDireccion(DireccionesModel direccionesModel) {
		return direccionesRepository.save(direccionesModel);
	}

	public boolean eliminarDireccion(Integer id) {
		try {
			direccionesRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Optional<DireccionesModel> encontrarDireccion(Integer id) {
		try {
			return direccionesRepository.findById(id);
		}catch (Exception error) {
			return Optional.empty();
		}
	}
}