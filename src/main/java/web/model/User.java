package web.model;
/*
 *
 *@Data 04.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Set;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Accessors(chain = true)

@NoArgsConstructor
@Entity
@Table(name = "fix_user")
public class User {

    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        roles.add(role);
}

    public User( String password, String name, Role role,Long id) {
        this.id = id;
        this.name = name;
        this.password = password;
        roles.add(role);
    }

//    public User(String password, String username, Role user, Long id) {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


    @ManyToMany(mappedBy = "RoleUser",fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
