package com.naru.itext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;



public class ITextTest {
	public static void main(String[] args) {
		Document document = new Document();
		
		String tempDir = System.getProperty("java.io.tmpdir");
		System.out.println("tempDir: "+tempDir);

		
		String downloadPath = "/Users/ejlee/Downloads/";
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(downloadPath+"pdf.pdf"));
			document.open();
			
			String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/view/report/test.jsp";
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filePath));
			document.close();
			System.out.println("document create: "+ document.getPageNumber());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		
	}
}
