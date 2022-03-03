package com.operacion.andromeda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.TicketsModel;

@Repository
public interface TicketsRepository extends CrudRepository<TicketsModel, Integer>{

}
