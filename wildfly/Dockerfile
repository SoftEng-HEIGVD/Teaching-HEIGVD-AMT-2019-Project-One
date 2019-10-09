FROM jboss/wildfly:14.0.1.Final

MAINTAINER Teklehaimanot-Alic

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ADD manageFootball-WebApp.war /opt/jboss/wildfly/standalone/deployments/


CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

