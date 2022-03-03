package com.operacion.andromeda.service;

import java.util.List;
import java.util.Optional;

import com.operacion.andromeda.model.MetodosDeEnvioModel;

public interface MetodosDeEnvioService {
	List<MetodosDeEnvioModel>obtenerTodosMetodosDeEnvio();
	Optional<MetodosDeEnvioModel> encontrarMetodoDeEnvio(Integer id);

}
