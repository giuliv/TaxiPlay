
CREATE TABLE `taxiplay`.`pasajero`(
  `id_pasajero` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(80) NOT NULL,
  `apellidos` VARCHAR(80) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `clave` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_pasajero`));


CREATE TABLE `taxiplay`.`chofer` (
  `id_chofer` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(80) NOT NULL,
  `apellidos` VARCHAR(80) NOT NULL,
  `dni` char(8) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
   PRIMARY KEY (`id_chofer`));
   
  
CREATE TABLE `taxiplay`.`vehiculo` (
  `id_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `placa` CHAR(6) NOT NULL,
  `marca` VARCHAR(30) NOT NULL,
  `modelo`VARCHAR(30) NOT NULL,
  `color` VARCHAR(30) NOT NULL,
  `capacidad` INT NOT NULL,
  `id_chofer` INT NOT NULL,
   PRIMARY KEY (`id_vehiculo`),
   CONSTRAINT `fk_chofer_vehiculo`
   FOREIGN KEY (`id_chofer`)
   REFERENCES `taxiplay`.`chofer` (`id_chofer`));

    
  CREATE TABLE `taxiplay`.`reserva` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `id_pasajero` INT NOT NULL,
  `id_vehiculo` INT NOT NULL,
  `direccion_partida`VARCHAR(100) NOT NULL,
  `direccion_destino` VARCHAR(100) NOT NULL,
  `fecha_inicio_viaje` DATETIME NOT NULL,
  `fecha_fin_viaje` DATETIME  NOT NULL,
  `latitud_inicial` DECIMAL(18,15) NOT NULL,
  `latitud_final` DECIMAL(18,15) NOT NULL,
  `longitud_inicial` DECIMAL(18,15) NOT NULL,
  `longitud_final` DECIMAL(18,15) NOT NULL,
  `distancia` DECIMAL(10,6) NOT NULL,
  `total_pagar`DECIMAL(10,2) NOT NULL,
  `metodo_pago`VARCHAR(30) NOT NULL,
   PRIMARY KEY (`id_reserva`),
   CONSTRAINT `fk_vehiculo_reserva`
   FOREIGN KEY (`id_vehiculo`)
   REFERENCES `taxiplay`.`vehiculo` (`id_vehiculo`),
   CONSTRAINT `fk_pasajero_reserva`
   FOREIGN KEY (`id_pasajero`)
   REFERENCES `taxiplay`.`pasajero` (`id_pasajero`));
  
INSERT INTO taxiplay.pasajero(nombres, apellidos, telefono, correo, clave)
VALUES('Enrique','López','964276456','enrique@gmail.com','clave1');
INSERT INTO taxiplay.pasajero(nombres, apellidos, telefono, correo, clave)
VALUES('Carola','Ruiz','965276444','carola@gmail.com','clave2');

INSERT INTO taxiplay.chofer(nombres, apellidos, dni, telefono, correo)
VALUES('Pablo','Lao','30744499','964822056','pablo@gmail.com');
INSERT INTO taxiplay.chofer(nombres, apellidos, dni, telefono, correo)
VALUES('Ana','Peralta','28740711','978476203','ana@gmail.com');

INSERT INTO taxiplay.vehiculo(placa, marca, modelo, color, capacidad, id_chofer)
VALUES('ABC123','Toyota','sedan','negro',5,1);
INSERT INTO taxiplay.vehiculo(placa, marca, modelo, color, capacidad, id_chofer)
VALUES('FFG456','Nissan','NV200 EVALIA','azul',4,2);