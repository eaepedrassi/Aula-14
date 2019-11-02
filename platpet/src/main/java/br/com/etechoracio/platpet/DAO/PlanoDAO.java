package br.com.etechoracio.platpet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.etechoracio.platpet.model.Plano;

public interface PlanoDAO extends 	JpaRepository<Plano, Integer> {
	

	
}