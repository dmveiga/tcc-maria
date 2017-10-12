--Inserts
--01
INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP) VALUES ('Brasil', 'MG', 'Belo Horizonte', 'Santa Efigênia', 'Av. dos Andradas', 3000, '30260070');
INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO) VALUES (1, 'Unisys', '1900-01-01', 100000, 5000000000.50);
INSERT INTO funcao (NOME, DESCRICAO) VALUES ('Desenvolvedor Java Jr.', 'Desenvolver, analisar requisitos e testar aplicações Java Web, utuilizando conhecimentos em HTML, Javascript, Css, entre outros');
INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO) VALUES (1, 1, 'Neymar da Silva Santos Júnior', '1992-02-05', 'neymar.jr@gmail.com', true, 10000000.23);
INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO) VALUES (1, 'Alok Achkar Peres Petrillo', '1991-08-26', 'alok@artistfactory.com', 'filho');
--02
INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP) VALUES ('Brasil', 'SP', 'São Paulo', 'Morumbi', 'Av. Dr. Chucri Zaidan', 1240, '04711130');
INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO) VALUES (2, 'Microsoft', '1950-02-02', 200000, 10000000000.50);
INSERT INTO funcao (NOME, DESCRICAO) VALUES ('Gerente de Projetos', 'Os gerentes de projetos cultivam as habilidades das pessoas para desenvolver confiança e comunicação entre todas as partes interessadas do projeto: seus patrocinadores, aqueles que farão uso dos resultados do projeto, aqueles que dispõem dos recursos necessários e os membros da equipe do projeto');
INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO) VALUES (2, 2, 'William Henry Gates III', '1992-02-05', 'bill@microsoft.com', false, 50000000.75);
INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO) VALUES (1, 'Marília Mendonça', '1995-07-22', 'marilia@hotmail.com', 'prima');
--03
INSERT INTO endereco (PAIS, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, CEP) VALUES ('Brasil', 'RJ', 'Rio de Janeiro', 'Lapa', 'R. Teixeira de Freitas', 31, '20021350');
INSERT INTO empresa (ID_ENDERECO, NOME, DATA_CRIACAO, NUM_FUNCIONARIOS, LUCRO) VALUES (3, 'Google', '2000-05-05', 300000, 15000000000.50);
INSERT INTO funcao (NOME, DESCRICAO) VALUES ('SCRUM Master', 'O Scrum Master procura assegurar que a equipe respeite e siga os valores e as práticas do Scrum. Ele também protege a equipe assegurando que ela não se comprometa excessivamente com relação àquilo que é capaz de realizar durante um Sprint.');
INSERT INTO funcionario (ID_EMPRESA, ID_FUNCAO, NOME, DATA_NASCIMENTO, EMAIL, ATIVO, SALARIO) VALUES (3, 1, 'Gisele Caroline Bündchen', '1975-10-28', 'gisele@outlook.com', true, 15000000.99);
INSERT INTO dependente (ID_FUNCIONARIO, NOME, DATA_NASCIMENTO, EMAIL, PARENTESCO) VALUES (1, 'Larissa de Macedo Machado', '1993-03-30', 'anitta@somlivre.com.br', 'filha');

--Busca Simples
SELECT * FROM funcionario WHERE nome = 'Neymar da Silva Santos Júnior'

--Busca Complexa
SELECT COUNT(*) FROM funcionario fio
JOIN funcao fao ON fao.ID_FUNCAO = fio.ID_FUNCAO
JOIN dependente dep ON dep.ID_FUNCIONARIO = fio.ID_FUNCIONARIO
JOIN empresa emp ON emp.ID_EMPRESA = fio.ID_EMPRESA
JOIN endereco ende ON ende.ID_ENDERECO = emp.ID_ENDERECO
WHERE emp.NUM_FUNCIONARIOS > 150000
AND fio.DATA_NASCIMENTO BETWEEN '1991/01/01' AND '2000/01/01'
AND fio.SALARIO > 30000000 
AND fio.nome LIKE '%William Henry Gates III%'
AND dep.EMAIL = 'marilia@hotmail.com'
AND fao.NOME = 'Gerente de Projetos'
AND ende.ESTADO = 'SP'