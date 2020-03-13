package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Role;
import web.model.User;
import web.repository.UsersRepository;
import web.security.securityDitel.UserDetailesImpl;


import javax.servlet.http.HttpServletRequest;
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
    UsersRepository usersRepository;


    @GetMapping(value = "user")
    public String getUser(ModelMap modelMap, Authentication authentication) {
        if(authentication==null)
            return "redirect:/login";
        UserDetailesImpl userDetailes= (UserDetailesImpl) authentication.getPrincipal();
        User user=new User().setPassword(userDetailes.getPassword()).setName(userDetailes.getUsername()).setId(userDetailes.getUser().getId());
        System.out.println(user);
        modelMap.addAttribute("userInJDBC", user);
        return "seeUser";//
    }
    @GetMapping(value = "changeUser")
    public String getChangeCar(ModelMap modelMap) {
        List<User> users = usersRepository.findAll();
        System.out.println(users);
        modelMap.addAttribute("userInJDBC", users);
        return "crud";//
    }



    @PostMapping(value = "deleteUser")
    public String deleteCar(HttpServletRequest req) {
        String[] items = req.getParameterValues("Delete");
//assuming Order is your order class and orderList is your item list
        for (String str : items) {
            try {
                Long id=Long.parseLong(str);
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
    public String postUpdateUser(HttpServletRequest req) {
        //?id=<c:out value='${Car.id}' />
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Long id = Long.parseLong(req.getParameter("id"));
        User user = new User().setName(name).setPassword(password).setId(id).setRole(Role.USER);
        System.out.println(user);
        usersRepository.save(user);
        System.out.println(user);
        return "redirect:/changeUser";
    }
}
