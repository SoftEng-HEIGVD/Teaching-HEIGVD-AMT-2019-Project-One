mvn clean install
cp -r target/*.war images/payara
cd topology-amt
docker-compose build
