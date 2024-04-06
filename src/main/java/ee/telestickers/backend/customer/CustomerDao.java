package ee.telestickers.backend.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerByTgId(Integer id);
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    boolean existsCustomerWithId(Long id);
    boolean existsCustomerWithTgId(Integer tgId);
    Customer findCustomerByOrderId(Long orderId);
}
