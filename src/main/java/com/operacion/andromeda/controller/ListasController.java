//package com.operacion.andromeda.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.operacion.andromeda.model.ListasModel;
//import com.operacion.andromeda.service.ListasService;
//
//@RestController
//public class ListasController {
//    private final ListasService listasService;
//	
//	public ListasController(@Autowired ListasService listasService) {
//		this.listasService = listasService;
//	}
//	
//	@GetMapping("/listas")
//	public ArrayList<ListasModel> obtenerDato(){
//		return listasService.obtenerDatos();	
//	}
//
//	@PostMapping("/listas")
//    public ListasModel guardarDatos(@RequestBody ListasModel listasModel) {
//    	return listasService.guardarDatos(listasModel);
//    }
//		
//	@DeleteMapping(path = "listas/{id}")
//	public boolean eliminarDato(@PathVariable("id") Integer id) {
//		return listasService.eliminarDato(id);
//	}
//}