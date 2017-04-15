package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address implements Serializable {

    private static final long serialVersionUID = 3654615882215336996L;
    @Id //signifies the primary key
    @Column(name = "ADDRESS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String street, city, country;

}
