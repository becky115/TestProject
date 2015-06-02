package com.naru.jasper.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/jasper")
public class ReportController {
	
	@RequestMapping("/index.do")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("/jasper/index");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET , value = "/pdfDownload.do")
	public ModelAndView a(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String filePath = "/WEB-INF/jasper/example1/";
		String reportYear = "2015";
		String reportMonth = "05";


		//parameter
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("filePath", filePath);
		params.put("reportYear", reportYear);
		params.put("reportMonth", reportMonth);
		
		//data create
		ReportData reportData = new ReportData();
		Map<String, ?> resultData = (Map<String, ?>) reportData.getData();
		Collection<Map<String, ?>> resultList = new ArrayList<Map<String,?>>();
		resultList.add(resultData);
		JRDataSource dataSource = new JRBeanCollectionDataSource(resultList);
		JRDataSource dataSource2 = new JRBeanCollectionDataSource((Collection<?>) resultData.get("systemCheckList"));
		JRDataSource dataSource3 = new JRBeanCollectionDataSource((Collection<?>) resultData.get("detectDetailList"));
		//JRDataSource dataSource4 = new JRBeanCollectionDataSource((Collection<?>) resultData.get("detectContentList"));
		params.put("dataSource", dataSource);
		params.put("subReportData", dataSource2);
		params.put("detectReportData", dataSource3);
		//params.put("detectSubReportData", dataSource4);
		

//		
//		//data export
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, params, new JRMapCollectionDataSource(resultList));
//		JasperExportManager.exportReportToPdfFile(jasperPrint, "eunji.pdf" );
		
//		modelAndView = new ModelAndView("pdfEMSReport");
//		AbstractJasperReportsView view = (AbstractJasperReportsView) modelAndView.getView();
//		view.render(params, request, response);
//		//view.setBeanName("pdfEmsReport");
//		System.out.println(view.getRequestContextAttribute());
		
		
		
		
		
//		JRBeanCollectionDataSource subsource = new JRBeanCollectionDataSource(reportData.getSystemCheckList());
//		params.put("subReportData", subsource);
//		System.out.println(subsource);
		modelAndView = new ModelAndView("pdfEMSReport", params);
		System.out.println(modelAndView);
		return modelAndView;

	}
}
