package com.naru.itext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/itext")
public class ITextController {
	private static final Logger logger = LoggerFactory.getLogger(ITextController.class);
	
	@Autowired private ITextDao itextDao;
	final static String filePath = "/Users/ejlee/Downloads/pdfTest/";
	
	
	@RequestMapping(value="/test.do")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView("report/test");
		itextDao.test();
		return mav;
	}
	
	@RequestMapping(value="/pdfDownload.do", method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	public ModelAndView pdfDownloadView(HttpServletRequest request, HttpServletResponse response){
		logger.debug("pdf downloading...");
		//data create
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("test", "test data");
		ModelAndView mav = new ModelAndView("pdfDownload");
		mav.addObject("data", data);
		return mav;
		
	}
}
