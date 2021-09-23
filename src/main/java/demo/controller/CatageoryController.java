package demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.CategoryDao;
import demo.model.Category;
@Controller
public class CatageoryController {

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/addcategory")
	public ModelAndView addCategpry(Principal principal,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("addcategory");
		Category category = new Category();
		mav.addObject("category",category);
		return mav;
	}

	@Transactional
	@PostMapping("/addcategory")
	public ModelAndView addCategpryToDB(@ModelAttribute Category category,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");
		
		Category c= categoryDao.addCategory(category);
		if(c!=null) {
			mav.addObject("message", "category added");
		} else {
			mav.addObject("error", "category with title already exists");
		}
		return mav;
	}
}
