<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body {
	font-family: 'Nanum Gothic', sans-serif;
}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.location01 {
	padding-top: 0px;
	padding-left: 470px;
}

hr.line {
	width: 653px;
	color: black;
	border: thin solid gray;
	border-bottom: 2px;
	text-align: left;
	margin-left: 0px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check() {
		var form = document.getElementById("writeForm3");
		//유효성 검사로직 추가
		return true;
	}
	function goList() {
		var form = document.getElementById("listForm3");
		form.submit();
	}
</script>
<%@ include file="../../template3/header.jsp" %>
</head>
<body>
<%@ include file="../../template3/header2.jsp" %>
<div class="location01">
	<div id="wrap">
		<div id="header"></div>
		<div id="main-menu"></div>
		<div id="container">
			<div id="content" style="min-height: 800px;">
				<div id="url-navi"></div>

				<!-- 본문 시작 -->
				<h1>${productType }</h1>
				<hr class="line">
				<div id="product">
					<form id="writeForm3" action="/shop01/bottomW3/" method="post"
						enctype="multipart/form-data" onsubmit="return check()">
						<p style="margin: 0; padding: 0;">
							<input type="hidden" name="productType" value="${param.productType }" />
						</p>
						<table id="write-form">
							<tr>
								<td>상품이름</td>
								<td><input type="text" name="title" size="71"
									style="height: 40px;" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>파일 첨부</td>
								<td><input type="file" name="upload" multiple /></td>
							</tr>
							<tr>
								<td>내용</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="contents" rows="20"
										style="width: 653px"></textarea></td>
							</tr>
							<td>&nbsp;</td>
							<tr>
								<td>썸네일 첨부</td>
								<td><input type="file" name="upload" multiple /></td>
							</tr>
						</table>
						<br />
						<hr class="line">
						<div
							style="text-align: center; padding-bottom: 15px; padding-right: 397px;">
							<input type="submit" value="전송"
								class="btn btn-info btn-sm active" /> <input type="button"
								value="목록" onclick="goList()"
								class="btn btn-info btn-sm active" />
						</div>
					</form>
				</div>
				<!--  본문 끝 -->

			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

		<div id="sidebar"></div>

		<div id="extra"></div>

		<div id="footer"></div>

	</div>
</div>
<%@ include file="../../template3/footer.jsp" %>
</body>
</html>