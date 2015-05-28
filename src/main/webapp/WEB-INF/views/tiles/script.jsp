<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery/jquery-2.1.4.js'/>"></script>
	
	<script type="text/javascript">
		function getResource(){
			return "<%=request.getContextPath()%>";
		}
	
	</script>
</head>
