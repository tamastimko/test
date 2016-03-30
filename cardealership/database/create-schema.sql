CREATE TABLE gepjarmutipus
(
  tipusnev character varying(100) NOT NULL,
  gyarto character varying(100) NOT NULL,
  CONSTRAINT gepjarmutipus_pkey PRIMARY KEY (tipusnev)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE gepjarmutipus
  OWNER TO postgres;
GRANT ALL ON TABLE gepjarmutipus TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE gepjarmutipus TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE gepjarmutipus TO tulajdonos_role;

CREATE TABLE javittat
(
  javitasid serial NOT NULL,
  keszletid serial NOT NULL,
  koltseg integer,
  szervizbekerules date,
  szervizbolkikerules date,
  rendszam character varying(100),
  alvazszam character varying(100),
  adoszam bigint,
  CONSTRAINT javittat_pkey PRIMARY KEY (javitasid),
  CONSTRAINT fk_javittat_keszlet FOREIGN KEY (keszletid)
      REFERENCES keszlet (keszletid) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_javittat_szerviz FOREIGN KEY (adoszam)
      REFERENCES szerviz (adoszam) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE javittat
  OWNER TO postgres;
GRANT ALL ON TABLE javittat TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE javittat TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE javittat TO tulajdonos_role;

CREATE TABLE keszlet
(
  keszletid serial NOT NULL,
  rendszam character varying(100),
  alvazszam character varying(100) NOT NULL,
  uzemanyag character varying(100),
  evjarat integer NOT NULL,
  bekerulesdatuma date,
  CONSTRAINT keszlet_pkey PRIMARY KEY (keszletid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE keszlet
  OWNER TO postgres;
GRANT ALL ON TABLE keszlet TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE keszlet TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE keszlet TO tulajdonos_role;


CREATE TABLE peldanya
(
  keszletid serial NOT NULL,
  rendszam character varying(100),
  alvazszam character varying(100),
  tipusnev character varying(100),
  CONSTRAINT fk_peldany_gepjarmutipus FOREIGN KEY (tipusnev)
      REFERENCES gepjarmutipus (tipusnev) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_peldany_keszlet FOREIGN KEY (keszletid)
      REFERENCES keszlet (keszletid) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE peldanya
  OWNER TO postgres;
GRANT ALL ON TABLE peldanya TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE peldanya TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE peldanya TO tulajdonos_role;


CREATE TABLE szerviz
(
  szerviznev character varying(100) NOT NULL,
  cim character varying(100) NOT NULL,
  adoszam bigint NOT NULL,
  telefonszam bigint,
  prefgyarto character varying(100),
  tevkor character varying(100),
  CONSTRAINT pk_szerviz_id PRIMARY KEY (adoszam)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE szerviz
  OWNER TO postgres;
GRANT ALL ON TABLE szerviz TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE szerviz TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE szerviz TO tulajdonos_role;

CREATE TABLE ugyfel
(
  nev character varying(100) NOT NULL,
  szemszam bigint NOT NULL,
  "cím" character varying(100) NOT NULL,
  anyjaneve character varying(100),
  nem character varying(100),
  CONSTRAINT ugyfel_pkey PRIMARY KEY (szemszam)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ugyfel
  OWNER TO postgres;
GRANT ALL ON TABLE ugyfel TO postgres;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE ugyfel TO tulajdonos_role;

CREATE TABLE vasarol
(
  vasarlasid serial NOT NULL,
  keszletid serial NOT NULL,
  vasarlasdatuma date,
  szemszam bigint,
  rendszam character varying(100),
  alvazszam character varying(100),
  CONSTRAINT vasarol_pkey PRIMARY KEY (vasarlasid),
  CONSTRAINT fk_vasarol_keszlet FOREIGN KEY (keszletid)
      REFERENCES keszlet (keszletid) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_vasarol_ugyfel FOREIGN KEY (szemszam)
      REFERENCES ugyfel (szemszam) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vasarol
  OWNER TO postgres;
GRANT ALL ON TABLE vasarol TO postgres;
GRANT SELECT, UPDATE, INSERT ON TABLE vasarol TO beosztott_role;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE vasarol TO tulajdonos_role;

