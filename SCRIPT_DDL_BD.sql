-- Gerado por Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   em:        2021-10-21 18:55:06 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE tb_h_dieta (
    cd_dieta                 INTEGER NOT NULL,
    dt_dieta                 DATE NOT NULL,
    ds_nome                  NVARCHAR2(100) NOT NULL,
    ds_descricao             NVARCHAR2(150) NOT NULL,
    nr_calorias              NUMBER(10) NOT NULL,
    ds_validade              NVARCHAR2(150) NOT NULL,
    tb_h_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE tb_h_dieta ADD CONSTRAINT tb_h_dieta_pk PRIMARY KEY ( cd_dieta );

CREATE TABLE tb_h_imc (
    cd_imc                   INTEGER NOT NULL,
    dt_imc                   DATE NOT NULL,
    nr_peso                  NUMBER(5, 2) NOT NULL,
    nr_altura                NUMBER(3, 2) NOT NULL,
    tb_h_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE tb_h_imc ADD CONSTRAINT tb_h_imc_pk PRIMARY KEY ( cd_imc );

CREATE TABLE tb_h_pressao (
    cd_pressao               INTEGER NOT NULL,
    dt_pressao               DATE NOT NULL,
    nr_sistolica             NUMBER(3) NOT NULL,
    nr_diastolica            NUMBER(3) NOT NULL,
    nr_bpm                   NUMBER(3) NOT NULL,
    tb_h_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE tb_h_pressao ADD CONSTRAINT tb_h_pressao_pk PRIMARY KEY ( cd_pressao );

CREATE TABLE tb_h_treino (
    cd_treino                INTEGER NOT NULL,
    dt_treino                DATE NOT NULL,
    ds_nome                  NVARCHAR2(100) NOT NULL,
    ds_descricao             NVARCHAR2(150) NOT NULL,
    nr_calorias              NUMBER(10) NOT NULL,
    ds_validade              NVARCHAR2(150) NOT NULL,
    ds_frequencia            NVARCHAR2(150) NOT NULL,
    tb_h_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE tb_h_treino ADD CONSTRAINT tb_h_treino_pk PRIMARY KEY ( cd_treino );

CREATE TABLE tb_h_usuario (
    cd_usuario       INTEGER NOT NULL,
    ds_nome          VARCHAR2(100) NOT NULL,
    dt_nascimento    DATE NOT NULL,
    ds_sexo          CHAR(1) NOT NULL,
    ds_email         NVARCHAR2(100) NOT NULL,
    ds_tipo_usuario  CHAR(1) NOT NULL,
    ds_cpf           NVARCHAR2(15),
    ds_cnpj          NVARCHAR2(20),
    ds_crn           NVARCHAR2(20),
    ds_cref          NVARCHAR2(20)
);

ALTER TABLE tb_h_usuario ADD CONSTRAINT tb_h_usuario_pk PRIMARY KEY ( cd_usuario );

ALTER TABLE tb_h_dieta
    ADD CONSTRAINT tb_h_dieta_tb_h_usuario_fk FOREIGN KEY ( tb_h_usuario_cd_usuario )
        REFERENCES tb_h_usuario ( cd_usuario );

ALTER TABLE tb_h_imc
    ADD CONSTRAINT tb_h_imc_tb_h_usuario_fk FOREIGN KEY ( tb_h_usuario_cd_usuario )
        REFERENCES tb_h_usuario ( cd_usuario );

ALTER TABLE tb_h_pressao
    ADD CONSTRAINT tb_h_pressao_tb_h_usuario_fk FOREIGN KEY ( tb_h_usuario_cd_usuario )
        REFERENCES tb_h_usuario ( cd_usuario );

ALTER TABLE tb_h_treino
    ADD CONSTRAINT tb_h_treino_tb_h_usuario_fk FOREIGN KEY ( tb_h_usuario_cd_usuario )
        REFERENCES tb_h_usuario ( cd_usuario );
        
CREATE SEQUENCE SQ_DIETA INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_IMC INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_PRESSAO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;
CREATE SEQUENCE SQ_TREINO INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0


