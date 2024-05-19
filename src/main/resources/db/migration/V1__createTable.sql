CREATE TABLE IF NOT EXISTS alumno
(
    id          int        NOT NULL PRIMARY KEY,
    nombre      varchar(10) NOT NULL,
    apellido    varchar(15) NOT NULL,
    estado      varchar(1) NOT NULL,
    edad        int NOT NULL
    ) ;
commit ;