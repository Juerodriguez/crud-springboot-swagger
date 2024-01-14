# Crud SpringBoot
Este es un proyecto de practica para crear una API Rest con Springboot y documentada con Swagger.

1. Crear la base de datos y conectar indicandola en src/main/resources/application.properties
2. Iniciar el servicio de maven con el siguiente comando:
```
./mvnw dependency:tree
./mvnw spring-boot:run
```
4. Una vez corriendo el servicio entrar en el siguiente link para ver la documentación:

http://localhost:9090/swagger-ui/index.html

------

## Extras

Si desea implementar rapidamente una base de datos sin tener que instalar ni configurar un gestor
le ayudara la herramienta de docker compose con phpMyadmin y Mysql integrado:

Ejecute para iniciarlo:
```
docker-compose up -d
```
Puede ver phpMyAdmin en:

http://localhost:8080

Para finalizar los servicios ejecute:

```
docker-compose down
```



