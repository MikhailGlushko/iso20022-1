package net.toregard.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item implements Serializable {
    private static final long serialVersionUID = -5925319981474638197L;

    @Id
    private String productId;
    private BigDecimal amount;
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    Long Ordreid;

}
