package cl.perfulandia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.model.dto.CasoAtencionDTO;
import cl.perfulandia.model.entities.CasoAtencion;
import cl.perfulandia.model.repositories.CasoAtencionRepository;

@Service
public class CasoAtencionService {

    @Autowired
    private CasoAtencionRepository repository;

    public List<CasoAtencionDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CasoAtencionDTO findById(Long id) {
        Optional<CasoAtencion> caso = repository.findById(id);
        return caso.map(this::toDTO).orElse(null);
    }

    public CasoAtencionDTO save(CasoAtencionDTO dto) {
        CasoAtencion saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    public CasoAtencionDTO update(Long id, CasoAtencionDTO dto) {
        CasoAtencion entidad = toEntity(dto);
        entidad.setId(id);
        return toDTO(repository.save(entidad));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CasoAtencionDTO toDTO(CasoAtencion c) {
        CasoAtencionDTO dto = new CasoAtencionDTO();
        dto.setId(c.getId());
        dto.setClienteId(c.getClienteId());
        dto.setTipo(c.getTipo());
        dto.setDescripcion(c.getDescripcion());
        dto.setEstado(c.getEstado());
        return dto;
    }

    private CasoAtencion toEntity(CasoAtencionDTO dto) {
        CasoAtencion c = new CasoAtencion();
        c.setId(dto.getId());
        c.setClienteId(dto.getClienteId());
        c.setTipo(dto.getTipo());
        c.setDescripcion(dto.getDescripcion());
        c.setEstado(dto.getEstado());
        return c;
    }
}
