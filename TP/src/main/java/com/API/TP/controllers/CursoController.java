package com.API.TP.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.TP.entities.Alumno;
import com.API.TP.entities.Curso;
import com.API.TP.services.CursoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( path = "api/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public List<Curso> getCursos(){
		return cursoService.getCursos();
	}
	
	@GetMapping("/{cursoId}")
	public Optional<Curso> getCurso(@PathVariable("cursoId") Long cursoId) {
		return cursoService.getCurso(cursoId);
	}
	
	@PostMapping("/add")
	public void saveCurso(@RequestBody Curso curso) {
		cursoService.saveCurso(curso);
	}
	
	@DeleteMapping("/delete/{cursoId}")
	public void deleteCurso(@PathVariable("cursoId") Long cursoId) {
		cursoService.deleteCurso(cursoId);
	}
	
	@PutMapping("/update/{cursoId}")
	public void updateCurso(@PathVariable("cursoId") Long cursoId, @RequestBody Curso curso) {
		cursoService.updateCurso(cursoId, curso);
	}
	
	@GetMapping("/fecha-fin/{fechaFin}")
	public List<Curso> getCursosByFechaFin(@PathVariable("fechaFin") @DateTimeFormat( pattern = "yyyy-MM-dd") Date fechaFin) {
		return cursoService.findCursosByFechaFin(fechaFin);
	}
	
	@GetMapping("/vigentes/docente/{docenteId}/alumnos")
	public List<Alumno> getAlumnosByCursosVigentes(@PathVariable("docenteId") Long docenteId) {
		return cursoService.findAlumnosByCursosVigentes(docenteId);
	}
}
