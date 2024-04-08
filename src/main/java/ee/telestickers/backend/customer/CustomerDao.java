package ee.telestickers.backend.customer;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerByTgId(Integer id);
    ResponseEntity<Customer> insertCustomer(Customer customer);
    ResponseEntity<Customer> updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    boolean existsCustomerWithId(Long id);
    boolean existsCustomerWithTgId(Integer tgId);
    Customer findCustomerByOrderId(Long orderId);
}
