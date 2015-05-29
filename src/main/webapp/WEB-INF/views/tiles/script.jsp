<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

	<link rel="stylesheet" href="<c:url value='/resources/external/bootstrap/css/bootstrap.css'/>"></link>
	<link rel="stylesheet" href="<c:url value='/resources/css/common.css'/>"></link>
	<style type="text/css">
		body {
			padding-top: 50px;
		}
		
		.starter-template {
			padding: 40px 15px;
			text-align: center;
		}
	</style>
	<script type="text/javascript" src="<c:url value='/resources/external/jquery/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/external/bootstrap/js/bootstrap.js'/>"></script>
	
	<script type="text/javascript">
		function getResource(){
			return "<%=request.getContextPath()%>";
		}
	
	</script>
</head>
