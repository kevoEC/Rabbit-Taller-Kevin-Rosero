# Camel RabbitMQ Lab

> Taller de integración de sistemas utilizando Apache Camel y RabbitMQ para demostrar el patrón de mensajería asíncrona y el desacoplamiento entre productor y consumidor.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Objetivos](#objetivos)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Ejecución](#ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Funcionamiento](#funcionamiento)
- [Evidencias](#evidencias)
- [Explicación Técnica](#explicación-técnica)
- [Autor](#autor)

## Descripción

Este proyecto integra sistemas desacoplados usando Apache Camel y RabbitMQ, aplicando el patrón de mensajería asíncrona. El flujo permite que productor y consumidor se comuniquen de forma independiente a través de una cola intermedia.

## Objetivos

- Aplicar el patrón de mensajería asíncrona.
- Configurar RabbitMQ en Docker y crear la cola `test.camel.queue`.
- Desarrollar productor y consumidor de mensajes usando Apache Camel.
- Evidenciar el desacoplamiento y ventajas del patrón.

## Requisitos

- Java 11
- Maven
- Docker Desktop (para RabbitMQ)
- Visual Studio Code (opcional)
- RabbitMQ Management UI: http://localhost:15672 (usuario: guest, contraseña: guest)

## Instalación

1. Levantar RabbitMQ en Docker:
   ```sh
   docker run -d --hostname my-rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

2. Acceder a la consola de administración:  
   http://localhost:15672  
   Usuario: `guest`  
   Contraseña: `guest`

3. Crear la cola:
   - Nombre: `test.camel.queue`
   - Opciones por defecto

4. Clonar este repositorio o descargar el código.

## Ejecución

1. Compilar el proyecto:
   ```sh
   mvn clean package
2. Ejecutar la aplicación:
   ```sh
   mvn spring-boot:run
3. Observar los mensajes:
   - En la terminal se verán logs de mensajes enviados y recibidos.
   - En RabbitMQ la cola `test.camel.queue` mostrará movimiento de mensajes (se mantienen en 0 si el consumidor está activo).

## Estructura del Proyecto

```
camel-rabbit-lab/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ejemplo/
│   │               └── camel/
│   │                   ├── MainApp.java
│   │                   ├── ProducerRoute.java
│   │                   └── ConsumerRoute.java
│   └── test/
│       └── java/
│           └── com/
│               └── ejemplo/
│                   └── camel/
│                       └── AppTest.java
├── pom.xml
```



## Funcionamiento

- `ProducerRoute`: Genera un mensaje cada 5 segundos y lo publica en la cola `test.camel.queue`.
- `ConsumerRoute`: Se suscribe a la cola y procesa los mensajes recibidos.
- `RabbitMQ`: Gestiona el almacenamiento, entrega y monitoreo de los mensajes, permitiendo el desacoplamiento entre productor y consumidor.

## Evidencias

- Capturas de pantalla de la consola de administración de RabbitMQ mostrando la cola `test.camel.queue` activa y procesando mensajes.
- Logs de la aplicación mostrando los mensajes enviados y recibidos por Camel.
- Demostración del desacoplamiento: si el consumidor está detenido, los mensajes se acumulan en la cola; al reiniciar el consumidor, los mensajes pendientes se procesan automáticamente.

## Explicación Técnica

### Qué patrón de integración se aplicó

Se aplicó el patrón de mensajería asíncrona mediante Message Broker utilizando RabbitMQ como intermediario. El productor publica mensajes en una cola, y el consumidor los procesa de forma desacoplada, siguiendo los principios de publicar-suscribirse y message queue.

### Cómo se logró el desacoplamiento productor-consumidor

El desacoplamiento se logró implementando la comunicación a través de RabbitMQ como intermediario entre productor y consumidor.
- El productor envía mensajes a la cola `test.camel.queue` usando Apache Camel, sin necesidad de conocer detalles sobre el consumidor.
- El consumidor se suscribe a la misma cola y procesa los mensajes cuando están disponibles, sin depender del productor.
- RabbitMQ almacena los mensajes hasta que puedan ser procesados.
- Si el consumidor está inactivo, los mensajes permanecen en la cola y no se pierden.
- Si el productor deja de enviar mensajes, el consumidor simplemente queda a la espera hasta recibir nuevos mensajes.
- Esto permite que ambos componentes evolucionen o se escalen de forma independiente y asegura la tolerancia a fallos.

### Ventajas que se observaron durante la práctica

- Desacoplamiento real: Productores y consumidores se pueden desarrollar y mantener de forma independiente.
- Tolerancia a fallos: Si el consumidor falla, los mensajes se conservan en la cola hasta que vuelva a estar activo.
- Escalabilidad: Es fácil agregar más consumidores o productores según la necesidad.
- Monitoreo y visibilidad: La consola de RabbitMQ permite ver el flujo y estado de los mensajes en tiempo real.
- Flexibilidad: Permite cambios y mejoras en los sistemas de manera aislada.

## Autor

**Kevin Rosero**  
Universidad: Universidad de las Americas 
Materia: Sistemas Integrados  
Año: 2025

