package com.API.TP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.TP.entities.Tema;
import com.API.TP.repositories.TemaRepository;

@Service
public class TemaService {

	@Autowired
	private TemaRepository temaRepository;
	
	public List<Tema> getTemas() {
		return temaRepository.findAll();
	}
	
	public Optional<Tema> getTema(Long id) {
		return temaRepository.findById(id);
	}
	
	public void addTema(Tema tema) {
		temaRepository.save(tema);
	}
	
	public void deleteTema(Long id) {
		temaRepository.deleteById(id);
	}
	
	public void updateTema(Long id, Tema tema) {
		Tema updatedTema = temaRepository.findById(id).
				orElseThrow(() -> new RuntimeException("El Tema con ID " + tema.getId() + " no fue encontrado"));
		
		updatedTema.setNombre(tema.getNombre());
		updatedTema.setDescripcion(tema.getDescripcion());
		
		temaRepository.save(updatedTema);
	}
}
