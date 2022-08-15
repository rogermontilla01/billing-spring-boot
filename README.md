# billing-spring-boot
This is just a small project using spring boot

### How to run this project
#### Run mysql data base:
 ```bash  
 docker-compose up -d   
```
#### Run Spring Boot Project:
```bash
mvn clean package
mvn spring-boot:run
```
#### Swagger:  [swagger link](http://localhost:8080/swagger-ui/index.html)

### How to test this project:
1. create a new user by **/client/create**
2. create new products by **/product/create**
3. make an invoice by **invoice/create** 
