# DynamoDB
Simple test application for KPI. Required Java 11 and Docker

## Build
### With Maven
```
mvn clean install
```
### With Maven wrapper
```
./mvnw clean install
```

## Configuration
Change path of volume for storing DB data in docker-compose.yml

Example:
```
  - dynamotest-data:/Users/${user}/IdeaProjects/dynamo-test/data
```

## Run
Run in terminal:

```
docker-compose up
```

## Swagger
Swagger-UI on [local machine](http://localhost:8099/swagger-ui.html#/)
