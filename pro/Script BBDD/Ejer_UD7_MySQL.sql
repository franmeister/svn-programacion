use java;
CREATE TABLE DEPART (
 DEPT_NO  int NOT NULL,
 DNOMBRE  VARCHAR(20), 
 LOC      VARCHAR(14) )  ;

INSERT INTO DEPART VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO DEPART VALUES (20,'INVESTIGACI�N','MADRID');
INSERT INTO DEPART VALUES (30,'VENTAS','BARCELONA');
INSERT INTO DEPART VALUES (40,'PRODUCCI�N','BILBAO');

CREATE TABLE EMPLE (
 EMP_NO    int NOT NULL,
 APELLIDO  VARCHAR(10)  ,
 OFICIO    VARCHAR(10)  ,
 DIR       int ,
 FECHA_ALT varchar(20),
 SALARIO   decimal(8,2),
 COMISION  decimal(8,2),
 DEPT_NO   int NOT NULL)  ;

INSERT INTO EMPLE VALUES (7369,'S�NCHEZ','EMPLEADO',7902,'17/12/1980',
                        104000,NULL,20);
INSERT INTO EMPLE VALUES (7499,'ARROYO','VENDEDOR',7698,'20/02/1980',
                        208000,39000,30);
INSERT INTO EMPLE VALUES (7521,'SALA','VENDEDOR',7698,'22/02/1981',
                        162500,65000,30);
INSERT INTO EMPLE VALUES (7566,'JIM�NEZ','DIRECTOR',7839,'02/04/1981',
                        386750,NULL,20);
INSERT INTO EMPLE VALUES (7654,'MART�N','VENDEDOR',7698,'29/09/1981',
                        162500,182000,30);
INSERT INTO EMPLE VALUES (7698,'NEGRO','DIRECTOR',7839,'01/05/1981',
                        370500,NULL,30);
INSERT INTO EMPLE VALUES (7782,'CEREZO','DIRECTOR',7839,'09/06/1981',
                        318500,NULL,10);
INSERT INTO EMPLE VALUES (7788,'GIL','ANALISTA',7566,'09/11/1981',
                        390000,NULL,20);
INSERT INTO EMPLE VALUES (7839,'REY','PRESIDENTE',NULL,'17/11/1981',
                        650000,NULL,10);
INSERT INTO EMPLE VALUES (7844,'TOVAR','VENDEDOR',7698,'08/09/1981',
                        195000,0,30);
INSERT INTO EMPLE VALUES (7876,'ALONSO','EMPLEADO',7788,'23/09/1981',
                        143000,NULL,20);
INSERT INTO EMPLE VALUES (7900,'JIMENO','EMPLEADO',7698,'03/12/1981',
                        123500,NULL,30);
INSERT INTO EMPLE VALUES (7902,'FERN�NDEZ','ANALISTA',7566,'03/12/1981',
                        390000,NULL,20);
INSERT INTO EMPLE VALUES (7934,'MU�OZ','EMPLEADO',7782,'23/01/1982',
                        169000,NULL,10);

create table NOTAS_ALUMNOS
 (
   NOMBRE_ALUMNO VARCHAR(25) NOT NULL ,
   nota1 int,
   nota2 int,
   nota3 int
 )  ;
 
insert into NOTAS_ALUMNOS VALUES ('Alcalde Garc�a, M. Luisa',5,5,5);
insert into NOTAS_ALUMNOS VALUES ('Benito Mart�n, Luis',7,6,8);
insert into NOTAS_ALUMNOS VALUES ('Casas Mart�nez, Manuel',7,5,5);
insert into NOTAS_ALUMNOS VALUES ('Corregidor S�nchez, Ana',6,9,8);
insert into NOTAS_ALUMNOS VALUES ('D�az S�nchez, Mar�a',NULL,NULL,7);
COMMIT;


create table LIBRERIA
 (TEMA CHAR(15) NOT NULL ,
  ESTANTE CHAR(1),
  EJEMPLARES int
 )  ;

