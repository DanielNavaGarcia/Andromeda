package com.operacion.andromeda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.DireccionesModel;

@Repository
public interface DireccionesRepository extends CrudRepository <DireccionesModel, Integer>
{

}
