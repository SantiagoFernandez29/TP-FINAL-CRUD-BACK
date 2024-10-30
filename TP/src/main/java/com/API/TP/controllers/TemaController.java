package com.API.TP.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.TP.entities.Tema;
import com.API.TP.services.TemaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( path = "api/temas")
public class TemaController {

	@Autowired
	private TemaService temaService;
	
	@GetMapping
	private List<Tema> getTemas(){
		return temaService.getTemas();
	}
	
	@GetMapping("/{temaId}")
	private Optional<Tema> getTema(@PathVariable("temaId") Long temaId) {
		return temaService.getTema(temaId);
	}
	
	@PostMapping("/add")
	private void addTema(@RequestBody Tema tema) {
		temaService.addTema(tema);
	}
	
	@DeleteMapping("/delete/{temaId}")
	private void deleteTema(@PathVariable("temaId") Long temaId) {
		temaService.deleteTema(temaId);
	}
	
	@PutMapping("/update/{temaId}")
	private void updateTema(@PathVariable("temaId") Long temaId, @RequestBody Tema tema) {
		temaService.updateTema(temaId, tema);
	}
}
