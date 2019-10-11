FROM jboss/wildfly:14.0.1.Final

MAINTAINER Jeremy Zerbib <jeremy.zerbib@heig-vd.ch>
MAINTAINER Adam Zouari <adam.zouari@heig-vd.ch>

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

