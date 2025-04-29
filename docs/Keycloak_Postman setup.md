# Настройка Keycloak и Postman

## Keycloak

**Шаг 1.** Создать realm *micro-api*
![Realm creation][realm-creation_img]

[realm-creation_img]: images/keycloak/realm-creation.png

**Шаг 2.** Переключиться на созданный realm и сделать клиента *microservices-api*
![Client creation 1][client-creation-1_img]
![Client creation 1][client-creation-2_img]

[client-creation-1_img]: images/keycloak/client-creation_1.png
[client-creation-2_img]: images/keycloak/client-creation_2.png

**Шаг 3.** Скопировать значение из поля *Client Secret*
![Client secret copy][copy-client-secret_img]

[copy-client-secret_img]: images/keycloak/copy-client-secret.png

## Postman

**Шаг 1.** В настройках коллеции запросов открыть вкладку *Authorization*, в селекторе *Auth Type* выбрать *OAuth 2.0* и в секции *Configure New Token* вставить в поле *Access Token URL* следующее значение: http://localhost:8080/realms/micro-api/protocol/openid-connect/token

![API collection auth setup][auth-setup_img]

[auth-setup_img]: images/postman/auth-setup.png

**Шаг 2.** В том же разделе в поле Client ID вставить занчение *microservices-api*, а в поле Client Secret вставить ранее скопированное значение из Keycloak (см. шаг 3)

Если всё было сделано правильно, то в Postman должно появиться сообщение об успешной настройке аутентификации.
