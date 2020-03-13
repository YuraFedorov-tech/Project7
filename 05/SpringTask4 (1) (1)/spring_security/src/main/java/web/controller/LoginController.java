package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *
 *@Data 13.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */
@Controller
public class LoginController {
    private static int r=0;
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(Authentication authentication) {
        if(authentication!=null)
            return "redirect:/user";
        return "login";
    }
}
