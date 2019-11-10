FROM payara/server-full:5.193

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>


ADD drivers/mysql-connector-java-8.0.18.jar /opt/payara/appserver/glassfish/lib/

COPY application/AMTProject01-1.0-SNAPSHOT.war $DEPLOY_DIR

ENTRYPOINT ${SCRIPT_DIR}/init_1_generate_deploy_commands.sh && \
    echo 'create-jdbc-connection-pool --datasourceclassname com.mysql.cj.jdbc.MysqlDataSource --restype javax.sql.DataSource --property user=root:password=root:DatabaseName=TeamEsport:ServerName=db:port=3306:useSSL=false:allowPublicKeyRetrieval=true TeamEsport_Pool' > mycommands.asadmin && echo 'create-jdbc-resource --connectionpoolid TeamEsport_Pool jdbc/TeamEsport' >> mycommands.asadmin && cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && ${PAYARA_DIR}/glassfish/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}


