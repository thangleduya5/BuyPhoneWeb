<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		<h2>DANH SÁCH HÓA ĐƠN</h2>
		<div class="link-export__wrapper"><a class="link-export" href="pdf/billConfirm.htm">Xuất danh sách</a></div>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="Admin/billConfirm.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div>
			<tg:paging pagedListHolder="${pagedListHolder}"
				pagedLink="${pagedLink}" />
		</div>
		<table>
			<tr>
				<th>Mã hóa đơn</th>
				<th>Mã khách hàng</th>
				<th>Ngày lập</th>
				<th>Số tiền</th>
				<th>Xem chi tiết</th>
			</tr>
			<c:forEach var="s" items="${pagedListHolder.pageList}">
            	<tr>
					<td>${s.idBill}</td>
					<td>${s.customer.idCustomer}</td>
					<td>${s.dateBill}</td>
					<td>${s.costBill}</td>
					<td><a href="Admin/billDetail/${s.idBill}.htm">Xem chi tiết</a></td>
				</tr>
            </c:forEach>
		</table>
	</div>

</body>
</html>