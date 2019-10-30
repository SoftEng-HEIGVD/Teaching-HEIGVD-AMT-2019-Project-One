FROM payara/server-full:5.183

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

ADD *.war ./glassfish/domains/domain1/autodeploy
ADD drivers/* /opt/payara5/glassfish/lib/

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && echo 'create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property user=postgres:password=example:DatabaseName=amt:ServerName=postgres:port=5432 amt_pool' > mycommands.asadmin && echo 'create-jdbc-resource --connectionpoolid "amt_pool" "jdbc/amt"' >> mycommands.asadmin && cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}