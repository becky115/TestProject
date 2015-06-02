<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tiles 적용 layout</title>
<tiles:insertAttribute name="script"/>
<style type="text/css">
@media (min-width: 768px) {
  .sidebar {
 	position: fixed;
    top: 51px;
    padding-top:20px;
	height:100%;
    overflow-x: hidden;
    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
    background-color: #f5f5f5;
    border-right: 1px solid #eee;
 }
}


/* Sidebar navigation */
.nav-sidebar {
  margin-right: -21px; /* 20px padding + 1px border */
  margin-bottom: 20px;
  margin-left: -20px;
}
.nav-sidebar > li > a {
  padding-right: 20px;
  padding-left: 20px;
}
.nav-sidebar > .active > a,
.nav-sidebar > .active > a:hover,
.nav-sidebar > .active > a:focus {
  color: #fff;
  background-color: #428bca;
}


/*
 * Main content
 */

.main {
  padding: 20px;
}
@media (min-width: 768px) {
  .main {
    padding-right: 40px;
    padding-left: 40px;
  }
}
</style>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<div class="container-fluid bodyCustom">
		<div class="row bodyCustom">
			 <div class="col-sm-3 col-md-2 sidebar" style="background-color: #F2F2F2;"> 
				<tiles:insertAttribute name="menu"/>
			 </div>
			 <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background-color: #E0F2F7; height:100%;">
				<tiles:insertAttribute name="body" flush="true"></tiles:insertAttribute>
				<tiles:insertAttribute name="contents" flush="true"></tiles:insertAttribute>
			 </div>
		</div>
	</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>