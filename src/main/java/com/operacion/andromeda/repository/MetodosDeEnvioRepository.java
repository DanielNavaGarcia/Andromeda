package com.operacion.andromeda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.MetodosDeEnvioModel;

@Repository
public interface MetodosDeEnvioRepository extends CrudRepository <MetodosDeEnvioModel, Integer> {

}
