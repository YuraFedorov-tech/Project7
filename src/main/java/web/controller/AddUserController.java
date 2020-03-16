package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Role;
import web.model.User;
import web.repository.UsersRepository;

import javax.servlet.http.HttpServletRequest;

/*
 *
 *@Data 13.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */
@Controller
public class AddUserController {
    @Autowired
    UsersRepository usersRepository;

    @PostMapping(value = "addUser")
    public String postAddCar(HttpServletRequest req) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = new User().setName(name).setPassword(password).setRole(Role.USER);
        usersRepository.save(user);
        return "redirect:/login";
    }
    @GetMapping (value = "/addUser")
    public String getAddCar() {
        return "addUser";
    }

}
