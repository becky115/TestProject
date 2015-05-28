package com.naru.itext;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextPageEvent implements PdfPageEvent{

	public void onOpenDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
	}

	public void onStartPage(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
	}

	public void onEndPage(PdfWriter writer, Document document) {
		PdfContentByte cb = writer.getDirectContent();
		cb.saveState();
		
		Rectangle rect = writer.getBoxSize("headerBox");
		
		cb.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
		cb.stroke();
		cb.setLineWidth(3);
		cb.restoreState();
		
//		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("on end page"), rect.getLeft(), rect.getBottom(), 0);
		
		
	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
	}

	public void onParagraph(PdfWriter writer, Document document,
			float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	public void onParagraphEnd(PdfWriter writer, Document document,
			float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	public void onChapter(PdfWriter writer, Document document,
			float paragraphPosition, Paragraph title) {
		// TODO Auto-generated method stub
		
	}

	public void onChapterEnd(PdfWriter writer, Document document,
			float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	public void onSection(PdfWriter writer, Document document,
			float paragraphPosition, int depth, Paragraph title) {
		// TODO Auto-generated method stub
		
	}

	public void onSectionEnd(PdfWriter writer, Document document,
			float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	public void onGenericTag(PdfWriter writer, Document document,
			Rectangle rect, String text) {
		// TODO Auto-generated method stub
		
	}

}
