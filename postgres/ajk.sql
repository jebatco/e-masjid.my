CREATE TABLE jawatan (
    id serial PRIMARY KEY,
    nama VARCHAR(50)
);
insert into jawatan (nama) values ('Pengerusi');
insert into jawatan (nama) values ('Timbalan Pengerusi');
insert into jawatan (nama) values ('Setiausaha');
insert into jawatan (nama) values ('Bendahari');
insert into jawatan (nama) values ('Ahli Jawatankuasa');

CREATE TABLE status_ajk (
    id serial PRIMARY KEY,
    nama VARCHAR(12)
);

CREATE TABLE penggal (
    id serial PRIMARY KEY,
    nama VARCHAR(50) NOT NULL,
    tarikh_mula int8 NOT NULL,
    tarikh_tamat int8 NOT NULL,
    fail_minit_mesy BYTEA NOT NULL
);

CREATE TABLE ajk (
    id serial PRIMARY KEY,
    penggal_id INTEGER REFERENCES penggal(id),
    jawatan_id INTEGER REFERENCES jawatan(id),
    nama VARCHAR(128) NOT NULL,
    tarikh_mula int8 NOT NULL,
    tarikh_tamat int8 NOT NULL,
    status_ajk_id integer REFERENCES status_ajk,
    create_date int8 NULL
);
