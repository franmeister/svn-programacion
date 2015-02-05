create table Libro(
  ISBN int primary key, 
  signatura varchar(80),
  titulo varchar(40),
  autor varchar(40),
  materia varchar(40), 
  editorial varchar(40)
);
  
Create table Revista(
  codRevista int primary key,
  signatura varchar(80),
  nombre varchar(40),
  materia varchar(40)
);

create table Articulo(
  codArticulo int primary key,
  titulo varchar(40),
  autor varchar(40),
  numPaginas int
);

create table keyWords(
  codarticulo int,
  keywords varchar(40),
  primary key (codarticulo,keywords),
  foreign key (codarticulo) references articulo(codarticulo)
);

create table	Cdrom(
  codCdrom int primary key,
  signatura varchar(40),
  titulo varchar(40),
  autor varchar(40),
  materia varchar(40),
  editorial varchar(40)
);

create table Usuario(
  codUsuario int primary key,
  nombre varchar(40),
  apellido1 varchar(40),
  apellido2 varchar(40)
);

create table prestamo (
  codusuario int not null,
  codmaterial int not null,
  tipomaterial enum('L','R','A','K','C'),
  fecha_prestamo date not null,
  fecha_devolucion date
);
  
