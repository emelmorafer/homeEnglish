
INSERT INTO Cliente (id,cedula,nombre,apellido,edad,direccion) 
VALUES (100,'1129525384','Daniel','Mora',33,'cra 34 # 65-234');
 
INSERT INTO Profesor (id,cedula,nombre,apellido,edad,direccion) 
VALUES (100,'1158452255','Michael','Smith',45,'cra 87 # 23-48');

INSERT INTO cita (id,id_cliente,id_profesor,estado_cita,fecha_inicio,fecha_fin,cantidad_horas,precio,direccion,nota) 
VALUES (100,100,100,'PENDIENTE DE PAGO','2020-09-20T13:00:00','2020-09-20T16:00:00',3,75000,'cra 72 # 25-65','cita asignada');

INSERT INTO cita (id,id_cliente,id_profesor,estado_cita,fecha_inicio,fecha_fin,cantidad_horas,precio,direccion,nota) 
VALUES (101,100,100,'APROBADA','2020-09-19T13:00:00','2021-09-19T16:00:00',3,75000,'cra 72 # 25-65','cita asignada');


  
  
  
  
  
  
  
  
  
  
  
  