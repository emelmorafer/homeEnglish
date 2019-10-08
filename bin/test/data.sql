DROP TABLE IF EXISTS Cliente;

CREATE TABLE Cliente (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  cedula VARCHAR(250) DEFAULT NULL,
  nombre VARCHAR(250) DEFAULT NULL,
  apellido VARCHAR(250) DEFAULT NULL,
  edad INT DEFAULT NULL,
  direccion VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS Profesor;

CREATE TABLE Profesor (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  cedula VARCHAR(250) DEFAULT NULL,
  nombre VARCHAR(250) DEFAULT NULL,
  apellido VARCHAR(250) DEFAULT NULL,
  edad INT DEFAULT NULL,
  direccion VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS Cita;

CREATE TABLE Cita (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  id_cliente BIGINT NOT NULL,
  id_profesor BIGINT NOT NULL,
  estado_cita VARCHAR(250) DEFAULT NULL,
  fecha_inicio TIMESTAMP DEFAULT NULL,
  fecha_fin TIMESTAMP DEFAULT NULL,
  cantidad_horas INT DEFAULT NULL,
  precio DOUBLE DEFAULT NULL,
  direccion VARCHAR(250) DEFAULT NULL,
  nota VARCHAR(250) DEFAULT NULL
);

INSERT INTO Cliente (id,cedula,nombre,apellido,edad,direccion) 
VALUES (100,'1129525384','Daniel','Mora',33,'cra 34 # 65-234');
 
INSERT INTO Profesor (id,cedula,nombre,apellido,edad,direccion) 
VALUES (100,'1158452255','Michael','Smith',45,'cra 87 # 23-48');

INSERT INTO Cita (id,id_cliente,id_profesor,estado_cita,fecha_inicio,fecha_fin,cantidad_horas,precio,direccion,nota) 
VALUES (100,100,100,'PENDIENTE DE PAGO','2020-09-20T13:00:00','2020-09-20T16:00:00',3,75000,'cra 72 # 25-65','cita asignada');

INSERT INTO Cita (id,id_cliente,id_profesor,estado_cita,fecha_inicio,fecha_fin,cantidad_horas,precio,direccion,nota) 
VALUES (101,100,100,'APROBADA','2020-09-19T13:00:00','2020-09-19T16:00:00',3,75000,'cra 72 # 25-65','cita asignada');
  
  