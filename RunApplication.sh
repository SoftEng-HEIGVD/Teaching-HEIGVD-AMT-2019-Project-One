cd AMTProject01
sudo mvn clean install
sudo chmod -R 777 target/
cp target/TeamEsport.war ../images/payara/application/TeamEsport.war
cd ../topology-amt/
sudo docker-compose down
sudo docker-compose up --build -d