INSERT INTO LIBRERIA VALUES ('Inform�tica', 'A',15);
INSERT INTO LIBRERIA VALUES ('Econom�a',    'A',10);
INSERT INTO LIBRERIA VALUES ('Deportes',    'B',8);
INSERT INTO LIBRERIA VALUES ('Filosof�a',   'C',7);
INSERT INTO LIBRERIA VALUES ('Dibujo',      'C',10);
INSERT INTO LIBRERIA VALUES ('Medicina',    'C',16);
INSERT INTO LIBRERIA VALUES ('Biolog�a',    'A',11);
INSERT INTO LIBRERIA VALUES ('Geolog�a',    'D',7);
INSERT INTO LIBRERIA VALUES ('Sociedad',    'D',9);
INSERT INTO LIBRERIA VALUES ('Labores',     'B',20);
INSERT INTO LIBRERIA VALUES ('Jardiner�a',    'E',6);


CREATE TABLE ALUMNOS
(
  DNI VARCHAR(10) NOT NULL,
  APENOM VARCHAR(30),
  DIREC VARCHAR(30),
  POBLA  VARCHAR(15),
  TELEF  VARCHAR(10)  
)  ;

CREATE TABLE ASIGNATURAS
(
  COD int NOT NULL,
  NOMBRE VARCHAR(25)
)  ;

CREATE TABLE NOTAS
(
  DNI VARCHAR(10) NOT NULL,
  COD int NOT NULL,
  NOTA int
)  ;

INSERT INTO ASIGNATURAS VALUES (1,'Prog. Leng. Estr.');
INSERT INTO ASIGNATURAS VALUES (2,'Sist. Inform�ticos');
INSERT INTO ASIGNATURAS VALUES (3,'An�lisis');
INSERT INTO ASIGNATURAS VALUES (4,'FOL');
INSERT INTO ASIGNATURAS VALUES (5,'RET');
INSERT INTO ASIGNATURAS VALUES (6,'Entornos Gr�ficos');
INSERT INTO ASIGNATURAS VALUES (7,'Aplic. Entornos 4�Gen');

INSERT INTO ALUMNOS VALUES
('12344345','Alcalde Garc�a, Elena', 'C/Las Matas, 24','Madrid','917766545');

INSERT INTO ALUMNOS VALUES
('4448242','Cerrato Vela, Luis', 'C/Mina 28 - 3A', 'Madrid','916566545');

INSERT INTO ALUMNOS VALUES
('56882942','D�az Fern�ndez, Mar�a', 'C/Luis Vives 25', 'M�stoles','915577545');

INSERT INTO NOTAS VALUES('12344345', 1,6);
INSERT INTO NOTAS VALUES('12344345', 2,5);
INSERT INTO NOTAS VALUES('12344345', 3,6);

INSERT INTO NOTAS VALUES('4448242', 4,6);
INSERT INTO NOTAS VALUES('4448242', 5,8);
INSERT INTO NOTAS VALUES('4448242', 6,4);
INSERT INTO NOTAS VALUES('4448242', 7,5);

INSERT INTO NOTAS VALUES('56882942', 4,8);
INSERT INTO NOTAS VALUES('56882942', 5,7);
INSERT INTO NOTAS VALUES('56882942', 6,8);
INSERT INTO NOTAS VALUES('56882942', 7,9);

CREATE TABLE NOMBRES
(
  NOMBRE VARCHAR(15),
  EDAD int
)  ;

INSERT INTO NOMBRES VALUES('PEDRO', 17);
INSERT INTO NOMBRES VALUES('JUAN', 17);
INSERT INTO NOMBRES VALUES('MAR�A', 16);
INSERT INTO NOMBRES VALUES('CLARA', 14);
INSERT INTO NOMBRES VALUES(NULL, 15);
INSERT INTO NOMBRES VALUES(NULL, 18);
INSERT INTO NOMBRES VALUES('JES�S', NULL);

