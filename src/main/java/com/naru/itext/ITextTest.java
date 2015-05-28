package com.naru.itext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;


//http://forum.spring.io/forum/spring-projects/web/98555-spring-pdf-issue
//AbstractView extends

public class ITextTest {
	//@Autowired private ITextDao itextDao;
	
	
	final static String filePath = "/Users/ejlee/Downloads/pdfTest/";
	
	public static void main(String[] args) {
		ITextDao itextDao = new ITextDao();

		String fileName = "example";
		String fileExtension = "pdf";
		
	//	String downLoadPath = filePath;+fileName;
		
		try {
			String downloadPath = filePath+itextDao.makeFileName(fileName, fileExtension);
			//htmltoPdfConvertTest(itextDao, downloadPath);
			//basicTest(itextDao, downloadPath);
			//tableTest(itextDao, downloadPath);
			htmlConvertTest2(itextDao, downloadPath);
			
			
		} catch (DocumentException e) {
			System.out.println("DocumentException error "+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException error "+ e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	

	
	public static void basicTest(ITextDao itextDao, String fileName) throws FileNotFoundException, DocumentException{
		
		ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20, 20, 20, 20);
		Document doc = itextDao.makeDocument(itextDoc);
		
		PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(fileName));
		doc.open();
		
		Paragraph ph = new Paragraph();
		ph.setAlignment(Element.ALIGN_CENTER);
		ph.add("pdf test~~");
		ph.add("pdf test~~2");
		doc.add(ph);
		doc.add(new Paragraph("pdf test333333"));
		
		LineSeparator line = new LineSeparator(1, 100, BaseColor.PINK, Element.ALIGN_CENTER, -5);
		doc.add(line);
		
		Chunk chunk = new Chunk("chunk test");
		chunk.setBackground(BaseColor.GREEN);
		doc.add(chunk);
		
		doc.add(Chunk.NEWLINE);
		doc.add(line);
		
		doc.addTitle("pdf title");
		System.out.println("document create >> basicTest::"+ pdfWriter.getPageNumber());
		doc.newPage();
		doc.add(new Paragraph("gg"));
		System.out.println("document create >> basicTest::"+ + pdfWriter.getPageNumber());
		doc.close();
		
	}
	
	public static void tableTest(ITextDao itextDao, String fileName) throws DocumentException, IOException{
		
		ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20, 20, 20, 20);
		
		Document doc = itextDao.makeDocument(itextDoc);
		PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(fileName));
		
		System.out.println("doc info: "+ doc.left(20)+"/"+ doc.top()+"/"+doc.right()+"/"+ doc.bottom());
		
		System.out.println();
		System.out.println(doc.left()+"-"+doc.leftMargin());
		System.out.println(doc.bottom()+"-"+doc.bottomMargin());
		System.out.println(doc.getPageSize());
		
		Rectangle headerBox = new Rectangle(doc.left(), doc.bottom(), doc.right(), doc.top()); //left, bottom, right, top
		
		pdfWriter.setPageEvent(new ITextPageEvent());
		pdfWriter.setBoxSize("headerBox", headerBox);
		doc.open();
		
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
		
		System.out.println(table);
		doc.add(new Paragraph("table Test 테스트ㅇㅇㅇdddd", new Font(bf, 11, Font.BOLD)));
		doc.add(table);
		
		doc.newPage();
		doc.add(new Paragraph("new page 2"));
		System.out.println(table.getNumberOfColumns());
		System.out.println("document create >> tableTest::"+ + pdfWriter.getPageNumber()+"/"+ doc.getPageNumber());
		
		if(doc.isOpen()){
			doc.close();
		}
		if(pdfWriter != null){
			pdfWriter.flush();
			pdfWriter.close();
		}

		
	}
	
	
	public static void htmlConvertTest(ITextDao itextDao, String fileName) throws DocumentException, IOException{
		Document doc = itextDao.makeDocument(null);
		PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(fileName));
		doc.open();
		
		String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/report/test2.jsp";
		String cssFilePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/report/style.css";

		
		// CSS
		CSSResolver cssResolver = new StyleAttrCSSResolver();
		CssFile cssFile = XMLWorkerHelper.getCSS(new FileInputStream(cssFilePath));
		cssResolver.addCss(cssFile);
		
		// HTML
		HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);//null or cssAppliers
		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
		
		// Pipelines
		PdfWriterPipeline pdf = new PdfWriterPipeline(doc, pdfWriter);
		HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
		CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
		
		
		XMLWorker worker = new XMLWorker(css, true);
		XMLParser xmlParser = new XMLParser(worker, Charset.forName("UTF-8"));
		xmlParser.parse(new FileInputStream(filePath));

	//	xwh.parseXHtml(writer, document, new FileInputStream(filePath), css);
		doc.close();
		System.out.println("document create: "+ doc.getPageNumber());
	}
	
	public static void htmlConvertTest2(ITextDao itextDao, String fileName) throws DocumentException, IOException{
		Document doc = itextDao.makeDocument(null);
		PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(fileName));
		doc.open();
		
		String filePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/report/report.jsp";
		String cssFilePath = "/Users/ejlee/Documents/git/TestProject/TestReport/src/main/webapp/WEB-INF/views/report/report.css";
			
		XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider();
		fontProvider.register("com/naru/itext/NanumGothic.ttf", "nanum"); 
		

		System.out.println(fontProvider);

		XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, doc, new FileInputStream(filePath), new FileInputStream(cssFilePath), fontProvider);

		doc.close();
	}
	
}
