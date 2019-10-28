FROM glassfish

ENV GLASSFISH_PATH glassfish
ENV ADMIN_USER admin
ENV ADMIN_PASSWORD admin

# set credentials to admin/admin 

RUN echo 'AS_ADMIN_PASSWORD=\n\
AS_ADMIN_NEWPASSWORD='$ADMIN_PASSWORD'\n\
EOF\n'\
>> /opt/tmpfile

RUN echo 'AS_ADMIN_PASSWORD='$ADMIN_PASSWORD'\n\
EOF\n'\
>> /opt/pwdfile

RUN \
 $GLASSFISH_PATH/bin/asadmin start-domain && \
 $GLASSFISH_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/tmpfile change-admin-password && \
 $GLASSFISH_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile enable-secure-admin && \
 $GLASSFISH_PATH/bin/asadmin restart-domain

# cleanup
RUN rm /opt/tmpfile


ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/
