/*
 Navicat Premium Data Transfer

 Source Server         : MYSQLDB
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : findme_db

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 11/12/2017 01:01:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for categorias
-- ----------------------------
DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `estado` int(1) NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categorias
-- ----------------------------
INSERT INTO `categorias` VALUES (1, 'hardware', 1, 'ADMIN', '2017-12-11 00:32:44', NULL, NULL);
INSERT INTO `categorias` VALUES (2, 'software', 1, 'ADMIN', '2017-12-11 00:32:56', NULL, NULL);

-- ----------------------------
-- Table structure for empresas
-- ----------------------------
DROP TABLE IF EXISTS `empresas`;
CREATE TABLE `empresas`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `razon_social` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ruc` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telefono` int(30) NOT NULL,
  `pagina_web` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imagen_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `estado` int(1) NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empresas
-- ----------------------------
INSERT INTO `empresas` VALUES (1, 'Maiden Assistant', 'Maiden Assistant S.A', '12345678901', 'Pasaje Amarillis 182', 945876543, 'http://maidenassistant.com', NULL, 1, 'ADMIN', '2017-12-11 00:19:24', NULL, NULL);

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `precio` decimal(10, 2) DEFAULT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_punto_servicio` int(11) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_id_puntos_servicio`(`id_punto_servicio`) USING BTREE,
  INDEX `fk_id_categoria`(`id_categoria`) USING BTREE,
  CONSTRAINT `fk_id_puntos_servicio` FOREIGN KEY (`id_punto_servicio`) REFERENCES `puntos_servicio` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productos
-- ----------------------------
INSERT INTO `productos` VALUES (1, 'Solución Técnica', 'Solución Técnica', NULL, 1, 1, 1, 'ADMIN', '2017-12-11 00:31:54', NULL, NULL);
INSERT INTO `productos` VALUES (2, 'Soluciónes TI', 'Solución Software', NULL, 2, 2, 1, 'ADMIN', '2017-12-11 00:33:52', NULL, NULL);

-- ----------------------------
-- Table structure for puntos_servicio
-- ----------------------------
DROP TABLE IF EXISTS `puntos_servicio`;
CREATE TABLE `puntos_servicio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comentario` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `latitud` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `longitud` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `estado` int(1) NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_empresa_id`(`empresa_id`) USING BTREE,
  CONSTRAINT `fk_empresa_id` FOREIGN KEY (`empresa_id`) REFERENCES `empresas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of puntos_servicio
-- ----------------------------
INSERT INTO `puntos_servicio` VALUES (1, 'Soluciones Tecnicas Jefri', 'En este local brindamos soluciones de hardware', '-12.1183795', '-76.9911505', 'Caminos del Inca 777', 1, 'ADMIN', '2017-12-11 00:23:18', NULL, NULL, 1);
INSERT INTO `puntos_servicio` VALUES (2, 'Soluciones Software', 'En este establecimiento brindamos soluciones de verdad', '-11.9938093', '-77.0661657', 'Pasaje Amarillis 182', 1, 'ADMIN', '2017-12-11 00:28:25', NULL, NULL, 1);

-- ----------------------------
-- Table structure for usuario_empresas
-- ----------------------------
DROP TABLE IF EXISTS `usuario_empresas`;
CREATE TABLE `usuario_empresas`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `estado` int(1) NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_usuario_id`(`id_usuario`) USING BTREE,
  INDEX `fk_id_empresa`(`id_empresa`) USING BTREE,
  CONSTRAINT `fk_usuario_id` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuario_empresas
-- ----------------------------
INSERT INTO `usuario_empresas` VALUES (1, 1, 1, 1, 'ADMIN', '2017-12-11 00:19:46', NULL, NULL);

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `active` boolean NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES (1, 'Tinker', 'Solutions', 'Factory', 'tinker', 'XXX', 1, 'ADMIN', '2017-12-11 00:16:14', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
