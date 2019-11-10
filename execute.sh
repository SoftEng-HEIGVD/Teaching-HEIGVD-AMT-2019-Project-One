#Build with maven
mvn clean install

# Copy *.war to docker topology
cp target/filmratingapp.war docker/images_docker/payara/

# docker compose
cd docker || exit
docker-compose down
docker-compose up --build

