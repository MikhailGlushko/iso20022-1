package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


@Entity(name = "CUSTOMER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer implements Serializable {

    private static final long serialVersionUID = 2812586255003539133L;

    @Id //signifies the primary key
    @Column(name = "CUSTOMER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false,length = 50)
    private String lastName;

    @Column(unique = true,name = "EMAIL_ADDRESS")
    @Embedded
    private EmailAddress emailAddress;

    /**
     * (Uni Directional)
     * We use @JoinColumn  with the addresses property,
     which causes the persistence provider to add another column
     to the table backing the Address object. This additional
     column will then be used to refer to the Customer to allow
     joining the tables. If we had left out the additional annotation(@JoinColumn),
     the persistence provider would have created a dedicated join table
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CUSTOMER_ID")
    private Set<Address> addresses;

//    @Column(name = "STREET")
//    private String street;

//    @OneToMany(mappedBy="customer",targetEntity=Order.class,
//            fetch=FetchType.EAGER)
//    private Collection orders;
}
