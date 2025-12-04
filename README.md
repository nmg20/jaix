# JAIX - Sistema de Gestión Musical

## Descripción General

JAIX es un sistema modular para la gestión, parsing, descarga y
organización de música a partir de playlists externas, principalmente de
YouTube. La arquitectura está basada en un backend principal en Java
(Spring Boot), un microservicio externo en Python (FastAPI + yt-dlp) y
un frontend desacoplado en React (Vite).

El objetivo principal del sistema es: - Parsear playlists externas. -
Normalizar y almacenar pistas. - Descargar audio. - Gestionar playlists
internamente. - Exponer toda la funcionalidad mediante una API REST.

------------------------------------------------------------------------

## Arquitectura del Sistema

JAIX está compuesto por tres módulos desacoplados:

### 1. Backend Principal **Jaix** (Java - Spring Boot)

-   Puerto por defecto: 8080
-   Responsabilidades:
    -   API REST principal.
    -   Gestión de playlists.
    -   Persistencia de tracks.
    -   Orquestación con microservicios.
    -   Lógica de negocio.

### 2. Microservicio de Parsing **aix-yt-dlp** (Python - FastAPI)

-   Puerto por defecto: 8000
-   Responsabilidades:
    -   Recepción de URLs o IDs de playlists.
    -   Parsing de playlists con yt-dlp.
    -   Devolución de metadatos normalizados.

### 3. Frontend (React + Vite)

-   Interfaz gráfica desacoplada.
-   Consumo de la API REST del backend Java.
-   Visualización de playlists, descargas y tracks.

------------------------------------------------------------------------

## Entidades Principales

### Track (Entidad Principal)

Representa una pista musical dentro del sistema.

Campos principales: - id - title - artist - album - releaseDate -
duration - route - info

### ExternalTrackDTO (DTO de Integración)

Representa una pista recibida desde el microservicio **aix-yt-dlp**.

Campos: - title - artist - album - duration - url - filePath

------------------------------------------------------------------------

## Flujo de Funcionamiento

1.  El frontend solicita el parseo de una playlist.
2.  El backend Java recibe la solicitud.
3.  Java delega el parsing al microservicio Python.
4.  Python devuelve la lista de pistas.
5.  Java transforma los DTOs en entidades Track.
6.  Las pistas se almacenan o procesan.
7.  El resultado se devuelve al frontend.

------------------------------------------------------------------------

## Cómo Arrancar el Proyecto

### 1. Microservicio Python

Activar entorno virtual del proyecto
Instalar con pip dependencias en requirements.txt
Arrancar con: uvicorn app:app --reload --port 8000

### 2. Backend Java

Requisitos: - Java 21 - Maven - Spring Boot

Arranque: - mvn clean install - mvn spring-boot:run

### 3. Frontend

Requisitos: - Node.js 18+

Arranque: - npm install - npm run dev

------------------------------------------------------------------------

## Módulos Externos

**Jaix**: - Spring Web - Spring Data JPA - WebClient - Hibernate

[aix-yt-dlp](https://github.com/nmg20/aix-yt-dlp): - FastAPI - yt-dlp - Pydantic - Uvicorn

[Frontend](https://github.com/nmg20/jaix-frontend): - React - Vite - Axios

------------------------------------------------------------------------

## Comunicación Entre Servicios

-   **Jaix** se comunica con **aix-yt-dlp** mediante WebClient.

-   El microservicio **aix-yt-dlp** expone: GET /playlists/parse?id=PLAYLIST_ID

-   Java transforma la respuesta JSON en: ExternalTrackDTO → Track

------------------------------------------------------------------------

## Roadmap Actual

-   Finalizar integración limpia Java ↔ Python.
-   Endpoint de descarga de audio.
-   Persistencia estable de playlists.
-   Autenticación.
-   Testing.
-   Documentación.

------------------------------------------------------------------------

## Objetivo del Proyecto

Crear una plataforma extensible para la gestión musical basada en
microservicios, con posibilidades de integración futura de IA, sistemas
de recomendación y análisis de datos musicales.
