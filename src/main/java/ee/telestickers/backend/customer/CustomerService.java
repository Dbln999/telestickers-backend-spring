package ee.telestickers.backend.customer;

import ee.telestickers.backend.exception.RequestValidationException;
import ee.telestickers.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("customer_jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByTgId(Integer tgId) {
        return customerDao.getCustomerByTgId(tgId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + tgId + " not found"));
    }

    public ResponseEntity<Customer> addCustomer(CustomerAddRequest customerAddRequest) {
        Integer tgId = customerAddRequest.tgId();

        if(customerDao.existsCustomerWithTgId(tgId)) {
            return updateCustomer(tgId, customerAddRequest);
        }
        else {
            Customer customer = new Customer(customerAddRequest.tgId(), customerAddRequest.firstname(), customerAddRequest.lastname(), customerAddRequest.country(), customerAddRequest.address(), customerAddRequest.postcode(), customerAddRequest.phoneNumber(), customerAddRequest.email(), customerAddRequest.city());
            return customerDao.insertCustomer(customer);
        }


    }

    public Customer findCustomerByOrderId(Long orderId) {
        return customerDao.findCustomerByOrderId(orderId);
    }

    public ResponseEntity<Customer> updateCustomer(Integer tgId, CustomerAddRequest customerAddRequest) {
        Customer customer = getCustomerByTgId(tgId);
        boolean changes = false;

        if(customerAddRequest.firstname() != null && !customerAddRequest.firstname().equals(customer.getFirstname())) {
            customer.setFirstname(customerAddRequest.firstname());
            changes = true;
        }

        if(customerAddRequest.lastname() != null && !customerAddRequest.lastname().equals(customer.getLastname())) {
            customer.setLastname(customerAddRequest.lastname());
            changes = true;
        }

        if(customerAddRequest.email() != null && !customerAddRequest.email().equals(customer.getEmail())) {
            customer.setEmail(customerAddRequest.email());
            changes = true;
        }

        if(customerAddRequest.postcode() != null && !customerAddRequest.postcode().equals(customer.getPostcode())) {
            customer.setPostcode(customerAddRequest.postcode());
            changes = true;
        }

        if(customerAddRequest.country() != null && !customerAddRequest.country().equals(customer.getCountry())) {
            customer.setCountry(customerAddRequest.country());
            changes = true;
        }

        if(customerAddRequest.address() != null && !customerAddRequest.address().equals(customer.getAddress())) {
            customer.setAddress(customerAddRequest.address());
            changes = true;
        }

        if(customerAddRequest.phoneNumber() != null && !customerAddRequest.phoneNumber().equals(customer.getPhoneNumber())) {
            customer.setPhoneNumber(customerAddRequest.phoneNumber());
            changes = true;
        }

        if(!changes) {
            throw new RequestValidationException("No customer changes found!");
        }

        return customerDao.updateCustomer(customer);
    }


}
