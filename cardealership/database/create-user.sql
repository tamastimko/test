CREATE USER tulajdonos;
ALTER USER tulajdonos PASSWORD 'topsecret1';
GRANT tulajdonos_role TO tulajdonos;

CREATE USER beosztott;
ALTER USER beosztott PASSWORD 'bestpassword1';
GRANT beosztott_role TO beosztott;