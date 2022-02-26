create sequence lab_diagnostico_seq as bigint increment 1 start 1;

create table lab_diagnostico
(
    cod_diagnostico    bigint default nextval('lab_diagnostico_seq'::regclass) not null
        constraint lab_diagnostico_pk
            primary key,
    nombre_diagnostico varchar(100)                                            not null,
    estado_diagnostico varchar(20)                                             not null,
    fecha_creacion     date,
    creado_por         varchar(35),
    fecha_modificacion date,
    modificado_por     varchar(35)
);

alter table lab_diagnostico
    owner to postgres;

create sequence lab_enfermedad_sistemica_seq as integer increment 1 start 1;

create table lab_enfermedad_sistemica
(
    cod_enfermedad_sistemica integer default nextval('lab_enfermedad_sistemica_seq'::regclass) not null
        constraint lab_enf_sistemica_pk
            primary key,
    nombre_enfermedad        varchar(30)                                                       not null,
    estado_enfermedad        varchar(10),
    fecha_creacion           date,
    creado_por               varchar(30),
    modificado_por           varchar(30),
    fecha_modificacion       date
);

alter table lab_enfermedad_sistemica
    owner to postgres;

create sequence lab_medicamento_seq as integer increment 1 start 1;

create table lab_medicamento
(
    cod_medicamento    integer default nextval('lab_medicamento_seq'::regclass) not null
        constraint lab_medicamento_pk
            primary key,
    nombre_medicamento varchar(35)                                              not null,
    estado_medicamento varchar(20)                                              not null,
    fecha_creacion     date,
    creado_por         varchar(35),
    fecha_modificacion date,
    modificado_por     varchar(35),
    tipo_medicamento   integer
);

alter table lab_medicamento
    owner to postgres;

create sequence lab_paciente_seq as bigint increment 1 start 1;

create table lab_paciente
(
    cod_paciente        bigint default nextval('lab_paciente_seq'::regclass) not null
        constraint lab_paciente_pk
            primary key,
    nombre              varchar(60)                                          not null,
    apellidos           varchar(60)                                          not null,
    email               varchar(50),
    identificacion      varchar(45),
    direccion           varchar(250),
    telefono            varchar(20),
    estadocivil         varchar(15),
    fechanacimiento     date,
    genero              varchar(15),
    ocupacion           varchar(50),
    tipo_identificacion varchar(15),
    creadopor           varchar(20),
    fechacreacion       date,
    modificadopor       varchar(20),
    fechamodificacion   date,
    num_ficha           varchar(30)
);

alter table lab_paciente
    owner to postgres;

create sequence lab_tincion_seq as integer increment 1 start 1;


create table lab_tincion
(
    cod_tincion        integer default nextval('lab_tincion_seq'::regclass) not null
        constraint lab_tincion_pk
            primary key,
    nombre_tincion     varchar(35)                                          not null,
    estado_tincion     varchar(10),
    fecha_creacion     date,
    creado_por         varchar(35),
    modificado_por     varchar(35),
    fecha_modificacion date
);

alter table lab_tincion
    owner to postgres;

create sequence lab_tipo_opcion_lesion_seq as integer increment 1 start 1;

create table lab_tipo_opcion_lesion
(
    cod_tipo_opcion_lesion integer default nextval('lab_tipo_opcion_lesion_seq'::regclass) not null
        constraint lab_tip_opcion_lesion_pk
            primary key,
    nombre_tipo_opcion     varchar(35)                                                     not null,
    valor_tipo_opcion      varchar(20)                                                     not null,
    estado_tipo_opcion     varchar(10)                                                     not null,
    fecha_creacion         date,
    creado_por             varchar(35),
    modificado_por         varchar(35),
    fecha_modificacion     date
);

alter table lab_tipo_opcion_lesion
    owner to postgres;

create sequence lab_usuario_seq as bigint increment 1 start 1;

create table lab_usuario
(
    cod_usuario       bigint default nextval('lab_usuario_seq'::regclass) not null
        constraint lab_usuario_pk
            primary key,
    login_usuario     varchar(20)                                         not null,
    nombres_doctor    varchar(50)                                         not null,
    apellidos_doctor  varchar(50)                                         not null,
    num_colegiado     varchar(15),
    password          varchar(60)                                         not null,
    estado            varchar(20)                                         not null,
    emailusuario      varchar(50),
    tipo_usuario      varchar(3)                                          not null,
    rol_usuario       varchar(2),
    creadopor         varchar(20),
    fechacreacion     date,
    modificadopor     varchar(20),
    fechamodificacion date,
    llave             varchar(50)
);

