package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "PRODUCT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    private static final long serialVersionUID = 3320762842201254389L;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROD_NAME", nullable = false,length = 50)
    private String name;

    @Column(name = "PROD_DESC", length = 200)
    private String description;

    @Column(name = "REGULAR_PRICE", precision = 2,nullable = false)
    private double price;

    @Column(name = "LAST_UPDATED_TIME")
    private LocalDateTime updatedTime;

    @ElementCollection
    private Map<String, String> attributes = new HashMap<String, String>();

    //@ManyToMany(mappedBy="productList",fetch=FetchType.EAGER)
    //private List<Order> orderList;
}
