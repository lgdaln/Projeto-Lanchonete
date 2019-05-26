
CREATE DATABASE projetolanchonete;

CREATE TABLE Atendente(
pk_matricula INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200)
);

CREATE TABLE Cliente(
pk_cod_cliente INT PRIMARY KEY AUTO_INCREMENT,
cpf VARCHAR(200),
nome VARCHAR(200)
);

CREATE TABLE Tipo(
pk_cod_tipo INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(200)
);

CREATE TABLE Produto(
pk_cod_produto INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200),
disponibilidade VARCHAR(200),
valor_unitario FLOAT,
fk_cod_tipo INT,
foreign key(fk_cod_tipo) references Tipo(pk_cod_tipo)
);

CREATE TABLE Pedido(
pk_cod_pedido INT PRIMARY KEY AUTO_INCREMENT,
data DATE,
hora TIME,
statusp VARCHAR(200),
observacao VARCHAR(200),
valorAtual FLOAT,
quantidade int,
fk_cod_cliente INT,
foreign key(fk_cod_cliente) references Cliente(pk_cod_cliente),
fk_cod_produto INT,
foreign key(fk_cod_produto) references Produto(pk_cod_produto),
fk_matricula INT,
foreign key(fk_matricula) references Atendente(pk_matricula)
);

USE projetolanchonete;


INSERT INTO  Tipo (pk_cod_tipo, descricao) VALUES ('1', 'Refeição');
INSERT INTO  Tipo (pk_cod_tipo, descricao) VALUES ('2', 'Lanche');
INSERT INTO  Tipo (pk_cod_tipo, descricao) VALUES ('3', 'Bebida');
INSERT INTO  Tipo (pk_cod_tipo, descricao) VALUES ('4', 'Doce');
INSERT INTO  Tipo (pk_cod_tipo, descricao) VALUES ('5', 'Salgado');

INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('1', 'Cuscuz com queijo', 'Sim', '3.50', '1');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('2', 'Cuscuz com charque', 'Sim', '3.50', '1');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('3', 'Misto', 'Sim', '1.50', '2');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('4', 'Beirute', 'Sim', '2.50', '2');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('5', 'Café', 'Sim', '1.00', '3');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('6', 'Refrigerrante', 'Sim', '4.50', '3');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('7', 'Água sem gás', 'Sim', '2.00', '3');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('8', 'Brigadeiro', 'Sim', '0.50', '4');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('9', 'Chocolate', 'Não', '0.50', '4');
INSERT INTO  Produto (pk_cod_produto, nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES ('10', 'Cochinha', 'Sim', '1.00', '5');


INSERT INTO  Atendente (nome) VALUES ('**SEM ATENDENTE**');
INSERT INTO  Atendente (nome) VALUES ('Luiz');
INSERT INTO  Atendente (nome) VALUES ('Maria');
INSERT INTO  Atendente (nome) VALUES ('Julia');






SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto WHERE pedido.data = '2019-05-17'
SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto WHERE pedido.status <> 'Entregue'

SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, pedido.statusp, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo, atendente.pk_matricula, atendente.nome AS nomeAtendente FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto INNER JOIN atendente ON pedido.fk_matricula = atendente.pk_matricula WHERE  pedido.statusp <> 'Entregue';

SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, pedido.statusp, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto ;
