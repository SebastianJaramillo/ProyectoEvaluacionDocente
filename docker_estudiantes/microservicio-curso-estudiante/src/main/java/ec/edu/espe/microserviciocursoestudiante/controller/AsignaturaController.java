package ec.edu.espe.microserviciocursoestudiante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.microserviciocursoestudiante.domain.Asignatura;
import ec.edu.espe.microserviciocursoestudiante.service.AsignaturaService;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Asignatura>> listAll() {
        return ResponseEntity.ok().body(asignaturaService.listAll());
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Asignatura> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(asignaturaService.findById(Long.parseLong(id)));
    }

    @PostMapping("/registro")
    public ResponseEntity<Asignatura> save(@RequestBody Asignatura asignatura) {
        return ResponseEntity.ok().body(asignaturaService.save(asignatura));
    }
}
