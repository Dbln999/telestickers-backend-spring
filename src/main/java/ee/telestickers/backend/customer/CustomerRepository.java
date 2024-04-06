package ee.telestickers.backend.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByTgId(Integer tgId);
    boolean existsCustomerById(Long id);
    boolean existsCustomerByTgId(Integer tgId);
    Customer findCustomerByOrdersId(Long orderId);
}
