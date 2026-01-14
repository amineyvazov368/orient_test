package selfStudy.tickerReservation.services;

import selfStudy.tickerReservation.clases.Customer;
import selfStudy.tickerReservation.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(int id) {
       return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
