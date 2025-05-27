package com.tecsup.mongodb_alumno.servicios;



import com.tecsup.mongodb_alumno.modelo.documents.Alumno;

import java.util.List;


public interface AlumnoService {
    List<Alumno> listarTodos();
    Alumno buscarPorId(String id);
    Alumno guardar(Alumno alumno);
    void eliminar(String id);
}