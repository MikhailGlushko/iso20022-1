package net.toregard.entities;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account implements Serializable {

    private static final long serialVersionUID = 8396870005651269970L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String username;
    private String password;

    @OneToMany(mappedBy="account")
    @OrderBy("name ASC")
    private List<Role> roles;



}
