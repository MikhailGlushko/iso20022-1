package net.toregard.restkontroller;

import net.toregard.entities.*;
import net.toregard.persistence.AddressRepository;
import net.toregard.persistence.CustomerRepository;
import net.toregard.persistence.OrderRepository;
import net.toregard.persistence.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerKontroller {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value= "/create",
            produces = "application/json",
            method = RequestMethod.GET)
    public Order create() {
        log.info("Start customerRepository*******************************");
        Address address = Address.builder().city("Oslo")
                .country("Norway")
                .street("Øvre Movei 23")
                .build();
        Address address2 = Address.builder().city("Oslo")
                .country("Norway")
                .street("Øvre Movei 24")
                .build();
        Set<Address> setAddresses = new HashSet<Address>();
        setAddresses.add(address);
        setAddresses.add(address2);

        EmailAddress email = new EmailAddress("todo@live.no");
        Customer customer =Customer.builder().firstName("Tore Gard")
                .lastName("Andersen")
                .addresses(setAddresses)
                .emailAddress(email)
                .build();
        Customer _customer =customerRepository.saveAndFlush(customer);
        log.info("saved customer");
        EmailAddress emailAddress=new EmailAddress("todo@gmail.com");
        address = addressRepository.findOne(2L);
        Order order = new Order(_customer,address,address2);
        LineItem item1 = LineItem.builder()
                .price(new BigDecimal(2000))
                .amount(2)
                .product(productRepository.findOne(1L))
                .build();
        order.setLineItems(new HashSet<LineItem>());
        order.getLineItems().add(item1);
        log.info("saved order");
        Order _order =orderRepository.saveAndFlush(order);

        customerRepository.delete(1L);

        return  _order;
    }
}
