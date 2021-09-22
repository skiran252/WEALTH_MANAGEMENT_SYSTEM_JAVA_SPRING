package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}


	@GetMapping("/admin")
	public String showAdminPanel() {
		return "systems";
	}
	
}
