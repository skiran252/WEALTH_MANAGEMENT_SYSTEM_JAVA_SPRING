package demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.TransactionDao;
import demo.dao.UserDao;
import demo.model.Stats;
import demo.model.User;

@Controller
public class BaseController {
	
	@Autowired 
	TransactionDao transactionDao;

	@Autowired
	UserDao userDao;
	
	@Transactional
	@GetMapping("/")
	public ModelAndView showHome(Principal principal) {
		ModelAndView mav = new ModelAndView("dashboard");
		User currentuser = userDao.findUserById(principal.getName());
		Stats stats = transactionDao.getTransactionStats(currentuser);
		mav.addObject("stats",stats);
		return mav;
	}
}
