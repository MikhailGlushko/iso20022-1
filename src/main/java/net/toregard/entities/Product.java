package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "PRODUCT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    private static final long serialVersionUID = 3320762842201254389L;

    @Id
    @Column(name = "PROD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prodId;

    @Column(name = "PROD_NAME", nullable = false,length = 50)
    private String prodName;

    @Column(name = "PROD_DESC", length = 200)
    private String prodDescription;

    @Column(name = "REGULAR_PRICE", precision = 2)
    private double price;

    @Column(name = "LAST_UPDATED_TIME")
    private LocalDateTime updatedTime;

    //@ManyToMany(mappedBy="productList",fetch=FetchType.EAGER)
    //private List<Order> orderList;
}
