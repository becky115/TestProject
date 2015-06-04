package com.naru.jasper.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportExport {
	public static void main(String[] args) {
		try {
			
			//jrxml load
			
			String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/java/com/naru/jasper/";
			String fileName = "report/report.jrxml";
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
			JasperPrint jasperPrint = JasperFillManager.fillReport(jr, params, new JRMapCollectionDataSource(resultList));
			JasperExportManager.exportReportToPdfFile(jasperPrint, "eunji.pdf" );
			
			
			JasperViewer viewer = new JasperViewer(jasperPrint, false);
			viewer.setTitle("title ~~");
			viewer.setVisible(true);
		
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
