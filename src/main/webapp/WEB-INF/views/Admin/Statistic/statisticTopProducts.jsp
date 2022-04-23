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
		
		<h2>Top doanh thu theo sản phẩm trong năm ${year}</h2>
		<table>
			<tr>
				<th>Số seri</th>
				<th>Tên điện thoại</th>
				<th>Nhãn hiệu</th>
				<th>Doanh thu</th>
			</tr>
			<c:forEach var="s" items="${list}">
				<tr>
					<td>${s.key.idPhone}</td>
					<td>${s.key.namePhone}</td>
					<td>${s.key.brand.nameBrand}</td>
					<td>${s.value}</td>
				</tr>
			</c:forEach>
		</table>	</div>

</body>
</html>