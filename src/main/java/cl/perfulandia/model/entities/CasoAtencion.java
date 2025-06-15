package cl.perfulandia.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caso_atencion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CasoAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private String tipo; // CONSULTA, RECLAMO

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado; // ABIERTO, EN_PROCESO, CERRADO
}