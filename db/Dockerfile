FROM mysql:5.7

ENV MY_SQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=db

COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

COPY ./sql-scripts/schema.sql .

EXPOSE 3306