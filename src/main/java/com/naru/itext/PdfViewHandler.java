package com.naru.itext;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;



public class PdfViewHandler extends AbstractView{
	private static final Logger logger = LoggerFactory.getLogger(PdfViewHandler.class);
	
	@Autowired private ITextDao itextDao;
	
	public PdfViewHandler() {
		super();
		setContentType("application/pdf");
	}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.debug("model: "+ model);
		
		
		String fileName = "test";
		String fileExtension = "pdf";
		String fileNameTemp = itextDao.makeFileName(fileName, fileExtension);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameTemp + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		ByteArrayOutputStream baos = createTemporaryOutputStream();
		ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20, 20, 20, 20);
		Document doc = itextDao.makeDocument(itextDoc);
		PdfWriter pdfWriter = PdfWriter.getInstance(doc, baos);
		
		
		htmlConvertTest(doc, pdfWriter);
		itextDao.pdfClose(doc, pdfWriter);
		writeToResponse(response, baos);
		
	}

	
	@Autowired(required = false)
	private void tableExampleCreate(Document doc, PdfWriter pdfWriter) throws DocumentException, IOException {
		Rectangle headerBox = new Rectangle(doc.left(), doc.bottom(), doc.right(), doc.top()); //left, bottom, right, top
		pdfWriter.setPageEvent(new ITextPageEvent());
		pdfWriter.setBoxSize("headerBox", headerBox);
		
		PdfPTable table = new PdfPTable(5);
		table.getDefaultCell().setBackgroundColor(BaseColor.YELLOW);
		PdfPCell cell = new PdfPCell(new Paragraph("cell"));
		//cell.addElement();
		cell.setMinimumHeight(50);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//높이 지정해야함
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);//글자 가운데
		
		table.addCell(cell);
		table.addCell("cell2");
		table.addCell("cell3");
		table.addCell("cell4");
		table.addCell("cell5");
		
		table.getDefaultCell().setBackgroundColor(BaseColor.ORANGE);
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				table.addCell("data: "+ i+"-"+j);
			}
		}
		
		BaseFont bf = BaseFont.createFont("com/naru/itext/NanumGothic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
		doc.open();
		doc.add(new Paragraph("table Test 테스트ㅇㅇㅇdddd", new Font(bf, 11, Font.BOLD)));
		doc.add(table);
		doc.newPage();
		doc.add(new Paragraph("new page 2"));
	}
	
	@Autowired(required = false)
	public void htmlConvertTest(Document doc, PdfWriter pdfWriter) throws DocumentException, IOException{
		String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/itext/report.jsp";
		String cssFilePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/itext/report.css";
	
		doc.open();
		
		XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider();
		fontProvider.register("com/naru/itext/NanumGothic.ttf", "nanum"); 

		XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, doc, new FileInputStream(filePath), new FileInputStream(cssFilePath), fontProvider);
		
	

	}

}
