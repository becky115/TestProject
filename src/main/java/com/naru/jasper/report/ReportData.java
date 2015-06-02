package com.naru.jasper.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class ReportData {
	
	
	private Map<String, Object> basicInfo; //
	
	private List<Map<?, ?>> systemCheckList; //시스템 점검

	private Map<String, Object> detectHistory; //탐지내역 
	
	private List<Map<?, ?>> detectDetailList ; //이상 트래픽 탐지 명세 

	public Map<String, ?> getData() {
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		//
		basicInfo = new HashMap<String, Object>();
		basicInfo.put("productName", "EPS"); //제품명 
		basicInfo.put("customerCompany", "한국외환은행"); //고객사 
		basicInfo.put("customerDepartment", "IT 정보보안부"); //담당부서 
		basicInfo.put("customerUsername", "홍길동"); //담당자  
		basicInfo.put("checkDate", "2015.05.20");//점검일자 
		basicInfo.put("checkTime", "14:00 ~ 15:00");//점검시간
		basicInfo.put("checkUserName", "나루씨큐리티"); //점검자
		
		
		//
		systemCheckList = new ArrayList<Map<?, ?>>();
		Map<String, Object> systemCheckData = new HashMap<String, Object>();
		systemCheckData.put("system", "EPS-Manager");//구분
		systemCheckData.put("cpuRate", "1%");//CPU 사용률 
		systemCheckData.put("memoryRate", "22%");//메모리 사용률 
		systemCheckData.put("diskRate", "2.9TB(사용중)/3.6TB");//DISK 사용률
		systemCheckList.add(systemCheckData);
		systemCheckData = new HashMap<String, Object>();
		systemCheckData.put("system", "EPS-Sensor");//구분
		systemCheckData.put("cpuRate", "10%");//CPU 사용률 
		systemCheckData.put("memoryRate", "35%");//메모리 사용률 
		systemCheckData.put("diskRate", "0.2TB(사용중)/2.7TB");//DISK 사용률
		systemCheckList.add(systemCheckData);
		
		
		//
		detectHistory = new HashMap<String, Object>();
		detectHistory.put("totalDetectNum", 50); //총 탐지내역
		detectHistory.put("actionDetectNum", 25); //행위 기반 탐지 
		
		
		
		
		detectDetailList = new ArrayList<Map<?, ?>>();
		//---------content 1
		Map<String, Object> data = new HashMap<String, Object>();	
		data.put("detectNum", "1"); //구분번호
		data.put("detectCount", "1"); //탐지횟수 
		data.put("srcIP", "10.5.1.1"); //출발지 IP 
	
		List<Map<?, ?>> detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		Map<String, Object> contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 1);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 1);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		//---------content 2
		data = new HashMap<String, Object>();	
		data.put("detectNum", "2"); //구분번호
		data.put("detectCount", "5"); //탐지횟수 
		data.put("srcIP", "127.0.0.1"); //출발지 IP 
	
		detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 3);
		contentData.put("content", "detect content 3");
		detectContentList.add(contentData);
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		//---------content 3
		data = new HashMap<String, Object>();	
		data.put("detectNum", "2"); //구분번호
		data.put("detectCount", "5"); //탐지횟수 
		data.put("srcIP", "127.0.0.1"); //출발지 IP 
	
		detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 3);
		contentData.put("content", "detect content 3");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 4);
		contentData.put("content", "detect content 4");
		detectContentList.add(contentData);
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		
		
		//result
		resultData.put("basicInfo", basicInfo);
		resultData.put("systemCheckList", systemCheckList);
		resultData.put("detectHistory", detectHistory);
		resultData.put("detectDetailList", detectDetailList);
		
		return resultData;
	}

	public Map<String, ?> getDataSpring() {
		Map<String, Object> resultData = new HashMap<String, Object>();
		
		//
		basicInfo = new HashMap<String, Object>();
		basicInfo.put("productName", "EPS"); //제품명 
		basicInfo.put("customerCompany", "한국외환은행"); //고객사 
		basicInfo.put("customerDepartment", "IT 정보보안부"); //담당부서 
		basicInfo.put("customerUsername", "홍길동"); //담당자  
		basicInfo.put("checkDate", "2015.05.20");//점검일자 
		basicInfo.put("checkTime", "14:00 ~ 15:00");//점검시간
		basicInfo.put("checkUserName", "나루씨큐리티"); //점검자
		
		
		//
		systemCheckList = new ArrayList<Map<?, ?>>();
		Map<String, Object> systemCheckData = new HashMap<String, Object>();
		systemCheckData.put("system", "EPS-Manager");//구분
		systemCheckData.put("cpuRate", "1%");//CPU 사용률 
		systemCheckData.put("memoryRate", "22%");//메모리 사용률 
		systemCheckData.put("diskRate", "2.9TB(사용중)/3.6TB");//DISK 사용률
		systemCheckList.add(systemCheckData);
		systemCheckData = new HashMap<String, Object>();
		systemCheckData.put("system", "EPS-Sensor");//구분
		systemCheckData.put("cpuRate", "10%");//CPU 사용률 
		systemCheckData.put("memoryRate", "35%");//메모리 사용률 
		systemCheckData.put("diskRate", "0.2TB(사용중)/2.7TB");//DISK 사용률
		systemCheckList.add(systemCheckData);
		
		
		//
		detectHistory = new HashMap<String, Object>();
		detectHistory.put("totalDetectNum", 50); //총 탐지내역
		detectHistory.put("actionDetectNum", 25); //행위 기반 탐지 
		
		
		
		
		detectDetailList = new ArrayList<Map<?, ?>>();
		//---------content 1
		Map<String, Object> data = new HashMap<String, Object>();	
		data.put("detectNum", "1"); //구분번호
		data.put("detectCount", "1"); //탐지횟수 
		data.put("srcIP", "10.5.1.1"); //출발지 IP 
	
		List<Map<?, ?>> detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		Map<String, Object> contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 1);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 1);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		//---------content 2
		data = new HashMap<String, Object>();	
		data.put("detectNum", "2"); //구분번호
		data.put("detectCount", "5"); //탐지횟수 
		data.put("srcIP", "127.0.0.1"); //출발지 IP 
	
		detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 2);
		contentData.put("contentNum", 3);
		contentData.put("content", "detect content 3");
		detectContentList.add(contentData);
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		//---------content 3
		data = new HashMap<String, Object>();	
		data.put("detectNum", "2"); //구분번호
		data.put("detectCount", "5"); //탐지횟수 
		data.put("srcIP", "127.0.0.1"); //출발지 IP 
	
		detectContentList = new ArrayList<Map<?, ?>>();//내용 및 처리현황
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 1);
		contentData.put("content", "detect content 1");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 2);
		contentData.put("content", "detect content 2");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 3);
		contentData.put("content", "detect content 3");
		detectContentList.add(contentData);
		
		contentData = new HashMap<String, Object>();
		contentData.put("detectNum", 3);
		contentData.put("contentNum", 4);
		contentData.put("content", "detect content 4");
		detectContentList.add(contentData);
		data.put("detectContentList", detectContentList);
		detectDetailList.add(data);
		
		
		
		//result
		resultData.put("basicInfo", basicInfo);
		resultData.put("systemCheckList", systemCheckList);
		resultData.put("detectHistory", detectHistory);
		resultData.put("detectDetailList", detectDetailList);
		
		return resultData;
	}

	public Map<String, Object> getBasicInfo() {
		return basicInfo;
	}


	public void setBasicInfo(Map<String, Object> basicInfo) {
		this.basicInfo = basicInfo;
	}


	public List<Map<?, ?>> getSystemCheckList() {
		return systemCheckList;
	}


	public void setSystemCheckList(List<Map<?, ?>> systemCheckList) {
		this.systemCheckList = systemCheckList;
	}


	public Map<String, Object> getDetectHistory() {
		return detectHistory;
	}


	public void setDetectHistory(Map<String, Object> detectHistory) {
		this.detectHistory = detectHistory;
	}


	public List<Map<?, ?>> getDetectDetailList() {
		return detectDetailList;
	}


	public void setDetectDetailList(List<Map<?, ?>> detectDetailList) {
		this.detectDetailList = detectDetailList;
	}


	
}
