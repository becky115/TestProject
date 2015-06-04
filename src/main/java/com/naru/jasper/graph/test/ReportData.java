package com.naru.jasper.graph.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class ReportData {
	
	private List<Map<?, ?>> dataList; 

	public Map<String, ?> getData() {//test2, test4
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		dataList = new ArrayList<Map<?, ?>>();
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("name", "name1");
		temp.put("count", 30);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name2");
		temp.put("count", 50);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name3");
		temp.put("count", 5);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name4");
		temp.put("count", 15);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name5");
		temp.put("count", 100);
		dataList.add(temp);
		
		//result
		resultData.put("dataList", dataList);
		
		return resultData;
	}
	
	public Map<String, ?> getData2() {//test1, test3
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		dataList = new ArrayList<Map<?, ?>>();
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("name", "name1");
		temp.put("count", 30);
		temp.put("count2", 5);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name2");
		temp.put("count", 50);
		temp.put("count2", 25);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name3");
		temp.put("count", 5);
		temp.put("count2", 65);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name4");
		temp.put("count", 15);
		temp.put("count2", 75);
		dataList.add(temp);
		
		temp = new HashMap<String, Object>();
		temp.put("name", "name5");
		temp.put("count", 100);
		temp.put("count2", 20);
		dataList.add(temp);
		
		//result
		resultData.put("dataList", dataList);
		
		return resultData;
	}

	public List<Map<?, ?>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<?, ?>> dataList) {
		this.dataList = dataList;
	}
	
}
