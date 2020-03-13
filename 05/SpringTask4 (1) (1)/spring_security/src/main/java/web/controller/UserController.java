package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	UsersRepository usersRepository;
//	@RequestMapping(value = "changeUser", method = RequestMethod.GET)
//	public String printWelcome1(ModelMap modelMap) {
//		List<User> users = usersRepository.findAll();
//		System.out.println(users);
//		modelMap.addAttribute("userInJDBC", users);
//		return "hello";
//	}
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}



}