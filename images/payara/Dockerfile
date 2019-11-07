FROM payara/server-full:5.183

MAINTAINER Baptiste Hardrick <baptiste.hardrick@heig-vd.ch>

ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/gfpw.txt && \
    ${PAYARA_PATH}/bin/asadmin start-domain domain1 && \
    ${PAYARA_PATH}/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=adminpw:DatabaseName=FlightCompany:ServerName=db:port=3306 pool_FlightCompany && \
    ${PAYARA_PATH}/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_FlightCompany jdbc/FlightCompany

#RUN ${PAYARA_PATH}/bin/asadmin stop-domain domain1