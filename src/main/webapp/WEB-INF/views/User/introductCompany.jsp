<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
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
.f-bg {
    background: #f6f6f6;
}
.f-wrap {
    width: 100%;
    padding: 0 6px;
    margin: 0 auto;
    overflow: visible;
}

    .f-wrap:before,
    .f-wrap:after {
        content: '';
        display: table;
    }

    .f-wrap:after {
        clear: both;
    }
.f-s1 h1 {
    text-align: center;
    font-size: 25.25px;
    font-weight: bold;
    padding: 36px 0;
}
.f-htit {
    text-transform: uppercase;
    font-size: 30.3px;
    color: #ff6c14;
    margin-bottom: 30px;
}

.f-rtext {
    text-align: right;
}

.f-tcenter {
    text-align: center;
}

.f-main {
    color: #202020;
    margin: 0 100px;
}

.f-header img {
    width: 100%;
}
.f-header{
	margin: 0 100px;
	margin-top: 145px;
}
.f-s2 {
    padding: 40px 0 30px;
}

.f-row {
    margin: 0 -25px;
}

.f-col1,
.f-col2 {
    float: left;
    padding: 0 25px;
    position: relative;
}

.f-col1 {
    width: 57.3%;
    text-align: justify;
    font-size: 17.68px;
}

.f-col2 {
    width: 42.7%;
}

@-webkit-keyframes fadeInUp {
  from {
    opacity: 0;
    -webkit-transform: translate3d(0, 100%, 0);
    transform: translate3d(0, 100%, 0);
  }

  to {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    -webkit-transform: translate3d(0, 100%, 0);
    transform: translate3d(0, 100%, 0);
  }

  to {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

.fadeInUp {
  -webkit-animation-name: fadeInUp;
  animation-name: fadeInUp;
}
.wow img{
    width: 100%;
}

</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header-app">
		<%@include file="/WEB-INF/views/User/Menu/header.jsp"%>
	</header>
	<header class="f-header">
    <p class="f-bndk"><img src="resource/img/banner.jpg" alt=""></p>
    <p class="f-bnmb"><img src="resource/img/banner-mb.jpg" alt=""></p>
	</header>
	<main class="f-main">
		<section class="f-s1 f-bg">
			<div class="f-wrap">
				<h1>Công ty Cổ Phần Bán Lẻ Kỹ Thuật Số FPT là thành viên của
					Tập đoàn FPT</h1>
			</div>
		</section>
		<section class="f-s2">
			<div class="f-wrap">
				<div class="f-row clearfix">
					<div class="f-col1 wow fadeInUp">
						<h2 class="f-htit">Giới thiệu chung</h2>
						<p>
							Được thành lập vào tháng 8/2007, FPT Shop là chuỗi cửa hàng bán
							lẻ chuyên về các sản phẩm kỹ thuật số như <a
								href="http://fptshop.com.vn/dien-thoai" title="">Điện thoại
								di động</a>, <a href="http://fptshop.com.vn/may-tinh-bang" title="">Máy
								tính bảng</a>, <a href="http://fptshop.com.vn/may-tinh-xach-tay"
								title="">Máy tính xách tay</a> và phụ kiện điện tử ... FPT Shop
							là trung tâm bán lẻ đầu tiên của Việt Nam được cấp chứng chỉ ISO
							9001: 2000 quản lý chất lượng theo tiêu chuẩn quốc tế.
						</p>
						<br>

						<p>Từ ngày 25/8/2015, là đại lý ủy quyền chính thức của Apple
							tại Việt Nam, FPT Shop chính thức nhập khẩu trực tiếp iPhone và
							iPad và mở rộng thêm MacBook và Apple watch vào tháng 8/2016.
							Điều này đồng nghĩa với việc FPT Retail đã nhập khẩu tất cả sản
							phẩm từ Apple.</p>
						<br>

						<p>Bên cạnh chuỗi bán lẻ FPT Shop, công ty FPT Retail còn có
							một chuỗi bán lẻ đạt chuẩn cao cấp nhất của Apple ở cấp độ APR
							(Apple Premium Reseller) với thương hiệu là F.Studio by FPT,
							chuyên doanh các sản phẩm Apple chính hãng với dịch vụ chăm sóc
							khách hàng 6 sao.</p>
						<br>

						<p>Như vậy, FPT Retail đã trở thành công ty duy nhất có chuỗi
							bán lẻ với đầy đủ mô hình cửa hàng của Apple bao gồm chuỗi bán lẻ
							mang thương hiệu F.Studio by FPT gồm 2 cấp độ APR (Apple Premium
							Reseller) và AAR (Apple Authorised Reseller).</p>
						<br>

						<p>Định hướng của FPT Shop không chỉ cung cấp cho khách hàng
							với các sản phẩm chính hãng mới nhất, chất lượng nhất mà còn là
							nơi để khách hàng trải nghiệm sản phẩm thoải mái dưới sự tư vấn
							của đội ngũ nhân viên và kỹ thuật được tào tạo bài bản. Điểm khác
							biệt của FPT Shop còn là các chính sách hậu mãi riêng biệt như
							Bảo hành Vàng: Bảo hành cho cả trường hợp bị rơi vỡ, vào nước,
							chính sách 1 đổi 1 trong vòng 30 ngày, ….</p>
						<br>

						<p>
							Tính đến tháng 6/2016, FPT Shop đã có hơn 350 cửa hàng trên 63
							tỉnh thành trong đó có 60 cửa hàng đã được Apple đưa vào danh
							sách đại lý Apple ủy quyền toàn cầu và chính thức được hiển thị
							tại trang <a href="http://www.apple.com" title="">http://www.apple.com</a>
						</p>

					</div>
					<div class="f-col2 wow fadeInUp">
						<p>
							<img src="resource/img/a1.jpg" alt="">
						</p>
						<br>
						<p>
							<img src="resource/img/a2.jpg" alt="">
						</p>
						<br>
						<p>
							<img src="resource/img/a3.jpg" alt="">
						</p>
					</div>
				</div>
			</div>
		</section>
	</main>
		<footer class="footer-app">
		<%@include file="/WEB-INF/views/User/Menu/footer.jsp"%>
	</footer>
</body>
</html>