package web.repository;
/*
 *
 *@Data 24.02.2020
 *@autor Fedorov Yuri
 *@project ru.yura
 *
 */

import web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    Optional<User> findOneByName(String name);

}
