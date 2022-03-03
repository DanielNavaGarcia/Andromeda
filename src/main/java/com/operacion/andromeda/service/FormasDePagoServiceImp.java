package com.operacion.andromeda.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operacion.andromeda.model.FormasDePagoModel;
import com.operacion.andromeda.repository.FormasDePagoRepository;

@Service
public class FormasDePagoServiceImp implements FormasDePagoService {
	private final FormasDePagoRepository formasDePagoRepository;
	
	public FormasDePagoServiceImp (@Autowired FormasDePagoRepository formasDePagoRepository) {
		this.formasDePagoRepository = formasDePagoRepository;
	}
	
	public ArrayList<FormasDePagoModel> obtenerFormasDePago(){
		return (ArrayList<FormasDePagoModel>) formasDePagoRepository.findAll();
	}
	
	public FormasDePagoModel guardarFormaDePago(FormasDePagoModel formasDePagoModel) {
		return formasDePagoRepository.save(formasDePagoModel);
	}
	
	public boolean eliminarFormaDePago(Integer id) {
		try {
			formasDePagoRepository.deleteById(id);
			return true;
		} catch(Exception error) {
			return false;
		}
	}	
	
	public Optional<FormasDePagoModel> encontrarFormaDePago(Integer id) {
		try {
			return formasDePagoRepository.findById(id);
		}catch (Exception error) {
			return Optional.empty();
		}
	}
}
