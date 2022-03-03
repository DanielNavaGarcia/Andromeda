package com.operacion.andromeda.service;

import java.util.ArrayList;
import java.util.Optional;

import com.operacion.andromeda.model.FormasDePagoModel;

public interface FormasDePagoService {
	ArrayList<FormasDePagoModel> obtenerFormasDePago();
	FormasDePagoModel guardarFormaDePago(FormasDePagoModel formasDePagoModel);
	boolean eliminarFormaDePago(Integer id);
	Optional<FormasDePagoModel> encontrarFormaDePago(Integer id);
}
