package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import com.operacion.andromeda.model.TicketsModel;

public interface TicketsService {
	List<TicketsModel> obtenerTodosTickets();
	TicketsModel guardarTicket(TicketsModel usuariosModel);
	boolean eliminarTicket(Integer id);
	Optional<TicketsModel> encontrarTicket(Integer id);
}
