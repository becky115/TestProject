package com.naru.itext;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;

public class ITextDao {
	
	public void test(){
		System.out.println("test");
	}
	
	
	public Document makeDocument(ITextDoc itextDoc){
		System.out.println("makeDocument: "+ itextDoc);
		//itextDoc.getRtc(), itextDoc.getMarginLeft(), itextDoc.getMarginTop(), itextDoc.getMarginRight(), itextDoc.getMarginBottom()
		Document doc = null;
		if(itextDoc == null){
			doc = new Document();
		}else{
			System.out.println("sdd"+ itextDoc.getMarginLeft());
			doc = new Document(itextDoc.getRtc(), itextDoc.getMarginLeft(), itextDoc.getMarginTop(), itextDoc.getMarginRight(), itextDoc.getMarginBottom());
		}
		
		//옵션 
		System.out.println(doc);

		return doc;
	}

	public String makeFileName(String fileName, String fileExtension){
		if(fileName == null) fileName = "";
		if(fileExtension == null) fileExtension = "pdf";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		Date now = new Date();
		String fmtDate = sdf.format(now);
		System.out.println("fmtDate:" + fmtDate);
		
		
		int randomNum = (int) (Math.random()*100);
		System.out.println("randomNum: "+randomNum);
		
		String resultFileName = fileName+"("+fmtDate+"_"+randomNum+")";
		System.out.println("resultFileName: "+ resultFileName);
		return resultFileName+"."+fileExtension;
	}
	
	
//	
//	public static void main(String[] args) {
//	//	ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20f, 20f, 20f, 0);
//		
//		
//		
//		
//		ITextDoc itextDoc = new ITextDoc(PageSize.A4);
//		makeDocument(itextDoc);
//	}
	
	
}
