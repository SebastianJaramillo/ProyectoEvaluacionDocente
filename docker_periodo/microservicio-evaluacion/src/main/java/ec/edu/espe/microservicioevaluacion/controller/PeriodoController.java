package ec.edu.espe.microservicioevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.microservicioevaluacion.domain.Periodo;
import ec.edu.espe.microservicioevaluacion.service.PeriodoService;

@CrossOrigin
@RestController
@RequestMapping("/periodo")
public class PeriodoController {
    
    @Autowired
    private PeriodoService periodoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Periodo>> listAll() {
        return ResponseEntity.ok().body(periodoService.listAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Periodo> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(periodoService.findById(id));
    }

    @PostMapping("/registro")
    public ResponseEntity<Periodo> save(@RequestBody Periodo periodo) {
        return ResponseEntity.ok().body(periodoService.save(periodo));
    }
}
