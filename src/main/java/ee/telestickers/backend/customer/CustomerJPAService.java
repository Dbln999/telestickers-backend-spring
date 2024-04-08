package ee.telestickers.backend.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customer_jpa")
public class CustomerJPAService implements CustomerDao{

    private final CustomerRepository customerRepository;

    public CustomerJPAService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerByTgId(Integer id) {
        return Optional.ofNullable(customerRepository.findCustomerByTgId(id));
    }

    @Override
    public ResponseEntity<Customer> insertCustomer(Customer customer) {
        Customer saved = customerRepository.save(customer);
        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        Customer saved = customerRepository.save(customer);
        return ResponseEntity.ok(saved);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsCustomerWithId(Long id) {
        return customerRepository.existsCustomerById(id);
    }

    @Override
    public boolean existsCustomerWithTgId(Integer tgId) {
        return customerRepository.existsCustomerByTgId(tgId);
    }

    @Override
    public Customer findCustomerByOrderId(Long orderId) {
        return customerRepository.findCustomerByOrdersId(orderId);
    }


}
