package net.toregard.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements Serializable {

    private static final long serialVersionUID = 4601956571293332206L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    private Account account;
    private String role;
}

//Tables:
//        User {id, name}
//        Group {id, name}
//        Rights {id, name}
//        Join tables:
//        User_in_group {user_id, group_id}
//        //Rows only created when adding user
// to a group User_in_Group_has_Rights{rights_id, user_in_group_id} //Rows only created when assigning a 'user_in_group' some rights From a database view that's what I was thinking. Mapping the first 3 tables to JPA should be no problem. The next two I'm not sure how. From here