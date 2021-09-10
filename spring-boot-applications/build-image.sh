#!/usr/bin/env bash

mvn clean package -U -DskipTests

cd ./spring-boot-webmvc
docker build --tag=spring-boot-webmvc:latest .

cd ../spring-boot-webflux/

docker build --tag=spring-boot-webflux:latest .