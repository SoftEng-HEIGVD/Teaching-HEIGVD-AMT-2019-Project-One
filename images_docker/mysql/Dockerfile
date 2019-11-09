FROM mysql:5.7.28

COPY conf/my.cnf /etc/mysql/my.cnf
COPY dump/* docker-entrypoint-initdb.d/
