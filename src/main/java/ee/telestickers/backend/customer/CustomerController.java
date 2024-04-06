package ee.telestickers.backend.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{tgId}")
    public Customer getCustomer(@PathVariable("tgId") Integer tgId) {
        return customerService.getCustomerByTgId(tgId);
    }

    @PostMapping()
    public void createCustomer(@RequestBody CustomerAddRequest customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping("/order/{orderId}")
    public Customer getCustomerByOrderId(@PathVariable("orderId") Long orderId) {
        return customerService.findCustomerByOrderId(orderId);
    }


}
