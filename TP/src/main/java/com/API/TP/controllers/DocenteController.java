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

import com.API.TP.entities.Docente;
import com.API.TP.services.DocenteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( path = "api/docentes")
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@GetMapping
	private List<Docente> getDocentes() {
		return docenteService.getDocentes();
	}
	
	@GetMapping("/{docenteId}")
	private Optional<Docente> getDocente(@PathVariable("docenteId") Long docenteId) {
		return docenteService.getDocente(docenteId);
	}
	
	@PostMapping("/add")
	private void addDocente(@RequestBody Docente docente) {
		docenteService.addDocente(docente);
	}
	
	@DeleteMapping("/delete/{docenteId}")
	private void deleteDocente(@PathVariable("docenteId") Long docenteId) {
		docenteService.deleteDocente(docenteId);
	}
	
	@PutMapping("/update/{docenteId}")
	private void updateDocente(@PathVariable("docenteId") Long docenteId, @RequestBody Docente docente) {
		docenteService.updateDocente(docenteId, docente);
	}

}
