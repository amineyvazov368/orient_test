package selfStudy.tickerReservation.repositories;

import selfStudy.tickerReservation.clases.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    List<Customer> customerList;

    public CustomerRepository() {
        this.customerList = new ArrayList<>();
    }


    public void save(Customer customer) {
        customerList.add(customer);
    }

    public Optional<Customer> findById(int id) {
      return customerList.stream().filter(customer -> customer.getId() == id)
              .findFirst();
    }

    public List<Customer> findAll() {
        return customerList;
    }
}
