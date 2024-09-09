package ru.app.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import ru.app.customer.document.Address;

public record CustomerRequest(
    String id,

    @NotNull(message = "Customer firstname is required")
    String firstname,

    @NotNull(message = "Customer lastname is required")
    String lastname,

    @NotNull(message = "Customer email is required")
    @Email(message = "Customer email is not valid email address")
    String email,
    
    Address address
) {
}
