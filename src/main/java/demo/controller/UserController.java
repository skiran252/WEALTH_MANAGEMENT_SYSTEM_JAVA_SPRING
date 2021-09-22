package demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.UserDaoImpl;
import demo.model.User;

@Controller
public class UserController {
	private Logger logger = Logger.getLogger(getClass().getName());

	@GetMapping("/signin")
	public String showMyLoginPage() {
		return "login";
	}

	@GetMapping("/register")
	public ModelAndView showRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/register/save")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		ModelAndView mav = null;
		try {
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.save(user);
			return new ModelAndView("home", "firstname", user.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			mav = new ModelAndView("register");
			mav.addObject("message", "Username already exists!!");
			return mav;
		}
	}

	@GetMapping("/access_denied")
	public String showAccessDeniedPage() {
		return "accessdenied";
	}
}
