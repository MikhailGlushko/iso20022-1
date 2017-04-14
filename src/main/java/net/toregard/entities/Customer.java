package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "CUSTOMER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer implements Serializable {

    private static final long serialVersionUID = 2812586255003539133L;

    @Id //signifies the primary key
    @Column(name = "CUST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false,length = 50)
    private String lastName;

    @Column(name = "STREET")
    private String street;
    @OneToMany(mappedBy="customer",targetEntity=Order.class,
            fetch=FetchType.EAGER)
    private Collection orders;
}
