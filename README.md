# crud-api-kotlin

## Fundamentos teóricos

> Springboot: O Spring Boot é um modulo do Spring framework que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.

> Kotlin: Kotlin é uma Linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011, que compila para a Máquina virtual Java e que também pode ser traduzida para a linguagem JavaScript e compilada para código nativo.

## Tecnologias
- Kotlin 1.6.21
- Spring Boot 2.6.7
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
- H2
- Tomcat (Embedded no Spring Boot)
- GIT
- JVM 17

## Execução

A execução das aplicações pode ser feita através de um comando Gradle que envoca a inicialização do Spring Boot ou inicializado através da propria IDE.

- Scripts
  ### Executar a aplicação
  - 1° comando: ``` ./gradlew clean build```
  - 2° comando: ```./gradlew bootRun```

## Testando a API

Para testar a API você pode utilizar o postman ou insomnia com os seguintes recursos
  ### Recursos para teste de API
  ### C - Create
  POST http://localhost:8080/customers
  Content-Type: application/json

```
  {
    "name": "Customer",
    "dateOfBirth": "1999-12-21",
    "cpf": "00000000001",
    "email": "customer@gmail.com"
  }
```

### R - Read
GET http://localhost:8080/customers
Content-Type: application/json

### U - Update
PUT http://localhost:8080/customers/1
Content-Type: application/json

```
  {
    "name": "customer",
    "dateOfBirth": "1999-12-21",
    "cpf": "00000000002",
    "email": "customer@gmail.com"
  }
```

### D - Delete
DELETE http://localhost:8080/customers/1
Content-Type: application/json