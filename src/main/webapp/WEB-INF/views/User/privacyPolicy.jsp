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
.fs-main {
	margin-top: 140px;
	padding: 15px 0;
	background: #f3f3f3;
}

.shop-cs-mainbox {
	margin: 0 100px;
	background: white;
}

.shop-cs-maintitle {
	font-size: 24px;
	font-weight: normal;
	margin-bottom: 15px;
}

.policy-container {
	font-size: 14px;
	line-height: 22px;
	color: #333;
}

.policy-container p {
	margin: 10px 0;
}
</style>
</head>
<body>
	<header class="header-app">
		<%@include file="/WEB-INF/views/User/Menu/header.jsp"%>
	</header>

	<section class="fs-main">
		<div class="shop-cs-mainbox policy-title" data-catecomment="7">
			<h3 class="shop-cs-maintitle">Chính sách bảo mật</h3>
			<div class="policy-container">
				<p style="text-align: justify;">
					<em> FPTshop.com.vn cam kết sẽ bảo mật những thông tin mang
						tính riêng tư của bạn. Bạn vui lòng đọc bản “Chính sách bảo mật”
						dưới đây để hiểu hơn những cam kết mà chúng tôi thực hiện, nhằm
						tôn trọng và bảo vệ quyền lợi của người truy cập. </em>
				</p>
				<div class="para-one">
					<h2 class="heading">
						<strong>1. Mục đích và phạm vi thu thập?</strong>
					</h2>
					<p class="para-text">Để truy cập và sử dụng một số dịch vụ tại
						FPTshop.com.vn, bạn có thể sẽ được yêu cầu đăng ký với chúng tôi
						thông tin cá nhân (Email, Họ tên, Số ĐT liên lạc…). Mọi thông tin
						khai báo phải đảm bảo tính chính xác và hợp pháp. FPTshop.com.vn
						không chịu mọi trách nhiệm liên quan đến pháp luật của thông tin
						khai báo.</p>
					<p class="para-text">Chúng tôi cũng có thể thu thập thông tin
						về số lần viếng thăm, bao gồm số trang bạn xem, số links (liên
						kết) bạn click và những thông tin khác liên quan đến việc kết nối
						đến site FPTshop.com.vn. Chúng tôi cũng thu thập các thông tin mà
						trình duyệt Web (Browser) bạn sử dụng mỗi khi truy cập vào
						FPTshop.com.vn, bao gồm: địa chỉ IP, loại Browser, ngôn ngữ sử
						dụng, thời gian và những địa chỉ mà Browser truy xuất đến.</p>
				</div>
				<div class="para-two">
					<h2 class="heading">
						<strong>2. Phạm vi sử dụng thông tin</strong>
					</h2>
					<p class="para-text">FPTshop.com.vn thu thập và sử dụng thông
						tin cá nhân bạn với mục đích phù hợp và hoàn toàn tuân thủ nội
						dung của “Chính sách bảo mật” này. Khi cần thiết, chúng tôi có thể
						sử dụng những thông tin này để liên hệ trực tiếp với bạn dưới các
						hình thức như: gởi thư ngỏ, đơn đặt hàng, thư cảm ơn, sms, thông
						tin về kỹ thuật và bảo mật…</p>
				</div>
				<div class="para-three">
					<h2 class="heading">
						<strong>3. Thời gian lưu trữ thông tin</strong>
					</h2>
					<p class="para-text">Dữ liệu cá nhân của Thành viên sẽ được lưu
						trữ cho đến khi có yêu cầu hủy bỏ hoặc tự thành viên đăng nhập và
						thực hiện hủy bỏ. Còn lại trong mọi trường hợp thông tin cá nhân
						thành viên sẽ được bảo mật trên máy chủ của FPTshop.com.vn.</p>
				</div>
				<div class="para-four">
					<h2 class="heading">
						<strong>4. Địa chỉ của đơn vị thu thập và quản lý thông
							tin cá nhân</strong>
					</h2>
					<ul class="poli-listct">
						<li style="margin-left: 25px;">Công Ty Cổ Phần Bán Lẻ Kỹ
							Thuật Số FPT</li>
						<li style="margin-left: 25px;">Địa chỉ đăng ký kinh doanh:
							261 - 263 Khánh Hội, P2, Q4, TP. Hồ Chí Minh</li>
						<li style="margin-left: 25px;">Văn phòng: 261 - 263 Khánh
							Hội, P2, Q4, TP. Hồ Chí Minh</li>
						<li style="margin-left: 25px;">Điện thoại văn phòng:
							028.38345837</li>
					</ul>
				</div>
				<div class="para-five">
					<h2 class="heading">
						<strong>5. Phương tiện và công cụ để người dùng tiếp cận
							và chỉnh sửa dữ liệu cá nhân</strong>
					</h2>
					<p>Hiện website chưa triển khai trang quản lý thông tin cá nhân
						của thành viên, vì thế việc tiếp cận và chỉnh sửa dữ liệu cá nhân
						dựa vào yêu cầu của khách hàng bằng cách hình thức sau:</p>
					<ul class="poli-listct">
						<li style="margin-left: 25px;">Gọi điện thoại đến tổng đài
							chăm sóc khách hàng 1800 6601, bằng nghiệp vụ chuyên môn xác định
							thông tin cá nhân và nhân viên tổng đài sẽ hỗ trợ chỉnh sửa thay
							người dùng</li>
						<li style="margin-left: 25px;">Để lại bình luận hoặc gửi góp
							ý trực tiếp từ website FPTshop.com.vn, quản trị viên kiểm tra
							thông tin và xem xét nội dung bình luận có phù hợp với pháp luật
							và chính sách của FPTshop.com.vn</li>
					</ul>
				</div>
				<div class="para-six">
					<h2 class="heading">
						<strong>6. Cam kết bảo mật thông tin cá nhân khách hàng</strong>
					</h2>
					<p>Thông tin cá nhân của thành viên trên FPTshop.com.vn được
						FPTshop.com.vn cam kết bảo mật tuyệt đối theo chính sách bảo vệ
						thông tin cá nhân của FPTshop.com.vn. Việc thu thập và sử dụng
						thông tin của mỗi thành viên chỉ được thực hiện khi có sự đồng ý
						của khách hàng đó trừ những trường hợp pháp luật có quy định khác.
					</p>
					<p>Không sử dụng, không chuyển giao, cung cấp hay tiết lộ cho
						bên thứ 3 nào về thông tin cá nhân của thành viên khi không có sự
						cho phép đồng ý từ thành viên.</p>
					<p>Trong trường hợp máy chủ lưu trữ thông tin bị hacker tấn
						công dẫn đến mất mát dữ liệu cá nhân thành viên, FPTshop.com.vn sẽ
						có trách nhiệm thông báo vụ việc cho cơ quan chức năng điều tra xử
						lý kịp thời và thông báo cho thành viên được biết.</p>
					<p>Bảo mật tuyệt đối mọi thông tin giao dịch trực tuyến của
						Thành viên bao gồm thông tin hóa đơn kế toán chứng từ số hóa tại
						khu vực dữ liệu trung tâm an toàn cấp 1 của FPTshop.com.vn.</p>
					<p>Hệ thống thanh toán thẻ được cung cấp bởi các đối tác cổng
						thanh toán (“Đối Tác Cổng Thanh Toán”) đã được cấp phép hoạt động
						hợp pháp tại Việt Nam. Theo đó, các tiêu chuẩn bảo mật thanh toán
						thẻ tại FPTShop đảm bảo tuân thủ theo các tiêu chuẩn bảo mật
						ngành.</p>
					<p>Ban quản lý FPTshop.com.vn yêu cầu các cá nhân khi đăng
						ký/mua hàng là thành viên, phải cung cấp đầy đủ thông tin cá nhân
						có liên quan như: Họ và tên, địa chỉ liên lạc, email, số chứng
						minh nhân dân, điện thoại, số tài khoản, số thẻ thanh toán …., và
						chịu trách nhiệm về tính pháp lý của những thông tin trên. Ban
						quản lý FPTshop.com.vn không chịu trách nhiệm cũng như không giải
						quyết mọi khiếu nại có liên quan đến quyền lợi của Thành viên đó
						nếu xét thấy tất cả thông tin cá nhân của thành viên đó cung cấp
						khi đăng ký ban đầu là không chính xác.</p>
				</div>
				<div class="para-seven">
					<h2 class="heading">
						<strong>7. Quy định bảo mật</strong>
					</h2>
					<p>Chính sách giao dịch thanh toán bằng thẻ quốc tế và thẻ nội
						địa (internet banking) đảm bảo tuân thủ các tiêu chuẩn bảo mật của
						các Đối Tác Cổng Thanh Toán gồm:</p>
					<p>Thông tin tài chính của Khách hàng sẽ được bảo vệ trong suốt
						quá trình giao dịch bằng giao thức SSL 256-bit (Secure Sockets
						Layer).</p>
					<p>Mật khẩu sử dụng một lần (OTP) được gửi qua SMS để đảm bảo
						việc truy cập tài khoản được xác thực.</p>
					<p>Các nguyên tắc và quy định bảo mật thông tin trong ngành tài
						chính ngân hàng theo quy định của Ngân hàng nhà nước Việt Nam.</p>
					<p>Chính sách bảo mật giao dịch trong thanh toán của FPTShop áp
						dụng với Khách hàng:</p>
					<ul class="poli-listct">
						<li style="margin-left: 25px;">Thông tin thẻ thanh toán của
							Khách hàng mà có khả năng sử dụng để xác lập giao dịch KHÔNG được
							lưu trên hệ thống của FPTShop. Đối Tác Cổng Thanh Toán sẽ lưu giữ
							và bảo mật theo tiêu chuẩn quốc tế PCI DSS.</li>
						<li style="margin-left: 25px;">Đối với thẻ nội địa (internet
							banking), FPTShop chỉ lưu trữ mã đơn hàng, mã giao dịch và tên
							ngân hàng. FPTShop cam kết đảm bảo thực hiện nghiêm túc các biện
							pháp bảo mật cần thiết cho mọi hoạt động thanh toán thực hiện
							trên trang FPTShop.</li>
					</ul>
				</div>
				<div class="para-eight">
					<h2 class="heading">
						<strong>8. Làm cách nào để yêu cầu xóa dữ liệu?</strong>
					</h2>
					<p>Bạn có thể gửi yêu cầu xóa dữ liệu qua email Trung tâm hỗ
						trợ của chúng tôi: fptshop@fpt.com.vn. Vui lòng cung cấp càng
						nhiều thông tin càng tốt về dữ liệu nào bạn muốn xóa. Yêu cầu sẽ
						được chuyển đến nhóm thích hợp để đánh giá và xử lý. Chúng tôi sẽ
						liên hệ từng bước để cập nhật cho bạn về tiến trình xóa.</p>
				</div>
			</div>
		</div>

	</section>

	<header class="footer-app">
		<%@include file="/WEB-INF/views/User/Menu/footer.jsp"%>
	</header>
</body>
</html>