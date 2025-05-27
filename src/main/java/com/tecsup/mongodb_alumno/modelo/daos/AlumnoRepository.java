package com.tecsup.mongodb_alumno.modelo.daos;

import com.tecsup.mongodb_alumno.modelo.documents.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


// Esta interfaz permite realizar operaciones CRUD sobre la colección "alumno"
@Repository
public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}