
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

CREATE TABLE Pedido(
pk_cod_pedido INT PRIMARY KEY AUTO_INCREMENT,
data DATE,
hora TIME,
statusp VARCHAR(200),
observacao VARCHAR(200),
fk_cod_cliente INT,
foreign key(fk_cod_cliente) references Cliente(pk_cod_cliente),
fk_matricula_atendente INT,
foreign key(fk_matricula_atendente) references Atendente(pk_matricula)
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
nome VARCHAR(200),
fk_cod_tipo INT,
foreign key(fk_cod_tipo) references Tipo(pk_cod_tipo)
);

CREATE TABLE RegistroVenda(
pk_cod_venda INT PRIMARY KEY AUTO_INCREMENT,
quantidade int,
valor_venda FLOAT,
fk_cod_produto INT,
foreign key(fk_cod_produto) references Produto(pk_cod_produto)
fk_cod_pedido INT,
foreign key(fk_cod_pedido) references Pedido(pk_cod_pedido)
);




