<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<h2>THÔNG TIN ĐIỆN THOẠI</h2>
        <form:form action="Admin/productEdit.htm" class="form-product" modelAttribute="phone">
            <div class="form-group">
               	<form:input type="hidden" path="screen.idScreen"/>
                <form:input type="hidden" path="cpu.idCPU"/>
                <form:input type="hidden" path="brand.idBrand"/>
                <form:input type="hidden" path="statusPhone"/>
                <form:input type="hidden" path="imagePhone"/>
                <div class="form-element">
                    <label class="label-title" for="">Số Seri: </label>
                    <form:input type="text" path="idPhone" readonly="true"/>
                    <form:errors class="error" path="idPhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Tên điện thoại: </label>
                    <form:input type="text" path="namePhone" placeholder="Nhập tên"/>
                    <form:errors class="error" path="namePhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Kích thước: </label>
                    <form:input type="text" path="sizePhone" placeholder="dai X rong X cao X trongluong"/>
                    <form:errors class="error" path="sizePhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Giá tiền: </label>
                    <form:input type="number" path="costPhone" placeholder="VND" pattern="[1-9]{1,9}" title="Giá tiền không được rỗng"/>
                    <form:errors class="error" path="costPhone"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Giảm giá: </label>
                    <form:input type="number" path="discountPhone" placeholder="%"/>
                    <form:errors class="error" path="discountPhone"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Màu: </label>
                    <form:input type="text" path="colorPhone" placeholder="xanh đỏ tím vàng"/>
                    <form:errors class="error" path="colorPhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Năm sản xuất: </label>
                    <form:input type="number" path="yearPhone" placeholder=""/>
                    <form:errors class="error" path="yearPhone"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Camera trước: </label>
                    <form:input type="number" path="cameraFrontPhone" placeholder="MP"/>
                    <form:errors class="error" path="cameraFrontPhone"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Camera sau: </label>
                    <form:input type="number" path="cameraRearPhone" placeholder="MP"/>
                    <form:errors class="error" path="cameraRearPhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Chất liệu: </label>
                    <form:input type="text" path="material"/>
                    <form:errors class="error" path="material"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Dung lượng pin: </label>
                    <form:input type="number" path="batteryPhone" placeholder="mAh"/>
                    <form:errors class="error" path="batteryPhone"/> 
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Hệ điều hành: </label>
                    <form:select path="osPhone" >
                        <option value="Android">Android</option>
                        <option value="IOS">IOS</option>
                    </form:select>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Ram: </label>
                    <form:select path="ramPhone" items="${rams}"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Rom: </label>
                    <form:select path="romPhone" items="${roms}"/>
                    <label for="" class="error"></label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Nhãn hiệu: </label>
                    <input type="text" list="brandName" value="${nameBrand}" name="nameBrand"/>
                    <datalist id="brandName">
                    	<c:forEach var="brand" items="${brands}">
                    		<option value="${brand.nameBrand}"/>
                    	</c:forEach>
                    </datalist>
                    <label for="" class="error">${errorBrand}</label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">CPU: </label>
                    <input type="text" list="cpuName" value="${namCPU}" name="nameCPU"/>
                    <datalist id="cpuName">
                    	<c:forEach var="cpu" items="${cpus}">
                    		<option value="${cpu.nameCPU}_${cpu.speedCPU}">
                    	</c:forEach>
                    </datalist>
                    <label for="" class="error">${errorCPU}</label>
                </div>
                <div class="form-element">
                    <label class="label-title" for="">Màn hình: </label>
                    <input type="text" list="screenName" value="${nameScreen}" name="nameScreen"/>
                    <datalist id="screenName">
                    	<c:forEach var="screen" items="${screens}">
                    		<option value="${screen.sizeScreen}_${screen.techScreen.nameTechScreen}_${screen.resolution.nameResolution}"/>
                    	</c:forEach>
                    </datalist>
                    <label for="" class="error">${errorScreen}</label>
                </div>
            </div>
            <button name="btnEdit">Cập nhật</button>
        </form:form>
	</div>
</body>
</html>