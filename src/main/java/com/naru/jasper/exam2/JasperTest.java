package com.naru.jasper.exam2;

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

public class JasperTest {
	public static void main(String[] args) throws JRException {
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("productName", "EPS");
		
	
		String filePath = "/Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/exam2/test.jrxml";
		JasperDesign jd = JRXmlLoader.load(filePath);///Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/
		System.out.println("jd: "+ jd);
		JasperReport jasperReport = JasperCompileManager.compileReport(jd);


		
		
		
		
		Collection<Map<String, ?>> list = new ArrayList<Map<String,?>>(); 
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("testTitle", "exam2");
		data.put("detailTitle", "detail_ exam2");
		list.add(data);
		 data = new HashMap<String, Object>();
			data.put("testTitle", "exam2111");
			data.put("detailTitle", "detail_ exam211");
			list.add(data);
		
		
		
		
		
	
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRMapCollectionDataSource(list));
		
		System.out.println(jasperPrint);
		
		JasperExportManager.exportReportToPdfFile(jasperPrint, "eunji.pdf" );
		JasperViewer viewer = new JasperViewer(jasperPrint, false);
		viewer.setTitle("title ~~");
		viewer.setVisible(true);
		
	}
	
	

}
