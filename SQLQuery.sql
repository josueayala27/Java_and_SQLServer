create database template

use template

create table generos(
id int not null identity(1,1) primary key,
genero nvarchar(25) not null
)

create table usuarios(
id int not null primary key,
nombre nvarchar(60) not null,
apellido nvarchar(60) not null,
id_genero int not null references generos(id),
fecha_nacimiento date not null,
foto image,
correo nvarchar(125) not null 
)

insert into generos values('Masculino')
insert into generos values('Femenino')

select * from generos

SELECT genero FROM generos

select * from usuarios

select a.id, a.nombre, a.apellido, g.genero, a.fecha_nacimiento from usuarios a, generos g where a.id_genero = g.id