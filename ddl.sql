-- public.lab_diagnostico_seq definition

-- DROP SEQUENCE public.lab_diagnostico_seq;

CREATE SEQUENCE public.lab_diagnostico_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_enfermedad_sistemica_seq definition

-- DROP SEQUENCE public.lab_enfermedad_sistemica_seq;

CREATE SEQUENCE public.lab_enfermedad_sistemica_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_biopsia_cod_biopsia_seq definition

-- DROP SEQUENCE public.lab_examen_biopsia_cod_biopsia_seq;

CREATE SEQUENCE public.lab_examen_biopsia_cod_biopsia_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_biopsia_cod_biopsia_seq1 definition

-- DROP SEQUENCE public.lab_examen_biopsia_cod_biopsia_seq1;

CREATE SEQUENCE public.lab_examen_biopsia_cod_biopsia_seq1
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_caracteristica_cod_examen_seq definition

-- DROP SEQUENCE public.lab_examen_caracteristica_cod_examen_seq;

CREATE SEQUENCE public.lab_examen_caracteristica_cod_examen_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_caracteristica_cod_examen_seq1 definition

-- DROP SEQUENCE public.lab_examen_caracteristica_cod_examen_seq1;

CREATE SEQUENCE public.lab_examen_caracteristica_cod_examen_seq1
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_cod_examen_seq definition

-- DROP SEQUENCE public.lab_examen_cod_examen_seq;

CREATE SEQUENCE public.lab_examen_cod_examen_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_examen_cod_examen_seq1 definition

-- DROP SEQUENCE public.lab_examen_cod_examen_seq1;

CREATE SEQUENCE public.lab_examen_cod_examen_seq1
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_medicamento_seq definition

-- DROP SEQUENCE public.lab_medicamento_seq;

CREATE SEQUENCE public.lab_medicamento_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_paciente_seq definition

-- DROP SEQUENCE public.lab_paciente_seq;

CREATE SEQUENCE public.lab_paciente_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_tincion_seq definition

-- DROP SEQUENCE public.lab_tincion_seq;

CREATE SEQUENCE public.lab_tincion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_tipo_opcion_lesion_seq definition

-- DROP SEQUENCE public.lab_tipo_opcion_lesion_seq;

CREATE SEQUENCE public.lab_tipo_opcion_lesion_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.lab_usuario_seq definition

-- DROP SEQUENCE public.lab_usuario_seq;

CREATE SEQUENCE public.lab_usuario_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- public.lab_diagnostico definition

-- Drop table

-- DROP TABLE public.lab_diagnostico;

CREATE TABLE public.lab_diagnostico (
	cod_diagnostico int8 NOT NULL DEFAULT nextval('lab_diagnostico_seq'::regclass),
	nombre_diagnostico varchar(35) NOT NULL,
	tipo_diagnostico varchar(20) NULL,
	estado_diagnostico varchar(20) NOT NULL,
	fecha_creacion date NULL,
	creado_por varchar(35) NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(35) NULL,
	CONSTRAINT lab_diagnostico_pk PRIMARY KEY (cod_diagnostico)
);


-- public.lab_enfermedad_sistemica definition

-- Drop table

-- DROP TABLE public.lab_enfermedad_sistemica;

CREATE TABLE public.lab_enfermedad_sistemica (
	cod_enfermedad_sistemica int4 NOT NULL DEFAULT nextval('lab_enfermedad_sistemica_seq'::regclass),
	nombre_enfermedad varchar(30) NOT NULL,
	estado_enfermedad varchar(10) NULL,
	fecha_creacion date NULL,
	creado_por varchar(30) NULL,
	modificado_por varchar(30) NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_enf_sistemica_pk PRIMARY KEY (cod_enfermedad_sistemica)
);


-- public.lab_medicamento definition

-- Drop table

-- DROP TABLE public.lab_medicamento;

