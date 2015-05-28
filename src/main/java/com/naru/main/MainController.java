package com.naru.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("/main/index");
		logger.debug("main index..");
		return mav;
	}
	
	
	
	 @RequestMapping("/hello")
	 public ModelAndView test() {
		String message = "Welcome to Spring";
		ModelAndView mav = new ModelAndView("/main/hello", "message", message);
		logger.debug("hello test..");
		return mav;
	}
}
