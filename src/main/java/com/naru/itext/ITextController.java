package com.naru.itext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;



@Controller
@RequestMapping(value="/itext")
public class ITextController {
	
	@Autowired private ITextDao itextDao;
	
	@RequestMapping(value="/test.do")
	public ModelAndView test(){
		ModelAndView mav = new ModelAndView("report/test");
		
		
		ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20, 20, 20, 20);
		Document doc = itextDao.makeDocument(itextDoc);
		itextDao.test();
		
		return mav;
		
	}
}
