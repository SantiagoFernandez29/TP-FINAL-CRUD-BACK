package com.API.TP.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.TP.entities.Alumno;
import com.API.TP.entities.Curso;
import com.API.TP.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	// GET de todos los cursos existentes.
	public List<Curso> getCursos(){
		return cursoRepository.findAll();
	}
	
	// GET de un curso en particular (puede no existir).
	public Optional<Curso> getCurso(Long id){
		return cursoRepository.findById(id);
	}
	
	// POST de un curso nuevo.
	public void saveCurso(Curso curso) {
		cursoRepository.save(curso);
	}
	
	// POST de eliminación de curso.
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
	}
	
	// PUT de actualización de curso existente.
	public void updateCurso(Long id, Curso curso) {
		Curso updatedCurso = cursoRepository.findById(id).
				orElseThrow(() -> new RuntimeException("El Curso con ID " + curso.getId() + " no fue encontrado"));
		
		updatedCurso.setAlumnos(curso.getAlumnos());
		updatedCurso.setDocente(curso.getDocente());
		updatedCurso.setFechaFin(curso.getFechaFin());
		updatedCurso.setFechaInicio(curso.getFechaInicio());
		updatedCurso.setPrecio(curso.getPrecio());
		updatedCurso.setTema(curso.getTema());
		
		cursoRepository.save(updatedCurso);
	}
	
	// GET de obtención de cursos que finaliza un día en específico.
	public List<Curso> findCursosByFechaFin(Date fechaFin) {
		return cursoRepository.findCursosByFechaFin(fechaFin);
	}
	
	// GET de obtención de cursos vigentes de un docente.
	public List<Alumno> findAlumnosByCursosVigentes(Long docenteId) {
		Date fechaActual = new Date();
		return cursoRepository.findAlumnosByCursosVigentes(docenteId, fechaActual);
	}
	

}
