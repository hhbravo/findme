- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;

CREATE TABLE IF NOT EXISTS `role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(50) NOT NULL,
  `role_status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO role(role_name, role_status) VALUES('ROLE_ADMIN', 1), ('ROLE_USER', 1),('ROLE_GUEST', 1);

  DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
 `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_role` INT(11) DEFAULT NULL,
  `username` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `last_login` DATETIME NULL DEFAULT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_rol`
  FOREIGN KEY (`id_role`)
  REFERENCES `bbva_testcase_generator`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO user(username, id_role, password, first_name, last_name, status)
VALUES('hbravo', 2, 'd8a820104dfaa7ebfabdf005672b20920975a39ac92ee4db41b4c47b2872c25d', 'Hans', 'Herrera', 1);


DROP TABLE IF EXISTS `usiness`;
CREATE TABLE `empresa`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `razon_social` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ruc` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telefono` int(30) NOT NULL,
  `pagina_web` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imagen_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `usuario_creacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_creacion` datetime(0) NOT NULL,
  `usuario_modificacion` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fecha_modificacion` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
