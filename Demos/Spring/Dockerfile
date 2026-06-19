# Build the project
FROM maven:latest as builder
COPY pom.xml    /usr/local/build/pom.xml
COPY src        /usr/local/build/src
COPY client     /usr/local/build/client
WORKDIR         /usr/local/build
RUN mvn clean package -DskipTests -P jar

# Prepare to run
FROM eclipse-temurin:11-jre

RUN apt-get update && \
    apt-get install -y fontconfig ttf-mscorefonts-installer && \
    fc-cache -f && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir -p /home/groupdocs/app/DocumentSamples/Output && \
    mkdir -p /home/groupdocs/app/Licenses
COPY configuration.yml /home/groupdocs/app/configuration.yml
COPY logback-spring.xml /home/groupdocs/app/logback-spring.xml
COPY --from=builder /usr/local/build/target/signature-spring-*.jar /home/groupdocs/app/app.jar
WORKDIR /home/groupdocs/app

ENV LIC_PATH "/home/groupdocs/app/Licenses"
ENV DOWNLOAD_ON true
ENV UPLOAD_ON true
ENV FILES_DIR "DocumentSamples"
ENV HOST_ADDRESS ""

EXPOSE 8080

VOLUME [ "/home/groupdocs/app", "/home/groupdocs/app/DocumentSamples", "/home/groupdocs/app/Licenses" ]

ENTRYPOINT [ "java", "-jar", "-Dlogback.configurationFile=/home/groupdocs/app/logback-spring.xml", "app.jar", "configuration.yml" ]
