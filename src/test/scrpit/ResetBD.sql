/* SQL Manager Lite for MySQL                              5.6.4.50082 */
/* ------------------------------------------------------------------- */
/* Host     : localhost                                                */
/* Port     : 3306                                                     */
/* Database : Satex_Java                                               */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'latin1' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `satex_java`;

CREATE DATABASE `Satex_Java`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_spanish_ci';

USE `satex_java`;

/* Structure for the `ordenes` table :  */

CREATE TABLE `ordenes` (
  `ClaveOrden` INTEGER(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `TipoOrden` VARCHAR(1) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `NumOrden` VARCHAR(20) COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `TotalRollos` INTEGER(5) UNSIGNED NOT NULL DEFAULT 0,
  `PesoTotal` DOUBLE UNSIGNED NOT NULL,
  `MetrajeTotal` DOUBLE UNSIGNED,
  `Color` VARCHAR(25) COLLATE latin1_spanish_ci DEFAULT '',
  `ClaveUsuario` INTEGER(6) NOT NULL DEFAULT 0,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NOT NULL,
  `Estatus` INTEGER(1) UNSIGNED DEFAULT 1,
  PRIMARY KEY USING BTREE (`ClaveOrden`),
  UNIQUE KEY `claveOrden` USING BTREE (`ClaveOrden`)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `rolloxorden` table :  */

CREATE TABLE `rolloxorden` (
  `ClaveRollo` INTEGER(12) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ClaveOrden` INTEGER(11) NOT NULL,
  `NumRollo` INTEGER(5) DEFAULT NULL,
  `PesoRollo` DOUBLE UNSIGNED NOT NULL,
  `MetrosRollo` DOUBLE UNSIGNED NOT NULL,
  `Rendimiento` DOUBLE UNSIGNED NOT NULL,
  `Calidad` INTEGER(10) UNSIGNED NOT NULL DEFAULT 1,
  `Fecha` DATE NOT NULL,
  `Hora` TIME NOT NULL,
  `ClaveUsuario` INTEGER(6) UNSIGNED NOT NULL,
  `Estatus` INTEGER(1) UNSIGNED NOT NULL,
  PRIMARY KEY USING BTREE (`ClaveRollo`),
  UNIQUE KEY `ClaveRollo` USING BTREE (`ClaveRollo`),
  KEY `ClaveOrden` USING BTREE (`ClaveOrden`)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `usuarios` table :  */

CREATE TABLE `usuarios` (
  `ClaveUsuario` INTEGER(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NombreUsuario` VARCHAR(40) COLLATE latin1_spanish_ci NOT NULL,
  `ClaveAcceso` INTEGER(4) NOT NULL DEFAULT 0,
  `Area` INTEGER(1) NOT NULL DEFAULT 0,
  `Puesto` INTEGER(1) NOT NULL DEFAULT 0,
  `Estatus` INTEGER(1) UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY USING BTREE (`ClaveUsuario`),
  UNIQUE KEY `ClaveUsuario` USING BTREE (`ClaveUsuario`)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
COMMENT='Usuarios de Terminales '
;


/* Data for the `usuarios` table  (LIMIT 0,500) */

INSERT INTO `usuarios` (`ClaveUsuario`, `NombreUsuario`, `ClaveAcceso`, `Area`, `Puesto`, `Estatus`) VALUES
  (1,'Enrique Fernández Jaimes',1234,1,1,1),
  (2,'Rigoberto de la Cruz',123,1,1,1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;