package com.naru.itext.graph.test;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextTest2 {
	
	
	public static void main(String[] args) throws IOException {
		
		//bar data
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(20, "value", "col1"); //value, rowKey, columnKey
		dataset.setValue(50, "value", "col2");
		dataset.setValue(10, "value", "col3");
		dataset.setValue(100, "value", "col4");
		dataset.setValue(2000, "value", "col5");
		
		JFreeChart jChart = ChartFactory.createBarChart("bar graph", "col title", "value", dataset, PlotOrientation.VERTICAL, false, true, false); //title, columnTitle, rowTitle, data, align, legend, tooltips, urls
		
		Date now = new Date(System.currentTimeMillis());
		String downloadPath = System.getProperty("user.dir")+"/pdfDownload/itext/";
		String downloadFileName = "pdf_"+now.getTime()+".pdf";

		PdfWriter pdfWriter = null;
		Document document = new Document();
		
		File fileTemp = new File(downloadPath);
		if(!fileTemp.exists()) fileTemp.mkdir();
		
		try {
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(downloadPath+downloadFileName));
			document.open();
			PdfContentByte canvas = pdfWriter.getDirectContent();
			
			
			System.out.println("height: "+pdfWriter.getPageSize().getHeight() );
			//			canvas.rectangle(0, pdfWriter.getPageSize().getHeight()-20, 20, 20 );	
			//			canvas.setColorFill(BaseColor.PINK);
			//			canvas.fill();
			//			canvas.setColorStroke(BaseColor.RED);
			//			canvas.fillStroke();
			
			Rectangle rectangle = new Rectangle(0, pdfWriter.getPageSize().getHeight(), pdfWriter.getPageSize().getWidth(), 0);
			rectangle.setBorder(Rectangle.BOX);
			rectangle.setBorderColor(BaseColor.BLACK);
			rectangle.setBorderWidth(2);
			rectangle.setBackgroundColor(BaseColor.PINK);
			canvas.rectangle(rectangle);
			
			PdfTemplate templete = canvas.createTemplate(400, 400);//width, height
			templete.rectangle(0, 0, 400, 400);
			templete.setColorFill(BaseColor.ORANGE);
			templete.fill();

			Graphics2D g2 = new PdfGraphics2D(templete, 300, 300);
			Rectangle2D area = new Rectangle2D.Double(0, 0, 300, 300);
			jChart.draw(g2, area);
			g2.dispose();
			
			canvas.addTemplate(templete, 0, 421);// height:842//template - the template ,x - the x location of this template , y - the y location of this template

			
			System.out.println("compelete: " + fileTemp.getAbsolutePath()+downloadFileName+"  getPageNumber:"+ pdfWriter.getPageNumber());
			document.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

