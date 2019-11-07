FROM jboss/wildfly:17.0.1.Final

MAINTAINER Baptiste Hardrick <baptiste.hardrick@heig-vd.ch>

COPY drivers/mysql-connector-java-5.1.39-bin.jar /opt/jboss/wildfly/standalone/deployments
COPY ProjectOneApp-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]