package com.naru.itext;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;


public class ITextDao {
	private static final Logger logger = LoggerFactory.getLogger(ITextDao.class);
	
	public void test(){
		ITextDoc itextDoc = new ITextDoc(PageSize.A4, 20f, 20f, 20f, 0);
		Document doc = makeDocument(itextDoc);
		String fileName = makeFileName("example", "pdf");
		logger.debug("doc: "+ doc);
		logger.debug("fileName: "+ fileName);
	}
	
	
	public Document makeDocument(ITextDoc itextDoc){
		Document doc = null;
		if(itextDoc == null){
			doc = new Document();
		}else{
			doc = new Document(itextDoc.getRtc(), itextDoc.getMarginLeft(), itextDoc.getMarginTop(), itextDoc.getMarginRight(), itextDoc.getMarginBottom());
		}
		return doc;
	}

	public String makeFileName(String fileName, String fileExtension){
		if(fileName == null) fileName = "";
		if(fileExtension == null) fileExtension = "pdf";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
		Date now = new Date();
		String fmtDate = sdf.format(now);
		
		int randomNum = (int) (Math.random()*10000);
		String resultFileName = fileName+"("+fmtDate+"_"+randomNum+")";
		return resultFileName+"."+fileExtension;
	}
	
	
}
