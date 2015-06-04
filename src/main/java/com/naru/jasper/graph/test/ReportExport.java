package com.naru.jasper.graph.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportExport {
	public static void main(String[] args) {
		try {
			Date now = new Date(System.currentTimeMillis());
			
			//jrxml load
			String downloadPath = System.getProperty("user.dir")+"/pdfDownload/";
			String downloadFileName = "pdf_"+now.getTime()+".pdf";
			String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/java/com/naru/jasper/graph/";
			String fileName = "test/test4.jrxml";
			String reportYear = "2015";
			String reportMonth = "05";
			
			JasperDesign jd = JRXmlLoader.load(filePath+fileName);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			
			
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
	
			//data export
			JasperPrint jasperPrint = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(reportData.getDataList()));
			
			
			//빈페이지 제거
			for(Iterator<JRPrintPage> i=jasperPrint.getPages().iterator(); i.hasNext();) {
				JRPrintPage page = i.next();
				if (page.getElements().size() == 0) i.remove();
			}
			 
			File fileTemp = new File(downloadPath);
			if(!fileTemp.exists()) fileTemp.mkdir();
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, downloadPath+downloadFileName);
			System.out.println("compelete pdf download page: "+jasperPrint.getPages().size());
			System.out.println("file path: "+ fileTemp.getAbsolutePath()+downloadFileName);
			
//			JasperViewer viewer = new JasperViewer(jasperPrint, false);
//			viewer.setTitle("title ~~");
//			viewer.setVisible(true);
			
		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
