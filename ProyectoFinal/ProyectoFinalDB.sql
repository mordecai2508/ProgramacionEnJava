CREATE DATABASE ProyectoFinalDB;
USE ProyectoFinalDB;

CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2) NOT NULL,
    cantidad_disponible INT NOT NULL
);


CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

CREATE TABLE venta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

detalle_ventaCREATE TABLE detalle_venta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    producto_id BIGINT,
    venta_id BIGINT,
    FOREIGN KEY (producto_id) REFERENCES producto(id),
    FOREIGN KEY (venta_id) REFERENCES venta(id)
);

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20)
);

--insertar productos
INSERT INTO producto (nombre, descripcion, precio, cantidad_disponible) VALUES
('RouterA', 'Router doble banda ftth', 120000.00, 50),
('AP', 'Acces Point TP-Link', 8000.00, 30);

SELECT * FROM producto;

--Insertar clientes
INSERT INTO cliente (nombre, email, telefono, direccion) VALUES
('Juan Pérez', 'juan.perez@example.com', '123456789', 'Calle 123'),
('María Gómez', 'maria.gomez@example.com', '987654321', 'Avenida 456');

SELECT * FROM cliente;