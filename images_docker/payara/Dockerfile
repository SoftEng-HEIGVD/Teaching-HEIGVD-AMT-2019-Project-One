FROM payara/server-full:5.193

COPY filmratingapp.war $DEPLOY_DIR

ADD drivers/mysql-connector-java-8.0.18.jar /glassfish4/glassfish/lib/
ADD scripts/post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin
