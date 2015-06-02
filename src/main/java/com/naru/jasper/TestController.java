package com.naru.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test/download")
public class TestController {

	@RequestMapping(method = RequestMethod.GET , value = "pdf")
	public ModelAndView a(ModelAndView modelAndView){
	
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		List<?> dataList = new ArrayList<Object>();
//		
//		
//	
		
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("dataList", dataList);
		data.put("productName", "EPS");
		JRDataSource dataSource = new JRBeanCollectionDataSource(dataList);

		parameterMap.put("dataSource", dataSource);
		parameterMap.put("productName", "EPS");
	//	JRDataSource jrDataSource = new JRTableModelDataSource(parameterMap)//;
		

		modelAndView = new ModelAndView("pdfReport", parameterMap);
		System.out.println(modelAndView);
		return modelAndView;

	}
	
//http://localhost:8080/conn/test/download/pdf.do
}