CREATE TABLE MISTEXTOS (
 TITULO  VARCHAR(50),
 AUTOR   VARCHAR(22),
 EDITORIAL VARCHAR(15), 
 PAGINA  int
 )  ;

INSERT INTO MISTEXTOS VALUES ('METODOLOG�A DE LA PROGRAMACI�N.', 
'ALCALDE, GARC�A', 'MCGRAWHILL',140);
INSERT INTO MISTEXTOS VALUES ('"INFORM�TICA B�SICA."', 'GARC�A GARCER�N', 'PARANINFO',130);
INSERT INTO MISTEXTOS VALUES ('SISTEMAS OPERATIVOS', 'J.F. GARC�A', 'OBSBORNE',300);
INSERT INTO MISTEXTOS VALUES ('SISTEMAS DIGITALES.', 'M.A. RU�Z', 
'PRENTICE HALL',190);
INSERT INTO MISTEXTOS VALUES ('"MANUAL DE C."', 'M.A. RU�Z', 'MCGRAWHILL',340);

CREATE TABLE LIBROS (
 TITULO  VARCHAR(32),
 AUTOR   VARCHAR(22),
 EDITORIAL VARCHAR(15), 
 PAGINA  int
 )  ;

INSERT INTO LIBROS VALUES ('LA COLMENA', 'CELA, CAMILO JOS�', 'PLANETA',240);
INSERT INTO LIBROS VALUES ('LA HISTORIA DE MI HIJO', 'GORDIMER, NADINE', 'TIEM.MODERNOS',327);
INSERT INTO LIBROS VALUES ('LA MIRADA DEL OTRO', 'G.DELGADO, FERNANDO', 'PLANETA',298);
INSERT INTO LIBROS VALUES ('�LTIMAS TARDES CON TERESA','MARSE, JUAN', 'C�RCULO',350);
INSERT INTO LIBROS VALUES ('LA NOVELA DE P. ANSUREZ', 
'TORRENTE B., GONZALO', 'PLANETA',162);

CREATE TABLE NACIMIENTOS (
 NOMBRE CHAR(15),
 APELLIDO CHAR(15),
 FECHANAC varchar(20),
 EDAD int
 )  ;


INSERT INTO NACIMIENTOS VALUES ('PEDRO', 'S�NCHEZ','12/05/1982', 17);
INSERT INTO NACIMIENTOS VALUES ('JUAN', 'JIM�NEZ','23/08/1982', 17);
INSERT INTO NACIMIENTOS VALUES ('MAR�A', 'L�PEZ','02/02/1983', 16);
INSERT INTO NACIMIENTOS VALUES ('CLARA', 'LASECA','20/05/1985', 14);

CREATE  TABLE  PARALEER
(
  COD_LIBRO  int,
  NOMBRE_LIBRO VARCHAR(40)
)  ;

CREATE  TABLE  LEIDOS
(
  COD_LIBRO  int,
  FECHA  varchar(10)
)  ;

INSERT INTO PARALEER values(100,'Cien A�os de Soledad');
INSERT INTO PARALEER values (200,'Los Mitos Griegos');
INSERT INTO PARALEER values (300,'El Camino');

INSERT INTO LEIDOS values(300, '20/02/1999');
INSERT INTO LEIDOS values(200, '11/04/1999');

Create TABLE ALUM
(
  NOMBRE VARCHAR(20),
 EDAD int,
 LOCALIDAD VARCHAR(15)
)  ;

Create TABLE  NUEVOS
(
  NOMBRE  VARCHAR(20),
 EDAD int,
 LOCALIDAD VARCHAR(15)
)  ;

Create TABLE ANTIGUOS
(
  NOMBRE  VARCHAR(20),
 EDAD int,
 LOCALIDAD VARCHAR(15)
)  ;

INSERT INTO ALUM VALUES('JUAN',18,'COSLADA');
INSERT INTO ALUM VALUES('PEDRO',19,'COSLADA');
INSERT INTO ALUM VALUES('ANA',17,'ALCALA');
INSERT INTO ALUM VALUES('LUISA',18,'TORREJ�N');
INSERT INTO ALUM VALUES('MAR�A',20,'MADRID');
INSERT INTO ALUM VALUES('ERNESTO',21,'MADRID');
INSERT INTO ALUM VALUES('RAQUEL',19,'TOLEDO');

