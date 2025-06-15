package cl.perfulandia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CasoAtencionDTO {
    private Long id;
    private Long clienteId;
    private String tipo;
    private String descripcion;
    private String estado;
}