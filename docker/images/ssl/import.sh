#!/bin/sh

sudo keytool -trustcacerts -keystore /usr/lib/jvm/default-java/jre/lib/security/cacerts -storepass changeit -alias payara -import -file ~/adam/modules/amt/projets/projet1/Teaching-HEIGVD-AMT-2019-Project-One/ssl/payara-self-signed-certificate.crt