INSERT INTO NUEVOS VALUES('JUAN',18,'COSLADA');
INSERT INTO NUEVOS VALUES('MAITE',15,'ALCALA');
INSERT INTO NUEVOS VALUES('SOF�A',14,'ALCALA');
INSERT INTO NUEVOS VALUES('ANA',17,'ALCALA');
INSERT INTO NUEVOS VALUES('ERNESTO',21,'MADRID');

INSERT INTO ANTIGUOS VALUES('MAR�A',20,'MADRID');
INSERT INTO ANTIGUOS VALUES('ERNESTO',21,'MADRID');
INSERT INTO ANTIGUOS VALUES('ANDR�S',26,'LAS ROZAS');
INSERT INTO ANTIGUOS VALUES('IRENE',24,'LAS ROZAS');


CREATE TABLE PERSONAL (
 COD_CENTRO   int NOT NULL,
 DNI char(10),
 APELLIDOS VARCHAR(30),
 FUNCION VARCHAR(15),
 SALARIO decimal(8,2) 
) ;

INSERT INTO PERSONAL VALUES (10,1112345,'Mart�nez Salas, Fernando',
'PROFESOR', 220000);
INSERT INTO PERSONAL VALUES (10,4123005,'Bueno Zarco, Elisa', 
'PROFESOR', 220000);
INSERT INTO PERSONAL VALUES (10,4122025,'Montes Garc�a, M.Pilar', 
'PROFESOR', 220000);

INSERT INTO PERSONAL VALUES (15,1112345,'Rivera Silvestre, Ana',
'PROFESOR', 205000);
INSERT INTO PERSONAL VALUES (15,9800990, 'Ramos Ruiz, Luis',
'PROFESOR', 205000);
INSERT INTO PERSONAL VALUES (15,8660990, 'De Lucas Fdez, M.Angel',
'PROFESOR', 205000);

INSERT INTO PERSONAL VALUES (22,7650000, 'Ruiz Lafuente, Manuel',
'PROFESOR', 220000);
INSERT INTO PERSONAL VALUES (45,43526789, 'Serrano Lagu�a, Mar�a',
'PROFESOR', 205000);


INSERT INTO PERSONAL VALUES (10,4480099,'Ruano Cerezo, Manuel',
'ADMINISTRATIVO', 180000);
INSERT INTO PERSONAL VALUES (15,1002345,'Albarr�n Serrano, Alicia',
'ADMINISTRATIVO', 180000);
INSERT INTO PERSONAL VALUES (15,7002660,'Mu�oz Rey, Felicia',
'ADMINISTRATIVO', 180000);
INSERT INTO PERSONAL VALUES (22,5502678,'Mar�n Mar�n, Pedro',
'ADMINISTRATIVO', 180000);
INSERT INTO PERSONAL VALUES (22,6600980, 'Peinado Gil, Elena',
'CONSERJE', 175000);
INSERT INTO PERSONAL VALUES (45,4163222, 'Sarro Molina, Carmen',
'CONSERJE', 175000);


CREATE TABLE PROFESORES (
 COD_CENTRO   integer NOT NULL,
 DNI          char(10),
 APELLIDOS VARCHAR(30),
 ESPECIALIDAD VARCHAR(16) 
)  ;


INSERT INTO PROFESORES VALUES (10,1112345,'Mart�nez Salas, Fernando',
'INFORM�TICA');
INSERT INTO PROFESORES VALUES (10,4123005,'Bueno Zarco, Elisa', 
'MATEM�TICAS');
INSERT INTO PROFESORES VALUES (10,4122025,'Montes Garc�a, M.Pilar', 
'MATEM�TICAS');

INSERT INTO PROFESORES VALUES (15,9800990, 'Ramos Ruiz, Luis',
	'LENGUA');
