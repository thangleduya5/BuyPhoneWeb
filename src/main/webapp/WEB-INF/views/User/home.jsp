<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/resource/css/User/menuStyle.css' />"
	rel="stylesheet">
<link href="<c:url value='/resource/css/Style.css' />" rel="stylesheet">
<link
	href="<c:url value='/resource/fontawesome-free-5.15.4-web/css/all.css' />"
	rel="stylesheet">
<base href="${pageContext.servletContext.contextPath}/">
<style type="text/css">
/*Container-app*/
.container-app {
	margin-top: 135px;
	display: flex;
	flex-direction: column;
	background-image: url("resource/img/backgroundMain.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
}
/*slide*/
.slide {
	margin: 0 100px;
	margin-top: 48px;
	position: relative;
}

.btn__slide {
	background-color: white;
	opacity: 0.7;
	border-radius: 50%;
	padding: 8px 16px;
	cursor: pointer;
	position: absolute;
	font-size: 32px;
	top: 50%;
	transform: translate(0, -50%);
	transition: all 0.5s;
}

#btn__slide--next {
	right: 0;
}

.btn__slide:hover {
	opacity: 1;
	box-shadow: 0 0 2px 2px;
}

.slide__item {
	display: none;
}

.slide__item img {
	width: 100%;
}

.slide__item--active {
	display: block;
}

/*end of slide*/
.container-app__wrap {
	margin: 48px 100px;
	/* border: solid 1px; */
	display: flex;
}

/*Selector*/
.selector {
	width: 24%;
	margin-right: 1%;
	background-color: white;
	box-shadow: 0px 0px 2px 2px rgb(201, 194, 194);
	border-radius: 5px;
}

.form__selector {
	margin: 12px;
}

.form__selector label {
	font-size: 20px;
	font-weight: bolder;
}

.form-element {
	margin-bottom: 12px;
}

.checkbox-group {
	margin-top: 8px;
}

.checkbox__element {
	display: inline-block;
	margin-right: 24px;
	margin-bottom: 4px;
}

.form__selector button {
	margin-left: 20%;
	width: 60%;
	cursor: pointer;
}
/*end of selector*/

/* card-item */
.card__list {
	width: 75%;
	/* border: solid 1px; */
	box-shadow: 0px 0px 2px 2px rgb(201, 194, 194);
	border-radius: 5px;
	background-color: white;
}

.card__item {
	width: 33.33%;
	float: left;
	padding: 8px;
	font-size: 20px;
	border-radius: 5px;
	transition: all 0.5s;
}

.card__item:hover {
	box-shadow: 0px 0px 4px 4px rgb(201, 194, 194);
}

.card__item:hover .card-item__img {
	width: 100%;
}

.card-item__link {
	display: block;
	height: 300px;
	display: flex;
	align-items: center;
	margin-bottom: 8px;
}

.card-item__img {
	width: 80%;
	transition: all 0.5s;
}

.card-item__name {
	text-align: center;
	display: block;
	color: black;
	font-weight: bolder;
}

.card-item__name:hover {
	color: #007aff;
}

.card-item__cost {
	margin: 8px 0;
	position: relative;
	height: 32px;
}

.card-item__cost p {
	display: inline-block;
}

.cost__unit {
	position: absolute;
	transform: translate(0, -50%);
	top: 50%;
	right: 0;
	text-decoration: line-through;
	font-style: italic;
}
.cost__unit-action {
	position: absolute;
	transform: translate(0, -50%);
	top: 50%;
	right: 0;
}

.cost__discount,
.cost__unit-action {
	padding: 4px;
	background-color: red;
	font-weight: bolder;
	border-radius: 5px;
}

.config__item {
	display: flex;
	margin: 8px auto;
	font-size: 16px;
}

.config__item i {
	position: relative;
	cursor: default;
}

.config__item i:hover .tooltip {
	display: block;
}

.btn__buy {
	width: 40%;
}

