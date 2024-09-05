package ru.app.customer.service;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ru.app.customer.document.Customer;
import ru.app.customer.dto.CustomerRequest;
import ru.app.customer.dto.CustomerResponse;
import ru.app.customer.exception.CustomerNotFoundException;
import ru.app.customer.mapper.CustomerMapper;
import ru.app.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(String.format(
                        "Cannot update customer: no customer found with the provided id: %s",
                        request.id())));
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll().stream().map(mapper::fromCustomer).collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId).map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("No customer found with the provided ID: %s", customerId)));
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(null);
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
