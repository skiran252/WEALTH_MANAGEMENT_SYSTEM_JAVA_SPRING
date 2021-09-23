package demo.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.AuthorityDaoimpl;
import demo.dao.UserDao;
import demo.model.Authority;
import demo.model.User;

@Controller
public class UserController {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private UserDao userdao;

	@Autowired
	private AuthorityDaoimpl authoritydao;

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

	@Transactional
	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		ModelAndView mav = null;
		int notexists = userdao.save(user);
		if (notexists == 1) {
			authoritydao.save(new Authority(user.getUsername(), "ROLE_USER"));
			return new ModelAndView("login", "created", "user created please login");
		} else {
			mav = new ModelAndView("login", "duplicateuser", "Username already exists!!");
			return mav;
		}
	}

	@GetMapping("/access_denied")
	public String showAccessDeniedPage() {
		return "accessdenied";
	}
}
