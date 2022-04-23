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
body {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 14px;
    line-height: 1.42857143;
    color: #333;
    overflow-x: hidden;
}

a, a:hover, a:focus, a:active {
    outline: none;
    text-decoration: none;
    color: #000000;
}
.fs-main{
	margin-top: 145px;
	padding: 15px 0;
    background: #f3f3f3;
}
.f-wrap{
	margin-left: 100px;
	margin-right: 100px;
}
.fshop-csmain{
    max-width: 930px;
    margin: 30px auto 0;
}
.fs-cstit{
    color: #3d3d3d;
    font-size: 22px;
    text-transform: uppercase;
    height: 63px;
    line-height: 63px;
    padding: 0 15px;
    border-bottom: 1px solid #e3e3e3;
}
.fs-csifo{
    padding: 22px 30px 35px;
    color: #4a4a4a;
}
.fs-csn-title{
    font-size: 16px;
    font-weight: 700;
    text-transform: uppercase;
    margin-bottom: 10px;
    line-height: 22px;
}
.fs-csntb thead{
    background: #99be73;
}
.fs-csntb thead tr th{
    text-align: center;
    border-bottom: none;
    width: 50%;
    font-size: 16px;
    color: #ffffff;
    font-weight: 700;
    text-transform: uppercase;
    padding: 13px 0;
    border-right: 1px solid #839e61;
}
.fs-csntb thead tr th:last-child{
    border-right: 1px solid #dbdbdb;
}
.fs-ctr{
    background: #ececec;
}
.table>tbody tr td{
    border: 1px solid #dbdbdb;
    padding: 8px 15px;
}
.table>tbody .fs-ctr td{
    border-top: none;
    text-align: center;
    padding: 10px 0;
    font-weight: 700;
}
.table>tbody tr td p strong,
.table>tbody tr td p span{
    display: block;
    margin: 6px 0;
}
.fs-csname{
    font-size: 16px;
    font-weight: bold;
    line-height: 20px;
}
.fs-csitxt{
    margin: 5px 0;
}
.fs-cs-kmul{
    margin: 15px 0;
}
.fs-cs-kmul li{
    margin: 5px 0;
}
.fs-cs-kmul li span{
    padding: 0 15px;
}
.fs-csnew,
.fs-csold,
.fs-cspk{
    margin-bottom: 30px;
}
.fs-csotb thead {
    background: #ff6f6f;
}
.fs-csotb thead tr th{
    border-right: 1px solid #ffaeae;
}
.table>tbody tr td p{
    margin: 3px 0;
}
.fs-cspk-nav{
    margin: 0 -8px;
}
.fs-cspk-nav li{
    float: left;
    width: 50%;
    margin: 8px 0;
    padding: 0 8px;
}
.fs-cspk-nifo{
    border: solid 1px #d5d5d5;
    padding: 25px 15px;
    text-align: center;
}
.fs-cspk-ntit{
    font-size: 16px;
    font-weight: 700;
    margin-bottom: 5px;
    text-transform: uppercase;
    max-height: 17px;
    padding: 3px 0 0 0;
    overflow: hidden;
    display: inline-block;
}
.fs-cspk-nifo p{
    height: 60px;
    padding: 3px 0;
    overflow: hidden;
}
.fs-cspk-nav li:nth-child(1) .fs-cspk-nifo{
    background-color: #dcfebe;
}
.fs-cspk-nav li:nth-child(2) .fs-cspk-nifo{
    background-color: #f4efbc;
}
.fs-cspk-nav li:nth-child(3) .fs-cspk-nifo{
    background-color: #cee5ff;
}
.fs-cspk-nav li:nth-child(4) .fs-cspk-nifo{
    background-color: #e9e9e9;
}
.fs-cs-note{
    margin: 10px 0;
}
.fs-csdt-nav .fs-cspk-nifo p {
    text-align: left;
    height: 45px;
}
.fs-csdt-nav .fs-cspk-nifo span{
    display: block;
    text-align: center;
}
.fs-csdt-nav .fs-cspk-nifo{
    height: 170px;
}
.fs-csdt-nav li:nth-child(1) .fs-cspk-nifo{
    background-color: #fff3d6;
}
.fs-csdt-nav li:nth-child(2) .fs-cspk-nifo{
    background-color: #c1deff;
}

