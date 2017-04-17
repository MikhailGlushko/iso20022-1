package net.toregard.entities;

import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * http://www.javaworld.com/article/2077817/java-se/understanding-jpa-part-1-the-object-oriented-paradigm-of-data-persistence.html
 * https://www.safaribooksonline.com/library/view/spring-data/9781449331863/ch04.html
 */

@Entity(name = "ORDERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = -2470071466425087308L;

    @Id //signifies the primary key
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Address shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<LineItem> lineItems;

    public Order(Customer customer,
                 Address shippingAddress,
                 Address billingAddress) {
        Assert.notNull(customer,"OrderRequest is null");
       Assert.notNull(shippingAddress,"shippingAddress is null");
        this.customer = customer;
        //this.emailAddress=emailAddress;
        this.shippingAddress = shippingAddress;
//        if(billingAddress == null) this.billingAddress=null; else
//            BeanUtils.copyProperties(billingAddress,this.billingAddress);
    }
}
