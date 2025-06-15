package cl.perfulandia.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.model.entities.CasoAtencion;

public interface CasoAtencionRepository extends JpaRepository<CasoAtencion, Long> {
}