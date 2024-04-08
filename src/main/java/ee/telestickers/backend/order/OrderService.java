package ee.telestickers.backend.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderDao orderDao;
    public OrderService(@Qualifier("order_jpa") OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrders() {
        return orderDao.getAllOrders();
    }

    public Optional<Order> getOrder(Long id) {
        return orderDao.getOrderById(id);
    }

    public ResponseEntity<Order> save(OrderAddRequest order) {
        return orderDao.addOrder(order);
    }

    public List<Order> getOrdersByUserTgId(Integer userId) {
        return orderDao.getOrdersByUserTgId(userId);
    }
}
