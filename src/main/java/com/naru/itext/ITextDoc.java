package com.naru.itext;

import com.itextpdf.text.Rectangle;

public class ITextDoc {
	private Rectangle rtc;
	private float marginLeft;
	private float marginTop;
	private float marginRight;
	private float marginBottom;
	
	public ITextDoc() {
	
	}
	
	public ITextDoc(Rectangle rtc) {
		super();
		this.rtc = rtc;
	}


	public ITextDoc(Rectangle rtc, float marginLeft, float marginTop,
			float marginRight, float marginBottom) {
		super();
		this.rtc = rtc;
		this.marginLeft = marginLeft;
		this.marginTop = marginTop;
		this.marginRight = marginRight;
		this.marginBottom = marginBottom;
	}


	public Rectangle getRtc() {
		return rtc;
	}


	public void setRtc(Rectangle rtc) {
		this.rtc = rtc;
	}


	public float getMarginLeft() {
		return marginLeft;
	}


	public void setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
	}


	public float getMarginTop() {
		return marginTop;
	}


	public void setMarginTop(float marginTop) {
		this.marginTop = marginTop;
	}


	public float getMarginRight() {
		return marginRight;
	}


	public void setMarginRight(float marginRight) {
		this.marginRight = marginRight;
	}


	public float getMarginBottom() {
		return marginBottom;
	}


	public void setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
	}

}
