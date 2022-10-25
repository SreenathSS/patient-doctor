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

``
## Doctor End points and sample payloads

```
1) Create Doctor - http://localhost:8080/v1/doctors

{
"firstName":"rahul",	
"lastName":"ram",
"department":"pediatric",
"patients":[
	{
	 "firstName":"baby",	
         "lastName":"akram"
	}
	
	]
	
}
```
```
2) Update Doctor - http://localhost:8080/v1/doctors/101

{
"firstName":"rahul",	
"lastName":"kumar",
"department":"ortho"
}
```
```
3) Delete Doctor - http://localhost:8080/v1/doctors/101

```
```
4) Get a Doctor - http://localhost:8080/v1/doctors/101

```
```
5) Get all Doctor - http://localhost:8080/v1/doctors

```
