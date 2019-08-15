FROM postgres:11

ENV POSTGIS_MAJOR 2.5
ENV POSTGIS_VERSION 2.5.2+dfsg-1~exp1.pgdg90+1

RUN apt-get update \
      && apt-cache showpkg postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR \
      && apt-get install -y --no-install-recommends \
           postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR=$POSTGIS_VERSION \
           postgresql-$PG_MAJOR-postgis-$POSTGIS_MAJOR-scripts=$POSTGIS_VERSION \
           postgis=$POSTGIS_VERSION \
      && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /var/local/data/regions
COPY data/regions/* /var/local/data/regions/

RUN mkdir -p /var/local/data/forecasts
COPY data/forecasts/* /var/local/data/forecasts/

RUN mkdir -p /docker-entrypoint-initdb.d
COPY ./config.sh /docker-entrypoint-initdb.d/initwb.sh
