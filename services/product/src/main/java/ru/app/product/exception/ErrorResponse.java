package ru.app.product.exception;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
