<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/resource/css/Admin/menuStyle.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/css/Admin/adminStyle.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/css/Style.css' />" rel="stylesheet">
<link
	href="<c:url value='/resource/fontawesome-free-5.15.4-web/css/all.css' />"
	rel="stylesheet">
<style type="text/css">
#chartContainer {
	width: 80%;
	height: 500px;
	margin-left: 10%;
	font-size: 20px;
}
form{
	padding: 0;
    border-radius:  0;
    box-shadow: none;
	margin: 24px 0px;
	margin-top: 0px;
}
input{
	width: 320px;
	font-size: 16px;
	padding: 4px;
	height: 32px;
}
button{
	width: 150px;
	display: inline-block;
	font-size: 16px;
}
</style>
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<%@include file="/WEB-INF/views/Admin/menu.jsp"%>
	<div class="container">
		<form action="" method="post">
			<input type="number" min="2000" max="2100" name="year" placeholder="Nhập năm">
			<button name="btnSearch">Tra cứu</button>
		</form>
		<div id="chartContainer"></div>
	</div>
	<script>
		window.onload = function() {

			var chart = new CanvasJS.Chart("chartContainer", {
				animationEnabled : true,
				theme : "light2", // "light1", "light2", "dark1", "dark2"
				title : {
					text : "Doanh thu trong năm ${year}"
				},
				axisY : {
					title : "Doanh thu"
				},
				axisX : {
					title : "Tháng"
				},
				data : [ {
					type : "line",
					showInLegend : true,
					indexLabelFontSize: 16,
					legendMarkerColor : "grey",
					legendText : "Đơn vị doanh thu: VND",
					dataPoints : 
						[ <c:forEach var="item" items="${list}">{y: ${item.value}, label :'${item.key}'},</c:forEach>]
				} ]
			});
			chart.render();
		}
	</script>
	<script type="text/javascript"
		src="resource/canvasjs-3.4.4/canvasjs.min.js"></script>

</body>
</html>