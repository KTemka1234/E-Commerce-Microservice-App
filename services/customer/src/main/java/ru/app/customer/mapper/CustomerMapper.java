package ru.app.customer.mapper;

import org.springframework.stereotype.Service;
import ru.app.customer.document.Customer;
import ru.app.customer.dto.CustomerRequest;
import ru.app.customer.dto.CustomerResponse;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null)
            return null;

        return Customer.builder().id(request.id()).firstname(request.firstname())
                .lastname(request.lastname()).email(request.email()).address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
            customer.getId(),
            customer.getFirstname(),
            customer.getLastname(),
            customer.getEmail(),
            customer.getAddress()
        );
    }
}
