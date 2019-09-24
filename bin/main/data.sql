DROP TABLE IF EXISTS cita;
 
CREATE TABLE cita (
  id INT AUTO_INCREMENT  PRIMARY KEY,  
  idCliente INT NOT NULL,
  idProfesor INT NOT NULL,
  estadoCita VARCHAR(250) NOT NULL,
  fechaInicio DATETIME NOT NULL, 
  fechaFin DATETIME NOT NULL,
  cantidadHoras INT NOT NULL,
  precio FLOAT DEFAULT NULL,
  direccion VARCHAR(250) NOT NULL,
  nota VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO cita (id,idCliente,idProfesor,estadoCita,fechaInicio,fechaFin,cantidadHoras,precio,direccion,nota) 
VALUES (1,1,1,'PENDIENTE','2019-09-20','2019-09-20',3,0,'cra 72 # 25-65','cita asignada');



DROP TABLE IF EXISTS Cliente;
 
CREATE TABLE Cliente (
  id INT AUTO_INCREMENT  PRIMARY KEY,    
  cedula VARCHAR(250) NOT NULL,
  nombre VARCHAR(250) NOT NULL, 
  apellido VARCHAR(250) DEFAULT NULL,
  edad INT NOT NULL, 
  direccion VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO Cliente (id,cedula,nombre,apellido,edad,direccion) 
VALUES (1,'1129525384','Emel','Mora',33,'cra 34 # 65-234');
  
  
  
DROP TABLE IF EXISTS Profesor;
 
CREATE TABLE Profesor (
  id INT AUTO_INCREMENT  PRIMARY KEY,    
  cedula VARCHAR(250) NOT NULL,
  nombre VARCHAR(250) NOT NULL, 
  apellido VARCHAR(250) DEFAULT NULL,
  edad INT NOT NULL, 
  direccion VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO Profesor (id,cedula,nombre,apellido,edad,direccion) 
VALUES (1,'1158452255','Michael','Smith',45,'cra 87 # 23-48');



DROP TABLE IF EXISTS EstadoCita;
  
  
  
  
  
  
  
  
  
  
  
  