CREATE TABLE public.lab_medicamento (
	cod_medicamento int4 NOT NULL DEFAULT nextval('lab_medicamento_seq'::regclass),
	nombre_medicamento varchar(35) NOT NULL,
	estado_medicamento varchar(20) NOT NULL,
	fecha_creacion date NULL,
	creado_por varchar(35) NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(35) NULL,
	tipo_medicamento int4 NULL,
	CONSTRAINT lab_medicamento_pk PRIMARY KEY (cod_medicamento)
);


-- public.lab_paciente definition

-- Drop table

-- DROP TABLE public.lab_paciente;

CREATE TABLE public.lab_paciente (
	cod_paciente int8 NOT NULL DEFAULT nextval('lab_paciente_seq'::regclass),
	nombre varchar(60) NOT NULL,
	apellidos varchar(60) NOT NULL,
	email varchar(50) NULL,
	identificacion varchar(45) NULL,
	direccion varchar(250) NULL,
	telefono varchar(20) NULL,
	estadocivil varchar(15) NULL,
	fechanacimiento date NULL,
	genero varchar(15) NULL,
	ocupacion varchar(50) NULL,
	tipo_identificacion varchar(15) NULL,
	creadopor varchar(20) NULL,
	fechacreacion date NULL,
	modificadopor varchar(20) NULL,
	fechamodificacion date NULL,
	CONSTRAINT lab_paciente_pk PRIMARY KEY (cod_paciente)
);


-- public.lab_tincion definition

-- Drop table

-- DROP TABLE public.lab_tincion;

CREATE TABLE public.lab_tincion (
	cod_tincion int4 NOT NULL DEFAULT nextval('lab_tincion_seq'::regclass),
	nombre_tincion varchar(35) NOT NULL,
	estado_tincion varchar(10) NULL,
	fecha_creacion date NULL,
	creado_por varchar(35) NULL,
	modificado_por varchar(35) NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_tincion_pk PRIMARY KEY (cod_tincion)
);


-- public.lab_tipo_opcion_lesion definition

-- Drop table

-- DROP TABLE public.lab_tipo_opcion_lesion;

CREATE TABLE public.lab_tipo_opcion_lesion (
	cod_tipo_opcion_lesion int4 NOT NULL DEFAULT nextval('lab_tipo_opcion_lesion_seq'::regclass),
	nombre_tipo_opcion varchar(35) NOT NULL,
	valor_tipo_opcion varchar(20) NOT NULL,
	estado_tipo_opcion varchar(10) NOT NULL,
	fecha_creacion date NULL,
	creado_por varchar(35) NULL,
	modificado_por varchar(35) NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_tip_opcion_lesion_pk PRIMARY KEY (cod_tipo_opcion_lesion)
);


-- public.lab_usuario definition

-- Drop table

-- DROP TABLE public.lab_usuario;

CREATE TABLE public.lab_usuario (
	cod_usuario int8 NOT NULL DEFAULT nextval('lab_usuario_seq'::regclass),
	login_usuario varchar(20) NOT NULL,
	nombres_doctor varchar(50) NOT NULL,
	apellidos_doctor varchar(50) NOT NULL,
	num_colegiado varchar(15) NULL,
	password varchar(60) NOT NULL,
	estado varchar(20) NOT NULL,
	emailusuario varchar(50) NULL,
	tipo_usuario varchar(3) NOT NULL,
	rol_usuario varchar(2) NULL,
	creadopor varchar(20) NULL,
	fechacreacion date NULL,
	modificadopor varchar(20) NULL,
	fechamodificacion date NULL,
	llave varchar(50) NULL,
	CONSTRAINT lab_usuario_pk PRIMARY KEY (cod_usuario)
);


-- public.lab_examen definition

-- Drop table

-- DROP TABLE public.lab_examen;

