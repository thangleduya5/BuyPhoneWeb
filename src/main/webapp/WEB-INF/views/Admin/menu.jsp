<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	
<header>
	<div class="header__logo">
		<img src="resource/img/FPTShop_logo.png" alt="">
	</div>
	<div class="header__right">
		<a class="header__logout" href="Admin/login.htm"><i class="fas fa-sign-out-alt"></i></a>
	</div>
</header>
<nav
	style="background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.5)), url(resource/img/navBackground.jpg); 
			background-position: center; 
			background-repeat: no-repeat; 
			background-size: cover;">
	<ul class="list__task">
		<li class="task__item">
			<a href="Admin/info.htm"> <img src="resource/img/admin.jpg" alt=""> <h3>Thông tin cá nhân</h3> </a>
		</li>
		<c:if test="${sessionScope.staff.role==1}">
			<li class="task__item">
				<a href="Admin/staff.htm"> <i class="fas fa-user-clock"></i> Quản lí nhân viên </a>
			</li>
		</c:if>
		<li class="task__item">
			<a href="Admin/productList.htm"> <i class="fab fa-product-hunt"></i> Quản lí sản phẩm </a>
			<ul class="list__sub-task">
				<li class="sub-task__item">
					<a href="Admin/productList.htm">Danh sách sản phẩm</a>
				</li>
				<li class="sub-task__item">
					<a href="Admin/productInsert.htm">Thêm sản phẩm</a>
				</li>
				<li class="sub-task__item">
					<a href="Admin/functionalcamera.htm">Chức năng camera</a>
				</li>
				<li class="sub-task__item">
					<a href="Admin/specialfeature.htm">Tính năng đặc biệt</a>
				</li>
			</ul>
		</li>
		<li class="task__item">
			<a href="Admin/customer.htm"> <i class="fas fa-users"></i> Quản lí khách hàng</a>
		</li>
		<li class="task__item">
			<a href="Admin/billUnConfirm.htm"> <i class="fas fa-file-invoice-dollar"></i> Quản lí hóa đơn</a>
			<ul class="list__sub-task">
				<li class="sub-task__item">
					<a href="Admin/billUnConfirm.htm">Đơn hàng chờ xử lý</a>
				</li>
				<li class="sub-task__item">
					<a href="Admin/billConfirm.htm">Đơn hàng đã hoàn thành</a>
				</li>
			</ul>
		</li>
		<c:if test="${sessionScope.staff.role==1}">
			<li class="task__item">
				<a href="Admin/statistic.htm"> <i class="fas fa-chart-area"></i> Thống kê </a>
				<ul class="list__sub-task">
					<li class="sub-task__item">
						<a href="Admin/statistic.htm">Doanh thu</a>
					</li>
					<li class="sub-task__item">
						<a href="Admin/statisticByBrand.htm">Doanh thu theo nhãn hiệu</a>
					</li>
					<li class="sub-task__item">
						<a href="Admin/statisticTopProducts.htm">Top doanh thu theo sản phẩm</a>
					</li>
				</ul>
			</li>
		</c:if>
	</ul>
</nav>