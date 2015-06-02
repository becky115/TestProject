package com.naru.jasper.examTable1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
			String filePath = "/Users/ejlee/Documents/git/connectome-web/src/main/java/com/narusec/web/test/examTable1/tableReport.jrxml";
			JasperDesign jd = JRXmlLoader.load(filePath);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			
			
			//parameter
			Map<String, Object> params = new HashMap<String,Object>();
			

			Map<String, Object> resultData = new HashMap<String, Object>();
			Collection<Map<String, ?>> resultList = new ArrayList<Map<String,?>>();
			
			
			
			int dataLength = 10;
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			Map<String, Object>	data = null;
			for(int i=0; i<dataLength; i++){
				data = new HashMap<String, Object>();
				for(int j=0; j<5; j++){
					data.put("data"+(j+1), "testData"+(i+1)+"_"+(j+1));
				}
				dataList.add(data);
			}
			
			resultData.put("dataList", dataList);
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