CREATE TABLE public.lab_examen (
	cod_examen serial NOT NULL,
	cod_paciente int8 NULL,
	num_examen varchar(20) NULL,
	fecha_examen date NULL,
	estado_examen varchar(25) NULL,
	historia_examen_lesion varchar(200) NULL,
	tamano_lesion varchar(15) NULL,
	dimensional_lesion varchar(20) NULL,
	duracion_lesion_dias int4 NULL,
	duracion_lesion_meses int4 NULL,
	duracion_lesion_anios int4 NULL,
	datos_importantes_lesion varchar(200) NULL,
	doctor_examen int8 NULL,
	tipo_remision varchar(20) NULL,
	doctor_remision varchar(30) NULL,
	direccion_doctor_remision varchar(50) NULL,
	telefono_doctor_remision varchar(50) NULL,
	email_doctor_remision varchar(50) NULL,
	dependencia_doctor_remision varchar(50) NULL,
	registro_doctor_remision varchar(50) NULL,
	necesita_biopsia boolean NULL,
	necesita_frote boolean NULL,
	CONSTRAINT lab_examen_pkey PRIMARY KEY (cod_examen),
	CONSTRAINT cod_paciente_fk FOREIGN KEY (cod_paciente) REFERENCES lab_paciente(cod_paciente),
	CONSTRAINT doctor_examen_fk FOREIGN KEY (doctor_examen) REFERENCES lab_usuario(cod_usuario)
);


-- public.lab_examen_biopsia definition

-- Drop table

-- DROP TABLE public.lab_examen_biopsia;

CREATE TABLE public.lab_examen_biopsia (
	cod_biopsia serial NOT NULL,
	cod_examen int4 NULL,
	num_biopsia varchar(20) NULL,
	usuario_biopsia int4 NULL,
	fecha_planificada date NULL,
	tipo_biopsia varchar(20) NULL,
	num_recibo varchar(10) NULL,
	serie_recibo varchar(10) NULL,
	monto_recibo numeric NULL,
	estado_enfermedad varchar(20) NULL,
	modificado_por varchar(30) NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_examen_biopsia_pkey PRIMARY KEY (cod_biopsia),
	CONSTRAINT num_biopsia_uq UNIQUE (num_biopsia),
	CONSTRAINT cod_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT usuario_biopsia_fk FOREIGN KEY (usuario_biopsia) REFERENCES lab_usuario(cod_usuario)
);


-- public.lab_examen_caracteristica definition

-- Drop table

-- DROP TABLE public.lab_examen_caracteristica;

CREATE TABLE public.lab_examen_caracteristica (
	cod_examen serial NOT NULL,
	codigo_tipo_opcion_lesion int4 NULL,
	fecha_creacion date NULL,
	creado_por varchar(20) NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(20) NULL,
	constraint fk_lab_tipo_opcion_lesion_fk foreign key (codigo_tipo_opcion_lesion) references lab_tipo_opcion_lesion(cod_tipo_opcion_lesion),
    constraint fk_lab_examen_caracteristica_fk foreign key (cod_examen) references lab_examen(cod_examen),
    constraint lab_examen_caracteristica_pk primary key (cod_examen, codigo_tipo_opcion_lesion)
);


-- public.lab_examen_diagnostico definition

-- Drop table

-- DROP TABLE public.lab_examen_diagnostico;

CREATE TABLE public.lab_examen_diagnostico (
	cod_examen int4 NOT NULL,
	cod_diagnostico int4 NOT NULL,
	indice_diagnostico int4 NULL,
	tipo_diagnostico int4 NULL,
	fecha_creacion date NULL,
	creado_por int4 NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(30) NULL,
	CONSTRAINT examen_diagnostico_pk PRIMARY KEY (cod_examen, cod_diagnostico),
	CONSTRAINT examen_diagnostico_diagnostico_fk FOREIGN KEY (cod_diagnostico) REFERENCES lab_diagnostico(cod_diagnostico),
	CONSTRAINT examen_diagnostico_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT examen_diagnostico_usuario_fk FOREIGN KEY (creado_por) REFERENCES lab_usuario(cod_usuario)
);


-- public.lab_examen_enfermedad_sistemica definition

-- Drop table

-- DROP TABLE public.lab_examen_enfermedad_sistemica;

