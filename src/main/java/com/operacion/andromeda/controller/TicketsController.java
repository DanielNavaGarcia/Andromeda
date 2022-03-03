package com.operacion.andromeda.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.operacion.andromeda.model.TicketsModel;
import com.operacion.andromeda.service.TicketsService;

@RestController
public class TicketsController {
    private final TicketsService ticketsService;
	
	public TicketsController(@Autowired TicketsService ticketsService) {
		this.ticketsService = ticketsService;
	}

	@GetMapping("/tickets")
	public ArrayList<TicketsModel> obtenerTodosTickets(){
		return (ArrayList<TicketsModel>) ticketsService.obtenerTodosTickets();	
	}

	@PostMapping("/tickets")
    public TicketsModel guardarTicket(@RequestBody TicketsModel ticketsModel) {
		ticketsModel.setFecha(LocalDateTime.now());
    	return ticketsService.guardarTicket(ticketsModel);
    }
	
	@DeleteMapping(path = "/tickets/{id}")
	public boolean eliminarTicket(@PathVariable("id") Integer id) {
		return ticketsService.eliminarTicket(id);
	}
	
	@GetMapping(path = "/tickets/{id}")
	public Optional<TicketsModel> encontrarTicket(@PathVariable("id") Integer id) {
		return ticketsService.encontrarTicket(id);
	}
}
