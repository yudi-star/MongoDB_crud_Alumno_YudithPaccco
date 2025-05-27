package com.tecsup.mongodb_alumno.controladores;

import com.tecsup.mongodb_alumno.modelo.documents.Alumno;
import com.tecsup.mongodb_alumno.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// Controlador para manejar las rutas web del CRUD de Alumno
@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Muestra la lista de alumnos
    @GetMapping("/listar")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoService.listarTodos());
        // Ahora apunta a la carpeta alumno
        return "alumno/listarView";
    }

    // Muestra el formulario para crear un nuevo alumno
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alumno", new Alumno());
        // Ahora apunta a la carpeta alumno
        return "alumno/formView";
    }

    // Guarda un nuevo alumno o actualiza uno existente
    @PostMapping("/form")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno, BindingResult result) {
        if (result.hasErrors()) {
            // Ahora apunta a la carpeta alumno
            return "alumno/formView";
        }
        alumnoService.guardar(alumno);
        return "redirect:/alumnos/listar";
    }

    // Muestra el formulario para editar un alumno existente
    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable String id, Model model) {
        Alumno alumno = alumnoService.buscarPorId(id);
        if (alumno == null) {
            return "redirect:/alumnos/listar";
        }
        model.addAttribute("alumno", alumno);
        // Ahora apunta a la carpeta alumno
        return "alumno/formView";
    }

    // Elimina un alumno por su id
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable String id) {
        alumnoService.eliminar(id);
        return "redirect:/alumnos/listar";
    }
    @GetMapping("/")
    public String inicio() {
        return "alumno/inicio";
    }
    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "alumno/inicio";
    }


}