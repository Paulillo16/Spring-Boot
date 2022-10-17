INSERT INTO almacenes (id, uuid, cliente, tipo, tamanio) VALUES (1, '89df38a7-2a5e-4ea3-9f3d-9e11e1e0fe7f', 'Cliente A', 'EST', 50);
INSERT INTO almacenes (id, uuid, cliente, tipo, tamanio) VALUES (2, '572bc40e-4a2e-4adc-afb1-2462ac513270', 'Cliente B', 'ROB', 10);
INSERT INTO estanterias (id, uuid, almacen_id, tipo) VALUES (1, '009a1883-ad3b-4f3e-9dce-111e597c6589', 1, 'A');
INSERT INTO estanterias (id, uuid, almacen_id, tipo) VALUES (2, 'bef40362-daeb-4b6e-9396-7fbc79e399e8', 1, 'B');