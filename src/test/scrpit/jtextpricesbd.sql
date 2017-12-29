/* SQL Manager Lite for MySQL                              5.6.4.50082 */
/* ------------------------------------------------------------------- */
/* Host     : localhost                                                */
/* Port     : 3306                                                     */
/* Database : jtextpricesbd                                            */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'latin1' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS jtextpricesbd;

CREATE DATABASE jtextpricesbd
    CHARACTER SET 'latin1'
    COLLATE 'latin1_spanish_ci';

USE jtextpricesbd;

SET sql_mode = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

/* Dropping database objects */

DROP TABLE IF EXISTS precioproducto;
DROP TABLE IF EXISTS logprecioproducto;
DROP TABLE IF EXISTS tipoprecio;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS acceso;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS tienda;
DROP TABLE IF EXISTS clasificaciontienda;
DROP TABLE IF EXISTS rol;

/* Structure for the `rol` table :  */

CREATE TABLE rol (
  IDRol INTEGER(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador del Rol',
  NombreRol VARCHAR(20) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Nombre del Rol',
  PRIMARY KEY USING BTREE (IDRol),
  UNIQUE KEY IDRol USING BTREE (IDRol),
  UNIQUE KEY NombreRol USING BTREE (NombreRol)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `clasificaciontienda` table :  */

CREATE TABLE clasificaciontienda (
  IDClasificacionTienda INTEGER(1) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Tipo de Tienda\r\n1 Matriz, 2 Sucursal',
  NombreClasificacionTienda VARCHAR(30) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Matriz ó Sucursal',
  Estatus INTEGER(1) UNSIGNED NOT NULL COMMENT 'Activo',
  PRIMARY KEY USING BTREE (IDClasificacionTienda),
  UNIQUE KEY IDClasificacionTienda USING BTREE (IDClasificacionTienda),
  UNIQUE KEY NombreClasificacionTienda USING BTREE (NombreClasificacionTienda)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `tienda` table :  */

CREATE TABLE tienda (
  IDTienda INTEGER(2) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'IDentificador por Tienda',
  Nombre_Tienda VARCHAR(30) COLLATE latin1_spanish_ci NOT NULL COMMENT 'El Nombre de la Tienda',
  clasificaciontienda_IDClasificacionTienda INTEGER(1) UNSIGNED NOT NULL,
  Estatus INTEGER(1) UNSIGNED NOT NULL COMMENT 'Activo',
  PRIMARY KEY USING BTREE (IDTienda),
  UNIQUE KEY IDTienda USING BTREE (IDTienda),
  KEY fk_tienda_clasificaciontienda1_idx USING BTREE (clasificaciontienda_IDClasificacionTienda),
  CONSTRAINT fk_tienda_clasificaciontienda1 FOREIGN KEY (clasificaciontienda_IDClasificacionTienda) REFERENCES clasificaciontienda (IDClasificacionTienda) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
COMMENT='\t'
;

/* Structure for the `usuario` table :  */

CREATE TABLE usuario (
  IDUsuario INTEGER(6) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador Unico del Usuario',
  NickName VARCHAR(20) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Nombre de usuario en Sistema',
  Password VARCHAR(20) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Contraseña del usuario',
  Nombre VARCHAR(40) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Nombre Real del Usuario',
  tienda_IDTienda INTEGER(2) UNSIGNED NOT NULL COMMENT 'fk: Tienda a la que pertenece',
  Estatus INTEGER(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'Activo',
  PRIMARY KEY USING BTREE (IDUsuario),
  UNIQUE KEY IDUsuario USING BTREE (IDUsuario),
  UNIQUE KEY NickName USING BTREE (NickName),
  KEY fk_tienda_IDTienda_idx USING BTREE (tienda_IDTienda),
  CONSTRAINT fk_tienda_IDTienda FOREIGN KEY (tienda_IDTienda) REFERENCES tienda (IDTienda) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
COMMENT='Informacion sobre el usuario que accesa al Sistema'
;

/* Structure for the `acceso` table :  */

CREATE TABLE acceso (
  IDAcceso INTEGER(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador por tipo de Acceso',
  usuario_IDUsuario INTEGER(6) UNSIGNED NOT NULL,
  IDRol INTEGER(3) UNSIGNED NOT NULL,
  PRIMARY KEY USING BTREE (IDAcceso),
  UNIQUE KEY IDAcceso USING BTREE (IDAcceso),
  KEY fk_acceso_usuario_idx USING BTREE (usuario_IDUsuario),
  KEY fk_acceso_rol1_idx USING BTREE (IDRol),
  CONSTRAINT fk_acceso_rol1 FOREIGN KEY (IDRol) REFERENCES rol (IDRol) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_acceso_usuario FOREIGN KEY (usuario_IDUsuario) REFERENCES usuario (IDUsuario) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `producto` table :  */

CREATE TABLE producto (
  IDProducto INTEGER(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificacion de Producto',
  Nombre_Producto VARCHAR(40) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Nombre del Producto',
  Ancho DOUBLE(6,2) UNSIGNED DEFAULT NULL COMMENT 'El ancho de la tela',
  Rendimiento DOUBLE(6,2) UNSIGNED DEFAULT NULL COMMENT 'Metros para 1Kg',
  Estatus INTEGER(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT 'Producto Activo',
  PRIMARY KEY USING BTREE (IDProducto),
  UNIQUE KEY IDProducto USING BTREE (IDProducto)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `tipoprecio` table :  */

CREATE TABLE tipoprecio (
  IDTipoPrecio INTEGER(1) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Por Rollo, por Kg o por Metros',
  NombrePrecio VARCHAR(20) COLLATE latin1_spanish_ci NOT NULL COMMENT 'La Descripcion del Precio',
  PRIMARY KEY USING BTREE (IDTipoPrecio),
  UNIQUE KEY IDTipoPrecio USING BTREE (IDTipoPrecio)
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `logprecioproducto` table :  */

CREATE TABLE logprecioproducto (
  IDLog INTEGER(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador por transacción de cambio de precio',
  FechaLog TIMESTAMP NULL DEFAULT NULL,
  usuario_IDUsuario INTEGER(6) UNSIGNED NOT NULL,
  producto_IDProducto INTEGER(8) UNSIGNED NOT NULL,
  tipoprecio_IDTipoPrecio INTEGER(1) UNSIGNED NOT NULL,
  PrecioPrevio DOUBLE(8,2) UNSIGNED NOT NULL COMMENT 'El Precio Anterior al cambio',
  NuevoPrecio DOUBLE(8,2) UNSIGNED NOT NULL COMMENT 'El nuevo precio registrado',
  PRIMARY KEY USING BTREE (IDLog),
  UNIQUE KEY IDLog USING BTREE (IDLog),
  KEY fk_logprecioproducto_usuario1_idx USING BTREE (usuario_IDUsuario),
  KEY fk_logprecioproducto_producto1_idx USING BTREE (producto_IDProducto),
  KEY fk_logprecioproducto_tipoprecio1_idx USING BTREE (tipoprecio_IDTipoPrecio),
  CONSTRAINT fk_logprecioproducto_producto1 FOREIGN KEY (producto_IDProducto) REFERENCES producto (IDProducto) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_logprecioproducto_tipoprecio1 FOREIGN KEY (tipoprecio_IDTipoPrecio) REFERENCES tipoprecio (IDTipoPrecio) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_logprecioproducto_usuario1 FOREIGN KEY (usuario_IDUsuario) REFERENCES usuario (IDUsuario) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/* Structure for the `precioproducto` table :  */

CREATE TABLE precioproducto (
  IDPrecioProducto INTEGER(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'El Precio por el Producto',
  producto_IDProducto INTEGER(8) UNSIGNED NOT NULL,
  tipoprecio_IDTipoPrecio INTEGER(1) UNSIGNED NOT NULL,
  PrecioProducto DOUBLE(8,2) UNSIGNED NOT NULL COMMENT 'El precio correspondiente del Producto',
  tienda_IDTienda INTEGER(2) UNSIGNED NOT NULL,
  FechaAlta TIMESTAMP NULL DEFAULT NULL,
  usuario_IDUsuarioAlta INTEGER(6) UNSIGNED NOT NULL,
  usuario_IDUsuarioModifica INTEGER(6) UNSIGNED NOT NULL,
  FechaMod TIMESTAMP NULL DEFAULT NULL,
  Estatus INTEGER(1) NOT NULL COMMENT 'Activo?',
  PRIMARY KEY USING BTREE (IDPrecioProducto),
  UNIQUE KEY IDPrecioProducto USING BTREE (IDPrecioProducto),
  KEY fk_precioproducto_producto1_idx USING BTREE (producto_IDProducto),
  KEY fk_precioproducto_tipoprecio1_idx USING BTREE (tipoprecio_IDTipoPrecio),
  KEY fk_precioproducto_tienda1_idx USING BTREE (tienda_IDTienda),
  KEY fk_precioproducto_usuario1_idx USING BTREE (usuario_IDUsuarioAlta),
  KEY fk_precioproducto_usuario2_idx USING BTREE (usuario_IDUsuarioModifica),
  CONSTRAINT fk_precioproducto_producto1 FOREIGN KEY (producto_IDProducto) REFERENCES producto (IDProducto) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_precioproducto_tienda1 FOREIGN KEY (tienda_IDTienda) REFERENCES tienda (IDTienda) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_precioproducto_tipoprecio1 FOREIGN KEY (tipoprecio_IDTipoPrecio) REFERENCES tipoprecio (IDTipoPrecio) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_precioproducto_usuario1 FOREIGN KEY (usuario_IDUsuarioAlta) REFERENCES usuario (IDUsuario) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_precioproducto_usuario2 FOREIGN KEY (usuario_IDUsuarioModifica) REFERENCES usuario (IDUsuario) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB
AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci'
;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;