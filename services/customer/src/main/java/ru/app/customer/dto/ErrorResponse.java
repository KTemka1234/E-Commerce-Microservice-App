package ru.app.customer.dto;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
