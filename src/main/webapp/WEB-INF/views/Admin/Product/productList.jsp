<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/resource/css/Admin/menuStyle.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/css/Admin/adminStyle.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/css/Style.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/fontawesome-free-5.15.4-web/css/all.css' />"
	rel="stylesheet">
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<%@include file="/WEB-INF/views/Admin/menu.jsp"%>
		<div class="container">
		<h2>DANH SÁCH SẢN PHẨM</h2>
		<div class="link-export__wrapper"><a class="link-export" href="pdf/phone.htm">Xuất danh sách</a></div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="Admin/productList.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div>
			<tg:paging pagedListHolder="${pagedListHolder}"
				pagedLink="${pagedLink}" />
		</div>
		<table>
			<tr>
				<th>Số seri</th>
				<th>Tên</th>
				<th>Giá tiền</th>
				<th>Nhãn hiệu</th>
				<th>Năm SX</th>
				<th>CPU</th>
				<th>RAM</th>				
				<th>ROM</th>
				<th>Màn hình</th>
				<th></th>				
				<th></th>
			</tr>
			<c:forEach var="s" items="${pagedListHolder.pageList}">
				<tr>
					<td>${s.idPhone}</td>
					<td>${s.namePhone}</td>
					<td>${s.costPhone}</td>
					<td>${s.brand.nameBrand}</td>
					<td>${s.yearPhone}</td>
					<td>${s.cpu.nameCPU}_${s.cpu.speedCPU}</td>
					<td>${s.ramPhone}</td>
					<td>${s.romPhone}</td>
					<td>${s.screen.sizeScreen}_${s.screen.techScreen.nameTechScreen}_${s.screen.resolution.nameResolution}</td>
					<td><a href="Admin/productList/${s.idPhone}.htm?linkDelete">Xóa</a></td>
					<td><a href="Admin/productEdit/${s.idPhone}.htm?linkEdit">Sửa</a></td>
				</tr>
			</c:forEach>
		</table>
		${message}
	</div>
</body>
</html>