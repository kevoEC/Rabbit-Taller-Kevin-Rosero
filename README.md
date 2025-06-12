Acceder a la consola de administración:
http://localhost:15672
Usuario: guest
Contraseña: guest

Crear la cola:

Nombre: test.camel.queue

Opciones por defecto

Clonar este repositorio o descargar el código.

Ejecución
Compilar el proyecto:

sh
Copiar
Editar
mvn clean package
Ejecutar la aplicación:

sh
Copiar
Editar
mvn spring-boot:run
Observar los mensajes:

En la terminal se verán logs de mensajes enviados y recibidos.

En RabbitMQ la cola test.camel.queue mostrará movimiento de mensajes (se mantienen en 0 si el consumidor está activo).

Estructura del Proyecto
swift
Copiar
Editar
camel-rabbit-lab/
├── src/
│   ├── main/java/com/ejemplo/camel/
│   │   ├── MainApp.java
│   │   ├── ProducerRoute.java
│   │   └── ConsumerRoute.java
│   └── test/java/com/ejemplo/camel/
│       └── AppTest.java
├── pom.xml
Funcionamiento
ProducerRoute: Genera un mensaje cada 5 segundos y lo publica en la cola test.camel.queue.

ConsumerRoute: Se suscribe a la cola y procesa los mensajes recibidos.

RabbitMQ: Gestiona el almacenamiento, entrega y monitoreo de los mensajes, permitiendo el desacoplamiento entre productor y consumidor.

Evidencias
Capturas de pantalla de la consola de administración de RabbitMQ mostrando la cola test.camel.queue activa y procesando mensajes.

Logs de la aplicación mostrando los mensajes enviados y recibidos por Camel.

Demostración del desacoplamiento: si el consumidor está detenido, los mensajes se acumulan en la cola; al reiniciar el consumidor, los mensajes pendientes se procesan automáticamente.

Explicación Técnica
Qué patrón de integración se aplicó
Se aplicó el patrón de mensajería asíncrona mediante Message Broker utilizando RabbitMQ como intermediario. El productor publica mensajes en una cola, y el consumidor los procesa de forma desacoplada, siguiendo los principios de publicar-suscribirse y message queue.

Cómo se logró el desacoplamiento productor-consumidor
El productor y el consumidor son independientes:

El productor envía mensajes a la cola test.camel.queue sin conocer ni depender del consumidor.

El consumidor escucha la cola y procesa mensajes cuando estén disponibles.

RabbitMQ actúa como intermediario, almacenando los mensajes hasta que el consumidor los procese.

Si el consumidor no está activo, los mensajes se acumulan y no se pierden.

Ventajas que se observaron durante la práctica
Desacoplamiento real: Productores y consumidores se pueden desarrollar y mantener de forma independiente.

Tolerancia a fallos: Si el consumidor falla, los mensajes se conservan en la cola hasta que vuelva a estar activo.

Escalabilidad: Es fácil agregar más consumidores o productores según la necesidad.

Monitoreo y visibilidad: La consola de RabbitMQ permite ver el flujo y estado de los mensajes en tiempo real.

Flexibilidad: Permite cambios y mejoras en los sistemas de manera aislada.

Autor
Kevin Rosero
Universidad: [Tu Universidad]
Materia: Sistemas Integrados
Año: 2025

yaml
Copiar
Editar

---

¡Ahora sí, solo tienes que copiar y pegar al README.md, Kevin!
