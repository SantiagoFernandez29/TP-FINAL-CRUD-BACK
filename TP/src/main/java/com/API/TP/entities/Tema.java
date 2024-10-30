package com.API.TP.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Se utiliza para generar un valor aleatorio de ID.
	private Long id;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private String nombre;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private String descripcion;
	
	public Tema() {}
	
	public Tema(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