.btn__add-cart {
	float: right;
	width: 55%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<header class="header-app">
		<%@include file="/WEB-INF/views/User/Menu/header.jsp"%>
	</header>


	<div class="container-app">
		<div class="slide">
			<div class="slide__list">
				<div class="slide__item slide__item--active" idx="0">
					<img src="resource/img/slide1.jpg">
				</div>
				<div class="slide__item" idx="1">
					<img src="resource/img/slide2.jpg">
				</div>
				<div class="slide__item" idx="2">
					<img src="resource/img/slide3.jpg">
				</div>
				<div class="slide__item" idx="3">
					<img src="resource/img/slide4.jpg">
				</div>
			</div>
			<span class="btn__slide" id="btn__slide--prev"><i
				class="fas fa-chevron-left"></i></span> <span class="btn__slide"
				id="btn__slide--next"><i class="fas fa-chevron-right"></i></span>
		</div>
		<div class="container-app__wrap">
			<div class="selector">
				<form class="form__selector" action="User/home.htm" method="POST">
					<div class="form-element">
						<label class="label-title" for="">Hãng sản xuất: </label>
						<div class="checkbox-group">
							<div class="checkbox__element">
								<input id="check__brand-all" type="checkbox" name="nameBrand" value="all" checked="checked"> Tất cả
							</div>
							<c:forEach var="b" items="${sessionScope.brands}">
								<div class="checkbox__element">
									<input class="check__brand-item" type="checkbox" name="nameBrand" value="${b.nameBrand}"> ${b.nameBrand}
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="form-element">
						<label class="label-title" for="">Mức giá: </label>
						<div class="checkbox-group">
							<div class="checkbox__element">
								<input id="check__price-all" type="checkbox" name="price" value="all" checked="checked"> Tất cả
							</div>
							<div class="checkbox__element">
								<input class="check__price-item" type="checkbox" name="price" value="<2"> Dưới 2 triệu
							</div>
							<div class="checkbox__element">
								<input class="check__price-item" type="checkbox" name="price" value="2->4"> Từ 2 - 4 triệu
							</div>
							<div class="checkbox__element">
								<input class="check__price-item" type="checkbox" name="price" value="4->7"> Từ 4 - 7 triệu
							</div>
							<div class="checkbox__element">
								<input class="check__price-item" type="checkbox" name="price" value="7->13"> Từ 7 - 13 triệu
							</div>
							<div class="checkbox__element">
								<input class="check__price-item" type="checkbox" name="price" value=">13"> Trên 13 triệu
							</div>
						</div>
					</div>
					<div class="form-element">
						<label class="label-title" for="">Tính năng đặc biệt: </label>
						<div class="checkbox-group">
						    <div class="checkbox__element">
								<input id="check__special-feature-all" type="checkbox" name="idSpecialFeature" value="all" checked="checked"> Tất cả
                    		</div>
                    		<c:forEach var="s" items="${sessionScope.specialFeatures}">
                    			<div class="checkbox__element">
									<input class="check__special-feature-item" type="checkbox" name="idSpecialFeature" value="${s.idSpecialFeature}"> ${s.nameSpecialFeature}
                    			</div>
                    		</c:forEach>
						</div>
					</div>
					<div class="form-element">
						<label class="label-title" for="">Dung lượng PIN: </label>
						<div class="checkbox-group">
							<div class="checkbox__element">
								<input id="check__battery-all" type="checkbox" name="battery" value="all" checked="checked"> Tất cả
							</div>
							<div class="checkbox__element">
								<input class="check__battery-item" type="checkbox" name="battery" value="<3"> Dưới 3000 mah
							</div>
							<div class="checkbox__element">
								<input class="check__battery-item" type="checkbox" name="battery" value="3->4"> Từ 3000 - 4000 mah
							</div>
							<div class="checkbox__element">
								<input class="check__battery-item" type="checkbox" name="battery" value=">4"> Siêu trâu: trên 4000 mah
							</div>
						</div>
					</div>
					<div class="form-element">
						<label class="label-title" for="">Màn hình: </label>
						<div class="checkbox-group">
							<div class="checkbox__element">
								<input id="check__screen-all" type="checkbox" name="screen" value="all" checked="checked"> Tất cả
							</div>
							<div class="checkbox__element">
								<input class="check__screen-item" type="checkbox" name="screen" value="<5"> Màn hình nhỏ: dưới 5.0 inch
							</div>
							<div class="checkbox__element">
								<input class="check__screen-item" type="checkbox" name="screen" value="5->6"> Nhỏ gọn vừa tay: dưới 6.0 inch
							</div>
							<div class="checkbox__element">
								<input class="check__screen-item" type="checkbox" name="screen" value=">6"> Trên 6.0 inch
							</div>
						</div>
					</div>
					<div class="form-element">
						<label class="label-title" for="">Camera: </label>
						<div class="checkbox-group">
							<div class="checkbox__element">
                 				<input id="check__functional-camera-all" type="checkbox" name="idFunctionalCamera" value="all" checked="checked"> Tất cả
							</div>
                    		<c:forEach var="f" items="${sessionScope.functionalCameras}">
								<div class="checkbox__element">
                 					<input class="check__functional-camera-item" type="checkbox" name="idFunctionalCamera" value="${f.idFunctionalCamera}"> ${f.nameFunctionalCamera}
								</div>
                    		</c:forEach>
						</div>
					</div>
					<button class="btn" name="btnSearch">Tìm kiếm</button>
				</form>
			</div>
			<div class="card__list">
			
			<c:if test="${searchAll==null}">
				<jsp:useBean id="pagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
				<c:if test="${brandsss!=null}">
					<c:url value="User/home/${brandsss}.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
				</c:if>
				<c:if test="${brandsss==null}">
					<c:url value="User/home.htm" var="pagedLink">
						<c:param name="p" value="~" />
					</c:url>
				</c:if>
				<div>
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />
					<style>
						.fs-search{
							display: none;
						}
					</style>
				</div>			

			
				
				<c:forEach var="p" items="${pagedListHolder.pageList}">
					<div class="card__item">
						<a href="User/phone/${p.idPhone}.htm" class="card-item__link"> <img
							src="resource/img/imgPhone/${f:substring(p.imagePhone,0,f:indexOf(p.imagePhone,'_'))}" alt="" class="card-item__img">
						</a> 
						<a href="User/phone/${p.idPhone}.htm" class="card-item__name">${p.namePhone}</a>
						<div class="card-item__cost">
							<c:if test="${p.discountPhone>0}">
								<p class="cost__discount">- ${p.discountPhone} %</p>
								<p class="cost__unit"> <fmt:formatNumber type="currency" value="${p.costPhone}" /></p>
							</c:if>
							<c:if test="${p.discountPhone==0}">
								<p class="cost__unit-action"> <fmt:formatNumber type="currency" value="${p.costPhone}" /></p>
							</c:if>						
						</div>
						<div class="card-item__config">
							<div class="config__item">
								<i class="fas fa-mobile-alt"> ${p.screen.sizeScreen} "
									<p class="tooltip">Screen</p>
								</i>
								 <i class="fas fa-memory"> ${p.ramPhone} GB
									<p class="tooltip">Ram</p>
								</i>
								 <i class="fas fa-hdd"> ${p.romPhone} GB
									<p class="tooltip"> Rom</p>
								</i>
							</div>
						</div>
						<div class="card-item__btn">
							<a href="User/phone/${p.idPhone}.htm" class="btn__buy btn">MUA NGAY</a> <a
								href="User/phone/${p.idPhone}.htm?linkAdd" class="btn__add-cart btn">THÊM VÀO GIỎ</a>
						</div>
					</div>
				</c:forEach>
			</c:if>
			
			<c:if test="${searchAll!=null}">
				
				<c:forEach var="p" items="${products}">
					<div class="card__item">
						<a href="User/phone/${p.idPhone}.htm" class="card-item__link"> <img
							src="resource/img/imgPhone/${f:substring(p.imagePhone,0,f:indexOf(p.imagePhone,'_'))}" alt="" class="card-item__img">
						</a> 
						<a href="User/phone/${p.idPhone}.htm" class="card-item__name">${p.namePhone}</a>
						<div class="card-item__cost">
							<p class="cost__discount">- ${p.discountPhone} %</p>
							<p class="cost__unit">${p.costPhone} đ</p>
						</div>
						<div class="card-item__config">
							<div class="config__item">
								<i class="fas fa-mobile-alt"> ${p.screen.sizeScreen} "
									<p class="tooltip">Screen</p>
								</i>
								 <i class="fas fa-memory"> ${p.ramPhone} GB
									<p class="tooltip">Ram</p>
								</i>
								 <i class="fas fa-hdd"> ${p.romPhone} GB
									<p class="tooltip"> Rom</p>
								</i>
							</div>
						</div>
						<div class="card-item__btn">
							<a href="User/phone/${p.idPhone}.htm" class="btn__buy btn">MUA NGAY</a> <a
								href="User/phone/${p.idPhone}.htm?linkAdd" class="btn__add-cart btn">THÊM VÀO GIỎ</a>
						</div>
					</div>
				</c:forEach>				
				
			</c:if>
			
			</div>
		</div>
	</div>

	<header class="footer-app">
		<%@include file="/WEB-INF/views/User/Menu/footer.jsp"%>
	</header>
	<script type="text/javascript"
		src="<c:url value='/resource/javascript/slide.js' />"></script>
	<script type="text/javascript">
		
	changeCheckBox(document.getElementById('check__brand-all'), document.getElementsByClassName('check__brand-item'));
	changeCheckBox(document.getElementById('check__price-all'), document.getElementsByClassName('check__price-item'));
	changeCheckBox(document.getElementById('check__special-feature-all'), document.getElementsByClassName('check__special-feature-item'));
	changeCheckBox(document.getElementById('check__battery-all'), document.getElementsByClassName('check__battery-item'));
	changeCheckBox(document.getElementById('check__screen-all'), document.getElementsByClassName('check__screen-item'));
	changeCheckBox(document.getElementById('check__functional-camera-all'), document.getElementsByClassName('check__functional-camera-item'));
		
		function changeCheckBox(all, list) {
			all.onclick=function(){
				if(all.checked==true){
					for(var i=0; i< list.length;i++){
						list[i].checked=false;
					}
				} else{
 					all.checked=true;
				}
			}
			for(var i=0; i< list.length;i++){
				list[i].onclick=function(){
					if(this.checked==true){
						var flag=true;
						for(var j=0; j< list.length;j++){
							if(list[j].checked==false){
								flag=false;
								break;
							}
						}
						if(flag==false){
							all.checked=false;
						} else{
							all.checked=true;
							for(var i=0; i< list.length;i++){
								list[i].checked=false;
							}
						}
					} else{
						for(var j=0; j< list.length;j++){
							if(list[j].checked==true){
								return;
							}
						}
 						all.checked=true;
					}
				}
			}
		}
	</script>
</body>
</html>