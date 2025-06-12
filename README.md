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
