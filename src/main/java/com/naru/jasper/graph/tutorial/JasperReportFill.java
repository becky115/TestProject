package com.naru.jasper.graph.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

public class JasperReportFill {
	public static void main(String[] args) throws JRException {
		String sourceFileName = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/java/com/naru/jasper/graph/tutorial/test.jrxml";
		JasperDesign jd = JRXmlLoader.load(sourceFileName);
		JasperReport jr = JasperCompileManager.compileReport(jd);

		DataBeanList DataBeanList = new DataBeanList();
		ArrayList<?> dataList = DataBeanList.getDataBeanList();

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(jr, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "eunji.pdf" );
			JasperViewer viewer = new JasperViewer(jasperPrint, false);
			viewer.setTitle("title ~~");
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
