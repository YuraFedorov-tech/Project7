package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.forms.UserForm;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UsersRepository;
import web.security.securityDitel.UserDetailesImpl;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*
 *
 *@Data 06.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Controller
public class ChangeUsersController {
    @Autowired
    private final UsersRepository usersRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;

    public ChangeUsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping(value = "addUser")
    public String postAddCar(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
   //     roles.add(new Role("ADMIN"));
        User user = new User(userForm.getName(), userForm.getPassword(), roles);
        usersRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/addUser")
    public String getAddCar() {
        return "addUser";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/user";
        }
        return "login";
    }



    @GetMapping(value = "user")
    public String getUser(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailesImpl userDetailes = (UserDetailesImpl) authentication.getPrincipal();
        User user = new User(userDetailes.getPassword(), userDetailes.getUsername(),  userDetailes.getUser().getId());
        System.out.println(user);
        modelMap.addAttribute("userInJDBC", user);
        return "seeUser";
    }

    @GetMapping(value = "changeUser")
    public String getChangeCar(ModelMap modelMap) {
        List<User> users = usersRepository.findAll();
        modelMap.addAttribute("userInJDBC", users);
        return "crud";
    }


    @PostMapping(value = "deleteUser")
    public String deleteCar(HttpServletRequest req) {
        String[] items = req.getParameterValues("Delete");
        for (String str : items) {
            try {
                Long id = Long.parseLong(str);
                usersRepository.delete(usersRepository.findUserById(id));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return "redirect:/changeUser";
    }

    @GetMapping(value = "updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = usersRepository.findUserById(id);
        model.addAttribute("User", user);
        return "change";
    }

    @PostMapping(value = "updateUser")
    public String postUpdateUser(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User(userForm.getPassword(), userForm.getName(), roles, userForm.getId());
        usersRepository.save(user);
        return "redirect:/changeUser";
    }


}
