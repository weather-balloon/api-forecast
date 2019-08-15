# PostGIS container image

To build: 

    docker build --tag wb-postgis .

A quick way to test it works:

    docker run -p 5432:5432 -e POSTGRES_PASSWORD=Pa55word --rm -it wb-postgis

To run as a daemon:

    docker run --name wb-postgis -v pgsqlvol:/var/lib/postgresql/data -p 5432:5432 -e POSTGRES_PASSWORD=Pa55word -d wb-postgis

To see the volume:

    docker volume ls
    docker volume inspect pgsqlvol

## Create the database

    CREATE DATABASE wb
        WITH 
        OWNER = postgres
        ENCODING = 'UTF8'
        LC_COLLATE = 'en_US.utf8'
        LC_CTYPE = 'en_US.utf8'
        TABLESPACE = pg_default
        CONNECTION LIMIT = -1;

    CREATE EXTENSION postgis;

Check the version:

    SELECT postgis_full_version();



## References

* [PostGIS docs](https://postgis.net/documentation/)
* [QGIS](https://docs.qgis.org/3.4/en/docs/index.html)
* [`shp2pgsql` quick guide](https://www.bostongis.com/pgsql2shp_shp2pgsql_quickguide.bqg)
* [pgAdmin](https://www.pgadmin.org/) - GUI for Postgres admin
* Docker image based on https://github.com/appropriate/docker-postgis/tree/master/11-2.5 
