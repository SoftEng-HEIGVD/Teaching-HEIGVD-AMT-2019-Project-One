FROM jboss/wildfly:17.0.1.Final

MAINTAINER Teklehaimanot-Alic



COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/
ADD data/mysql-connector-java-5.1.48.jar /opt/jboss/wildfly/standalone/deployments/
ADD data/manageFootball-WebApp.war /opt/jboss/wildfly/standalone/deployments/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent


CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

