USE sql10810935;

CREATE TABLE IF NOT EXISTS mesas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL UNIQUE,
    status VARCHAR(20) DEFAULT 'LIVRE'
);

CREATE TABLE IF NOT EXISTS reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mesa_id INT NOT NULL,
    nome_cliente VARCHAR(100) NOT NULL,
    data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (mesa_id) REFERENCES mesas(id)
);

-- Populate Data
INSERT INTO mesas (numero, status) VALUES (1, 'LIVRE');
INSERT INTO mesas (numero, status) VALUES (2, 'LIVRE');
INSERT INTO mesas (numero, status) VALUES (3, 'RESERVADA');
INSERT INTO mesas (numero, status) VALUES (4, 'LIVRE');
INSERT INTO mesas (numero, status) VALUES (5, 'LIVRE');
INSERT INTO mesas (numero, status) VALUES (6, 'RESERVADA');
INSERT INTO mesas (numero, status) VALUES (7, 'LIVRE');
INSERT INTO mesas (numero, status) VALUES (8, 'LIVRE');

INSERT INTO reservas (mesa_id, nome_cliente) VALUES (3, 'João Silva');
INSERT INTO reservas (mesa_id, nome_cliente) VALUES (6, 'Maria Oliveira');
