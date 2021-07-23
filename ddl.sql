create table lab_diagnostico
(
    cod_diagnostico    bigint default nextval('lab_diagnostico_seq'::regclass) not null
        constraint lab_diagnostico_pk
            primary key,
    nombre_diagnostico varchar(35)                                             not null,
    estado_diagnostico varchar(20)                                             not null,
    fecha_creacion     date,
    creado_por         varchar(35),
    fecha_modificacion date,
    modificado_por     varchar(35)
);

alter table lab_diagnostico
    owner to postgres;

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
    fecha_planificada  date,
    tipo_biopsia       varchar(20),
    num_recibo         varchar(10),
    serie_recibo       varchar(10),
    monto_recibo       numeric,
    estado_enfermedad  varchar(20),
    modificado_por     varchar(30),
    fecha_modificacion date
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

create table lab_examen_imagen
(
    cod_examen         integer
        constraint imagen_examen_fk
            references lab_examen,
    num_frote          varchar(20),
    num_biopsia        varchar(20)
        constraint imagen_biopsia_fk
            references lab_examen_biopsia (num_biopsia),
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

create table lab_presentacion_medicamento
(
    cod_medicamento    integer     not null
        constraint lab_medicamento_fk_cod_medicamento
            references lab_medicamento,
    tipo_presentacion  varchar(30) not null,
    estado_medicamento varchar(20) not null,
    fecha_creacion     date,
    creado_por         varchar(35),
    fecha_modificacion date,
    modificado_por     varchar(35),
    constraint lab_presentacion_medicamento_pk
        primary key (cod_medicamento, tipo_presentacion)
);

alter table lab_presentacion_medicamento
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
    monto_recibo       varchar(20),
    cod_tincion        integer
        constraint cod_tincion_fk
            references lab_tincion,
    estado_frote       varchar(20),
    usuario_frote      integer
        constraint frote_usuario_fk
            references lab_usuario,
    modificado_por     varchar(20),
    fecha_modificacion date
);

alter table lab_examen_frote
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

