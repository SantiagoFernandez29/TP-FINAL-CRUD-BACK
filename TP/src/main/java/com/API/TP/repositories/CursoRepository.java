package com.API.TP.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.API.TP.entities.Alumno;
import com.API.TP.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
	// Seleccioná los cursos en los que su fechaFin coincida con la pasada por parámetro.
	// Se hace con @Query porque uso DATE para sacarle la hora a la fecha, haciendo que solo se almacene YYYY-MM-DD.
    @Query("SELECT c FROM Curso c WHERE DATE(c.fechaFin) = :fechaFin")
    List<Curso> findCursosByFechaFin(@Param("fechaFin") Date fechaFin);
    
    // Selecciono los alumnos presentes en los alumnos disponibles de los cursos
    // cuyo profesor coincida con el que representa el ID pasado por parámetro y la fecha del curso sea actual.
    @Query("SELECT a FROM Curso c JOIN c.alumnos a WHERE c.docente.id = :docenteId AND :fechaActual BETWEEN c.fechaInicio AND c.fechaFin")
    List<Alumno> findAlumnosByCursosVigentes(@Param("docenteId") Long docenteId, @Param("fechaActual") Date fechaActual);
    
    
    
    // Seleccioná los cursos en los que el id del docente coincida con el pasado por parámetro y la fecha del curso sea actual.
    //@Query("SELECT c FROM Curso c WHERE c.docente.id = :docenteId AND :fechaActual BETWEEN c.fechaInicio AND c.fechaFin")
}