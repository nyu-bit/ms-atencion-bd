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

import cl.perfulandia.model.dto.CasoAtencionDTO;
import cl.perfulandia.service.CasoAtencionService;



@RestController
@RequestMapping("/atencion")
public class CasoAtencionController {

    @Autowired
    private CasoAtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<CasoAtencionDTO>> listar() {
        return new ResponseEntity<>(atencionService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoAtencionDTO> obtener(@PathVariable Long id) {
        CasoAtencionDTO dto = atencionService.obtenerPorId(id);
        return (dto != null) ? new ResponseEntity<>(dto, HttpStatus.OK)
                             : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CasoAtencionDTO> crear(@RequestBody CasoAtencionDTO dto) {
        CasoAtencionDTO creado = atencionService.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody CasoAtencionDTO dto) {
        CasoAtencionDTO existente = atencionService.obtenerPorId(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CasoAtencionDTO actualizado = atencionService.actualizar(id, dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        CasoAtencionDTO existente = atencionService.obtenerPorId(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        atencionService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
