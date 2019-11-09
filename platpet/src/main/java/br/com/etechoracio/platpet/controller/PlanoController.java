package br.com.etechoracio.platpet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping
	public void insert(@RequestBody Plano plan) {
		dao.save(plan);
	}
	
	@GetMapping
	public List<Plano> findAll(){
		return dao.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Plano> findById(@PathVariable Integer id){
		return dao.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Plano> update(@PathVariable("id") Integer id,
										@RequestBody Plano plan){
	return dao.findById(id)
			.map(record -> {
				record.setTipoplano(plan.getTipoplano());
				record.setDescplano(plan.getDescplano());
				record.setDuraplano(plan.getDuraplano());
				record.setValorplano(plan.getValorplano());
				Plano updated = dao.save(record);
				return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return dao.findById(id)
				.map(record -> {
					dao.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());

	}
}