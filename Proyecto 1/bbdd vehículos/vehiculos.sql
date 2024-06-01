CREATE DATABASE vehiculos;
USE vehiculos;

CREATE TABLE Vehiculos (
id INT AUTO_INCREMENT, 
tipo VARCHAR(250) NOT NULL,
marca VARCHAR (45) NOT NULL,
potencia INT NOT NULL,
fecha_compra DATE, 
PRIMARY KEY (id)
);


SELECT * FROM Vehiculos;


-- DATOS INSERTADOS:
INSERT INTO Vehiculos (tipo, marca, potencia, fecha_compra) VALUES 
('Coche', 'Toyota', 150, '2023-05-01');

INSERT INTO Vehiculos (tipo, marca, potencia, fecha_compra) VALUES 
('Barco', 'Yamaha', 350, '2023-03-10');

INSERT INTO Vehiculos (tipo, marca, potencia, fecha_compra) VALUES 
('Avion', 'Boeing', 50000, '2022-07-15');

-- QUERIES:
-- Para coger la potencia media según el tipo:
SELECT tipo, AVG(potencia) AS potencia_media FROM Vehiculos WHERE tipo = "Coche";

-- Para coger la potencia máxima
SELECT tipo, MAX(potencia) AS potencia_maxima FROM Vehiculos WHERE tipo = "Moto";
 commit;
