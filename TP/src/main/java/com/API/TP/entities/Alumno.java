package com.API.TP.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Se utiliza para generar un valor incremental de ID.
	private Long id;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private String nombre;
	
	@Column(name = "fecha_nacimiento", nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Indicas el formato que esperas.
	@Temporal(TemporalType.TIMESTAMP) // Se utiliza para definir el tipo de campo como fecha (con TIMESTAMP evito que se decremente en 1 la fecha desde Angular).
	private Date fechaNacimiento;
	
	public Alumno() {}
	
	public Alumno(String nombre, Date fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
