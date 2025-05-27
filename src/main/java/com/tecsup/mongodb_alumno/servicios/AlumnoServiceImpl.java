package com.tecsup.mongodb_alumno.servicios;

import com.tecsup.mongodb_alumno.modelo.daos.AlumnoRepository;
import com.tecsup.mongodb_alumno.modelo.documents.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Implementa la lógica de negocio usando el repositorio
@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Devuelve la lista de todos los alumnos
    @Override
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    // Busca un alumno por su id
    @Override
    public Alumno buscarPorId(String id) {
        Optional<Alumno> optional = alumnoRepository.findById(id);
        return optional.orElse(null);
    }

    // Guarda o actualiza un alumno
    @Override
    public Alumno guardar(Alumno alumno) {
        // 🔥 Esta es la línea clave: si el id está vacío, lo seteamos a null
        if (alumno.getId() != null && alumno.getId().trim().isEmpty()) {
            alumno.setId(null);
        }
        return alumnoRepository.save(alumno);
    }

    // Elimina un alumno por su id
    @Override
    public void eliminar(String id) {
        alumnoRepository.deleteById(id);
    }
}
