package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *  @ManyToOne annotation that will actually be turned
 *  into a product_id column in the LineItem table pointing to the Product
 */
@Entity(name = "LINEITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LineItem {
    @Id //signifies the primary key
    @Column(name = "CUST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private BigDecimal price;
    private int amount;
}
