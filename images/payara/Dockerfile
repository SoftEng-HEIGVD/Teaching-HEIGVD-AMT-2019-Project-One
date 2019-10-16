FROM payara/server-full:5.183

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

ADD drivers/mysql-connector-java-5.1.39-bin.jar /opt/payara5/glassfish/lib/

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && \
echo 'create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.ConnectionPoolDataSource --property user=root:password=amt_project_1_pwd:DatabaseName=amtprojectone:ServerName=db:port=3306 amt-pool' > mycommands.asadmin && \
echo 'create-jdbc-resource --connectionpoolid amt-pool jdbc/amtDatasource' >> mycommands.asadmin && \
cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && \
${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}

# https://docs.oracle.com/cd/E26576_01/doc.312/e24938/create-jdbc-resource.htm#GSRFM00037