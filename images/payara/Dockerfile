FROM payara/server-full:5.193


COPY application/* /home/AMTProjectOne.war
ADD drivers/ ${PAYARA_DIR}/glassfish/lib/
ADD scripts/post-boot-commands.asadmin /opt/payara/config/post-boot-commands.asadmin




