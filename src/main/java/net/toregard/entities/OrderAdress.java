package net.toregard.entities;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderAdress {
    private String type;
    private String street, city, country;

}
