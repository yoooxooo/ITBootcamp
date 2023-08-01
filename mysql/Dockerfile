FROM mysql
MAINTAINER ITAcademy

ADD /tables/ddl/*.sql /docker-entrypoint-initdb.d/
ADD /user-service/ddl/*.sql /docker-entrypoint-initdb.d/