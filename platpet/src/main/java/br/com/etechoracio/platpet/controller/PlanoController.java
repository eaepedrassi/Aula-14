package br.com.etechoracio.platpet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.platpet.DAO.PlanoDAO;
import br.com.etechoracio.platpet.model.Plano;

@RestController
@RequestMapping("/planos")

public class PlanoController {
	
	@Autowired
	private PlanoDAO dao;
	
}
