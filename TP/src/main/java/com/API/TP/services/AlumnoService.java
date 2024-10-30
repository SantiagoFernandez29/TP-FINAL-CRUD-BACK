package com.API.TP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.TP.entities.Alumno;
import com.API.TP.repositories.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	// GET de todos los alumnos existentes.
	public List<Alumno> getAlumnos(){
		return alumnoRepository.findAll();
	}
	
	// GET de un alumno en específico (puede no existir).
	public Optional<Alumno> getAlumno(Long id) {
		return alumnoRepository.findById(id);
	}
	
	// POST de un alumno nuevo.
	public void addAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}
	
	// DELETE de eliminación de alumno.
		public void deleteAlumno(Long id) {
			alumnoRepository.deleteById(id);
		}
	
	// PUT de un alumno actualizado.
	public void updateAlumno(Long id, Alumno alumno) {
		
		Alumno updatedAlumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("El Alumno con ID " + alumno.getId() + " no fue encontrado"));
		// Ejecuto una excepción para evitar utilizar Optional<>, ya que sería redundante dentro del if.
			
		// Actualizo el alumno con los campos del objeto pasado por parámetro.
		updatedAlumno.setNombre(alumno.getNombre());
		updatedAlumno.setFechaNacimiento(alumno.getFechaNacimiento());
			
		// Guardo el alumno actualizado en la BDD.
		alumnoRepository.save(updatedAlumno);
	
	}

}