CREATE TABLE public.lab_examen_enfermedad_sistemica (
	cod_examen int4 NOT NULL,
	cod_enfermedad_sistemica int4 NOT NULL,
	fecha_creacion date NULL,
	creado_por varchar(20) NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(20) NULL,
	CONSTRAINT lab_examen_enfermedad_sistemica_pk PRIMARY KEY (cod_examen, cod_enfermedad_sistemica),
	CONSTRAINT cod_enfermedad_sistemica_fk FOREIGN KEY (cod_enfermedad_sistemica) REFERENCES lab_enfermedad_sistemica(cod_enfermedad_sistemica),
	CONSTRAINT cod_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen)
);


-- public.lab_examen_frote definition

-- Drop table

-- DROP TABLE public.lab_examen_frote;

CREATE TABLE public.lab_examen_frote (
	cod_examen int4 NULL,
	num_frote varchar(20) NOT NULL,
	num_biopsia int4 NULL,
	cod_tincion int4 NULL,
	estado_frote varchar(20) NULL,
	usuario_frote int4 NULL,
	modificado_por varchar(20) NULL,
	fecha_modificacion date NULL,
	CONSTRAINT lab_examen_frote_pkey PRIMARY KEY (num_frote),
	CONSTRAINT num_frote_uq UNIQUE (num_frote),
	CONSTRAINT cod_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT cod_tincion_fk FOREIGN KEY (cod_tincion) REFERENCES lab_tincion(cod_tincion),
	CONSTRAINT frote_usuario_fk FOREIGN KEY (usuario_frote) REFERENCES lab_usuario(cod_usuario)
);


-- public.lab_examen_hist_estados definition

-- Drop table

-- DROP TABLE public.lab_examen_hist_estados;

CREATE TABLE public.lab_examen_hist_estados (
	cod_examen int4 NULL,
	num_frote varchar(20) NULL,
	num_biopsia varchar(20) NULL,
	estado varchar(10) NULL,
	fecha_creacion date NULL,
	creado_por varchar NULL,
	modificado_por varchar NULL,
	fecha_modificacion date NULL,
	CONSTRAINT hist_estados_biopsia_fk FOREIGN KEY (num_biopsia) REFERENCES lab_examen_biopsia(num_biopsia),
	CONSTRAINT hist_estados_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT hist_estados_frote_fk FOREIGN KEY (num_frote) REFERENCES lab_examen_frote(num_frote)
);


-- public.lab_examen_imagen definition

-- Drop table

-- DROP TABLE public.lab_examen_imagen;

CREATE TABLE public.lab_examen_imagen (
	cod_examen int4 NULL,
	num_frote varchar(20) NULL,
	num_biopsia varchar(20) NULL,
	num_imagen int4 NULL,
	ruta_imagen varchar NULL,
	nombre_imagen varchar NULL,
	fecha_creacion date NULL,
	creado_por varchar NULL,
	modificado_por varchar NULL,
	fecha_modificacion date NULL,
	CONSTRAINT imagen_biopsia_fk FOREIGN KEY (num_biopsia) REFERENCES lab_examen_biopsia(num_biopsia),
	CONSTRAINT imagen_examen_fk FOREIGN KEY (cod_examen) REFERENCES lab_examen(cod_examen),
	CONSTRAINT imagen_frote_fk FOREIGN KEY (num_frote) REFERENCES lab_examen_frote(num_frote)
);


-- public.lab_presentacion_medicamento definition

-- Drop table

-- DROP TABLE public.lab_presentacion_medicamento;

CREATE TABLE public.lab_presentacion_medicamento (
	cod_medicamento int4 NOT NULL,
	tipo_presentacion varchar(30) NOT NULL,
	estado_medicamento varchar(20) NOT NULL,
	fecha_creacion date NULL,
	creado_por varchar(35) NULL,
	fecha_modificacion date NULL,
	modificado_por varchar(35) NULL,
	CONSTRAINT lab_presentacion_medicamento_pk PRIMARY KEY (cod_medicamento, tipo_presentacion),
	CONSTRAINT lab_medicamento_fk_cod_medicamento FOREIGN KEY (cod_medicamento) REFERENCES lab_medicamento(cod_medicamento)
);
