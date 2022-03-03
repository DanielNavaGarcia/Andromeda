//package com.operacion.andromeda.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.operacion.andromeda.model.ListasModel;
//import com.operacion.andromeda.repository.ListasRepository;
//
//@Service
//public class ListasService {
//	private final ListasRepository listasRepository;
//	
//	public ListasService(@Autowired ListasRepository listasRepository) {
//		this.listasRepository = listasRepository;
//	}
//
//	public ArrayList<ListasModel> obtenerDatos(){
//		return (ArrayList<ListasModel>) listasRepository.findAll();
//	}
//	
//	public ListasModel guardarDatos(ListasModel listasModel) {
//		return listasRepository.save(listasModel);
//	}
//	
//	public boolean eliminarDato(Integer id) {
//		try {
//			listasRepository.deleteById(id);
//			return true;
//		} catch(Exception error) {
//			return false;
//		}
//	}
//}