alter table lab_usuario
    owner to postgres;

create table lab_examen
(
    cod_examen                  serial not null
        constraint lab_examen_pkey
            primary key,
    cod_paciente                bigint
        constraint cod_paciente_fk
            references lab_paciente,
    num_examen                  varchar(20),
    fecha_examen                date,
    estado_examen               varchar(25),
    historia_examen_lesion      varchar(200),
    tamano_lesion               varchar(15),
    dimensional_lesion          varchar(20),
    duracion_lesion_dias        integer,
    duracion_lesion_meses       integer,
    duracion_lesion_anios       integer,
    datos_importantes_lesion    varchar(200),
    doctor_examen               bigint
        constraint doctor_examen_fk
            references lab_usuario,
    doctor_remision             varchar(30),
    direccion_doctor_remision   varchar(50),
    telefono_doctor_remision    varchar(50),
    email_doctor_remision       varchar(50),
    dependencia_doctor_remision varchar(50),
    necesita_biopsia            boolean,
    necesita_frote              boolean
);

alter table lab_examen
    owner to postgres;

create table lab_examen_biopsia
(
    cod_biopsia        serial not null
        constraint lab_examen_biopsia_pkey
            primary key,
    cod_examen         integer
        constraint cod_examen_fk
            references lab_examen,
    num_biopsia        varchar(20)
        constraint num_biopsia_uq
            unique,
    usuario_biopsia    integer
        constraint usuario_biopsia_fk
            references lab_usuario,
    fecha              date,
    tipo_biopsia       varchar(20),
    num_recibo         varchar(10),
    serie_recibo       varchar(10),
    monto_recibo       numeric,
    estado_biopsia     varchar(30),
    modificado_por     varchar(30),
    fecha_modificacion date,
    procedimiento      integer,
    tipo_cirugia       integer,
    instrumento        integer,
    muestra_estudio    varchar,
    observaciones      varchar
);

alter table lab_examen_biopsia
    owner to postgres;

create table lab_examen_caracteristica
(
    cod_examen                serial  not null
        constraint fk_lab_examen_caracteristica_fk
            references lab_examen,
    codigo_tipo_opcion_lesion integer not null
        constraint fk_lab_tipo_opcion_lesion_fk
            references lab_tipo_opcion_lesion,
    fecha_creacion            date,
    creado_por                varchar(20),
    fecha_modificacion        date,
    modificado_por            varchar(20),
    constraint lab_examen_caracteristica_pk
        primary key (cod_examen, codigo_tipo_opcion_lesion)
);

alter table lab_examen_caracteristica
    owner to postgres;

create table lab_examen_diagnostico
(
    cod_examen         integer not null
        constraint examen_diagnostico_examen_fk
            references lab_examen,
    cod_diagnostico    integer not null
        constraint examen_diagnostico_diagnostico_fk
            references lab_diagnostico,
    tipo_diagnostico   integer,
    fecha_creacion     date,
    creado_por         integer
        constraint examen_diagnostico_usuario_fk
            references lab_usuario,
    fecha_modificacion date,
    modificado_por     varchar(30),
    constraint examen_diagnostico_pk
        primary key (cod_examen, cod_diagnostico)
);

alter table lab_examen_diagnostico
    owner to postgres;

create table lab_examen_enfermedad_sistemica
(
    cod_examen               integer not null
        constraint cod_examen_fk
            references lab_examen,
    cod_enfermedad_sistemica integer not null
        constraint cod_enfermedad_sistemica_fk
            references lab_enfermedad_sistemica,
    fecha_creacion           date,
    creado_por               varchar(20),
    fecha_modificacion       date,
    modificado_por           varchar(20),
    constraint lab_examen_enfermedad_sistemica_pk
        primary key (cod_examen, cod_enfermedad_sistemica)
);

alter table lab_examen_enfermedad_sistemica
    owner to postgres;

