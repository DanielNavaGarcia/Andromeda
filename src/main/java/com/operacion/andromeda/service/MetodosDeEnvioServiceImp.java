package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operacion.andromeda.model.MetodosDeEnvioModel;
import com.operacion.andromeda.repository.MetodosDeEnvioRepository;

@Service
public class MetodosDeEnvioServiceImp implements MetodosDeEnvioService{
	private final MetodosDeEnvioRepository metodosDeEnvioRepository;
	
	public MetodosDeEnvioServiceImp (@Autowired MetodosDeEnvioRepository metodosDeEnvioRepository) {
		this.metodosDeEnvioRepository = metodosDeEnvioRepository; 
	}
	
	public List<MetodosDeEnvioModel>obtenerTodosMetodosDeEnvio(){
		return (List<MetodosDeEnvioModel>) metodosDeEnvioRepository.findAll();
	}
	
	public Optional<MetodosDeEnvioModel> encontrarMetodoDeEnvio(Integer id) {
		try {
			return metodosDeEnvioRepository.findById(id);
		}catch (Exception error) {
			return Optional.empty();
		}
	}
	
}
