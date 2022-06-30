FROM mysql:5.7

ENV MYSQL_ALLOW_EMPTY_PASSWORD=true
ENV MYSQL_DATABASE=db

COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

COPY ./sql-scripts/schema.sql .

EXPOSE 3306