create table lab_examen_frote
(
    cod_frote          serial      not null
        constraint lab_examen_frote_pkey
            primary key,
    cod_examen         integer
        constraint cod_examen_fk
            references lab_examen,
    num_frote          varchar(20) not null
        constraint num_frote_uq
            unique,
    num_recibo         varchar(20),
    serie_recibo       varchar(20),
    monto_recibo       numeric,
    cod_tincion        integer
        constraint cod_tincion_fk
            references lab_tincion,
    estado_frote       varchar(30),
    usuario_frote      integer
        constraint frote_usuario_fk
            references lab_usuario,
    modificado_por     varchar(20),
    fecha_modificacion date,
    fecha              date,
    muestra_estudio    varchar,
    observaciones      varchar
);

alter table lab_examen_frote
    owner to postgres;

create table lab_examen_imagen
(
    cod_examen         integer
        constraint imagen_examen_fk
            references lab_examen,
    cod_frote          integer
        constraint lab_examen_imagen_lab_examen_frote_cod_frote_fk
            references lab_examen_frote,
    cod_biopsia        integer
        constraint lab_examen_imagen_lab_examen_biopsia_cod_biopsia_fk
            references lab_examen_biopsia,
    num_imagen         integer,
    ruta_imagen        varchar,
    nombre_imagen      varchar,
    fecha_creacion     date,
    creado_por         varchar,
    modificado_por     varchar,
    fecha_modificacion date
);

alter table lab_examen_imagen
    owner to postgres;

create table lab_examen_hist_estados
(
    cod_examen         integer
        constraint hist_estados_examen_fk
            references lab_examen,
    cod_frote          integer
        constraint hist_estados_frote_fk
            references lab_examen_frote,
    cod_biopsia        integer
        constraint hist_estados_biopsia_fk
            references lab_examen_biopsia,
    estado             varchar(10),
    fecha_creacion     date,
    creado_por         varchar,
    modificado_por     varchar,
    fecha_modificacion date
);

alter table lab_examen_hist_estados
    owner to postgres;

create table lab_informe
(
    cod_informe     serial not null
        constraint lab_informe_pkey
            primary key,
    fecha_informe   date,
    clinica         varchar,
    direccion       varchar,
    solicitante     varchar,
    datos_clinicos  varchar,
    desc_macros     varchar,
    desc_mirco      varchar,
    diagnostico     integer,
    usuario_informe integer
        constraint usuario_informe_fk
            references lab_usuario,
    cod_frote       integer
        constraint frote_informe_fk
            references lab_examen_frote,
    cod_biopsia     integer
        constraint biopsia_informe_fk
            references lab_examen_biopsia,
	observaciones varchar NULL
);




alter table lab_informe
    owner to postgres;

create table lab_presentacion_medicamento
(
    cod_presentacion   serial      not null
        constraint lab_presentacion_medicamento_pk
            primary key,
    cod_medicamento    integer     not null
        constraint lab_medicamento_fk_cod_medicamento
            references lab_medicamento,
    tipo_presentacion  varchar(30) not null,
    estado_medicamento varchar(20) not null,
    fecha_creacion     date,
    creado_por         varchar(35),
    fecha_modificacion date,
    modificado_por     varchar(35),
    constraint lab_presentacion_uq
        unique (cod_medicamento, tipo_presentacion)
);

alter table lab_presentacion_medicamento
    owner to postgres;

create table lab_examen_receta
(
    cod_receta                   serial not null
        constraint lab_examen_receta_pk
            primary key,
    cod_examen                   integer
        constraint lab_examen_receta_lab_examen_cod_examen_fk
            references lab_examen,
    cod_presentacion_medicamento integer
        constraint lab_examen_receta_tipo_presentacion_fk
            references lab_presentacion_medicamento,
    num_receta                   integer,
    notas                        varchar,
    creado_por                   bigint,
    fecha_creacion               date,
    modificado_por               bigint,
    fecha_modificacion           date
);

alter table lab_examen_receta
    owner to postgres;

    
    -- Drop table

-- DROP TABLE public.lab_examen_seguimiento;

