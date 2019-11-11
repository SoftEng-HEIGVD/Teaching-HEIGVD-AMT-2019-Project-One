FROM mysql:8
MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

COPY csv/* /var/lib/mysql-files/
COPY conf/my.cnf /etc/mysql/my.cnf
COPY data/* /docker-entrypoint-initdb.d/
