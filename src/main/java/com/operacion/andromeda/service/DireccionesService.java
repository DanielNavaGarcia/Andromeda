package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import com.operacion.andromeda.model.DireccionesModel;

public interface DireccionesService {
	List<DireccionesModel> obtenerTodasDirecciones();
	DireccionesModel guardarDireccion(DireccionesModel direccionesModel);
	boolean eliminarDireccion(Integer id);
	Optional<DireccionesModel> encontrarDireccion(Integer id);
}