CREATE TABLE public.lab_examen_seguimiento (
	cod_seguimiento serial NOT NULL,
	cod_examen int4 NULL,
	fecha_seguimiento date NULL,
	observaciones varchar NULL,
	observaciones_adicional varchar NULL,
	usuario_seguimiento int8 NULL,
	modificado_por int8 NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_examen_seguimiento_pkey PRIMARY KEY (cod_seguimiento),
	CONSTRAINT lab_examen_seguimiento_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT usuario_seguimiento_fk FOREIGN KEY (usuario_seguimiento) REFERENCES lab_usuario(cod_usuario)
);

alter table lab_examen_seguimiento
    owner to postgres;

create view lab_reporte_examen_vw
            (cod_examen, num_examen, fecha_examen, fec_examen, nombre_paciente, tipo_identificacion, identificacion,
             ocupacion, numero_ficha, enfermedades, diagnosticos_diferenciales, estado_examen, doctor_examen,
             color_lesion, naturaleza_lesion, sintoma_lesion, forma_lesion, superficie_lesion, consistencia_lesion,
             intraoseo_lesion, pieza_lesion, tamano_lesion, dias_lesion, meses_lesion, anios_lesion, doctor_remision,
             dependencia_doctor_remision, req_biopsia, numero_biopsia, fec_biopsia, fecha_biopsia, muestra_biopsia,
             procedimiento, procedimiento_biopsia, tipo_cirugia, tipocirugia_biopsia, instrumento, instrumento_biopsia,
             usuario_biopsia, usuario_realiza_biopsia, estado_biopsia, fecha_informe_biopsia, diagnostico_biopsia,
             usuario_informe_biopsia, req_frote, num_frote, num_muestra_frote, fec_frote, fecha_frote, cod_tincion,
             tincion, usuario_frote, usuario_realiza_frote, estado_frote, fecha_informe_frote,
             diagnostico_informe_frote, usuario_informe_frote)
as
SELECT le.cod_examen,
       le.num_examen,
       le.fecha_examen,
       to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
       concat(lp.nombre, ' ', lp.apellidos)                                   AS nombre_paciente,
       lp.tipo_identificacion,
       lp.identificacion,
       lp.ocupacion,
       COALESCE(lp.num_ficha, ' '::character varying)                         AS numero_ficha,
       (SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
        FROM lab_examen_enfermedad_sistemica lees,
             lab_enfermedad_sistemica les
        WHERE lees.cod_examen = le.cod_examen
          AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica)   AS enfermedades,
       (SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
        FROM lab_examen_diagnostico led,
             lab_diagnostico ld
        WHERE led.cod_examen = le.cod_examen
          AND led.cod_diagnostico = ld.cod_diagnostico)                       AS diagnosticos_diferenciales,
       le.estado_examen,
       concat(lu.nombres_doctor, ' ', lu.apellidos_doctor)                    AS doctor_examen,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'COLOR'::text)                  AS color_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text)             AS naturaleza_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text)                AS sintoma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'FORMA'::text)                  AS forma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text)             AS superficie_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text)           AS consistencia_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text)              AS intraoseo_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text)                  AS pieza_lesion,
       le.tamano_lesion,
       le.duracion_lesion_dias                                                AS dias_lesion,
       le.duracion_lesion_meses                                               AS meses_lesion,
       le.duracion_lesion_anios                                               AS anios_lesion,
       le.doctor_remision,
       le.dependencia_doctor_remision,
       CASE
           WHEN le.necesita_biopsia = false THEN 'No'::text
           ELSE 'Si'::text
