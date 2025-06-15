CREATE DATABASE atencion;
USE atencion;

CREATE TABLE caso_atencion (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cliente_id BIGINT NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  descripcion TEXT NOT NULL,
  estado VARCHAR(20) NOT NULL
);

-- Datos de prueba
INSERT INTO caso_atencion (cliente_id, tipo, descripcion, estado) VALUES
(1, 'RECLAMO', 'El producto llegó en mal estado', 'ABIERTO'),
(2, 'CONSULTA', '¿Cuánto tarda el envío?', 'ABIERTO');
