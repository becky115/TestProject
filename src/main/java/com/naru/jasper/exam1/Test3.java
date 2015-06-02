package com.naru.jasper.exam1;

import java.util.ArrayList;

public class Test3 {
	private String id;
	private ArrayList<TestDetail> detailList;
	
	public Test3(String id, ArrayList<TestDetail> detailList) {
		super();
		this.id = id;
		this.detailList = detailList;
	}
	
	public String getId() {
		return id;
	}
	public ArrayList<TestDetail> getDetailList() {
		return detailList;
	}
	
}