END                                                                AS req_biopsia,
       leb.num_biopsia                                                        AS numero_biopsia,
       leb.fecha                                                              AS fec_biopsia,
       to_char(leb.fecha::timestamp with time zone, 'dd/mm/yyyy'::text)       AS fecha_biopsia,
       leb.muestra_estudio                                                    AS muestra_biopsia,
       leb.procedimiento,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.procedimiento = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'PROCEDIMIENTO'::text)          AS procedimiento_biopsia,
       leb.tipo_cirugia,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.tipo_cirugia = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'TIPOCIRUGIA'::text)            AS tipocirugia_biopsia,
       leb.instrumento,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.instrumento = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'INSTRUMENTO'::text)            AS instrumento_biopsia,
       leb.usuario_biopsia,
       (SELECT concat(lu4.nombres_doctor, ' ', lu4.apellidos_doctor) AS concat
        FROM lab_usuario lu4
        WHERE lu4.cod_usuario = leb.usuario_biopsia)                          AS usuario_realiza_biopsia,
       leb.estado_biopsia,
       (SELECT to_char(li2.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_informe_biopsia
        FROM lab_informe li2
        WHERE li2.cod_biopsia = leb.cod_biopsia)                              AS fecha_informe_biopsia,
       (SELECT ld2.nombre_diagnostico
        FROM lab_informe li,
             lab_diagnostico ld2
        WHERE leb.cod_biopsia = li.cod_biopsia
          AND li.diagnostico = ld2.cod_diagnostico)                           AS diagnostico_biopsia,
       (SELECT concat(lu3.nombres_doctor, ' ', lu3.apellidos_doctor) AS concat
        FROM lab_informe li3,
             lab_usuario lu3
        WHERE li3.cod_biopsia = leb.cod_biopsia
          AND li3.usuario_informe = lu3.cod_usuario)                          AS usuario_informe_biopsia,
       CASE
           WHEN le.necesita_frote = false THEN 'No'::text
           ELSE 'Si'::text
END                                                                AS req_frote,
       lef.num_frote,
       lef.muestra_estudio                                                    AS num_muestra_frote,
       lef.fecha                                                              AS fec_frote,
       to_char(lef.fecha::timestamp with time zone, 'dd/mm/yyyy'::text)       AS fecha_frote,
       lef.cod_tincion,
       (SELECT string_agg(lt.nombre_tincion::text, ' ,'::text) AS string_agg
        FROM lab_tincion lt
        WHERE lef.cod_tincion = lt.cod_tincion)                               AS tincion,
       lef.usuario_frote,
       (SELECT concat(lu5.nombres_doctor, ' ', lu5.apellidos_doctor) AS concat
        FROM lab_usuario lu5
        WHERE lu5.cod_usuario = lef.usuario_frote)                            AS usuario_realiza_frote,
       lef.estado_frote,
       (SELECT to_char(li4.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_informe_frote
        FROM lab_informe li4
        WHERE li4.cod_frote = lef.cod_frote)                                  AS fecha_informe_frote,
       (SELECT ld3.nombre_diagnostico
        FROM lab_informe li5,
             lab_diagnostico ld3
        WHERE lef.cod_frote = li5.cod_frote
          AND li5.diagnostico = ld3.cod_diagnostico)                          AS diagnostico_informe_frote,
       (SELECT concat(lu2.nombres_doctor, ' ', lu2.apellidos_doctor) AS concat
        FROM lab_informe li6,
             lab_usuario lu2
        WHERE lef.cod_frote = li6.cod_frote
          AND li6.usuario_informe = lu2.cod_usuario)                          AS usuario_informe_frote
FROM lab_examen le
         JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
         JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
         LEFT JOIN lab_examen_biopsia leb ON le.cod_examen = leb.cod_examen
         LEFT JOIN lab_examen_frote lef ON le.cod_examen = lef.cod_examen
ORDER BY le.cod_examen;

alter table lab_reporte_examen_vw
    owner to postgres;

create view lab_reporte_biopsia_vw
            (cod_examen, num_examen, fecha_examen, fec_examen, nombre_paciente, tipo_identificacion, identificacion,
             ocupacion, numero_ficha, enfermedades, diagnosticos_diferenciales, estado_examen, doctor_examen,
             color_lesion, naturaleza_lesion, sintoma_lesion, forma_lesion, superficie_lesion, consistencia_lesion,
             intraoseo_lesion, pieza_lesion, tamano_lesion, dias_lesion, meses_lesion, anios_lesion, doctor_remision,
             dependencia_doctor_remision, req_biopsia, numero_biopsia, fec_biopsia, fecha_biopsia, muestra_biopsia,
             procedimiento, procedimiento_biopsia, tipo_cirugia, tipocirugia_biopsia, instrumento, instrumento_biopsia,
             usuario_biopsia, usuario_realiza_biopsia, estado_biopsia, datos_recibo, valor_recibo,
             fecha_informe_biopsia, diagnostico_biopsia, usuario_informe_biopsia)
as
SELECT le.cod_examen,
       le.num_examen,
       le.fecha_examen,
       to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
       concat(lp.nombre, ' ', lp.apellidos)                                   AS nombre_paciente,
       lp.tipo_identificacion,
       lp.identificacion,
       lp.ocupacion,
       COALESCE(lp.num_ficha, ' '::character varying)                         AS numero_ficha,
       (SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
        FROM lab_examen_enfermedad_sistemica lees,
             lab_enfermedad_sistemica les
        WHERE lees.cod_examen = le.cod_examen
          AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica)   AS enfermedades,
       (SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
        FROM lab_examen_diagnostico led,
             lab_diagnostico ld
        WHERE led.cod_examen = le.cod_examen
          AND led.cod_diagnostico = ld.cod_diagnostico)                       AS diagnosticos_diferenciales,
       le.estado_examen,
       concat(lu.nombres_doctor, ' ', lu.apellidos_doctor)                    AS doctor_examen,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'COLOR'::text)                  AS color_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text)             AS naturaleza_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text)                AS sintoma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'FORMA'::text)                  AS forma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text)             AS superficie_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text)           AS consistencia_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text)              AS intraoseo_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text)                  AS pieza_lesion,
       le.tamano_lesion,
       le.duracion_lesion_dias                                                AS dias_lesion,
       le.duracion_lesion_meses                                               AS meses_lesion,
       le.duracion_lesion_anios                                               AS anios_lesion,
       le.doctor_remision,
       le.dependencia_doctor_remision,
       CASE
           WHEN le.necesita_biopsia = false THEN 'No'::text
           ELSE 'Si'::text