@media (max-width: 768px) {
    .fs-csn-title {
        font-size: 13px;
        line-height: 18px;
    }
    .fs-cstit{
        font-size: 18px;
        height: 50px;
        line-height: 50px;
    }
    .fs-csifo{
        font-size: 13px;
        padding: 15px 10px;
    }
    .fs-csntb thead tr th,
    .table>tbody .fs-ctr td,
    .table>tbody tr td p,
    .table>tbody tr td,
    .fs-csname{
        font-size: 13px;
    }
    .fs-cs-kmul li span {
        padding: 0 10px;
    }
    .fs-cspk-nav li {
        float: none;
        width: 100%;
        margin: 8px 0;
        padding:0;
    }
    .fs-cspk-nav{
        margin: 0;
    }
    .fs-csdt-nav .fs-cspk-nifo {
        height: auto;
    }
    .fs-csdt-nav .fs-cspk-nifo p {
        text-align: left;
        height: auto;
    }
}
@media (max-width: 480px) {
    .fs-cstit {
        font-size: 15px;
    }
    .fs-csn-title {
        font-size: 12px;
    }
}
.hdsd-main{line-height:25px;padding:10px 15px;background:#fff}
.hdsd-tb{margin-bottom:10px;width:100%;border:1px solid #ccc}
.hdsd-tb tr td{padding:8px;border:1px solid #ccc}
.hdsd-tr1{text-align:center;background:rgba(146,208,80,1)}
.hdsd-tr2{text-align:center;background:rgba(217,217,217,1)}
.hdsd-noti{padding:8px;text-align:center;background:rgba(146,208,80,1)}
.fs-cspk-ntit{max-height:40px}.fs-cspk-nifo{height:140px}
.fs-cspk-nav li:nth-child(4) .fs-cspk-nifo {background-color:#cee5ff}
.fs-cspk-nav li:nth-child(6) .fs-cspk-nifo {background-color:#e9e9e9}
.fs-cs-kmul li span{padding:0;width:35px;text-align:center;float:left}
.fs-cs-kmul li p{margin-left:35px}
.fs-cspk-nav li:nth-child(2) .fs-cspk-nifo {background-color:#f4dbbc}
.fs-cspk-nav li:nth-child(3) .fs-cspk-nifo {background-color:#f4efbc}
.fs-cspk-ntit{max-height:40px;line-height:20px}
.fs-cspk-nifo{height:185px}
.fs-cspk-nifo p{height:107px}
.dhdt,.dhdt tr,.dhdt td{border:1px solid #000;padding:5px}
.dhdt{text-align:left;margin-bottom:30px;margin-top:20px}
</style>
</head>

<body>
	<header class="header-app">
		<%@include file="/WEB-INF/views/User/Menu/header.jsp"%>
	</header>
<section class="fs-main">
	<div class="f-wrap">
	    <div class="hdsd-main">
	        <p style="text-align: center;font-size: 18px;"><strong>QUY CHẾ HOẠT ĐỘNG&nbsp;WEBSITE CUNG CẤP DỊCH VỤ TMĐT FPTSHOP.COM.VN</strong></p>
			<br/>
	        <p><strong>I. Nguy&ecirc;n tắc chung</strong></p>
	        <p>- Website thương mại điện tử FPTshop.com.vn do C&ocirc;ng ty Cổ Phần B&aacute;n lẻ kỹ thuật số FPT (&ldquo;C&ocirc;ng ty&rdquo;) thực hiện hoạt động v&agrave; vận h&agrave;nh. Đối tượng phục vụ l&agrave; tất cả kh&aacute;ch h&agrave;ng tr&ecirc;n 63 tỉnh th&agrave;nh Việt Nam c&oacute; nhu cầu mua h&agrave;ng nhưng kh&ocirc;ng c&oacute; thời gian đến shop hoặc đặt trước để khi đến shop l&agrave; đảm bảo c&oacute; h&agrave;ng.</p>
	        <p>- Sản phẩm được kinh doanh tại <a href="http://www.fptshop.com.vn">www.FPTshop.com.vn</a> phải đ&aacute;p ứng đầy đủ c&aacute;c quy định của ph&aacute;p luật, kh&ocirc;ng b&aacute;n h&agrave;ng nh&aacute;i, h&agrave;ng kh&ocirc;ng r&otilde; nguồn gốc, h&agrave;ng x&aacute;ch tay.</p>
	        <p>- Hoạt động mua b&aacute;n tại FPTshop.com.vn phải được thực hiện c&ocirc;ng khai, minh bạch, đảm bảo quyền lợi của người ti&ecirc;u d&ugrave;ng.</p>
	        <p><strong>II. Quy định chung</strong></p>
	        <p><strong><u>T&ecirc;n Miền website Thương mại Điện tử:</u></strong></p>
	        <p>Website thương mại điện tử FPTshop.com.vn do C&ocirc;ng ty Cổ phần b&aacute;n lẻ kỹ thuật số ph&aacute;t triển với t&ecirc;n miền giao dịch l&agrave;: www.FPTshop.com.vn (sau đ&acirc;y gọi tắt l&agrave;: &ldquo;FPTshop.com.vn&rdquo;)</p>
	        <p><strong><u>Định nghĩa chung:</u></strong></p>
	        <p><strong>Người b&aacute;n</strong>&nbsp;l&agrave; C&ocirc;ng ty Cổ phần B&aacute;n lẻ kỹ thuật số FPT</p>
	        <p><strong>Người mua</strong>&nbsp;l&agrave; c&ocirc;ng d&acirc;n Việt Nam tr&ecirc;n khắp 63 tỉnh th&agrave;nh. Người mua c&oacute; quyền đăng k&yacute; t&agrave;i khoản hoặc kh&ocirc;ng cần đăng k&yacute; để thực hiện giao dịch.</p>
	        <p><strong>Th&agrave;nh vi&ecirc;n</strong>&nbsp;l&agrave; bao gồm cả người mua v&agrave; người tham khảo th&ocirc;ng tin, thảo luận tại website.</p>
	        <p>Nội dung bản Quy chế n&agrave;y tu&acirc;n thủ theo c&aacute;c quy định hiện h&agrave;nh của Việt Nam. Th&agrave;nh vi&ecirc;n khi tham gia website TMĐT FPTshop.com.vn phải tự t&igrave;m hiểu tr&aacute;ch nhiệm ph&aacute;p l&yacute; của m&igrave;nh đối với luật ph&aacute;p hiện h&agrave;nh của Việt Nam v&agrave; cam kết thực hiện đ&uacute;ng những nội dung trong Quy chế n&agrave;y.</p>
	        <p><strong>III. Quy tr&igrave;nh giao dịch</strong></p>
	        <p><strong><u>D&agrave;nh cho người mua h&agrave;ng tại website TMĐT FPTshop.com.vn</u></strong></p>
	        <p><strong>Bước 1:</strong>&nbsp;T&igrave;m kiếm v&agrave; chọn sản phẩm cần mua.</p>
	        <p><strong>Bước 2:</strong>&nbsp;Xem gi&aacute; v&agrave; th&ocirc;ng tin chi tiết sản phẩm đ&oacute;, nếu qu&yacute; kh&aacute;ch đồng &yacute; muốn đặt h&agrave;ng, qu&yacute; kh&aacute;ch ấn v&agrave;o 1 trong 3 n&uacute;t mua h&agrave;ng:</p>
	        <p>+ Mua ngay</p>
	        <p>+ Trả g&oacute;p 0%</p>
	        <p>+ Trả g&oacute;p qua thẻ</p>
	        <p><strong>Bước 3:&nbsp;</strong>Qu&yacute; kh&aacute;ch điền đầy đủ th&ocirc;ng tin theo mua h&agrave;ng theo mẫu:</p>
	        <p>+ Họ tên; Số điện thoại; Email</p>
	        <p>+ Chọn phương thức nhận h&agrave;ng: Nh&acirc;n h&agrave;ng tại cửa h&agrave;ng hoặc giao h&agrave;ng tận nơi</p>
	        <p>+ Chọn phương thức thanh to&aacute;n: Trả tiền mặt; Thẻ ATM; Thẻ Quốc tế (Visa, MasterCard); Trả g&oacute;p. Qu&yacute; kh&aacute;ch h&agrave;ng đang sử dụng thẻ ATM nội địa hoặc thẻ t&iacute;n dụng Visa, Master qu&yacute; kh&aacute;ch c&oacute; thể thanh to&aacute;n đơn h&agrave;ng bằng c&aacute;ch click chọn v&agrave;o h&igrave;nh thức thanh to&aacute;n tương ứng v&agrave; l&agrave;m theo hướng dẫn của ng&acirc;n h&agrave;ng.</p>
	        <p><strong>Bước 4:</strong> Sau&nbsp; khi đ&atilde; nhập đầy đủ th&ocirc;ng tin, qu&yacute; kh&aacute;ch click &ldquo;Đặt h&agrave;ng&rdquo; để ho&agrave;n tất đặt h&agrave;ng</p>
	        <p><strong>Bước 5:&nbsp;</strong>Sau khi nhận đơn h&agrave;ng của người mua, FPTshop.com.vn sẽ li&ecirc;n lạc với kh&aacute;ch h&agrave;ng qua th&ocirc;ng tin số điện qu&yacute; kh&aacute;ch h&agrave;ng cung cấp từ số điện thoại 028 7300 6601 để x&aacute;c thực th&ocirc;ng tin đơn h&agrave;ng.</p>
	        <p><strong>Bước 6:</strong>&nbsp;FPTshop.com.vn giao h&agrave;ng tận nh&agrave; đến cho kh&aacute;ch h&agrave;ng hoặc kh&aacute;ch h&agrave;ng đến trực tiếp c&aacute;c cửa h&agrave;ng tr&ecirc;n to&agrave;n quốc để nhận h&agrave;ng.</p>
	
	        <p><strong><u>D&agrave;nh cho b&ecirc;n b&aacute;n h&agrave;ng l&agrave; FPTshop.com.vn</u></strong></p>
	        <p>- Chuẩn bị sản xuất nội dung gồm: h&igrave;nh ảnh sản phẩm chụp thực tế hoặc h&igrave;nh ảnh do h&atilde;ng sản xuất cung cấp, b&agrave;i viết giới thiệu, th&ocirc;ng tin cấu h&igrave;nh sản phẩm.</p>
	        <p>- Nhập liệu bằng c&ocirc;ng cụ quản l&yacute; ri&ecirc;ng d&agrave;nh cho nh&acirc;n vi&ecirc;n FPTshop.com.vn</p>
	        <p>- Định dạng h&igrave;nh ảnh sử dụng tr&ecirc;n website: jpg, png.</p>
	        <p><strong><u>Quy tr&igrave;nh giao nhận vận chuyển</u></strong></p>
	        <p>- FPTshop.com.vn thực hiện giao h&agrave;ng tr&ecirc;n to&agrave;n quốc. Khi nhận đơn h&agrave;ng từ người mua v&agrave; sau khi đ&atilde; x&aacute;c nhận th&ocirc;ng tin mua h&agrave;ng qua điện thoại, FPTshop.com.vn sẽ tiến h&agrave;nh giao h&agrave;ng theo y&ecirc;u cầu của qu&yacute; kh&aacute;ch h&agrave;ng:</p>
	        <p>- Giữ h&agrave;ng tại c&aacute;c cửa h&agrave;ng của FPTShop tr&ecirc;n to&agrave;n quốc v&agrave; người mua sẽ đến trực tiếp cửa h&agrave;ng kiểm tra v&agrave; nhận h&agrave;ng.</p>
	        <p>- Giao h&agrave;ng tận nơi trên toàn bộ 63 tỉnh th&agrave;nh</p>
	        <p>- FPT Shop nhận giao đơn h&agrave;ng c&oacute; thời gian hẹn giao tại nh&agrave; trước 21h00 đối với Điện thoại, M&aacute;y t&iacute;nh bảng v&agrave; trước 20h00 đối với M&aacute;y t&iacute;nh x&aacute;ch tay.</p>
	        <p>- Miễn ph&iacute; giao h&agrave;ng trong b&aacute;n k&iacute;nh 20km c&oacute; đặt shop.</p>
	        <p>- Với khoảng c&aacute;ch lớn hơn 20km, nh&acirc;n vi&ecirc;n FPTShop sẽ tư vấn chi tiết về c&aacute;ch thức giao nhận thuận tiện nhất</p>
	        <p>- Với những đơn h&agrave;ng giao tại nh&agrave; v&agrave; c&oacute; gi&aacute; trị từ 50 triệu đồng trở l&ecirc;n, Qu&yacute; kh&aacute;ch vui l&ograve;ng thanh to&aacute;n trước 100% gi&aacute; trị đơn h&agrave;ng.</p>
	        <p><strong><u>Quy tr&igrave;nh bảo h&agrave;nh/đổi trả sản phẩm </u></strong></p>
	        <p style="text-align: center"><img src="images/hd/pic1.jpg" alt=""></p>
	        <div class="fshop-csmain">
	    <div class="fs-csifo">
	        <div class="fs-csnew">
	            <h2 class="fs-csn-title">I. CHÍNH SÁCH ĐỔI TRẢ SẢN PHẨM MỚI: APPLE, ĐTDĐ, MTB, MTXT, SMARTWATCH, MÀN HÌNH LCD SAMSUNG</h2>
	            <table class="table fs-csntb">
	                <thead>
	                    <tr>
	                        <th>THÁNG 1</th>
	                        <th>THÁNG 2-12</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do nhà sản xuất</td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <p><strong>1 ĐỔI 1</strong> sản phẩm cùng model, cùng màu, cùng dung lượng.</br>
								Trong tình huống sản phẩm đổi hết hàng, khách hàng có thể đổi sang một sản phẩm khác tương đương hoặc cao hơn về giá trị so với sản phẩm lỗi.</span>
	                            <strong>Hoặc</strong>
	                             Khách hàng muốn trả sản phẩm: FPTShop sẽ kiểm tra tình trạng máy và thông báo đến Khách hàng về giá trị thu lại sản phẩm ngay tại cửa hàng.</p>
	                        </td>
	                        <td>
								<p><strong>GỬI MÁY ĐI BẢO HÀNH THEO QUI ĐỊNH CỦA HÃNG</strong>
								<strong>Hoặc</strong>
								Khách hàng muốn đổi sang sản phẩm khác hoặc trả sản phẩm: FPTShop sẽ kiểm tra tình trạng máy và thông báo đến Khách hàng về giá trị thu lại sản phẩm ngay tại cửa hàng.</p>                         
	                        </td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm không lỗi (đổi trả theo nhu cầu của khách hàng)</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2">
	                            <p>Khách hàng muốn đổi sang sản phẩm khác hoặc trả sản phẩm: FPTShop sẽ kiểm tra tình trạng máy và thông báo đến Khách hàng về giá trị thu lại sản phẩm ngay tại cửa hàng.</p>
	                        </td>             
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do người sử dụng</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2"><strong>Không áp dụng đổi trả</strong> với sản phẩm:</br>
							- Máy không còn giữ nguyên 100% hình dạng ban đầu, bao gồm: có dấu hiệu va chạm mạnh, cấn móp, bị vào nước...</br>
							- Không đủ điều kiện bảo hành theo chính sách của hãng.</br>
							Trong trường hợp này, FPT Shop hỗ trợ chuyển TTBH và khách hàng chịu phí sửa chữa.
							</td>
	                    </tr>
	                </tbody>
	            </table>
	
	            <p><strong>Phí đổi trả khác nếu có:</strong> FPTShop sẽ kiểm tra tình trạng máy và thông báo đến khách hàng về mức phí phải thu ngay tại cửa hàng.</p>
	            <p><strong><i>Lưu ý với sản phẩm mua trả góp:</i></strong></p>
	            <ul class="fs-cs-kmul">
	                <li><span>•</span>Trong 14 ngày đầu tiên: khách hàng huỷ hợp đồng và không phải chịu bất kỳ khoản chi phí trả góp nào</li>
	                <li><span>•</span>Sau 14 ngày: khách hàng phải thanh lý hợp đồng và chịu phí theo từng công ty trả góp</li>
	            </ul>
	        </div>
			<div class="fs-csold">
	            <h2 class="fs-csn-title">II.	CHÍNH SÁCH ĐỔI TRẢ SẢN PHẨM ĐÃ QUA SỬ DỤNG: ĐTDĐ, MTB, MTXT SMARTWATCH (Bao gồm APPLE)</h2>
	            <table class="table fs-csntb fs-csotb">
	                <thead>
	                    <tr>
	                        <th>THÁNG 1</th>
	                        <th>THÁNG 2-12</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do nhà sản xuất</td>
	                    </tr>
	                    <tr>
	                        <td>Miễn phí đổi sản phẩm tương đương: cùng model, cùng dung lượng, cùng thời gian bảo hành…</br>
							Trường hợp không có sản phẩm tương đương, FPT Shop hoàn lại tiền 100%
							</td>
	                        <td>FPT Shop gửi máy đi bảo hành theo chính sách của hãng hoặc bảo hành của FPTShop.com.vn
							</td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm không lỗi</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2"><p>Không áp dụng đổi trả</p></td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do người sử dụng</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2"><strong>Không áp dụng đổi trả</strong> với sản phẩm:</br>
							- Máy không còn giữ nguyên 100% hình dạng ban đầu, bao gồm: có dấu hiệu va chạm mạnh, cấn móp, bị vào nước...</br>
							- Không đủ điều kiện bảo hành theo chính sách của hãng.</br>
							Trong trường hợp này, FPT Shop hỗ trợ chuyển TTBH và khách hàng chịu phí sửa chữa.
							</td>
	                    </tr>
	                </tbody>
	            </table>
				 <p><strong>Phí đổi trả khác nếu có: </strong>FPTShop sẽ kiểm tra tình trạng máy và thông báo đến khách hàng về mức phí phải thu ngay tại cửa hàng</p>           
	        </div>
			<div class="fs-csold">
	            <h2 class="fs-csn-title">III.	 CHÍNH SÁCH ĐỔI TRẢ ĐỒNG HỒ THỜI TRANG, VÒNG ĐEO TAY THÔNG MINH</h2>
	            <table class="table fs-csntb fs-csotb">
	                <thead>
	                    <tr>
	                        <th>THÁNG 1</th>
	                        <th>TỪ THÁNG THỨ 2 ĐẾN THỜI HẠN BẢO HÀNH</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do NSX (Bao gồm các lỗi kĩ thuật liên quan đến bộ máy, không bao gồm pin)</td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <p>Miễn phí 1 đổi 1 sản phẩm cùng model</br>
								<strong>Hoặc</strong>
								- KH được đổi sang sản phẩm khác model bằng hoặc cao tiền hơn, thanh toán thêm phần chênh lệch, và phí đổi trả tính như sau:</br>
								+ Nếu sản phẩm KH đã mua hết hàng (trên toàn hệ thống): Không mất phí đổi trả</br>
								+ Nếu sản phẩm KH đã mua còn hàng: FPTShop sẽ kiểm tra tình trạng máy và thông báo đến Khách hàng về giá trị thu lại sản phẩm ngay tại cửa hàng.
								</p>
	                        </td>
	                        <td>
	                            <p>Gửi bảo hành theo chính sách hãng</br>
								- Trường hợp không sửa chữa được hoặc bảo hành trễ hẹn so với cam kết (tối đa 30 ngày): KH được đổi sản phẩm mới, thanh toán thêm phần chênh lệch. Sản phẩm cũ được FPTShop sẽ kiểm tra tình trạng máy và thông báo đến Khách hàng về giá trị thu lại sản phẩm ngay tại cửa hàng.
								</p>
	                        </td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm không lỗi</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2"><p>Không áp dụng đổi trả</p></td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do người sử dụng</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2">FPTShop hỗ trợ chuyển TTBH hãng sửa chữa (có tính phí).</td>
	                    </tr>
	                </tbody>
	            </table>
	            <p><strong>Lưu ý:</strong></p>
	            <ul class="fs-cs-kmul">
				<li><span>-</span>Đồng hồ thời trang chỉ được hưởng chính sách bảo hành, đổi trả khi còn phiếu bảo hành</li>
	            <li><span>-</span><strong>Phí đổi trả khác nếu có:</strong> FPTShop sẽ kiểm tra tình trạng máy và thông báo đến khách hàng về mức phí phải thu ngay tại cửa hàng</li>
				<li><span>-</span>Đối với vòng đeo tay: khi trả hoặc đổi sản phẩm khác, khách hàng phải trả lại sạc, nếu không còn sạc FPTShop chỉ tiếp nhận bảo hành</li>
	            </ul>
				<p><strong>Thời hạn bảo hành đồng hồ thời trang</strong></p>
				<table class="dhdt">
					<tbody>
						<tr>
							<td width="408"><p><strong>H&atilde;ng</strong></p>
							<td width="111"><p><strong>Bảo h&agrave;nh m&aacute;y</strong></p></td>
							<td width="115"><p><strong>Bảo h&agrave;nh pin</strong></p></td>
						</tr>
						<tr>
							<td width="408"><p>Bulova</p></td>
							<td width="111"><p>36 th&aacute;ng</p></td>
							<td width="115"><p><strong>Trọn đời</strong></p></td>
						</tr>
						<tr>
							<td width="408"><p>Ferrari, Tommy Hilfiger, Lascote, Daniel Klein. Free look, Festina, Candino</p></td>
							<td width="111"><p>24 th&aacute;ng</p></td>
							<td width="115"><p><strong>Trọn đời</strong></p></td></tr>
						<tr>
							<td width="408"><p><br/> Kitten-Kid, Nakzen, Rossini, SKmei, Sinobi, SK, Elle</p></td>
							<td width="111"><p>12 th&aacute;ng</p></td>
							<td width="115"><p><strong>Trọn đời</strong></p></td>
						</tr>
						<tr>
							<td width="408"><p>Casio G-shock, Casio Baby-G, Casio Cover</p></td>
							<td width="111"><p>60 th&aacute;ng</p></td>
							<td width="115"><p>60 th&aacute;ng</p></td>
						</tr>
						<tr>
							<td width="408"><p>Casio Genaral, Casico Edifice</p></td>
							<td width="111"><p>12 th&aacute;ng</p></td>
							<td width="115"><p>18 th&aacute;ng</p></td>
						</tr>
						<tr>
							<td width="408"><p>Citizen</p></td>
							<td width="111"><p>12 th&aacute;ng</p></td>
							<td width="115"><p>12 th&aacute;ng</p></td>
						</tr>
						<tr>
							<td width="408"><p>Orient</p></td>
							<td width="111"><p>12 th&aacute;ng</p></td>
							<td width="115"><p>Kh&ocirc;ng bảo h&agrave;nh</p></td>
						</tr>
					</tbody>
				</table>
	        </div>
	        <div class="fs-csold">
	            <h2 class="fs-csn-title">IV.	CHÍNH SÁCH ĐỔI TRẢ MÁY IN</h2>
	            <table class="table fs-csntb fs-csotb">
	                <thead>
	                    <tr>
	                        <th>THÁNG 1</th>
	                        <th>TỪ THÁNG THỨ 2 ĐẾN THỜI HẠN BẢO HÀNH</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do NSX</td>
	                    </tr>
	                    <tr>
	                        <td>
	                            <p>1 đổi 1 sản phẩm cùng mã (Chỉ đổi máy, không đổi hộp mực)</p>
	                        </td>
	                        <td>
	                            <p>Gửi bảo hành theo chính sách hãng</p>
	                        </td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm không lỗi</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2"><p>Không áp dụng đổi trả</p></td>
	                    </tr>
	                    <tr class="fs-ctr">
	                        <td colspan="2">Sản phẩm lỗi do người sử dụng</td>
	                    </tr>
	                    <tr class="fs-ctr2">
	                        <td colspan="2">Không áp dụng đổi trả, bảo hành, FPT Shop hỗ trợ chuyển TTBH Hãng sửa chữa (có tính phí), bao gồm:</br>
							+ Vỡ, nứt thân máy, trầy xước, gãy chốt hộp mực, khách hàng tự mở máy đế sửa chữa</br>
							+ Máy không dư nguyên 100% hình dạng ban đầu</td>
	                    </tr>
	                </tbody>
	            </table>
	            <p><strong>Lưu ý:</strong></p>
	            <ul class="fs-cs-kmul">
				<li><span>•</span>Khi đổi máy in, KH phải trả cả vỏ hộp. Nếu thiếu vở hộp, chỉ áp dụng bảo hành, không đổi máy mới. </li>
	            <li><span>•</span><strong>Phí đổi trả khác nếu có: </strong> FPTShop sẽ kiểm tra tình trạng máy và thông báo đến khách hàng về mức phí phải thu ngay tại cửa hàng</li>
	            </ul>
	        </div>
			<div class="fs-csold">
	            <h2 class="fs-csn-title">V. CHÍNH SÁCH BẢO HÀNH PHỤ KIỆN</h2>
	            <ul class="fs-cspk-nav clearfix">
	                <li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">BẢO HÀNH 1 NĂM 1 ĐỔI 1</h2>
	                        <p style="font-size: 13px;">
							Thẻ nhớ, USB, Chuột, Cáp, Sạc, Sạc dự phòng, Bàn phím, Đế tản nhiệt, Tai nghe (trừ Tai nghe JBL giá dưới 2.5 triệu), Thiết bị mạng, Ổ cứng, Loa (trừ Loa Harman Kardon), Loa Kéo-Karaoke, Loa JBL (trừ Loa JBL Studio BAR mã 00441172) Bộ phát wifi không dây, Đèn LED để bàn đa năng, Cân điện tử.
	                        </p>
	                    </div>
	
	                </li>
					
					<li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">BẢO HÀNH 1 NĂM CHÍNH HÃNG</h2>
	                        <p>
	Phụ kiện nhập khẩu chính hãng Apple, Loa JBL Studio BAR (mã 00441172) và loa Harman Kardon                        </p>
	                    </div>
	                </li>
	
	                            	
					<li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">BẢO HÀNH 6 THÁNG 1 ĐỔI 1</h2>
	                        <p>
	Mic hát karaoke, Quạt cầm tay, Tai nghe JBL giá dưới 2.5 triệu                        </p>
	                    </div>
	                </li>
					
					<li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">BẢO HÀNH 15 NGÀY 1 ĐỔI 1</h2>
	                        <p>
	                            Bao da, và Ốp lưng có giá từ 50.000 VNĐ (trừ Bao da, Ốp lưng chính hãng Samsung)
	                        </p>
	                    </div>
	                </li>
					
					 <li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">DÁN LẦN ĐẦU MUA NGUYÊN GIÁ, TỪ LẦN THỨ 2:</h2>
	                        <p>
	Dán lại với giá 25.000VNĐ/mặt: Đối với MDMH lẻ và combo miếng dán 2 mặt (dành cho ĐTDĐ)</br>
	GIÁ GIẢM 30%: Đối với MDMH lẻ và combo miếng dán 2 mặt (dành cho MTB, MTXT), MDMH Kính cường lực                   </p>
	                    </div>
	                </li>
	
	                
	                <li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">KHÔNG ÁP DỤNG BẢO HÀNH</h2>
	                        <p>
	                            Ba lô, Túi xách, Túi chống sốc, Túi chống nước, Gậy chụp hình, Tay cầm chơi game, Bao da và ốp lưng nhập khẩu chính hãng Samsung
	                        </p>
	                    </div>
	
	                </li>
	
	            </ul>
				<p style="margin-bottom: 15px;"><strong>Lưu ý:</strong></p>
				<p style="margin-bottom: 15px;"><strong>MDMH:</strong> không giới hạn số lần dán, KHÔNG giới hạn số tháng áp dụng. Chỉ cần đúng imei máy đã sử dụng miếng dán ở lần mua đầu tiên.</p>
				<p style="margin-bottom: 15px;"><strong>Quạt cầm tay, Tai nghe JBL, Loa JBL:</strong> không bảo hành phụ kiện kèm theo.
	</p> 
				
	            <p><strong>Điều kiện bảo hành:</strong></p>
	            <ul class="fs-cs-kmul">
				<li><span>•</span> <p>Sản phẩm bảo hành bị lỗi kỹ thuật (không bao gồm lỗi thẩm mỹ, lỗi do người sử dụng)</p></li>
				<li><span>•</span> <p>Đối với phụ kiện ốp lưng, bao da mua kèm máy (Điện thoại di động/ Máy tính bảng): FPT Shop hỗ trợ nhập trả lại phụ kiện trong trường hợp khách hàng trả hàng do lỗi NSX.</p></li>
				<li><span>•</span> <p>Miếng dán màn hình mua kèm máy: trong trường hợp khách hàng đổi máy do lỗi NSX, FPT Shop đổi miếng dán mới cho Khách hàng.</p></li>
				<li><span>•</span> <p>Combo phụ kiện: FPT Shop bảo hành cho sản phẩm bị lỗi theo chính sách phụ kiện mua lẻ</p></li>
				<li><span>•</span> <p>Sản phẩm có thời gian bảo hành dài hơn 12 tháng theo chính sách của nhà sản xuất, kể từ tháng 13 khách hàng bảo hành sản phẩm trực tiếp tại trung tâm bảo hành Hãng</p></li>
				<li><span>•</span> <p>
				Đối với PK chính hãng Apple: Khách hàng mang sản phẩm đến tất cả các cửa hàng FPTShop/F.Studio by FPT trên toàn quốc để được hỗ trợ chuyển tới Trung tâm bảo hành uỷ quyền của Apple. Việc xác định tình trạng lỗi có thuộc diện bảo hành hay không sẽ do Apple quyết định.
				</p></li> 
	            </ul>
	        </div>
	        <div class="fs-csdt">
	            <h2 class="fs-csn-title">VI. CHÍNH SÁCH ĐỔI TRẢ DỊCH VỤ</h2>
	            <ul class="fs-cspk-nav fs-csdt-nav clearfix">
	                <li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">ĐẦU THU KỸ THUẬT SỐ FPT PLAYBOX</h2>
	                        <p>
	                            <strong>30 ngày đầu tiên:</strong> Miễn phí 1 đổi 1 khi sản phẩm lỗi NSX.
	 
	                        </p>
	                        <p>
	                            <strong>Tháng thứ 2-12:</strong>  FPT Shop hỗ trợ chuyển trung tâm bảo hành NSX.
	                        </p>
	                    </div>
	
	                </li>
	                <li>
	                    <div class="fs-cspk-nifo">
	                        <h2 class="fs-cspk-ntit">Phần mềm dịch vụ</h2>
	                        <span>(không bao gồm các phần mềm Microsoft)</span>
	                        <p>
	                            FPT Shop hoàn lại tiền 100% trong 31 ngày đầu nếu khách hàng không còn nhu cầu sử dụng sản phẩm.
	                        </p>
	                    </div>
	                </li>
	            </ul>
	            <p><strong>Phí đổi trả nếu có:</strong></p>
	            <ul class="fs-cs-kmul">
	                <li><span>•</span> Mất vỏ hộp thu phí 2% giá trên hóa đơn</li>
	                <li><span>•</span> Mất phụ kiện đi kèm thu phí 5% trên giá hoá đơn  cho mỗi phụ kiện mất.</li>
	            </ul>
	        </div>
	    </div>
	</div>
	
	        <p><strong>&nbsp;</strong></p>
	        <p><strong><u>Đối với giao dịch của FPTshop.com.vn</u></strong></p>
	        <p>FPTshop.com.vn tiếp nhận khiếu nại qua c&aacute;c h&igrave;nh thức sau:</p>
	        <p>- Tại website li&ecirc;n hệ, b&igrave;nh luận kh&aacute;ch h&agrave;ng</p>
	        <p>- Qua tổng đ&agrave;i giải quyết khiếu nại: 1800 6616</p>
	        <p>- Email: fptshop@fpt.com.vn</p>
	        <p>- Trực tiếp tại c&aacute;c cửa h&agrave;ng FPTShop</p>
	        <p>- Tại văn ph&ograve;ng c&ocirc;ng ty: Lầu 3, 261 Kh&aacute;nh Hội, P2, Q4, TP. Hồ Ch&iacute; Minh</p>
	
	        <p><strong>IV. Quy tr&igrave;nh thanh to&aacute;n</strong></p>
	        <p>Người mua v&agrave; b&ecirc;n b&aacute;n c&oacute; thể tham khảo c&aacute;c phương thức thanh to&aacute;n sau đ&acirc;y v&agrave; lựa chọn &aacute;p dụng phương thức ph&ugrave; hợp:</p>
	        <p><strong><u>C&aacute;ch 1:&nbsp;Thanh to&aacute;n trực tiếp (người mua nhận h&agrave;ng tại địa chỉ b&ecirc;n b&aacute;n):</u></strong></p>
	        <p>- Bước 1: Người mua t&igrave;m hiểu th&ocirc;ng tin về sản phẩm, dịch vụ được đăng tin.</p>
	        <p>- Bước 2: Người mua đến địa chỉ b&aacute;n h&agrave;ng l&agrave; c&aacute;c cửa h&agrave;ng FPTShop</p>
	        <p>- Bước 3: Người mua thanh to&aacute;n bằng tiền mặt, thẻ ATM nội địa hoặc thẻ t&iacute;n dụng v&agrave; nhận h&agrave;ng.</p>
	        <p><strong>C&aacute;ch 2:&nbsp;Thanh to&aacute;n sau (COD &ndash; giao h&agrave;ng v&agrave; thu tiền tận nơi):</strong></p>
	        <p>- Bước 1: Người mua t&igrave;m hiểu th&ocirc;ng tin về sản phẩm, dịch vụ được đăng tin.</p>
	        <p>- Bước 2: Người mua x&aacute;c thực đơn h&agrave;ng (điện thoại, tin nhắn, email).</p>
	        <p>- Bước 3: Người b&aacute;n x&aacute;c nhận th&ocirc;ng tin Người mua.</p>
	        <p>- Bước 4: Người b&aacute;n chuyển h&agrave;ng.</p>
	        <p>- Bước 5: Người mua nhận h&agrave;ng v&agrave; thanh to&aacute;n bằng tiền mặt, thẻ ATM nội địa hoặc thẻ t&iacute;n dụng.</p>
	        <p><strong>C&aacute;ch 3:&nbsp;Thanh to&aacute;n online qua thẻ t&iacute;n dụng, chuyển khoản:</strong></p>
	        <p>- Bước 1: Người mua t&igrave;m hiểu th&ocirc;ng tin về sản phẩm, dịch vụ được đăng tin.</p>
	        <p>- Bước 2: Người mua x&aacute;c thực đơn h&agrave;ng (điện thoại, tin nhắn, email).</p>
	        <p>- Bước 3: Người b&aacute;n x&aacute;c nhận th&ocirc;ng tin Người mua.</p>
	        <p>- Bước 4: Người mua thanh to&aacute;n.</p>
	        <p>- Bước 5: Người b&aacute;n chuyển h&agrave;ng.</p>
	        <p>- Bước 6: Người mua nhận h&agrave;ng.</p>
	        <p><strong>V. Đảm bảo an to&agrave;n giao dịch</strong></p>
	        <p>- Ban quản l&yacute; đ&atilde; sử dụng c&aacute;c dịch vụ để bảo vệ th&ocirc;ng tin về nội dung m&agrave; người b&aacute;n đăng &nbsp;sản phẩm tr&ecirc;n FPTshop.com.vn. Để đảm bảo c&aacute;c giao dịch được tiến h&agrave;nh th&agrave;nh c&ocirc;ng, hạn chế tối đa rủi ro c&oacute; thể ph&aacute;t sinh.</p>
	        <p>- Người mua n&ecirc;n cung cấp th&ocirc;ng tin đầy đủ (t&ecirc;n, địa chỉ, số điện thoại, email) khi tham gia mua h&agrave;ng của FPTshop.com.vn để FPTshop.com.vn c&oacute; thể li&ecirc;n hệ nhanh lại với người mua trong trường hợp xảy ra lỗi.</p>
	        <p>- Trong trường hợp giao dịch nhận h&agrave;ng tại nh&agrave; của người mua, th&igrave; người mua chỉ n&ecirc;n thanh to&aacute;n sau khi đ&atilde; kiểm tra h&agrave;ng ho&aacute; chi tiết v&agrave; h&agrave;i l&ograve;ng với sản phẩm.</p>
	        <p>- Khi thanh to&aacute;n trực tuyến bằng thẻ ATM nội địa, Visa, Master người mua n&ecirc;n tự m&igrave;nh thực hiện v&agrave; kh&ocirc;ng được để lộ th&ocirc;ng tin thẻ. FPTshop.com.vn kh&ocirc;ng lưu trữ th&ocirc;ng tin thẻ của người mua sau khi thanh to&aacute;n, m&agrave; th&ocirc;ng qua hệ thống của ng&acirc;n h&agrave;ng li&ecirc;n kết. N&ecirc;n tuyệt đối bảo mật th&ocirc;ng tin thẻ cho kh&aacute;ch h&agrave;ng.</p>
	        <p>- Trong trường lỗi xảy ra trong qu&aacute; tr&igrave;nh thanh to&aacute;n trực tuyến, C&ocirc;ng ty b&aacute;n lẻ kỹ thuật số FPT sẽ l&agrave; đơn vị giải quyết cho kh&aacute;ch h&agrave;ng trong v&ograve;ng 1 giờ l&agrave;m việc từ khi tiếp nhận th&ocirc;ng tin từ người thực hiện giao dịch.</p>
	        <p><strong>VI. Bảo vệ th&ocirc;ng tin c&aacute; nh&acirc;n kh&aacute;ch h&agrave;ng</strong></p>
	        <p>FPTshop.com.vn cam kết sẽ bảo mật những th&ocirc;ng tin mang t&iacute;nh ri&ecirc;ng tư của bạn. Bạn vui l&ograve;ng đọc bản &ldquo;Ch&iacute;nh s&aacute;ch bảo mật&rdquo; dưới đ&acirc;y để hiểu hơn những cam kết m&agrave; ch&uacute;ng t&ocirc;i thực hiện, nhằm t&ocirc;n trọng v&agrave; bảo vệ quyền lợi của người truy cập:</p>
	        <p><strong>1. Mục đ&iacute;ch v&agrave; phạm vi thu thập</strong></p>
	        <p>- Để truy cập v&agrave; sử dụng một số dịch vụ tại FPTshop.com.vn, bạn c&oacute; thể sẽ được y&ecirc;u cầu đăng k&yacute; với ch&uacute;ng t&ocirc;i th&ocirc;ng tin c&aacute; nh&acirc;n (Email, Họ t&ecirc;n, Số ĐT li&ecirc;n lạc&hellip;). Mọi th&ocirc;ng tin khai b&aacute;o phải đảm bảo t&iacute;nh ch&iacute;nh x&aacute;c v&agrave; hợp ph&aacute;p. FPTshop.com.vn kh&ocirc;ng chịu mọi tr&aacute;ch nhiệm li&ecirc;n quan đến ph&aacute;p luật của th&ocirc;ng tin khai b&aacute;o.&nbsp;</p>
	        <p>- Ch&uacute;ng t&ocirc;i cũng c&oacute; thể thu thập th&ocirc;ng tin về số lần viếng thăm, bao gồm số trang bạn xem, số links (li&ecirc;n kết) bạn click v&agrave; những th&ocirc;ng tin kh&aacute;c li&ecirc;n quan đến việc kết nối đến site Fptshop.com.vn. Ch&uacute;ng t&ocirc;i cũng thu thập c&aacute;c th&ocirc;ng tin m&agrave; tr&igrave;nh duyệt Web (Browser) bạn sử dụng mỗi khi truy cập v&agrave;o FPTshop.com.vn, bao gồm: địa chỉ IP, loại Browser, ng&ocirc;n ngữ sử dụng, thời gian v&agrave; những địa chỉ m&agrave; Browser truy xuất đến.</p>
	        <p><strong>2 Phạm vi sử dụng th&ocirc;ng tin</strong></p>
	        <p>- FPTshop.com.vn thu thập và sử dụng thông tin cá nhân bạn với mục đích phù hợp và hoàn toàn tuân thủ nội dung của “Chính sách bảo mật” này. Khi cần thiết, chúng tôi có thể sử dụng những thông tin này để liên hệ trực tiếp với bạn dưới các hình thức như: gởi thư ngỏ, đơn đặt hàng, thư cảm ơn, sms, thông tin về kỹ thuật và bảo mật…
	</br>- Bằng việc bấm vào nút "Đặt mua trả góp", Khách hàng đồng ý cho Home Credit được thu thập, sử dụng cũng như chia sẻ cho bên thứ ba các  thông tin liên quan đến khách hàng và/hoặc thông tin liên quan đến (các) khoản vay của khách hàng tại Home Credit hoặc các tổ chức khác.</p>
	        <p><strong>3. Thời gian lưu trữ th&ocirc;ng tin</strong></p>
	        <p>Dữ liệu c&aacute; nh&acirc;n của Th&agrave;nh vi&ecirc;n sẽ được lưu trữ cho đến khi c&oacute; y&ecirc;u cầu hủy bỏ hoặc tự th&agrave;nh vi&ecirc;n đăng nhập v&agrave; thực hiện hủy bỏ. C&ograve;n lại trong mọi trường hợp th&ocirc;ng tin c&aacute; nh&acirc;n th&agrave;nh vi&ecirc;n sẽ được bảo mật tr&ecirc;n m&aacute;y chủ của FPTshop.com.vn.</p>
	        <p><strong>4. Địa chỉ của đơn vị thu thập v&agrave; quản l&yacute; th&ocirc;ng tin c&aacute; nh&acirc;n</strong></p>
	        <p>C&ocirc;ng ty Cổ phần b&aacute;n lẻ kỹ thuật FPT</p>
	        <p>- Địa chỉ đăng k&yacute; kinh doanh: 261 &ndash; 263 Kh&aacute;nh Hội, P2, Q4, TP. Hồ Ch&iacute; Minh</p>
	        <p>- Văn ph&ograve;ng: Lầu 3, 261 &ndash; 263 Kh&aacute;nh Hội, P2, Q4, TP. Hồ Ch&iacute; Minh</p>
	        <p>- Điện thoại văn ph&ograve;ng: 028 730 23456</p>
	        <p><strong>5. Phương tiện v&agrave; c&ocirc;ng cụ để người d&ugrave;ng tiếp cận v&agrave; chỉnh sửa dữ liệu c&aacute; nh&acirc;n</strong></p>
	        <p>Hiện website chưa triển khai trang quản l&yacute; th&ocirc;ng tin c&aacute; nh&acirc;n của th&agrave;nh vi&ecirc;n, v&igrave; thế việc tiếp cận v&agrave; chỉnh sửa dữ liệu c&aacute; nh&acirc;n dựa v&agrave;o y&ecirc;u cầu của kh&aacute;ch h&agrave;ng bằng c&aacute;ch h&igrave;nh thức sau:</p>
	        <p>- Gọi điện thoại đến tổng đ&agrave;i chăm s&oacute;c kh&aacute;ch h&agrave;ng 1800 6616, bằng nghiệp vụ chuy&ecirc;n m&ocirc;n x&aacute;c định th&ocirc;ng tin c&aacute; nh&acirc;n v&agrave; nh&acirc;n vi&ecirc;n tổng đ&agrave;i sẽ hỗ trợ chỉnh sửa thay người d&ugrave;ng</p>
	        <p>- Để lại b&igrave;nh luận hoặc gửi g&oacute;p &yacute; trực tiếp từ website&nbsp;<a href="http://www.fptshop.com.vn">www.fptshop.com.vn</a>, quản trị vi&ecirc;n kiểm tra th&ocirc;ng tin v&agrave; li&ecirc;n lạc lại với người d&ugrave;ng để x&aacute;c nhận th&ocirc;ng tin 1 lần nữa v&agrave; quản trị vi&ecirc;n chỉnh sửa th&ocirc;ng tin cho người d&ugrave;ng.</p>
	        <p><strong>6. Cam kết bảo mật th&ocirc;ng tin c&aacute; nh&acirc;n kh&aacute;ch h&agrave;ng</strong></p>
	        <p>- Th&ocirc;ng tin c&aacute; nh&acirc;n của th&agrave;nh vi&ecirc;n tr&ecirc;n FPTshop.com.vn được FPTshop.com.vn cam kết bảo mật tuyệt đối theo ch&iacute;nh s&aacute;ch bảo vệ th&ocirc;ng tin c&aacute; nh&acirc;n của FPTshop.com.vn. Việc thu thập v&agrave; sử dụng th&ocirc;ng tin của mỗi th&agrave;nh vi&ecirc;n chỉ được thực hiện khi c&oacute; sự đồng &yacute; của kh&aacute;ch h&agrave;ng đ&oacute; trừ những trường hợp ph&aacute;p luật c&oacute; quy định kh&aacute;c.</p>
	        <p>- Kh&ocirc;ng sử dụng, kh&ocirc;ng chuyển giao, cung cấp hay tiết lộ cho b&ecirc;n thứ 3 n&agrave;o về th&ocirc;ng tin c&aacute; nh&acirc;n của th&agrave;nh vi&ecirc;n khi kh&ocirc;ng c&oacute; sự cho ph&eacute;p đồng &yacute; từ th&agrave;nh vi&ecirc;n.</p>
	        <p>- Trong trường hợp m&aacute;y chủ lưu trữ th&ocirc;ng tin bị hacker tấn c&ocirc;ng dẫn đến mất m&aacute;t dữ liệu c&aacute; nh&acirc;n th&agrave;nh vi&ecirc;n, FPTshop.com.vn sẽ c&oacute; tr&aacute;ch nhiệm th&ocirc;ng b&aacute;o vụ việc cho cơ quan chức năng điều tra xử l&yacute; kịp thời v&agrave; th&ocirc;ng b&aacute;o cho th&agrave;nh vi&ecirc;n được biết.</p>
	        <p>- Bảo mật tuyệt đối mọi th&ocirc;ng tin giao dịch trực tuyến của Th&agrave;nh vi&ecirc;n bao gồm th&ocirc;ng tin h&oacute;a đơn kế to&aacute;n chứng từ số h&oacute;a tại khu vực dữ liệu trung t&acirc;m an to&agrave;n cấp 1 của Fptshop.com.vn.</p>
	        <p>- Ban quản l&yacute; Fptshop.com.vn y&ecirc;u cầu c&aacute;c c&aacute; nh&acirc;n khi đăng k&yacute;/mua h&agrave;ng l&agrave; th&agrave;nh vi&ecirc;n, phải cung cấp đầy đủ th&ocirc;ng tin c&aacute; nh&acirc;n c&oacute; li&ecirc;n quan như: Họ v&agrave; t&ecirc;n, địa chỉ li&ecirc;n lạc, email, số chứng minh nh&acirc;n d&acirc;n, điện thoại, số t&agrave;i khoản, số thẻ thanh to&aacute;n &hellip;., v&agrave; chịu tr&aacute;ch nhiệm về t&iacute;nh ph&aacute;p l&yacute; của những th&ocirc;ng tin tr&ecirc;n. Ban quản l&yacute; Fptshop.com.vn kh&ocirc;ng chịu tr&aacute;ch nhiệm cũng như kh&ocirc;ng giải quyết mọi khiếu nại c&oacute; li&ecirc;n quan đến quyền lợi của Th&agrave;nh vi&ecirc;n đ&oacute; nếu x&eacute;t thấy tất cả th&ocirc;ng tin c&aacute; nh&acirc;n của th&agrave;nh vi&ecirc;n đ&oacute; cung cấp khi đăng k&yacute; ban đầu l&agrave; kh&ocirc;ng ch&iacute;nh x&aacute;c</p>
	        <p><strong>VII.&nbsp;Quản l&yacute; th&ocirc;ng tin xấu</strong></p>
	        <p><strong>Quy định th&agrave;nh vi&ecirc;n</strong></p>
	        <p>- Th&agrave;nh vi&ecirc;n sẽ tự chịu tr&aacute;ch nhiệm về bảo mật v&agrave; lưu giữ mọi hoạt động sử dụng dịch vụ dưới t&ecirc;n đăng k&yacute;, mật khẩu của m&igrave;nh. Th&agrave;nh vi&ecirc;n c&oacute; tr&aacute;ch nhiệm th&ocirc;ng b&aacute;o kịp thời cho website TMĐT FPTshop.com.vn về những h&agrave;nh vi sử dụng tr&aacute;i ph&eacute;p, lạm dụng, vi phạm bảo mật, lưu giữ t&ecirc;n đăng k&yacute; v&agrave; mật khẩu của b&ecirc;n thứ ba để c&oacute; biện ph&aacute;p giải quyết ph&ugrave; hợp.</p>
	        <p>- Th&agrave;nh vi&ecirc;n kh&ocirc;ng được thay đổi, chỉnh sửa, g&aacute;n g&eacute;p, copy, truyền b&aacute;, ph&acirc;n phối, cung cấp v&agrave; tạo những c&ocirc;ng cụ tương tự của dịch vụ do website TMĐT FPTshop.com.vn cung cấp cho một b&ecirc;n thứ ba nếu kh&ocirc;ng được sự đồng &yacute; của website TMĐT FPTshop.com.vn trong bản Quy chế n&agrave;y.</p>
	        <p>- Th&agrave;nh vi&ecirc;n kh&ocirc;ng được h&agrave;nh động g&acirc;y mất uy t&iacute;n của&nbsp;website&nbsp;MTĐT FPTshop.com.vn dưới mọi h&igrave;nh thức như g&acirc;y mất đo&agrave;n kết giữa c&aacute;c th&agrave;nh vi&ecirc;n bằng c&aacute;ch sử dụng t&ecirc;n đăng k&yacute; thứ hai, th&ocirc;ng qua một b&ecirc;n thứ ba hoặc tuy&ecirc;n truyền, phổ biến những th&ocirc;ng tin kh&ocirc;ng c&oacute; lợi cho uy t&iacute;n của&nbsp;website&nbsp;TMĐT FPTshop.com.vn.</p>
	        <p><strong>VIII. Tr&aacute;ch nhiệm trong trường hợp ph&aacute;t sinh lỗi kỹ thuật</strong></p>
	        <p>- Website&nbsp;TMĐT FPTshop.com.vn cam kết nỗ lực đảm bảo sự an to&agrave;n v&agrave; ổn định của to&agrave;n bộ hệ thống kỹ thuật. Tuy nhi&ecirc;n, trong trường hợp xảy ra sự cố do lỗi của&nbsp;FPTshop.com.vn, FPTshop.com.vn sẽ ngay lập tức &aacute;p dụng c&aacute;c biện ph&aacute;p để đảm bảo quyền lợi cho người mua h&agrave;ng.</p>
	        <p>- Khi thực hiện c&aacute;c giao dịch tr&ecirc;n website, bắt buộc c&aacute;c th&agrave;nh vi&ecirc;n phải thực hiện đ&uacute;ng theo c&aacute;c quy tr&igrave;nh hướng dẫn.</p>
	        <p>- Ban quản l&yacute;&nbsp;website&nbsp;TMĐT FPTshop.com.vn cam kết cung cấp chất lượng dịch vụ tốt nhất cho c&aacute;c th&agrave;nh vi&ecirc;n tham gia giao dịch. Trường hợp ph&aacute;t sinh lỗi kỹ thuật, lỗi phần mềm hoặc c&aacute;c lỗi kh&aacute;ch quan kh&aacute;c dẫn đến th&agrave;nh vi&ecirc;n kh&ocirc;ng thể tham gia giao dịch được th&igrave; c&aacute;c th&agrave;nh vi&ecirc;n th&ocirc;ng b&aacute;o cho Ban quản l&yacute;&nbsp;website&nbsp;TMĐT qua địa chỉ email fptshop@fpt.com.vn hoặc qua điện thoại 1800 6616 (từ 8:00 &ndash; 22:00 hằng ng&agrave;y) ch&uacute;ng t&ocirc;i sẽ khắc phục lỗi trong thời gian sớm nhất, tạo điều kiện cho c&aacute;c th&agrave;nh vi&ecirc;n tham gia&nbsp;website&nbsp;TMĐT FPTshop.com.vn.</p>
	        <p>- Tuy nhi&ecirc;n, Ban quản l&yacute;&nbsp;website&nbsp;TMĐT FPTshop.com.vn sẽ kh&ocirc;ng chịu tr&aacute;ch nhiệm giải quyết trong trường hợp th&ocirc;ng b&aacute;o của c&aacute;c th&agrave;nh vi&ecirc;n kh&ocirc;ng đến được Ban quản l&yacute;, ph&aacute;t sinh từ lỗi kỹ thuật, lỗi đường truyền, phần mềm hoặc c&aacute;c lỗi kh&aacute;c kh&ocirc;ng do Ban quản l&yacute; g&acirc;y ra.</p>
	        <p><strong>IX. Quyền v&agrave; nghĩa vụ của Ban quản l&yacute; website TMĐT FPTshop.com.vn</strong></p>
	        <p><strong>1. Quyền của Ban quản l&yacute; FPTshop.com.vn:</strong></p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn sẽ tiến h&agrave;nh cung cấp c&aacute;c dịch vụ, sản phẩm cho kh&aacute;ch h&agrave;ng sau khi đ&atilde; ho&agrave;n th&agrave;nh c&aacute;c thủ tục v&agrave; c&aacute;c điều kiện bắt buộc m&agrave;&nbsp;n&ecirc;u ra.&nbsp;</p>
	        <p>- FPTshop.com.vn sẽ tiến h&agrave;nh x&acirc;y dựng c&aacute;c ch&iacute;nh s&aacute;ch dịch vụ tr&ecirc;n Trang web. C&aacute;c ch&iacute;nh s&aacute;ch n&agrave;y sẽ được c&ocirc;ng bố tr&ecirc;n&nbsp;FPTshop.com.vn.&nbsp;</p>
	        <p>- Trong trường hợp c&oacute; cơ sở để chứng minh th&agrave;nh vi&ecirc;n cung cấp th&ocirc;ng tin cho S&agrave;n giao dịch điện tử FPTshop.com.vn kh&ocirc;ng ch&iacute;nh x&aacute;c, sai lệch, kh&ocirc;ng đầy đủ hoặc c&oacute; dấu hiệu vi phạm ph&aacute;p luật hay thuần phong mỹ tục Việt Nam th&igrave; S&agrave;n giao dịch điện tử FPTshop.com.vn c&oacute; quyền từ chối, tạm ngừng hoặc chấm dứt quyền sử dụng dịch vụ của th&agrave;nh vi&ecirc;n.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;c&oacute; thể chấm dứt quyền th&agrave;nh vi&ecirc;n v&agrave; quyền sử dụng một hoặc tất cả c&aacute;c dịch vụ của th&agrave;nh vi&ecirc;n trong trường hợp th&agrave;nh vi&ecirc;n vi phạm c&aacute;c Quy chế của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn, hoặc c&oacute; những h&agrave;nh vi ảnh hưởng đến hoạt động kinh doanh tr&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;c&oacute; thể chấm dứt ngay quyền sử dụng dịch vụ v&agrave; quyền th&agrave;nh vi&ecirc;n của th&agrave;nh vi&ecirc;n nếu&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;ph&aacute;t hiện th&agrave;nh vi&ecirc;n đ&atilde; ph&aacute; sản, bị kết &aacute;n hoặc đang trong thời gian thụ &aacute;n, trong trường hợp th&agrave;nh vi&ecirc;n tiếp tục hoạt động c&oacute; thể g&acirc;y cho&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;tr&aacute;ch nhiệm ph&aacute;p l&yacute;, c&oacute; những hoạt động lừa đảo, giả mạo, g&acirc;y rối loạn thị trường, g&acirc;y mất đo&agrave;n kết đối với c&aacute;c th&agrave;nh vi&ecirc;n kh&aacute;c của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn, hoạt &nbsp;động vi phạm ph&aacute;p luật hiện h&agrave;nh của Việt Nam.&nbsp;</p>
	        <p>- Trong trường hợp chấm dứt quyền th&agrave;nh vi&ecirc;n v&agrave; quyền sử dụng dịch vụ th&igrave; tất cả c&aacute;c chứng nhận, c&aacute;c quyền của th&agrave;nh vi&ecirc;n được cấp sẽ mặc nhi&ecirc;n hết gi&aacute; trị v&agrave; bị chấm dứt.</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;giữ bản quyền sử dụng dịch vụ v&agrave; c&aacute;c nội dung tr&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;theo c&aacute;c quy định ph&aacute;p luật về bảo hộ sở hữu tr&iacute; tuệ tại Việt Nam. Tất cả c&aacute;c biểu tượng, nội dung theo c&aacute;c ng&ocirc;n ngữ kh&aacute;c nhau đều thuộc quyền sở hữu của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn. Nghi&ecirc;m cấm mọi h&agrave;nh vi sao ch&eacute;p, sử dụng v&agrave; phổ biến bất hợp ph&aacute;p c&aacute;c quyền sở hữu tr&ecirc;n.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;giữ quyền được thay đổi bảng, biểu gi&aacute; dịch vụ v&agrave; phương thức thanh to&aacute;n trong thời gian cung cấp dịch vụ cho th&agrave;nh vi&ecirc;n theo nhu cầu v&agrave; điều kiện khả năng của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;v&agrave; sẽ b&aacute;o trước cho th&agrave;nh vi&ecirc;n thời hạn l&agrave; một (01) th&aacute;ng.</p>
	        <p><strong>2. Nghĩa vụ của Ban quản l&yacute; FPTSHOP.COM.VN</strong></p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;chịu tr&aacute;ch nhiệm x&acirc;y dựng dịch vụ bao gồm một số c&ocirc;ng việc ch&iacute;nh như: nghi&ecirc;n cứu, thiết kế, mua sắm c&aacute;c thiết bị phần cứng v&agrave; phần mềm, kết nối Internet, x&acirc;y dựng ch&iacute;nh s&aacute;ch phục vụ cho hoạt động&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;trong điều kiện v&agrave; phạm vi cho ph&eacute;p.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;sẽ tiến h&agrave;nh triển khai v&agrave; hợp t&aacute;c với c&aacute;c đối t&aacute;c trong việc x&acirc;y dựng hệ thống c&aacute;c dịch vụ, c&aacute;c c&ocirc;ng cụ tiện &iacute;ch phục vụ cho việc giao dịch của c&aacute;c th&agrave;nh vi&ecirc;n tham gia v&agrave; người sử dụng tr&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;chịu tr&aacute;ch nhiệm x&acirc;y dựng, bổ sung hệ thống c&aacute;c kiến thức, th&ocirc;ng tin về: nghiệp vụ ngoại thương, thương mại điện tử, hệ thống văn bản ph&aacute;p luật thương mại trong nước v&agrave; quốc tế, thị trường nước ngo&agrave;i, cũng như c&aacute;c tin tức c&oacute; li&ecirc;n quan đến hoạt động của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;sẽ tiến h&agrave;nh c&aacute;c hoạt động x&uacute;c tiến, quảng b&aacute;&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;ra thị trường nước ngo&agrave;i trong phạm vi v&agrave; điều kiện cho ph&eacute;p, g&oacute;p phần mở rộng, kết nối đ&aacute;p ứng c&aacute;c nhu cầu t&igrave;m kiếm bạn h&agrave;ng v&agrave; ph&aacute;t triển thị trường nước ngo&agrave;i của c&aacute;c th&agrave;nh vi&ecirc;n tham gia&nbsp;Website TMĐT&nbsp;FPTshop.com.vn.&nbsp;</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn&nbsp;sẽ cố gắng đến mức cao nhất trong phạm vi v&agrave; điều kiện c&oacute; thể để duy tr&igrave; hoạt động b&igrave;nh thường của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;v&agrave; khắc phục c&aacute;c sự cố như: sự cố kỹ thuật về m&aacute;y m&oacute;c, lỗi phần mềm, hệ thống đường truyền internet, nh&acirc;n sự, c&aacute;c biến động x&atilde; hội, thi&ecirc;n tai, mất điện, c&aacute;c quyết định của cơ quan nh&agrave; nước hay một tổ chức li&ecirc;n quan thứ ba. Tuy nhi&ecirc;n nếu những sự cố tr&ecirc;n xảy ra nằm ngo&agrave;i khả năng kiểm so&aacute;t, l&agrave; những trường hợp bất khả kh&aacute;ng m&agrave; g&acirc;y thiệt hại cho th&agrave;nh vi&ecirc;n th&igrave;&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;kh&ocirc;ng phải chịu tr&aacute;ch nhiệm li&ecirc;n đới.</p>
	        <p><strong>Website TMĐT FPTshop.com.vn phải c&oacute; tr&aacute;ch nhiệm:</strong></p>
	        <p>- X&acirc;y dựng v&agrave; thực hiện cơ chế để đảm bảo việc đăng th&ocirc;ng tin tr&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;được thực hiện ch&iacute;nh x&aacute;c.&nbsp;</p>
	        <p>- Kh&ocirc;ng đăng tải những th&ocirc;ng tin b&aacute;n h&agrave;ng h&oacute;a, dịch vụ thuộc danh mục h&agrave;ng h&oacute;a, dịch vụ cấm kinh doanh theo quy định của ph&aacute;p luật v&agrave; h&agrave;ng h&oacute;a hạn chế kinh doanh theo quy định tại Th&ocirc;ng tư 47/2014/TT-BCT.</p>
	        <p><strong>X. Quyền v&agrave; tr&aacute;ch nhiệm th&agrave;nh vi&ecirc;n tham gia website TMĐT FPTshop.com.vn</strong></p>
	        <p><strong>1. Quyền của Th&agrave;nh vi&ecirc;n Website TMĐT FPTshop.com.vn</strong></p>
	        <p>- Khi đăng k&yacute; trở th&agrave;nh th&agrave;nh vi&ecirc;n của FPTshop.com.vn v&agrave; được FPTshop.com.vn đồng &yacute;, th&agrave;nh vi&ecirc;n sẽ được tham gia thảo luận, đ&aacute;nh gi&aacute; sản phẩm, mua h&agrave;ng tại FPTshop.com.vn .</p>
	        <p>- Th&agrave;nh vi&ecirc;n c&oacute; quyền đ&oacute;ng g&oacute;p &yacute; kiến cho&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;trong qu&aacute; tr&igrave;nh hoạt động. C&aacute;c kiến nghị được gửi trực tiếp bằng thư, fax hoặc email đến cho&nbsp;Website TMĐT&nbsp;FPTshop.com.vn.</p>
	        <p><strong> Nghĩa vụ của Th&agrave;nh vi&ecirc;n Website TMĐT FPTshop.com.vn</strong></p>
	        <p>- Th&agrave;nh vi&ecirc;n sẽ tự chịu tr&aacute;ch nhiệm về bảo mật v&agrave; lưu giữ v&agrave; mọi hoạt động sử dụng dịch vụ dưới t&ecirc;n đăng k&yacute;, mật khẩu v&agrave; hộp thư điện tử của m&igrave;nh.</p>
	        <p>- Th&agrave;nh vi&ecirc;n cam kết những th&ocirc;ng tin cung cấp cho&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;v&agrave; những th&ocirc;ng tin đang tải l&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;l&agrave; ch&iacute;nh x&aacute;c.</p>
	        <p>- Th&agrave;nh vi&ecirc;n cam kết kh&ocirc;ng được thay đổi, chỉnh sửa, sao ch&eacute;p, truyền b&aacute;, ph&acirc;n phối, cung cấp v&agrave; tạo những c&ocirc;ng cụ tương tự của dịch vụ do&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;cung cấp cho một b&ecirc;n thứ ba nếu kh&ocirc;ng được sự đồng &yacute; của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;trong Quy định n&agrave;y.</p>
	        <p>- Th&agrave;nh vi&ecirc;n kh&ocirc;ng được h&agrave;nh động g&acirc;y mất uy t&iacute;n của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;dưới mọi h&igrave;nh thức như g&acirc;y mất đo&agrave;n kết giữa c&aacute;c th&agrave;nh vi&ecirc;n bằng c&aacute;ch sử dụng t&ecirc;n đăng k&yacute; thứ hai, th&ocirc;ng qua một b&ecirc;n thứ ba hoặc tuy&ecirc;n truyền, phổ biến những th&ocirc;ng tin kh&ocirc;ng c&oacute; lợi cho uy t&iacute;n của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn.</p>
	        <p><strong>XI. Điều khoản &aacute;p dụng</strong></p>
	        <p>- Mọi tranh chấp ph&aacute;t sinh giữa&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;v&agrave; th&agrave;nh vi&ecirc;n sẽ được giải quyết tr&ecirc;n cơ sở thương lượng. Trường hợp kh&ocirc;ng đạt được thỏa thuận như mong muốn, một trong hai b&ecirc;n c&oacute; quyền &nbsp;đưa vụ việc ra T&ograve;a &aacute;n nh&acirc;n d&acirc;n c&oacute; thẩm quyền tại Th&agrave;nh phố Hồ Ch&iacute; Minh để giải quyết.</p>
	        <p>- Quy chế của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;ch&iacute;nh thức c&oacute; hiệu lực thi h&agrave;nh kể từ ng&agrave;y k&yacute; Quyết định ban h&agrave;nh k&egrave;m theo Quy chế n&agrave;y.&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;c&oacute; quyền v&agrave; c&oacute; thể thay đổi Quy chế n&agrave;y bằng c&aacute;ch th&ocirc;ng b&aacute;o l&ecirc;n&nbsp;Website TMĐT&nbsp;FPTshop.com.vn&nbsp;cho c&aacute;c th&agrave;nh vi&ecirc;n biết. Quy chế sửa đổi c&oacute; hiệu lực kể từ ng&agrave;y Quyết định về việc sửa đổi Quy chế c&oacute; hiệu lực. Việc th&agrave;nh vi&ecirc;n tiếp tục sử dụng dịch vụ sau khi Quy chế sửa đổi được c&ocirc;ng bố v&agrave; thực thi đồng nghĩa với việc họ đ&atilde; chấp nhận Quy chế sửa đổi n&agrave;y.</p>
	        <p><strong>XII. Điều khoản cam kết</strong></p>
	        <p>Địa chỉ li&ecirc;n lạc ch&iacute;nh thức của&nbsp;Website TMĐT&nbsp;FPTshop.com.vn:</p>
	        <p>- Website TMĐT&nbsp;FPTshop.com.vn</p>
	        <p>- C&ocirc;ng ty/Tổ chức : C&ocirc;ng ty Cổ Phần B&aacute;n lẻ kỹ thuật số FPT</p>
	        <p>- Địa chỉ: 261 &ndash; 263 Kh&aacute;nh Hội, P2, Q4, TP. Hồ Ch&iacute; Minh</p>
	        <p>- Văn ph&ograve;ng: Lầu 3, 261 &ndash; 263 Kh&aacute;nh Hội, P2, Q4, TP. Hồ Ch&iacute; Minh</p>
	        <p>- Tel: 028 730 23456&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email: fptshop@fpt.com.vn</p>
	        <p>&nbsp;</p>
	    </div>
	</div>
</section>
	<footer class="footer-app">
		<%@include file="/WEB-INF/views/User/Menu/footer.jsp"%>
	</footer>
</body>
</html>