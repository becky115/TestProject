<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value='/resources/js/common/header.js'/>"></script>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid" style="padding:0px">
		<div class="col-sm-3 col-md-2">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Test Report</a>
			</div>
		</div>
		<div class="col-sm-9 col-md-10">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="javascript:mainAction()">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#test">test</a></li>
					<li><a href="#test2">test2</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>