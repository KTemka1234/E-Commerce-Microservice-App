# E-COMMERCE-MICROSERVICE-APP

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Микросервисное приложение для иммитации процессов интернет магазина, разработанное как pet-проект для изучения и закрепления навыков работы с микросервисной архитектурой.

## 🏗️ Архитектура

![App structure][structure_img]

[structure_img]: docs/images/app_structure.jpg

## 📌 О проекте

Этот проект представляет собой backend часть для e-commerce приложения, которое разбито на независимые микросервисы. Каждый сервис отвечает за определенную бизнес-логику и взаимодействует с другими сервисами через REST API (Open Feign).

## 🛠 Технологический стек

### Основные технологии

- **Java 21**
- **Spring Framework 6**
  - Spring Boot 3
  - Spring Data JPA
  - Spring Validation
  - Lombok
  - Flyway migration
  - Spring Cloud Config Server
  - Spring Cloud Discovery (Netflix Eureka)
  - Spring Actuator
  - Distributed tracing with Zipkin
  - Spring OpenFeign
  - Spring Gateway
- **Базы данных**
  - PostgreSQL
  - MongoDB
- **Мессенджер**: Apache Kafka
- **Аутентификация**: Keycloak
- **Уведомления**: Java Mail Sender
- **Контейнеризация**: Docker (docker-compose)

## ⚙️ Установка и запуск

### Требования

* JDK 21
* Maven
* Docker (docker-compose)

### 1. Клонирование репозитория

```bash
git clone https://github.com/KTemka1234/E-Commerce-Microservice-App.git
cd ./E-Commerce-Microservice-App
```

### 2. Настройка окружения

Создайте файл переменных среды **.env** в корне проекта на основе файла [example.env](example.env):

```bash
SPRING_ACTIVE_PROFILE=dev # docker or dev (dev for local startup without docker)

POSTGRES_USER=user
POSTGRES_PASSWORD=password

PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org
PGADMIN_DEFAULT_PASSWORD=password

MONGO_USER=user
MONGO_PASSWORD=password

MONGO_EXPRESS_USER=user
MONGO_EXPRESS_PASSWORD=password

MAIL_DEV_USER=user
MAIL_DEV_PASSWORD=password

FLYWAY_USER=user
FLYWAY_PASSWORD=password

KEYCLOAK_ADMIN=user
KEYCLOAK_ADMIN_PASSWORD=password
```

### 3. Запуск через docker-compose

**На данный момент полностью запустить проект в docker'е не получится из-за нерешённой проблемы с *Eureka Discovery Server***

### 4. Ручной запуск
Перед запуском программы убедитесь, что у вас создан файл *.env* и есть переменная среды *SPRING_ACTIVE_PROFILE=dev*.

**Запуск инфраструктуры проекта**

```bash
docker compose -f ./docker-compose.yml up -d --build
```

Дождитесь, когда запустятся все сервисы. Если возникла ошибка о том, что какой-то из сервисов имеет статус unhealthy, то выполните команду выше повторно без остановки уже запущенных сервисов.

**Запуск микросервисов**

Чтобы сервисы не падали с ошибкой, необходимо их запустить в определённом порядке:

1. config-server
2. discovery
3. customer, order, notification, payment, product (порядок не имеет значения)
4. gateway

## 🌐 Доступ к приложению

### 1. Настройка Keycloak и Postman

Перед тем, как использовать API нужно настроить Keycloak и Postman для авторизации - [гайд здесь](docs/Keycloak_Postman%20setup.md).

### 2. Ресурсы

* **API Gateway**: http://localhost:8222 (Коллекция Postman с готовым к использованию REST API [здесь](./postman))
* **Eureka discovery server**: http://localhost:8761
* **Keycloak**: http://localhost:8080
* **Zipkin Tracing**: http://localhost:9411
* **Mail dev**: http://localhost:1025
* **Kafka manager**: http://localhost:9000
* **Mongo Express**: http://localhost:8081
* **PGadmin**: http://localhost:5050

## 📜 License

MIT License. Подробнее см. в файле [LICENSE](LICENSE).
