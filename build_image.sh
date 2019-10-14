mvn clean install
cp -r target/*.war images/payara
docker-compose build
rm -rf images/payara/*.war
docker-compose up
