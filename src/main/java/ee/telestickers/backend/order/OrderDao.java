package ee.telestickers.backend.order;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    ResponseEntity<Order> addOrder(OrderAddRequest order);
    List<Order> getOrdersByUserTgId(Integer tgId);
}
