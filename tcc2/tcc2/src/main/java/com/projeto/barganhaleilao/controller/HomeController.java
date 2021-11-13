package com.projeto.barganhaleilao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {

	
	@RequestMapping("/home")
	public String novo() {
		return "Home";
	}
	

}
