FROM openjdk:17
COPY target/webapp-0.0.1-SNAPSHOT.jar service.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/service.jar" ]docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=sa -e MYSQL_DATABASE=jugnicaragua -e MYSQL_USER=sa -e MYSQL_PASSWORD=sa -d mysql:5.7