INSERT INTO PROFESORES VALUES (15,1112345,'Rivera Silvestre, Ana',
	'DIBUJO');
INSERT INTO PROFESORES VALUES (15,8660990, 'De Lucas Fdez, M.Angel',
'LENGUA');

INSERT INTO PROFESORES VALUES (22,7650000, 'Ruiz Lafuente, Manuel',
'MATEM�TICAS');
INSERT INTO PROFESORES VALUES (45,43526789, 'Serrano Lagu�a, Mar�a',
'INFORM�TICA');

CREATE TABLE CENTROS (
 COD_CENTRO   int NOT NULL,
 TIPO_CENTRO  CHAR(1),
 NOMBRE VARCHAR(30),
 DIRECCION VARCHAR(26),
 TELEFONO VARCHAR(10),
 NUM_PLAZAS integer
 )  ;


INSERT INTO CENTROS VALUES (10,'S','IES El Quijote', 
'Avda. Los Molinos 25', '965-887654',538);
INSERT INTO CENTROS VALUES (15,'P','CP Los Danzantes', 'C/Las Musas s/n',
'985-112322',250);
INSERT INTO CENTROS VALUES (22,'S', 'IES Planeta Tierra', 'C/Mina 45',
'925-443400',300);
INSERT INTO CENTROS VALUES (45,'P', 'CP Manuel Hidalgo', 'C/Granada 5',
'926-202310',220);
INSERT INTO CENTROS VALUES (50,'S', 'IES Anto�ete', 'C/Los Toreros 21',
'989-406090',310);


CREATE TABLE EMPLE30 (
 EMP_NO    int NOT NULL,
 APELLIDO  VARCHAR(10)  ,
 OFICIO    VARCHAR(10)  ,
 DIR       int ,
 FECHA_ALT varchar(20),
 SALARIO   decimal(8,2),
 COMISION  decimal(8,2),
 DEPT_NO   int NOT NULL);


CREATE TABLE COCHES (NOMBRE VARCHAR(15));

INSERT INTO COCHES VALUES('SEAT');



CREATE TABLE ARTICULOS(
ARTICULO       VARCHAR(20)NOT NULL,
COD_FABRICANTE char(3) NOT NULL,
PESO           decimal(5,2) NOT NULL ,
CATEGORIA      VARCHAR(10) NOT NULL,
PRECIO_VENTA   decimal(8,2),
PRECIO_COSTO   decimal(8,2),
EXISTENCIAS    integer );

INSERT INTO ARTICULOS VALUES ('Macarrones',20, 1, 'Primera',100,98,120);
INSERT INTO ARTICULOS VALUES ('Tallarines',20, 2, 'Primera',120,100,100);
INSERT INTO ARTICULOS VALUES ('Tallarines',20, 1, 'Segunda',99,50,100);
INSERT INTO ARTICULOS VALUES ('Macarrones',20, 1, 'Tercera',80,50,100);

INSERT INTO ARTICULOS VALUES ('At�n',10, 3, 'Primera',200,150,220);
INSERT INTO ARTICULOS VALUES ('At�n',10, 3, 'Segunda',150,100,220);
INSERT INTO ARTICULOS VALUES ('At�n',10, 3, 'Tercera',100,50,220);
INSERT INTO ARTICULOS VALUES ('Sardinillas',10, 1,
 'Primera',250,200,200);
INSERT INTO ARTICULOS VALUES ('Sardinillas',10, 1,
 'Segunda',200,160,200);
INSERT INTO ARTICULOS VALUES ('Sardinillas',10, 1, 
'Tercera',100,150,220);
INSERT INTO ARTICULOS VALUES ('Mejillones',10, 1, 
'Tercera',90,50,200);
INSERT INTO ARTICULOS VALUES ('Mejillones',10, 1, 
'Primera',200,150,300);



