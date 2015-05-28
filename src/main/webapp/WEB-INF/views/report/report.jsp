<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
<style type="text/css">


</style>
</head>
<body>
	<div>
		<h1>APT EPS 트래픽 분석 월간보고 및 점검</h1>
	</div>
	<table class='dataTable'>
		<tr>
			<th>제품명</th>
			<td colspan="3">EPS</td>
		</tr>
		<tr>
			<th>고객사</th>
			<td>한국외환은행</td>
			<th>점검일</th>
			<td>2015.04.20</td>
		</tr>
		<tr>
			<th>담당부서</th>
			<td>IT정보보안부</td>
			<th>점검시간</th>
			<td>14:20~18:00</td>
		</tr>
		<tr>
			<th>담당자</th>
			<td>고객(인)</td>
			<th>점검자</th>
			<td>나루씨큐리티(인)</td>
		</tr>
	</table>
	<div>
		<h2>1.시스템 점검</h2>
	</div>
	<table class='dataTable'>
		<tr>
			<th>구분</th>
			<td>EPS-Manager</td>
			<td>EPS-Sensor</td>
		</tr>
		<tr>
			<th>CPU사용률</th>
			<td>1%</td>
			<td>28%</td>
		</tr>
		<tr>
			<th>메모리사용률</th>
			<td>22%</td>
			<td>30%</td>
		</tr>
		<tr>
			<th>DISK사용률</th>
			<td>2.9TB(사용중)/3.6TB</td>
			<td>0.2TB(사용중)/2.7TB</td>
		</tr>
	</table>
	<div>
		<h2>2.이상 트래픽 탐지 현황</h2>
	</div>
	<div>
		<h3>2-1. 총 탐지내역</h3>
	</div>
	<table class='dataTable'>
		<tr>
			<th rowspan="2">총탐지내역</th>
			<th>이상 트래픽 탐지현황</th>
		</tr>
		<tr>
			<th>행위 기반탐지</th>
		</tr>
		<tr>
			<td>46건</td>
			<td>31건</td>
		</tr>
	</table>
	<div>
		<h3>2-2.이상 트래픽 탐지 명세</h3>
	</div>
	<div>
		<h4>2-2-1. 행위 기반 탐지(행위기반 분석에 의한 보안정책 위반 행위)</h4>
	</div>
	<table class='dataTable'>
		<tr>
			<th>구분번호</th>
			<th>내용 및 처리현황</th>
			<th>탐지 횟수</th>
			<th>출발지 IP</th>
		</tr>
		<tr>
			<td>20150427-1</td>
			<td>
				<table class='dataSubTable'>
					<tr>
						<td>내용1</td>
					</tr>
					<tr>
						<td>내용2</td>
					</tr>
					<tr>
						<td>내용3</td>
					</tr>
				</table>
			</td>
			<td>1</td>
			<td>127.0.0.1</td>
		</tr>
		<tr>
			<td>20150501-1</td>
			<td>
				<table class='dataSubTable'>
					<tr>
						<td>내용1</td>
					</tr>
					<tr>
						<td>내용2</td>
					</tr>
				</table>
			</td>
			<td>3</td>
			<td>125.0.0.1</td>
		</tr>
		<tr>
			<td>20150513-1</td>
			<td>
				<table class='dataSubTable'>
					<tr>
						<td>내용1</td>
					</tr>
				</table>
			</td>
			<td>12</td>
			<td>222.0.0.1</td>
		</tr>
		<tr>
			<td>20150525-1</td>
			<td>
				<table class='dataSubTable'>
					<tr>
						<td>내용1</td>
					</tr>
					<tr>
						<td>내용1</td>
					</tr>
				</table>
			</td>
			<td>12</td>
			<td>222.0.0.1</td>
		</tr>
	</table>
</body>
</html>

<!-- 
	<table>
		<tr>
			<th></th>
			<td></td>
			<td></td>
		</tr>
	</table>
	
 -->