<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value='/resources/js/main/main.js'/>"></script>
<!-- contents -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		<li data-target="#carousel-example-generic" data-slide-to="3"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox" >
		<div class="item active">
			<img src="<c:url value='/resources/img/gray.jpg'/>" alt="first" style="width:100%; max-height: 500px">
			<div class="carousel-caption">
				1
			</div>
		</div>
		<div class="item">
			<img src="<c:url value='/resources/img/gray.jpg'/>" alt="second" style="width:100%; max-height: 500px">
			<div class="carousel-caption">
				2
			</div>
		</div>
		<div class="item">
			<img src="<c:url value='/resources/img/gray.jpg'/>" alt="third" style="width:100%; max-height: 500px">
			<div class="carousel-caption">
				3
			</div>
		</div>
		<div class="item">
			<img src="<c:url value='/resources/img/gray.jpg'/>" alt="fourth" style="width:100%; max-height: 500px">
			<div class="carousel-caption">
				4
			</div>
		</div>
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>

