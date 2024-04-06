package ee.telestickers.backend.order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    void addOrder(OrderAddRequest order);
    List<Order> getOrdersByUserTgId(Integer tgId);
}
