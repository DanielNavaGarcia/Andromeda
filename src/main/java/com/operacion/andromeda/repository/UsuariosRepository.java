package com.operacion.andromeda.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operacion.andromeda.model.UsuariosModel;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Integer> {
	Optional<UsuariosModel> findByCorreoContaining(String email_cliente);
}
