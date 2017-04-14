package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "ORDER_INVOICE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice implements Serializable {

    private static final long serialVersionUID = -951741925367906380L;

    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;

    @Column(name = "AMOUNT_DUE", precision = 2)
    private double amountDue;

    @Column(name = "DATE_RAISED")
    private Date orderRaisedDt;

    @Column(name = "DATE_SETTLED")
    private Date orderSettledDt;

    @Column(name = "DATE_CANCELLED")
    private Date orderCancelledDt;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

//    @OneToOne(optional=false)
//    @JoinColumn(name = "ORDER_ID")
//    private Order order;
}
