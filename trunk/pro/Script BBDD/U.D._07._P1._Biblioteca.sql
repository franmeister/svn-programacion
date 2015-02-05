create table Libro(
  ISBN integer primary key, 
  signatura varchar2(80),
  titulo varchar2(40),
  autor varchar2(40),
  materia varchar2(40), 
  editorial varchar2(40)
);
  
Create table Revista(
  codRevista integer primary key,
  signatura varchar2(80),
  nombre varchar2(40),
  materia varchar2(40)
);

create table Articulo(
  codArticulo integer primary key,
  titulo varchar2(40),
  autor varchar2(40),
  numPaginas integer
);

create table keyWords(
  codarticulo integer,
  keywords varchar2(40),
  primary key (codarticulo,keywords),
  foreign key (codarticulo) references articulo(codarticulo)
);

create table	Cdrom(
  codCdrom integer primary key,
  signatura varchar2(40),
  titulo varchar2(40),
  autor varchar2(40),
  materia varchar2(40),
  editorial varchar2(40)
);

create table Usuario(
  codUsuario integer primary key,
  nombre varchar2(40),
  apellido1 varchar2(40),
  apellido2 varchar2(40)
);

create table prestamo (
  codusuario integer not null,
  codmaterial integer not null,
  tipomaterial char(1) constraint ckc_tipo check (tipomaterial in ('L','R','A','K','C')),
  fecha_prestamo date not null,
  fecha_devolucion date
);
  
