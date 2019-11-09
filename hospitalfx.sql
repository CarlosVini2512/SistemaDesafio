create table Medico (
idMedico int not null AUTO_INCREMENT,
nome varchar(50),
cpf varchar(50),
idade int,
tipoSanguineo varchar(50) ,
sexo varchar(50),
statusPessoa varchar(200), 
login varchar(50),
senha varchar(50),
numeroRegistro int,
especialidade varchar(50),
constraint PK_Medico primary key(idMedico));

create table Enfermeiro (
id int not null AUTO_INCREMENT,
nome varchar(50),
cpf varchar(50),
idade int,
tipoSanguineo varchar(50) ,
sexo varchar(50),
login varchar(50),
senha varchar(50),
numeroRegistro varchar(50),
especialidade varchar(50),
constraint PK_Enfermeiro primary key(idEnfermeiro));

create table Gerente (
idGerente int not null AUTO_INCREMENT,
cargo varchar(50),
constraint PK_Gerente primary key(idGerente));

create table Paciente (
idPaciente int not null AUTO_INCREMENT,
nome varchar(50),
cpf varchar(50),
idade int,
tipoSanguineo varchar(50),
sexo varchar(50) ,
statusPessoa varchar(200),
doenca varchar (300) ,
historico varchar (300),
constraint PK_Paciente primary key(idPaciente));

create table EnfermidadePessoal (
idEnfermidadePessoal int not null AUTO_INCREMENT,
comentario varchar(100),
statusEnfermeiro varchar(100),
constraint PK_EnfermidadePessoal primary key (idEnfermidadePessoal));

create table Enfermidade(
idEnfermidade int not null AUTO_INCREMENT,
nome varchar(60),
descricao varchar(200),
tipo varchar(80),
constraint PK_Enfermidade primary key (idEnfermidade));

create table Entrada (
idEntrada int not null AUTO_INCREMENT,
dataEntrada date,
dataSaida date,
statusEntrada varchar(50),
situacaoPaciente varchar(300),
constraint PK_Entrada primary key (idEntrada));

create table Atendimento (
idAtendimento int not null AUTO_INCREMENT,
comentarioEnfermeiro varchar(100),
comentarioMedico varchar(100),
altura float,
peso float,
dData date,
doenca varchar(300),
constraint PK_Atendimento primary key (idAtendimento));

