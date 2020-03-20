package web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.Set;


/*
 *
 *@Data 10.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Data
@NoArgsConstructor
@Entity
//public class Role implements GrantedAuthority {

@Table(name = "roles")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = -8186644851823152209L;

    @Id
    @Column(name = "ID_")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE")
    private String role;


    public Role(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }


}

//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    Set<User> users;
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    protected Role(){}
//    public Role(String name)
//    {
//        role = name;
//    }
//
//    @Override
//    public String getAuthority() {
//        return getRole();
//    }
//}