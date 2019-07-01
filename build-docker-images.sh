#!/usr/bin/env bash

docker build -t pksheldon4/simple-client-app --build-arg JAR_FILE=target/simple-client-app.jar client-app/
docker build -t pksheldon4/simple-books-api --build-arg JAR_FILE=target/simple-books-api.jar books-api/