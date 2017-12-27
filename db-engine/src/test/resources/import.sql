-- ----------------------------
-- Records of usuarios
-- ----------------------------
--  INSERT INTO `User` (user_id,active,email,name,last_name,password,account,user_create,fec_create,user_modify,fec_modify)
--  VALUES (1, TRUE,'hans@gmail.com', 'hans', 'herrera', '123', 'hans.herrera', 'ADMIN', '2017-12-11 00:16:14', NULL, NULL);


INSERT INTO role(role_name, role_status) VALUES('ROLE_ADMIN', 1);
INSERT INTO role(role_name, role_status) VALUES('ROLE_USER', 1);
INSERT INTO role(role_name, role_status) VALUES('ROLE_GUEST', 1);


INSERT INTO user(username, id_role, password, first_name, last_name, status) VALUES('hans', 2, 'd8a820104dfaa7ebfabdf005672b20920975a39ac92ee4db41b4c47b2872c25d', 'Hans', 'Herrera', 1);
INSERT INTO user(username, id_role, password, status) VALUES('test', 1, 'd8a820104dfaa7ebfabdf005672b20920975a39ac92ee4db41b4c47b2872c25d', 1);

INSERT INTO user_role(id_user, id_role, status) VALUES(1, 1, 1);
INSERT INTO user_role(id_user, id_role, status) VALUES(2, 2, 1);


INSERT INTO empresa(nombre,  ruc, status) VALUES('tinker-solutions', '12345678910', 1);
INSERT INTO empresa(nombre,  ruc, status) VALUES('digital-cook', '0123456789', 1);

