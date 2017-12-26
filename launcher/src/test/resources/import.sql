INSERT INTO paas_file(path, upload_date) VALUES('C:\Users\A C E R\Desktop\entelgy\Paas\file.rar', now());

INSERT INTO business_service(registry_id, logical_id) VALUES (null, 'users');

INSERT INTO business_service_modeling_file(id_business_service, id_paas_file, version, activated) VALUES(1, 1, 'v0.9.0', 1);

INSERT INTO multichannel_service (id_business_service, path, http_method) VALUES (1, '/user', 'post');
INSERT INTO multichannel_service (id_business_service, path, http_method) VALUES (1, '/user', 'get');
INSERT INTO multichannel_service (id_business_service, path, http_method) VALUES (1, '/user/simulate', 'post');
INSERT INTO multichannel_service (id_business_service, path, http_method) VALUES (1, '/user', 'put');