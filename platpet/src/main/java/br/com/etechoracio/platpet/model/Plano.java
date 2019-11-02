package br.com.etechoracio.platpet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="PLANO")
@Entity
@Setter
@Getter
public class Plano {
	
	@Column(name="IDPLANO")
	@GeneratedValue
	@Id
	private int id;
	
	@Column(name="TIPOPLANO")
	private int tipoplano;
	
	@Column(name="DESCPLANO")
	private String descplano;
	
	@Column(name="DURAPLANO")
	private int duraplano;
	
	@Column(name="VALORPLANO")
	private long valorplano;
	
}