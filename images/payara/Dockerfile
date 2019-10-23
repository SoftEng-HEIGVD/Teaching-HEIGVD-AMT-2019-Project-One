FROM payara/server-full:5.183

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

ADD *.war $DEPLOY_DIR
ADD drivers/* /opt/payara5/glassfish/lib/

#RUN echo "AS_ADMIN_PASSWORD=glassfish" > /tmp/gfpw.txt && ./glassfish/bin/asadmin start-domain domain1 && ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --datasourceClassName "org.postgresql.ds.PGConnectionPoolDataSource" --restype "javax.sql.ConnectionPoolDataSource" --property "ServerName=localhost:PortNumber=5432:DatabaseName=AMT:User=postgres:Password=example" "amt" && ./glassfish/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid "amt" "jdbc/amt"

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && echo 'create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property user=postgres:password=example:DatabaseName=amt:ServerName=postgres:port=5432 amt_pool' > mycommands.asadmin && echo 'create-jdbc-resource --connectionpoolid "amt_pool" "jdbc/amt"' >> mycommands.asadmin && cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}