INSERT INTO ARTICULOS VALUES ('Macarrones',25, 1, 'Primera',90,68,150);
INSERT INTO ARTICULOS VALUES ('Tallarines',25, 1, 'Primera',100,90,100);
INSERT INTO ARTICULOS VALUES ('Fideos',25, 1, 'Segunda',75,50,100);
INSERT INTO ARTICULOS VALUES ('Fideos',25, 1, 'Primera',100,80,100);


INSERT INTO ARTICULOS VALUES ('Galletas Cuadradas',
15, 1, 'Primera',100,80,100);
INSERT INTO ARTICULOS VALUES ('Galletas Cuadradas',
15, 1, 'Segunda',70,50,100);
INSERT INTO ARTICULOS VALUES ('Galletas Cuadradas',
15, 1, 'Tercera',50,40,100);
INSERT INTO ARTICULOS VALUES ('Barquillos',15, 1, 'Primera',100,80,100);
INSERT INTO ARTICULOS VALUES ('Barquillos',15, 1, 'Segunda',100,80,100);
INSERT INTO ARTICULOS VALUES ('Canutillos',15, 2, 'Primera',170,150,110);
INSERT INTO ARTICULOS VALUES ('Canutillos',15, 2, 'Segunda',120,150,110);

INSERT INTO ARTICULOS VALUES ('Leche entera',30, 1, 
'Primera',110,100,300);
INSERT INTO ARTICULOS VALUES ('Leche desnat.',30, 1, 
'Primera',120,100,300);
INSERT INTO ARTICULOS VALUES ('Leche semi.',30, 1, 
'Primera',130,110,300);
INSERT INTO ARTICULOS VALUES ('Leche entera',30, 2, 
'Primera',210,200,300);
INSERT INTO ARTICULOS VALUES ('Leche desnat.',30, 2, 
'Primera',220,200,300);
INSERT INTO ARTICULOS VALUES ('Leche semi.',30, 2, 
'Primera',230,210,300);
INSERT INTO ARTICULOS VALUES ('Mantequilla',30, 1, 
'Primera',510,400,200);
INSERT INTO ARTICULOS VALUES ('Mantequilla',30, 1, 
'Segunda',450,340,200);


CREATE TABLE FABRICANTES(
COD_FABRICANTE char(3) NOT NULL,
NOMBRE         VARCHAR(15), 
PAIS           VARCHAR(15));

INSERT INTO FABRICANTES VALUES(10,'CALVO', 'ESPA�A');
INSERT INTO FABRICANTES VALUES(15,'LU', 'BELGICA');
INSERT INTO FABRICANTES VALUES(20,'BARILLA', 'ITALIA');
INSERT INTO FABRICANTES VALUES(25,'GALLO', 'ESPA�A');
INSERT INTO FABRICANTES VALUES(30,'PRESIDENT', 'FRANCIA');

CREATE TABLE TIENDAS(
NIF       VARCHAR(10) NOT NULL,
NOMBRE    VARCHAR(20),
DIRECCI�N VARCHAR(20),
POBLACI�N VARCHAR(20),
PROVINCIA VARCHAR(20),
CODPOSTAL decimal(5,0) );

INSERT INTO TIENDAS VALUES('1111-A','Almacenes P�rez', 'C/Toledo, 20',
 'Siguenza','GUADALAJARA',19104); 
INSERT INTO TIENDAS VALUES('5555-B','La gacela', 'C/Santander Rios, 45',
 'Azuqueca','GUADALAJARA', 19209);
INSERT INTO TIENDAS VALUES('2222-A','Comestibles Rodolfo', 
'C/ del Val s/n', 'Alcal� de Henares','MADRID',28804);
INSERT INTO TIENDAS VALUES('4444-A','La Pasta Gansa', 'C/Alcal�, 2',
 'Ajalvir','MADRID', 28765);
 INSERT INTO TIENDAS VALUES('3333-N','Ultramarinos Montse',
  'Avda. Pio 10', 'Toledo','TOLEDO',45100);
INSERT INTO TIENDAS VALUES('4141-B','Todo Toledo',
 'C/Avila 24', 'Talavera','TOLEDO',45199);

