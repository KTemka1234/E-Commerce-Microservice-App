package ru.app.order.feignclient.customer;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email
) {

}
