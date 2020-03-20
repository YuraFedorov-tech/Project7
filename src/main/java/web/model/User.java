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
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Accessors(chain = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "fix_user")
public class User {

    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        roles.add(role);
    }

    public User(String password, String name, Role role, Long id) {
        this.id = id;
        this.name = name;
        this.password = password;
        roles.add(role);
    }
    public User(String password, String name, Long id) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User(String name, String password, List<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    public User(String name, String password, List<Role> roles,Long id) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.id = id;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void setAuthorities(List<Role> roles) {
        this.roles = roles;
    }

}
