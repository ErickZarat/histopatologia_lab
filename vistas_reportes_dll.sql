-- public.lab_reporte_biopsia_vw source

CREATE OR REPLACE VIEW public.lab_reporte_biopsia_vw
AS SELECT le.cod_examen,
    le.num_examen,
    le.fecha_examen,
    to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
    concat(lp.nombre, ' ', lp.apellidos) AS nombre_paciente,
    lp.tipo_identificacion,
    lp.identificacion,
    lp.ocupacion,
    COALESCE(lp.num_ficha, ' '::character varying) AS numero_ficha,
    ( SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
           FROM lab_examen_enfermedad_sistemica lees,
            lab_enfermedad_sistemica les
          WHERE lees.cod_examen = le.cod_examen AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica) AS enfermedades,
    ( SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
           FROM lab_examen_diagnostico led,
            lab_diagnostico ld
          WHERE led.cod_examen = le.cod_examen AND led.cod_diagnostico = ld.cod_diagnostico) AS diagnosticos_diferenciales,
    le.estado_examen,
    concat(lu.nombres_doctor, ' ', lu.apellidos_doctor) AS doctor_examen,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'COLOR'::text) AS color_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text) AS naturaleza_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text) AS sintoma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'FORMA'::text) AS forma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text) AS superficie_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text) AS consistencia_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text) AS intraoseo_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text) AS pieza_lesion,
    le.tamano_lesion,
    le.duracion_lesion_dias AS dias_lesion,
    le.duracion_lesion_meses AS meses_lesion,
    le.duracion_lesion_anios AS anios_lesion,
    le.doctor_remision,
    le.dependencia_doctor_remision,
        CASE
            WHEN le.necesita_biopsia = false THEN 'No'::text
            ELSE 'Si'::text
        END AS req_biopsia,
    leb.num_biopsia AS numero_biopsia,
    leb.fecha AS fec_biopsia,
    to_char(leb.fecha::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_biopsia,
    leb.muestra_estudio AS muestra_biopsia,
    leb.procedimiento,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.procedimiento = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'PROCEDIMIENTO'::text) AS procedimiento_biopsia,
    leb.tipo_cirugia,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.tipo_cirugia = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'TIPOCIRUGIA'::text) AS tipocirugia_biopsia,
    leb.instrumento,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.instrumento = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'INSTRUMENTO'::text) AS instrumento_biopsia,
    leb.usuario_biopsia,
    ( SELECT concat(lu4.nombres_doctor, ' ', lu4.apellidos_doctor) AS concat
           FROM lab_usuario lu4
          WHERE lu4.cod_usuario = leb.usuario_biopsia) AS usuario_realiza_biopsia,
    leb.estado_biopsia,
    concat(leb.serie_recibo, '-', leb.num_recibo) AS datos_recibo,
    leb.monto_recibo AS valor_recibo,
    ( SELECT to_char(li2.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_informe_biopsia
           FROM lab_informe li2
          WHERE li2.cod_biopsia = leb.cod_biopsia) AS fecha_informe_biopsia,
    ( SELECT ld2.nombre_diagnostico
           FROM lab_informe li,
            lab_diagnostico ld2
          WHERE leb.cod_biopsia = li.cod_biopsia AND li.diagnostico = ld2.cod_diagnostico) AS diagnostico_biopsia,
    ( SELECT concat(lu3.nombres_doctor, ' ', lu3.apellidos_doctor) AS concat
           FROM lab_informe li3,
            lab_usuario lu3
          WHERE li3.cod_biopsia = leb.cod_biopsia AND li3.usuario_informe = lu3.cod_usuario) AS usuario_informe_biopsia
   FROM lab_examen le
     JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
     JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
     JOIN lab_examen_biopsia leb ON le.cod_examen = leb.cod_examen
  ORDER BY le.cod_examen, leb.fecha;

-- Permissions

ALTER TABLE public.lab_reporte_biopsia_vw OWNER TO postgres;
GRANT ALL ON TABLE public.lab_reporte_biopsia_vw TO postgres;


-- public.lab_reporte_examen_vw source

CREATE OR REPLACE VIEW public.lab_reporte_examen_vw
AS SELECT le.cod_examen,
    le.num_examen,
    le.fecha_examen,
    to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
    concat(lp.nombre, ' ', lp.apellidos) AS nombre_paciente,
    lp.tipo_identificacion,
    lp.identificacion,
    lp.ocupacion,
    COALESCE(lp.num_ficha, ' '::character varying) AS numero_ficha,
    ( SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
           FROM lab_examen_enfermedad_sistemica lees,
            lab_enfermedad_sistemica les
          WHERE lees.cod_examen = le.cod_examen AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica) AS enfermedades,
    ( SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
           FROM lab_examen_diagnostico led,
            lab_diagnostico ld
          WHERE led.cod_examen = le.cod_examen AND led.cod_diagnostico = ld.cod_diagnostico) AS diagnosticos_diferenciales,
    le.estado_examen,
    concat(lu.nombres_doctor, ' ', lu.apellidos_doctor) AS doctor_examen,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'COLOR'::text) AS color_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text) AS naturaleza_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text) AS sintoma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'FORMA'::text) AS forma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text) AS superficie_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text) AS consistencia_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text) AS intraoseo_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text) AS pieza_lesion,
    le.tamano_lesion,
    le.duracion_lesion_dias AS dias_lesion,
    le.duracion_lesion_meses AS meses_lesion,
    le.duracion_lesion_anios AS anios_lesion,
    le.doctor_remision,
    le.dependencia_doctor_remision,
        CASE
            WHEN le.necesita_biopsia = false THEN 'No'::text
            ELSE 'Si'::text
        END AS req_biopsia,
    leb.num_biopsia AS numero_biopsia,
    leb.fecha AS fec_biopsia,
    to_char(leb.fecha::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_biopsia,
    leb.muestra_estudio AS muestra_biopsia,
    leb.procedimiento,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.procedimiento = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'PROCEDIMIENTO'::text) AS procedimiento_biopsia,
    leb.tipo_cirugia,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.tipo_cirugia = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'TIPOCIRUGIA'::text) AS tipocirugia_biopsia,
    leb.instrumento,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_tipo_opcion_lesion ltol
          WHERE leb.instrumento = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'INSTRUMENTO'::text) AS instrumento_biopsia,
    leb.usuario_biopsia,
    ( SELECT concat(lu4.nombres_doctor, ' ', lu4.apellidos_doctor) AS concat
           FROM lab_usuario lu4
          WHERE lu4.cod_usuario = leb.usuario_biopsia) AS usuario_realiza_biopsia,
    leb.estado_biopsia,
    ( SELECT to_char(li2.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_informe_biopsia
           FROM lab_informe li2
          WHERE li2.cod_biopsia = leb.cod_biopsia) AS fecha_informe_biopsia,
    ( SELECT ld2.nombre_diagnostico
           FROM lab_informe li,
            lab_diagnostico ld2
          WHERE leb.cod_biopsia = li.cod_biopsia AND li.diagnostico = ld2.cod_diagnostico) AS diagnostico_biopsia,
    ( SELECT concat(lu3.nombres_doctor, ' ', lu3.apellidos_doctor) AS concat
           FROM lab_informe li3,
            lab_usuario lu3
          WHERE li3.cod_biopsia = leb.cod_biopsia AND li3.usuario_informe = lu3.cod_usuario) AS usuario_informe_biopsia,
        CASE
            WHEN le.necesita_frote = false THEN 'No'::text
            ELSE 'Si'::text
        END AS req_frote,
    lef.num_frote,
    lef.muestra_estudio AS num_muestra_frote,
    lef.fecha AS fec_frote,
    to_char(lef.fecha::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_frote,
    lef.cod_tincion,
    ( SELECT string_agg(lt.nombre_tincion::text, ' ,'::text) AS string_agg
           FROM lab_tincion lt
          WHERE lef.cod_tincion = lt.cod_tincion) AS tincion,
    lef.usuario_frote,
    ( SELECT concat(lu5.nombres_doctor, ' ', lu5.apellidos_doctor) AS concat
           FROM lab_usuario lu5
          WHERE lu5.cod_usuario = lef.usuario_frote) AS usuario_realiza_frote,
    lef.estado_frote,
    ( SELECT to_char(li4.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_informe_frote
           FROM lab_informe li4
          WHERE li4.cod_frote = lef.cod_frote) AS fecha_informe_frote,
    ( SELECT ld3.nombre_diagnostico
           FROM lab_informe li5,
            lab_diagnostico ld3
          WHERE lef.cod_frote = li5.cod_frote AND li5.diagnostico = ld3.cod_diagnostico) AS diagnostico_informe_frote,
    ( SELECT concat(lu2.nombres_doctor, ' ', lu2.apellidos_doctor) AS concat
           FROM lab_informe li6,
            lab_usuario lu2
          WHERE lef.cod_frote = li6.cod_frote AND li6.usuario_informe = lu2.cod_usuario) AS usuario_informe_frote
   FROM lab_examen le
     JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
     JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
     LEFT JOIN lab_examen_biopsia leb ON le.cod_examen = leb.cod_examen
     LEFT JOIN lab_examen_frote lef ON le.cod_examen = lef.cod_examen
  ORDER BY le.cod_examen;

-- Permissions

ALTER TABLE public.lab_reporte_examen_vw OWNER TO postgres;
GRANT ALL ON TABLE public.lab_reporte_examen_vw TO postgres;


-- public.lab_reporte_frote_vw source

CREATE OR REPLACE VIEW public.lab_reporte_frote_vw
AS SELECT le.cod_examen,
    le.num_examen,
    le.fecha_examen,
    to_char(le.fecha_examen::timestamp with time zone, 'dd/mm/yyyy'::text) AS fec_examen,
    concat(lp.nombre, ' ', lp.apellidos) AS nombre_paciente,
    lp.tipo_identificacion,
    lp.identificacion,
    lp.ocupacion,
    COALESCE(lp.num_ficha, ' '::character varying) AS numero_ficha,
    ( SELECT string_agg(les.nombre_enfermedad::text, ' ,'::text) AS string_agg
           FROM lab_examen_enfermedad_sistemica lees,
            lab_enfermedad_sistemica les
          WHERE lees.cod_examen = le.cod_examen AND lees.cod_enfermedad_sistemica = les.cod_enfermedad_sistemica) AS enfermedades,
    ( SELECT string_agg(ld.nombre_diagnostico::text, ' ,'::text) AS string_agg
           FROM lab_examen_diagnostico led,
            lab_diagnostico ld
          WHERE led.cod_examen = le.cod_examen AND led.cod_diagnostico = ld.cod_diagnostico) AS diagnosticos_diferenciales,
    le.estado_examen,
    concat(lu.nombres_doctor, ' ', lu.apellidos_doctor) AS doctor_examen,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'COLOR'::text) AS color_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'NATURALEZA'::text) AS naturaleza_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SINTOMA'::text) AS sintoma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'FORMA'::text) AS forma_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'SUPERFICIE'::text) AS superficie_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'CONSISTENCIA'::text) AS consistencia_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'INTRAOSEO'::text) AS intraoseo_lesion,
    ( SELECT string_agg(ltol.valor_tipo_opcion::text, ' ,'::text) AS string_agg
           FROM lab_examen_caracteristica lec,
            lab_tipo_opcion_lesion ltol
          WHERE lec.cod_examen = le.cod_examen AND lec.codigo_tipo_opcion_lesion = ltol.cod_tipo_opcion_lesion AND ltol.nombre_tipo_opcion::text = 'PIEZA'::text) AS pieza_lesion,
    le.tamano_lesion,
    le.duracion_lesion_dias AS dias_lesion,
    le.duracion_lesion_meses AS meses_lesion,
    le.duracion_lesion_anios AS anios_lesion,
    le.doctor_remision,
    le.dependencia_doctor_remision,
        CASE
            WHEN le.necesita_frote = false THEN 'No'::text
            ELSE 'Si'::text
        END AS req_frote,
    lef.num_frote,
    lef.muestra_estudio AS num_muestra_frote,
    lef.fecha AS fec_frote,
    to_char(lef.fecha::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_frote,
    lef.cod_tincion,
    ( SELECT string_agg(lt.nombre_tincion::text, ' ,'::text) AS string_agg
           FROM lab_tincion lt
          WHERE lef.cod_tincion = lt.cod_tincion) AS tincion,
    concat(lef.serie_recibo, '-', lef.num_recibo) AS datos_recibo,
    lef.monto_recibo AS valor_recibo,
    lef.usuario_frote,
    ( SELECT concat(lu5.nombres_doctor, ' ', lu5.apellidos_doctor) AS concat
           FROM lab_usuario lu5
          WHERE lu5.cod_usuario = lef.usuario_frote) AS usuario_realiza_frote,
    lef.estado_frote,
    ( SELECT to_char(li4.fecha_informe::timestamp with time zone, 'dd/mm/yyyy'::text) AS fecha_informe_frote
           FROM lab_informe li4
          WHERE li4.cod_frote = lef.cod_frote) AS fecha_informe_frote,
    ( SELECT ld3.nombre_diagnostico
           FROM lab_informe li5,
            lab_diagnostico ld3
          WHERE lef.cod_frote = li5.cod_frote AND li5.diagnostico = ld3.cod_diagnostico) AS diagnostico_informe_frote,
    ( SELECT concat(lu2.nombres_doctor, ' ', lu2.apellidos_doctor) AS concat
           FROM lab_informe li6,
            lab_usuario lu2
          WHERE lef.cod_frote = li6.cod_frote AND li6.usuario_informe = lu2.cod_usuario) AS usuario_informe_frote
   FROM lab_examen le
     JOIN lab_paciente lp ON le.cod_paciente = lp.cod_paciente
     JOIN lab_usuario lu ON le.doctor_examen = lu.cod_usuario
     JOIN lab_examen_frote lef ON le.cod_examen = lef.cod_examen
  ORDER BY le.cod_examen;

-- Permissions

ALTER TABLE public.lab_reporte_frote_vw OWNER TO postgres;
GRANT ALL ON TABLE public.lab_reporte_frote_vw TO postgres;