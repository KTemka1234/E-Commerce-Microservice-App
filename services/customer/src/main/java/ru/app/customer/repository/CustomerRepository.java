package ru.app.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.app.customer.document.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
