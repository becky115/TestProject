package com.naru.itext;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class PdfViewHandler2 extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("buildPdfDocument");
		String fileName = "teset.pdf";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		 PdfPTable table = new PdfPTable(5);
			table.getDefaultCell().setBackgroundColor(Color.YELLOW);
			PdfPCell cell = new PdfPCell(new Paragraph("cell"));
			//cell.addElement();
			cell.setMinimumHeight(50);
			cell.setBackgroundColor(Color.LIGHT_GRAY);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//높이 지정해야함
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);//글자 가운데
			
			table.addCell(cell);
			table.addCell("cell2");
			table.addCell("cell3");
			table.addCell("cell4");
			table.addCell("cell5");
			
			table.getDefaultCell().setBackgroundColor(Color.ORANGE);
			for(int i=0; i<5; i++){
				for(int j=0; j<5; j++){
					table.addCell("data: "+ i+"-"+j);
				}
			}
			
			BaseFont bf = BaseFont.createFont("com/naru/itext/NanumGothic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			System.out.println(table);
			document.add(new Paragraph("table Test 테스트ㅇㅇㅇdddd", new Font(bf, 11, Font.BOLD)));
			
			document.add(table);
			System.out.println(document);
		}
		
	

}
