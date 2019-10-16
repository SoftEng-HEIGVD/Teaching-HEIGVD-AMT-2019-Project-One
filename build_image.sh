#mvn clean install
cp -r target/*.war images/payara
cd topology-amt
docker-compose build
cd ..
rm -rf images/payara/*.war
cd topology-amt
docker-compose up
