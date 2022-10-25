# Spring Boot JPA MySQL - Building Rest CRUD API example


## Build Spring Boot application
```
mvn package Dmaven.test.skip=true
```

## Run application using docker
```
docker-compose up
```

## Patient End points and sample payloads
```
1) Create Patient - http://localhost:8080/v1/patients

{
"firstName":"sree",	
"lastName":"nath",
"doctor":{
	"firstName":"arun",
	"lastName":"nath",
	"department":"dental"
}
	
}
```
```
2) Update Patient - http://localhost:8080/v1/patients/302

{
"firstName":"sree",	
"lastName":"kumar"
}
```
```
3) Delete Patient - http://localhost:8080/v1/patients/302

```
```
4) Get a Patient - http://localhost:8080/v1/patients/302

```
5) Get all Patients - http://localhost:8080/v1/patients