END                                                                AS req_biopsia,
       leb.num_biopsia                                                        AS numero_biopsia,
       leb.fecha                                                              AS fec_biopsia,
       to_char(leb.fecha::timestamp with time zone, 'dd/mm/yyyy'::text)       AS fecha_biopsia,
       leb.muestra_estudio                                                    AS muestra_biopsia,
       leb.procedimiento,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.procedimiento = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'PROCEDIMIENTO'::text)          AS procedimiento_biopsia,
       leb.tipo_cirugia,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.tipo_cirugia = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'TIPOCIRUGIA'::text)            AS tipocirugia_biopsia,
       leb.instrumento,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_tipo_opcion_lesion ltol
        WHERE leb.instrumento = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'INSTRUMENTO'::text)            AS instrumento_biopsia,
       leb.usuario_biopsia,
       (SELECT concat(lu4.nombres_doctor, ' ', lu4.apellidos_doctor) AS concat
        FROM lab_usuario lu4
        WHERE lu4.cod_usuario = leb.usuario_biopsia)                          AS usuario_realiza_biopsia,
       leb.estado_biopsia,
       concat(leb.serie_recibo, '-', leb.num_recibo)                          AS datos_recibo,
       leb.monto_recibo                                                       AS valor_recibo,
       (SELECT to_char(li2.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_informe_biopsia
        FROM lab_informe li2
        WHERE li2.cod_biopsia = leb.cod_biopsia)                              AS fecha_informe_biopsia,
       (SELECT ld2.nombre_diagnostico
        FROM lab_informe li,
             lab_diagnostico ld2
        WHERE leb.cod_biopsia = li.cod_biopsia
          AND li.diagnostico = ld2.cod_diagnostico)                           AS diagnostico_biopsia,
       (SELECT concat(lu3.nombres_doctor, ' ', lu3.apellidos_doctor) AS concat
        FROM lab_informe li3,
             lab_usuario lu3
        WHERE li3.cod_biopsia = leb.cod_biopsia
          AND li3.usuario_informe = lu3.cod_usuario)                          AS usuario_informe_biopsia
FROM lab_examen le
         JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
         JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
         JOIN lab_examen_biopsia leb ON le.cod_examen = leb.cod_examen
ORDER BY le.cod_examen, leb.fecha;

alter table lab_reporte_biopsia_vw
    owner to postgres;

create view lab_reporte_frote_vw
            (cod_examen, num_examen, fecha_examen, fec_examen, nombre_paciente, tipo_identificacion, identificacion,
             ocupacion, numero_ficha, enfermedades, diagnosticos_diferenciales, estado_examen, doctor_examen,
             color_lesion, naturaleza_lesion, sintoma_lesion, forma_lesion, superficie_lesion, consistencia_lesion,
             intraoseo_lesion, pieza_lesion, tamano_lesion, dias_lesion, meses_lesion, anios_lesion, doctor_remision,
             dependencia_doctor_remision, req_frote, num_frote, num_muestra_frote, fec_frote, fecha_frote, cod_tincion,
             tincion, datos_recibo, valor_recibo, usuario_frote, usuario_realiza_frote, estado_frote,
             fecha_informe_frote, diagnostico_informe_frote, usuario_informe_frote)
as
SELECT le.cod_examen,
       le.num_examen,
       le.fecha_examen,
       to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
       concat(lp.nombre, ' ', lp.apellidos)                                   AS nombre_paciente,
       lp.tipo_identificacion,
       lp.identificacion,
       lp.ocupacion,
       COALESCE(lp.num_ficha, ' '::character varying)                         AS numero_ficha,
       (SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
        FROM lab_examen_enfermedad_sistemica lees,
             lab_enfermedad_sistemica les
        WHERE lees.cod_examen = le.cod_examen
          AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica)   AS enfermedades,
       (SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
        FROM lab_examen_diagnostico led,
             lab_diagnostico ld
        WHERE led.cod_examen = le.cod_examen
          AND led.cod_diagnostico = ld.cod_diagnostico)                       AS diagnosticos_diferenciales,
       le.estado_examen,
       concat(lu.nombres_doctor, ' ', lu.apellidos_doctor)                    AS doctor_examen,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'COLOR'::text)                  AS color_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text)             AS naturaleza_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text)                AS sintoma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'FORMA'::text)                  AS forma_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text)             AS superficie_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text)           AS consistencia_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text)              AS intraoseo_lesion,
       (SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
        FROM lab_examen_caracteristica lec,
             lab_tipo_opcion_lesion ltol
        WHERE lec.cod_examen = le.cod_examen
          AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion
          AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text)                  AS pieza_lesion,
       le.tamano_lesion,
       le.duracion_lesion_dias                                                AS dias_lesion,
       le.duracion_lesion_meses                                               AS meses_lesion,
       le.duracion_lesion_anios                                               AS anios_lesion,
       le.doctor_remision,
       le.dependencia_doctor_remision,
       CASE
           WHEN le.necesita_frote = false THEN 'No'::text
           ELSE 'Si'::text
