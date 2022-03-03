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

import com.operacion.andromeda.model.FormasDePagoModel;
import com.operacion.andromeda.service.FormasDePagoService;

@RestController 
public class FormasDePagoController {
	private final FormasDePagoService formasDePagoService;
	
	public FormasDePagoController(@Autowired FormasDePagoService formasDePagoService) {
		this.formasDePagoService = formasDePagoService;
	}

	@GetMapping("/formas-de-pago")
	public ArrayList<FormasDePagoModel> obtenerFormasDePago() {
		return (ArrayList<FormasDePagoModel>) formasDePagoService.obtenerFormasDePago();
	}

	@PostMapping("/formas-de-pago")
	public FormasDePagoModel guardarFormaDePago(@RequestBody FormasDePagoModel formasDePagoModel) {
		return formasDePagoService.guardarFormaDePago(formasDePagoModel);
	}
	
	@DeleteMapping (path = "/formas-de-pago/{id}")  
		public boolean eliminarFormaDePago(@PathVariable("id") Integer id) {
		return formasDePagoService.eliminarFormaDePago(id);
	}
	
	@GetMapping(path = "/formas-de-pago/{id}")
	public Optional<FormasDePagoModel> encontrarFormaDePago(@PathVariable("id") Integer id) {
		return formasDePagoService.encontrarFormaDePago(id);
	}
}
