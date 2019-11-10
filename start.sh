#!/bin/bash
mvn clean install
mv target/projectone.war images/payara/
docker-compose down
docker-compose up --build
