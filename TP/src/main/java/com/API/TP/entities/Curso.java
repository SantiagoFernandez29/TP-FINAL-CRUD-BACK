package com.API.TP.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Se utiliza para generar un valor incremental de ID.
	private Long id;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Indicas el formato que esperas.
	@Temporal(TemporalType.DATE)  // Solo guarda el día, mes y año
	private Date fechaInicio;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Indicas el formato que esperas.
	@Temporal(TemporalType.DATE)  // Solo guarda el día, mes y año
	private Date fechaFin;
	
	@Column(nullable = false) // Indica que la columna no puede ser nula en la base de datos.
	private Long precio;
	
	@ManyToOne // Muchos cursos para un docente.
	@JoinColumn(name = "docente_id") // Especifico que la columna docente_legajo contiene la FK hacia la tabla Curso.
	private Docente docente;
	
	@ManyToOne // Muchos cursos para un tema.
	@JoinColumn(name = "tema_id") // Especifico que la columna tema_nombre contiene la FK hacia la tabla Curso.
	private Tema tema;
	
	@ManyToMany
	@JoinTable(
			name = "Curso_Alumno",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id")
			)
	private List<Alumno> alumnos;
	
	public Curso() {}
	
	public Curso(Date fechaInicio, Date fechaFin, Long precio, Docente docente, Tema tema, List<Alumno> alumnos) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.docente = docente;
		this.tema = tema;
		this.alumnos = alumnos;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	

}
