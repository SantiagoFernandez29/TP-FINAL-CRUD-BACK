package com.API.TP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.TP.entities.Docente;
import com.API.TP.repositories.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	
	// GET de todos los docentes.
	public List<Docente> getDocentes() {
		return docenteRepository.findAll();
	}
	
	// GET de un docente en específico (puede no existir).
	public Optional<Docente> getDocente(Long id) {
		return docenteRepository.findById(id);
	}
	
	// POST de un nuevo docente.
	public void addDocente(Docente docente) {
		docenteRepository.save(docente);
	}
	
	// DELETE de un docente.
	public void deleteDocente(Long id) {
		docenteRepository.deleteById(id);
	}
	
	// PUT de un docente en particular actualizado.
	public void updateDocente(Long id, Docente docente) {
		Docente updatedDocente = docenteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("El Docente con ID " + docente.getId() + " no fue encontrado"));
		// Ejecuto una excepción para evitar utilizar Optional<>, ya que sería redundante dentro del if.
		
		// Actualizo el docente con los campos del objeto pasado por parámetro.
		updatedDocente.setNombre(docente.getNombre());
		updatedDocente.setLegajo(docente.getLegajo());
		
		// Guardo el docente actualizado en la BDD.
		docenteRepository.save(updatedDocente);
	}
}
