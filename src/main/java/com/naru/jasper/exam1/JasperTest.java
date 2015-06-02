package com.naru.jasper.exam1;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperTest {
	public static void main(String[] args) throws JRException {
//		JasperReport jasperReport = JasperCompileManager.compileReport("/Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/test.jrxml");

//		
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, data);
//		//JasperFillManager.fillReport(sourceFileName, params, dataSource)
//		
//		JasperExportManager.exportReportToPdfFile(jasperPrint, "Simple_Report.pdf");
//		
//		
//		JasperViewer viewer = new JasperViewer(jasperPrint);
//		viewer.setTitle("title ~~");
//		viewer.setVisible(true);
		
		
		ArrayList<Object> list = new ArrayList<Object>();
		HashMap<String, Object> data = new HashMap<String,Object>();
	data.put("data1", "kkk");
		list.add(data);
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		list.add("4");
		
		HashMap<String, Object> params = new HashMap<String,Object>();
	//	HashMap params = new HashMap();
		params.put("productName", "EPS");
		
		///Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/test.jrxml
		//String filePath = "\\Users\\ejlee\\Documents\\git\\connectome-web\\src\\main\\java\\com\\narusec\\web\\test\\test.jrxml";
		String filePath = "/Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/exam1/test.jrxml";
		JasperDesign jd = JRXmlLoader.load(filePath);///Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/
		System.out.println("jd: "+ jd);
		JasperReport jasperReport = JasperCompileManager.compileReport(jd);
		
		
		
		
//		Collection<Test> list2 = new ArrayList<Test>();
//		List list3 = new ArrayList<Object>();
//		list3.add(new Test2("eeeee"));
//		
//		
//		list2.add(new Test("dd", list3));
//		list2.add(new Test("gg", list3));
		
		ArrayList<TestDetail> detailList = new ArrayList<TestDetail>();
		detailList.add(new TestDetail("1_info_1", "1_info_2"));
		detailList.add(new TestDetail("2_info_1", "2_info_2"));
		detailList.add(new TestDetail("3_info_1", "3_info_2"));
		list.add(new Test3("id1", detailList));
		list.add(new Test3("id2", detailList));
		list.add(new Test3("id3", detailList));
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list));//, new JRBeanCollectionDataSource(list)
		System.out.println("jasperPrint: "+ jasperPrint);
		System.out.println(jasperPrint.getName());
		String[] propertyName = jasperPrint.getPropertyNames();
		for(int i=0; i<propertyName.length; i++){
			System.out.println(propertyName[i]);
		}
		
		
		//JasperExportManager.exportReportToPdf(jasperPrint );
		JasperExportManager.exportReportToPdfFile(jasperPrint, "eunji.pdf" );
		JasperViewer viewer = new JasperViewer(jasperPrint, false);
		viewer.setTitle("title ~~");
		viewer.setVisible(true);
		
	}
	
	

}
