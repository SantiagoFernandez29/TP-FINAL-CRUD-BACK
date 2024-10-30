package com.API.TP.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Docente")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Se utiliza para generar un valor incremental de ID.
	private Long id;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private Long legajo;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private String nombre;
	
	public Docente() {}
	
	public Docente(Long legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getLegajo() {
		return legajo;
	}
	
	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
