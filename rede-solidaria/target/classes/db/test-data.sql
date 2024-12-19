INSERT INTO  entidade(id, creationTime, updateTime, version, nome, email, contacto, nif, morada, concelho, docs) VALUES
                                                                                       (1, '2024-12-14','2024-12-14', 0,'Associação Boa Esperança','associação_BE@gmail.com', 962314471, 509338833, 'Rua da Boa Esperança, nº4 2900-008 Setúbal', 'Setúbal', null),
                                                                                       (2, '2024-12-14','2024-12-14', 0,'Bairro feliz','associação_Feliz@gmail.com', 934267564, 508229944, 'Praça do Bairro, nº45 2650-143 Amadora', 'Amadora', null),
                                                                                       (3, '2024-12-14','2024-12-14', 0,'Nosso povo', 'nossoPovo@hotmail.com', 923461895, 507337755, 'Rua 25 de Abril, nº1 2800-633 Almada', 'Almada', null),
                                                                                       (4, '2024-12-14','2024-12-14', 0,'Bem-Estar', 'associação_BemEstar@gmail.com', 963418924, 505939344, 'Rua do Bem Estar, nº88 4ºdto 1549-007 Lisboa', 'Lisboa', null),
                                                                                       (5, '2024-12-14','2024-12-14', 0,'Associação AJudar o Proximo', 'ajudaroproximo@gmail.com', 912674286, 503552345, 'Pcta dos Malmequeres, nº55 1200-884 Lisboa', 'Lisboa', null),
                                                                                       (6, '2024-12-14','2024-12-14', 0,'Ajuda ao Idoso', 'ajudaaoidoso@gmail.com', 938639750, 508465345, 'Rua Poeta António Aleixo, nº12 2855-432 Corroios', 'Seixal', null);

INSERT INTO servico(id, tiposervico, certificado) VALUES
                                                      (1, 'Canalizador', true),
                                                      (2, 'Eletricista', true),
                                                      (3, 'Mecânico', true),
                                                      (4, 'Jardineiro', false),
                                                      (5, 'Técnico de gás', true),
                                                      (6, 'Eletrónica', false),
                                                      (7, 'Cozinha', false),
                                                      (8, 'Ensino', true),
                                                      (9, 'Informática', false),
                                                      (10, 'Compras', false),
                                                      (11, 'Companhia', false);

INSERT INTO prestadorsvc(id, creationTime, updateTime, version, nome, email, contacto, nif, concelho, servico_id, ativo, docs) VALUES
                                                                                                                                   (1, '2024-12-14','2024-12-14', 0,'Jorge Armando','armandoJorge1@gmail.com', 935274826, 208447373, 'almada', 2, true, null),
                                                                                                                                   (2, '2024-12-14','2024-12-14', 0,'Mario Sousa','marinhosousa@gmail.com', 913627834, 202994455, 'amadora', 3, false, null),
                                                                                                                                   (3, '2024-12-14','2024-12-14', 0,'João Paulo','paulinhoda08@gmail.com', 932563915, 202867345, 'seixal', 1, false, null),
                                                                                                                                   (4, '2024-12-14','2024-12-14', 0,'Silvestre Lopes','silvestreL@gmail.com', 912674968, 204006677, 'almada', 4, true, null),
                                                                                                                                   (5, '2024-12-14','2024-12-14', 0,'Horacio Migueis','MigueisHoracio213@gmail.com', 91354899, 203769233, 'setúbal', 5, true, null),
                                                                                                                                   (6, '2024-12-14','2024-12-14', 0,'Paulo Fernandes','MigueisHoracio213@gmail.com', 91354899, 203889630, 'lisboa', 5, true, null);

INSERT INTO ticket(ID, CREATIONTIME, UPDATETIME, VERSION, ENTIDADE_ID, SERVICO_ID, TIPOTRABALHO, DATAPRETENDIDA, DATACONCLUSAO, HORAS, PRESTADORSVC_ID, ABERTO, EMPROGRESSO, CONCLUIDO) VALUES
    (1, '2025-01-03','2025-01-03',0, 1,4, 'Cortar a relva', '2025-01-10', '2017-10-10', 5, 4, true, false, false),
    (2, '2025-01-03','2025-01-03',0, 2,3, 'Carregar arcondicionado da carrinha da escola', '2025-02-10', '2017-10-10', 5, 2, false, true, false),
    (3, '2025-01-03','2025-01-03',0, 2,2, 'Mudar lâmpadas das salas de aula', '2025-03-10', '2017-10-10', 5, 1, true, false, false),
    (4, '2025-01-03','2025-01-03',0, 3,2, 'Colocar tomadas novas na sala de estar', '2025-04-10', '2017-10-10', 5, 1, true, false, false),
    (5, '2025-01-03','2025-01-03',0, 4,2, 'Fazer puxada de eletricidade para o sotão', '2025-05-10', '2017-10-10', 5, 1, false, false, true),
    (6, '2025-01-03','2025-01-03',0, 5,8, 'Aulas de Português para utente Chinês', '2025-06-10', '2017-10-10', 5, 1, true, false, false),
    (5, '2025-01-03','2025-01-03',0, 6,11, 'Fazer companhia a utente no seu aniversário', '2025-07-10', '2017-10-10', 5, 1, true, false, false);