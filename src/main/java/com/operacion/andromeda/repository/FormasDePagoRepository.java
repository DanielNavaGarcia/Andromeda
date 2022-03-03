package com.operacion.andromeda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.FormasDePagoModel;

@Repository
public interface FormasDePagoRepository extends CrudRepository <FormasDePagoModel, Integer>{

}