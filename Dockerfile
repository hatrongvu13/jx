FROM eclipse-temurin:17.0.14_7-jdk-ubi9-minimal

LABEL authors="hatrongvu"

WORKDIR /opt/service

COPY /target/*.jar /opt/service/app.jar

COPY /src/main/resources /opt/service/resources_default

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

RUN chgrp -R 0 ./ && chmod -R g=u ./
ENTRYPOINT ["/entrypoint.sh"]