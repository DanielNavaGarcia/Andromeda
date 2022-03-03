package com.operacion.andromeda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.operacion.andromeda.model.MetodosDeEnvioModel;
import com.operacion.andromeda.service.MetodosDeEnvioService;

@RestController
public class MetodosDeEnvioController {
    private final MetodosDeEnvioService metodosDeEnvioService;
	
	public MetodosDeEnvioController(@Autowired MetodosDeEnvioService metodosDeEnvioService) {
		this.metodosDeEnvioService = metodosDeEnvioService;
	}
	
	@GetMapping("/metodos-de-envio")
	public ArrayList<MetodosDeEnvioModel> obtenerTodosMetodosDeEnvio(){
		return (ArrayList<MetodosDeEnvioModel>) metodosDeEnvioService.obtenerTodosMetodosDeEnvio();	
	}
	
	@GetMapping(path = "/metodos-de-envio/{id}")
	public Optional<MetodosDeEnvioModel> encontrarMetodoDeEnvio(@PathVariable("id") Integer id) {
		return metodosDeEnvioService.encontrarMetodoDeEnvio(id);
	}
}