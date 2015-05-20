package com.naru.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	 @RequestMapping("/main/hello")  
	 public ModelAndView test() {  
	  String message = "Welcome to Spring 4.0 !";
	  ModelAndView mav = new ModelAndView("/main/hello", "message", message);
	  System.out.println("hello");
	  System.out.println(mav);
	  return mav;
	 }  
}
