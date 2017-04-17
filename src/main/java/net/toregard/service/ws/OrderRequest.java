package net.toregard.service.ws;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderRequest",
        propOrder = {
                "customerId",
                "itemId",
                "amount"
        })
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {
    @XmlElement(name = "CustomerId", required = true)
    private Long customerId;
    @XmlElement(name = "ItemId", required = true)
    private Long itemId;
    @XmlElement(name = "Amount", required = true)
    private double amount;
}
