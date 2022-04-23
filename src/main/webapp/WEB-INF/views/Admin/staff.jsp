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
<title>Insert title here</title>
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<%@include file="/WEB-INF/views/Admin/menu.jsp"%>
	<div class="container">
		<h2>THÔNG TIN NHÂN VIÊN</h2>
		<form:form action="Admin/staff.htm" class="form-staff" modelAttribute="staff">
			<div class="form-group">
				<form:input type="hidden" path="idStaff"/> 
				<form:input type="hidden" path="role"/> 
				<form:input type="hidden" path="password"/> 
				<div class="form-element">
					<label class="label-title" for="">Họ tên: </label> 
					<form:input type="text" placeholder="Nhập họ tên" path="nameStaff"/>
					<label for="" class="error"></label>
					<form:errors class="error" path="nameStaff"/> 
				</div>
				<div class="form-element">
					<label class="label-title" for="">Số điện thoại: </label> 
					<form:input type="text" placeholder="Nhập số điện thoại" path="phoneStaff"/> 					
					<label class="error"></label>
					<form:errors class="error" path="phoneStaff"/>
				</div>	
				<div class="form-element">
					<label class="label-title" for="">Email: </label> 
					<form:input type="email" path="emailStaff"/> 
					<label for="" class="error"></label>
					<form:errors class="error" path="emailStaff"/>
				</div>
				<div class="form-element">
					<label class="label-title" for="">Địa chỉ: </label> 
					<form:input type="text" path="addressStaff"/> 
					<label for="" class="error"></label>
					<form:errors class="error" path="addressStaff"/>
				</div>
				<div class="form-element">
					<label class="label-title" for="">Giới tính: </label> 
					<form:select path="sexStaff" id="sex">
						<option value="Nam">Nam</option>
						<option value="Nữ">Nữ</option>
					</form:select> 
				</div>
				<div class="form-element">
					<label class="label-title" for="">Ngày sinh: </label> 
					<input type="date" value="${d}" name="date" /> 
					<label for="" class="error"></label>
					<form:errors class="error" path="birthdayStaff"/>
				</div>
			</div>
			<button name="${btnStatus}">Lưu</button>
		</form:form>
		<div> <p>${message}</p></div>

		<h2>DANH SÁCH NHÂN VIÊN</h2>
		<div class="link-export__wrapper"><a class="link-export" href="pdf/staff.htm">Xuất danh sách</a></div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="Admin/staff.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div>
			<tg:paging pagedListHolder="${pagedListHolder}"
				pagedLink="${pagedLink}" />

		</div>
		<table>
			<tr>
				<th>Họ và tên</th>
				<th>Ngày sinh</th>
				<th>Giới tính</th>
				<th>Số điện thoại</th>
				<th>Email</th>
				<th>Địa chỉ</th>
				<th>Xóa</th>
				<th>Sửa</th>
				<th>Reset</th>
			</tr>
			<c:forEach var="s" items="${pagedListHolder.pageList}">
				<tr>
					<td>${s.nameStaff}</td>
					<td>${s.birthdayStaff}</td>
					<td>${s.sexStaff}</td>
					<td>${s.phoneStaff}</td>
					<td>${s.emailStaff}</td>
					<td>${s.addressStaff}</td>
					<td><a href="Admin/staff/${s.idStaff}.htm?linkDelete">Xóa</a></td>
					<td><a href="Admin/staff/${s.idStaff}.htm?linkEdit">Sửa</a></td>
					<td><a href="Admin/staff/${s.idStaff}.htm?linkReset">Reset</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>