#!/bin/bash
mvn clean install
cp target/projectone.war images/payara/
docker-compose down
docker-compose up --build
