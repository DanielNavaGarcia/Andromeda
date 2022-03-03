package com.operacion.andromeda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.operacion.andromeda.model.DireccionesModel;
import com.operacion.andromeda.service.DireccionesService;

@RestController
public class DireccionesController {
	private final DireccionesService direccionesService;
	
	public DireccionesController(@Autowired DireccionesService direccionesService) {
		this.direccionesService = direccionesService;
	}
	
	@GetMapping("/direcciones")
	public ArrayList<DireccionesModel> obtenerTodasDirecciones(){
		return (ArrayList<DireccionesModel>) direccionesService.obtenerTodasDirecciones();
	}
	
	@PostMapping("/direcciones")
	public DireccionesModel guardarDireccion(@RequestBody DireccionesModel direccionesModel) {
		return direccionesService.guardarDireccion(direccionesModel);
	}
	
	@DeleteMapping(path = "direcciones/{id_direcciones}") 
	public boolean eliminarDireccion(@PathVariable("id_direcciones") Integer id_direcciones) {
		return direccionesService.eliminarDireccion(id_direcciones);
	}
	
	@GetMapping(path = "direcciones/{id}")
	public Optional<DireccionesModel> encontrarDireccion(@PathVariable("id") Integer id) {
		return direccionesService.encontrarDireccion(id);
	}
}