END                                                                AS req_frote,
       lef.num_frote,
       lef.muestra_estudio                                                    AS num_muestra_frote,
       lef.fecha                                                              AS fec_frote,
       to_char(lef.fecha::timestamp with time zone, 'dd/mm/yyyy'::text)       AS fecha_frote,
       lef.cod_tincion,
       (SELECT string_agg(lt.nombre_tincion::text, ' ,'::text) AS string_agg
        FROM lab_tincion lt
        WHERE lef.cod_tincion = lt.cod_tincion)                               AS tincion,
       concat(lef.serie_recibo, '-', lef.num_recibo)                          AS datos_recibo,
       lef.monto_recibo                                                       AS valor_recibo,
       lef.usuario_frote,
       (SELECT concat(lu5.nombres_doctor, ' ', lu5.apellidos_doctor) AS concat
        FROM lab_usuario lu5
        WHERE lu5.cod_usuario = lef.usuario_frote)                            AS usuario_realiza_frote,
       lef.estado_frote,
       (SELECT to_char(li4.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_informe_frote
        FROM lab_informe li4
        WHERE li4.cod_frote = lef.cod_frote)                                  AS fecha_informe_frote,
       (SELECT ld3.nombre_diagnostico
        FROM lab_informe li5,
             lab_diagnostico ld3
        WHERE lef.cod_frote = li5.cod_frote
          AND li5.diagnostico = ld3.cod_diagnostico)                          AS diagnostico_informe_frote,
       (SELECT concat(lu2.nombres_doctor, ' ', lu2.apellidos_doctor) AS concat
        FROM lab_informe li6,
             lab_usuario lu2
        WHERE lef.cod_frote = li6.cod_frote
          AND li6.usuario_informe = lu2.cod_usuario)                          AS usuario_informe_frote
FROM lab_examen le
         JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
         JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
         JOIN lab_examen_frote lef ON le.cod_examen = lef.cod_examen
ORDER BY le.cod_examen;

alter table lab_reporte_frote_vw
    owner to postgres;

