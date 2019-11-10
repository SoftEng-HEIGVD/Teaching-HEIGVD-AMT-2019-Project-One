FROM payara/server-full:5.193

ADD drivers/ ${PAYARA_DIR}/glassfish/lib/
ADD scripts/post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin

COPY filmratingapp.war $DEPLOY_DIR