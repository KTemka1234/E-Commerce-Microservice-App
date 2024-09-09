package ru.app.customer.dto;

import ru.app.customer.document.Address;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {

}
