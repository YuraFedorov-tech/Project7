package web.security.securityDitel;
/*
 *
 *@Data 07.03.2020
 *@autor Fedorov Yuri
 *@project ru.yura
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UsersRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    //    Optional<User> userCandidate = usersRepository.findOneByLogin(login);
        Optional<User> userCandidate = usersRepository.findOneByName(name);
//        if (userCandidate.isPresent()) {
//            return new UserDetailsImpl(userCandidate.get());
//        } else throw new IllegalArgumentException("User not found");
        return new
                UserDetailesImpl(usersRepository.findOneByName(name)
                .orElseThrow(IllegalArgumentException::new));
    }
}
