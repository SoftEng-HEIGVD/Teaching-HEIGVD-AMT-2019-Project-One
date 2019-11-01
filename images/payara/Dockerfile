FROM payara/server-full:4.181

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

#ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish/lib/
RUN curl http://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.46/mysql-connector-java-5.1.46.jar -o glassfish/lib/mysql-connector-java-5.1.46.jar

RUN echo "AS_ADMIN_PASSWORD=admin" > /tmp/gfpw.txt && \
    ./glassfish/bin/asadmin start-domain domain1 && \
    ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=root:DatabaseName=chillout:ServerName=db:port=3306:useSSL=false pool_chillout && \
     cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && \
   ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_chillout jdbc/chillout
