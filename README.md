## RabbitMQ Exchange Types

This project was developed using to Java11 and RabbitMQ. The Spring boot framework is preferred for Java EE.

#### Prerequisites
1. You need to have jdk11.
2. You need to have mvn command in your path.
3. You need to have RabbitMQ instance or docker engine.

Run RabbitMQ as a container:
``docker run -d --hostname my-rabbit --name myrabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 15672:15672 rabbitmq:3-management``


##
####Http Request Example

Direct Exchange:
```
POST /document/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "name": "The Fellowship of the Ring",
    "description": "description",
    "documentType": "EXCEL"
}
```
-----

Fanout Exchange:
```
POST /game-object/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "label": "Monster 1",
    "shapeType": "CIRCLE",
    "x": 20,
    "y": 10,
    "z": 100
}
```
-----

Header Exchange:
```
POST /notification/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "text": "Notification1",
    "platform": "MOBILE"
}
```
-----

Topic Exchange:
```
POST /data-center/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "name": "Earth",
    "path": "data.center.eu.north."
}
```