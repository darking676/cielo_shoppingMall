<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body { font-family: 'Nanum Gothic', sans-serif;}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template/header.jsp" %>
</head>
<body>
<c:set var="session" value="${memId }" />
<!-- contents start -->
<table>
	<colgroup>
		<col width="5%" />
		<col width="10%" />
		<col width="20%" />
		<col width="10%" />
		<col width="20%" />
		<col width="10%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th scope="col" class="checkbox">
				<ul>
					<input type="checkbox" checked="checked" name="check_all" id="check_all"
					 class="input_check" onclick="funcAllchk(func1)" />
				</ul>
			</th>
			<th scope="col">번호</th>
			<th scope="col">상품명</th>
			<th scope="col">수량</th>
			<th scope="col">가격</th>
			<th scope="col">계수</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${f:length(list) > 0 }">
				<c:set var="tot" value="0" />
				<c:set var="totpay" value="1" />
				<c:set var="sel_number" value="1" />
				<c:set var="sub_pay" value="1" />
				<c:set var="stock_config" value="1" />
				<c:forEach items="${clist }" var="cean" varStatus="status">
					<tr style="text-align: center;">
						<td class="checkbox">
							<ul class="select_subject">
								<input type="checkbox" checked="checked" class="input_check" id="${totpay }"
								 name="check_li" value="${status.current.productNum }" onclick="func1(this)" />
								 <input type="hidden" id="sub_payment" value="${cean.price * cean.basketNum }" />
							</ul>
						</td>
						<td class="title" style="text-align: center;">
						<a href="#" name="title">${cean.productNum }</a>
						<input type="hidden" id="user_id" value="${memId }" /></td>
						
						<td>${cean.productNum }</td>
						
						<td class="title" style="text-align: center;"><a href="#" name="title">${cean.p_name }</a>
						<input type="hidden" id="user_id" value="${memId }"></td>
						
						<td>
							<input type="number${sel_number }" name="number" max="50" min="1" 
							value="${cean.basketNum }" class="wdp_38p" /><a href="#" 
							class="btn" id="number_mod" name="number_mod">수정</a> 	
							<input type="hidden" id="stock${stock_config }" value="${status.current.p_stock }"> 
						</td>
						
						<td id="price_sel">${cean.price}</td>
						
						<td id="sub_pay${sub_pay }">${cean.price * cean.basketNum}</td>
						
						<td>
							<a href="#" class="btn" id="go_empty" name="empty">비우기</a>
							<input type="hidden" id="empty_no" value="${status.current.productNum }">
						</td>
					</tr>
					<c:set var="tot" value="${tot + cean.price * cean.basketNum }" />
					<c:set var="totpay" value="${totpay + 1 }" />
					<c:set var="sel_number" value="${sel_number + 1 }" />
					<c:set var="sub_pay" value="${sub_pay + 1 }" />
					<c:set var="stock_config" value="${stock_config + 1 }" />
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회 결과 없음</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<td colspan="5" ></td>	
		<td colspan="1" style="text-align: center;">총 결제금액 :<span id="payment"></span><span> &#8361;</span></td>
		<td></td>
	</tbody>
</table>
<br>
<a href="pay/" class="btn" id="go_payment" name="payment">결제하기</a>
<!-- contents end -->
<%@ include file="../template/footer.jsp" %>
</body>
</html>