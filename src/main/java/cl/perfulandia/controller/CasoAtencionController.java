package cl.perfulandia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.perfulandia.model.dto.CasoAtencionDTO;
import cl.perfulandia.service.CasoAtencionService;



@RestController
@RequestMapping("/atencion")
public class CasoAtencionController {

    @Autowired
    private CasoAtencionService casoService;

    @GetMapping
    public ResponseEntity<List<CasoAtencionDTO>> listar() {
        return ResponseEntity.ok(casoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoAtencionDTO> obtener(@PathVariable Long id) {
        CasoAtencionDTO dto = casoService.findById(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CasoAtencionDTO> crear(@RequestBody CasoAtencionDTO dto) {
        return ResponseEntity.status(201).body(casoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoAtencionDTO> actualizar(@PathVariable Long id, @RequestBody CasoAtencionDTO dto) {
        return ResponseEntity.ok(casoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        casoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
