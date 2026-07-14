# Spring Boot + MySQL + Redis (Dockerized)

A hands-on project demonstrating containerization of a Spring Boot application with a persistent MySQL database and a Redis caching layer, orchestrated using Docker Compose.

## What this project demonstrates
- Dockerizing a Spring Boot application (writing a Dockerfile, building images)
- Multi-container orchestration using Docker Compose
- MySQL integration via Spring Data JPA
- Redis caching using Spring's `@Cacheable` / `@CacheEvict`
- Health checks to solve container startup ordering issues
- Docker volumes for persisting database data across restarts

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cache + Redis
- MySQL 8
- Docker & Docker Compose

## Architecture
## Running locally

1. Clone the repo
```bash
git clone https://github.com/Ashwitha-Ulli/spring-boot-docker-redis-mysql.git
cd spring-boot-docker-redis-mysql
```

2. Build the jar
```bash
mvn clean package -DskipTests
```

3. Start all containers
```bash
docker-compose up -d --build
```

4. Test the API (using Postman or curl)

Add a book:
POST http://localhost:8080/add
Content-Type: application/json
{ "id": 1, "name": "Clean Code", "author": "Robert Martin" }

Fetch a book (first call hits MySQL, subsequent calls are served from Redis cache):
GET http://localhost:8080/book/1

Clear cache:
DELETE http://localhost:8080/cache/1

## Key learnings
- `depends_on` alone doesn't wait for a service to be ready, only that its container has started. Health checks are needed to properly sequence startup.
- Containers communicate using service names (e.g., `mysqldb`, `redis`) defined in `docker-compose.yml`, not `localhost`.
- Objects cached in Redis must implement `Serializable`.
- Docker images are immutable snapshots, code changes require rebuilding the image, not just restarting the container.

## Note
Credentials used here (root/root) are for local development only.

## What's next
Currently learning Kubernetes to understand how this kind of multi-container setup is deployed and orchestrated at scale in real production environments.
