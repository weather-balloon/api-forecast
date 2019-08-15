#!/bin/bash
set -e

# Perform all actions as $POSTGRES_USER
export PGUSER="$POSTGRES_USER"

psql <<EOSQL
    CREATE DATABASE forecasts;
    CREATE DATABASE regions;
EOSQL

psql --dbname="regions" <<EOSQL
    CREATE EXTENSION IF NOT EXISTS postgis;
EOSQL

shp2pgsql /var/local/data/regions/IDM00001.shp ForecastRegions | psql -d regions
