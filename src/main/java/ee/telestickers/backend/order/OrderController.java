package ee.telestickers.backend.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/get-user-orders/{id}")
    public List<Order> getUserOrders(@PathVariable Integer id) {
        return orderService.getOrdersByUserTgId(id);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderAddRequest order) {
        return orderService.save(order);
    }
}
