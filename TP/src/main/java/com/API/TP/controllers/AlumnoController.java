package com.API.TP.controllers;

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
import com.API.TP.services.AlumnoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( path = "api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	private List<Alumno> getAlumnos(){
		return alumnoService.getAlumnos();
	}
	
	@GetMapping("/{alumnoId}")
	private Optional<Alumno> getAlumno(@PathVariable("alumnoId") Long alumnoId) {
		return alumnoService.getAlumno(alumnoId);
	}
	
	@PostMapping("/add")
	private void addAlumno(@RequestBody Alumno alumno) {
		alumnoService.addAlumno(alumno);
	}
	
	@DeleteMapping("/delete/{alumnoId}")
	private void deleteAlumno(@PathVariable("alumnoId") Long alumnoId) {
		alumnoService.deleteAlumno(alumnoId);
	}
	
	@PutMapping("/update/{alumnoId}")
	private void updateAlumno(@PathVariable("alumnoId") Long alumnoId, @RequestBody @DateTimeFormat(pattern = "dd-MM-yyyy") Alumno alumno) {
		alumnoService.updateAlumno(alumnoId, alumno);
	}
}
