package web.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.forms.UserForm;
import web.model.*;
import web.security.securityDitel.UserDetailesImpl;
import web.service.UserService;

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
    UserService userService;

    @PostMapping(value = "addUser")
    public String postAddCar(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User(userForm.getName(), userForm.getPassword(), roles);
        userService.add(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/addUser")
    public String getAddUser() {
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

    @GetMapping(value = "admin/changeUser")
    public String getChangeCar(ModelMap modelMap) {
        List<User> users = userService.findAll();
        modelMap.addAttribute("userInJDBC", users);
        return "crud";
    }


    @PostMapping(value = "admin/deleteUser")
    public String deleteCar(HttpServletRequest req) {
        String[] items = req.getParameterValues("Delete");
        for (String str : items) {
            try {
                Long id = Long.parseLong(str);
                userService.delete(id);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/changeUser";
    }

    @GetMapping(value = "admin/updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userService.findById(id);
        model.addAttribute("User", user);
        return "change";
    }

    @PostMapping(value = "admin/updateUser")
    public String postUpdateUser(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User(userForm.getPassword(), userForm.getName(), roles, userForm.getId());
        userService.add(user);
        return "redirect:/admin/changeUser";
    }


}
