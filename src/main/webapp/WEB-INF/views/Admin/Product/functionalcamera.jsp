<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
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
.form-error{
font-size: 12px;
color: red;
}
</style>
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<%@include file="/WEB-INF/views/Admin/menu.jsp"%>
	<div class="container">
		<h2>THÔNG TIN CHỨC NĂNG CAMERA</h2>
		<form:form style="box-shadow: none;" action="Admin/functionalcamera.htm" modelAttribute="functionalcamera">
			<div class="form-group">
				<form:input type="hidden" path="idFunctionalCamera"/> 
				<div class="form-element">
					<label style="width:30%; margin-right: 2%" for="">Chức năng camera: </label> 
					<form:input type="text" placeholder="Nhập chức năng camera" path="nameFunctionalCamera"/>
					<label for="" class="error"></label>
					<form:errors class="form-error" path="nameFunctionalCamera"/> 
				</div>
				
			</div>
			<button name="${btnStatus}">Lưu</button>
		</form:form>
		<div> <p>${message}</p></div>

		<h2>DANH SÁCH CHỨC NĂNG CAMERA</h2>

		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="Admin/functionalcamera.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div>
			<tg:paging pagedListHolder="${pagedListHolder}"
				pagedLink="${pagedLink}" />
		</div>
		<table>
			<tr>
				<th>ID</th>
				<th>Chức năng camera</th>
				<th>Xóa</th>
				<th>Sửa</th>
			</tr>
			<c:forEach var="s" items="${pagedListHolder.pageList}">
				<tr>
					<td>${s.idFunctionalCamera}</td>
					<td>${s.nameFunctionalCamera}</td>
					<td><a href="Admin/functionalcamera/${s.idFunctionalCamera}.htm?linkDelete">Xóa</a></td>
					<td><a href="Admin/functionalcamera/${s.idFunctionalCamera}.htm?linkEdit">Sửa</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>