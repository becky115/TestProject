package com.naru.itext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/itext")
public class ITextController {
	
	
	@RequestMapping(value="/test.do")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView("report/test");
		
		
		
		return mav;
		
	}
}
