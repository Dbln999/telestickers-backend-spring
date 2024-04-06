package ee.telestickers.backend.order;

import ee.telestickers.backend.customer.Customer;
import ee.telestickers.backend.customer.CustomerService;
import ee.telestickers.backend.stickerpack.StickerPack;
import ee.telestickers.backend.stickerpack.StickerPackService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("order_jpa")
public class OrderJPAService implements OrderDao{

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final StickerPackService stickerPackService;

    public OrderJPAService(OrderRepository orderRepository, CustomerService customerService, StickerPackService stickerPackService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.stickerPackService = stickerPackService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addOrder(OrderAddRequest order) {
        Customer customer = customerService.getCustomerByTgId(order.tgId());
        StickerPack stickerPack = stickerPackService.getStickerPack(order.stickerPackId());
        Order newOrder = new Order(customer, stickerPack, order.printfulId());
        orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getOrdersByUserTgId(Integer tgId) {
        Customer customer = customerService.getCustomerByTgId(tgId);
        return orderRepository.findAllByCustomerId(customer.getId());
    }
}
