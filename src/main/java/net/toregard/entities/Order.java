package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * http://www.javaworld.com/article/2077817/java-se/understanding-jpa-part-1-the-object-oriented-paradigm-of-data-persistence.html
 *
 */


@Entity(name = "ORDERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = -2470071466425087308L;

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totPrice;

    @Column(name = "OREDER_DESC")
    private String orderDesc;

    @Column(name = "ORDER_DATE")
    private Date orderDt;

//    @OneToOne(optional=false,cascade=CascadeType.ALL,
//            mappedBy="order",targetEntity=Invoice.class)
//    private Invoice invoice;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    @ManyToOne(optional=false)
    @JoinColumn(name="CUST_ID")
    private Customer customer;
}
