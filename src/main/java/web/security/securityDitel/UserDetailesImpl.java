package web.security.securityDitel;
/*
 *
 *@Data 07.03.2020
 *@autor Fedorov Yuri
 *@project ru.yura
 *
 */

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.model.User;

import java.util.Collection;
import java.util.Collections;


public class UserDetailesImpl implements UserDetails {
    private User user;

    public UserDetailesImpl(User user) {
        this.user = user;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       // String userRole = user.getRole().name();
   //     String userRole=user.getRoles().toString();
   //     Collection<? extends GrantedAuthority> userRoles=user.getAuthorities();
     //   SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
