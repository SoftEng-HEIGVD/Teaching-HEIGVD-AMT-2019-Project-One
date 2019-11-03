FROM jboss/wildfly:14.0.1.Final

MAINTAINER Teklehaimanot-Alic

COPY data/mysql-connector-java-5.1.48-bin.jar /opt/jboss/wildfly/standalone/deployments/
COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ADD data/manageFootball-WebApp.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

