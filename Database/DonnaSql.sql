create database Donna;
use Donna;

CREATE TABLE Voo (
Id_voo INTEGER PRIMARY KEY auto_increment,
Origem VARCHAR(30),
Destino VARCHAR(30),
Data_Ida DATETIME,
Data_Volta DATETIME,
Valor DECIMAL(5,2)
);

CREATE TABLE Hospedagem (
Id_hospedagem INTEGER PRIMARY KEY auto_increment,
Incluso VARCHAR(10),
Diarias INTEGER
);

CREATE TABLE Permissoes (
Id_permissoes INTEGER PRIMARY KEY auto_increment,
Tipo_permissoes VARCHAR(10)
);

CREATE TABLE Cliente (
Id_cliente INTEGER PRIMARY KEY auto_increment,
Nome VARCHAR(50),
Telefone VARCHAR(20),
CPF VARCHAR(20),
Email VARCHAR(50),
Estado VARCHAR(20),
Cidade VARCHAR(30),
Bairro VARCHAR(30),
Rua VARCHAR(50),
Numero INTEGER,
CEP VARCHAR(10)
);

CREATE TABLE Usuário (
Id_usuario INTEGER PRIMARY KEY auto_increment,
Login VARCHAR(30),
Senha VARCHAR(30),
Id_cliente INTEGER,
Id_permissoes INTEGER,
FOREIGN KEY(Id_cliente) REFERENCES Cliente (Id_cliente),
FOREIGN KEY(Id_permissoes) REFERENCES Permissoes (Id_permissoes)
);

CREATE TABLE Pacote (
Id_pacote INTEGER PRIMARY KEY auto_increment,
Valor DECIMAL(5,2),
Desconto INTEGER,
Id_hospedagem INTEGER,
Id_voo INTEGER,
FOREIGN KEY(Id_voo) REFERENCES Voo (Id_voo),
FOREIGN KEY(Id_hospedagem) REFERENCES Hospedagem (Id_hospedagem)
);

CREATE TABLE Reserva (
Id_reserva INTEGER PRIMARY KEY auto_increment,
Tipo_pag VARCHAR(20),
Valor_total DECIMAL(5,2),
Id_usuario INTEGER,
FOREIGN KEY(Id_usuario) REFERENCES Usuário (Id_usuario)
);

CREATE TABLE Itens_reserva (
Id_itens INTEGER PRIMARY KEY auto_increment,
Quantidade INTEGER,
Valor DECIMAL(5,2),
Id_pacote INTEGER,
Id_reserva INTEGER,
FOREIGN KEY(Id_pacote) REFERENCES Pacote (Id_pacote),
FOREIGN KEY(Id_reserva) REFERENCES Reserva (Id_reserva)
);

ALTER TABLE permissoes MODIFY COLUMN Tipo_permissoes VARCHAR(20);
ALTER TABLE hospedagem MODIFY COLUMN Incluso VARCHAR(20);
ALTER TABLE pacote MODIFY COLUMN Valor VARCHAR(10);
ALTER TABLE itens_reserva MODIFY COLUMN Valor VARCHAR(10);

select * from usuarios;
select * from pacotes;
select * from hospedagem;

CREATE VIEW usuarios as
SELECT u.Id_usuario, u.Login, u.Senha, c.Id_cliente, c.Nome, p.Id_permissoes, p.Tipo_permissoes 
FROM usuário u, cliente c, permissoes p 
where u.Id_cliente = c.Id_cliente and u.Id_permissoes = p.Id_permissoes order by u.Id_usuario asc;

CREATE VIEW pacotes as
SELECT p.Id_pacote, p.Valor, p.Desconto, h.Id_hospedagem, h.Incluso, h.Diarias,  v.Id_voo, v.Destino, v.Data_Ida 
FROM pacote p, hospedagem h, voo v 
where p.Id_hospedagem = h.Id_hospedagem and p.Id_voo = v.Id_voo order by p.Id_pacote asc;