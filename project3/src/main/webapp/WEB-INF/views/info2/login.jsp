<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

.location01{
  padding-top: 75px;
  padding-left: 550px;
}

#naver_id_login{
  padding-left: 120px;


}


</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template/header.jsp" %>
</head>
<body>
<%@ include file="../template/header2.jsp" %>

<div class="location01">
<form class="form-horizontal" action="/shop01/login/" method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">LOGIN</legend>
    </div>
    <div class="control-group">
      <!-- ID -->
      <label class="control-label"  for="ID">ID</label>
      <div class="controls">
      
      <input type="text" id="memID" name="memID" placeholder="" 
      class="input-xlarge" style="padding-left: 130px">
      <br/>
      <br/>
      </div>
    </div>
    <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">PASSWORD</label>
      <div class="controls">  
      <input type="password" id="memPassword" name="memPassword" placeholder=""
       class="input-xlarge" style="padding-left: 130px">
      <br/>
      <br/>
      <br/>
      </div>
    </div>
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-info btn-sm active" style="width: 288px">LOGIN</button>
        <br/>
        <br/>
      </div>
    </div>
  </fieldset>
</form>
        <a href="/shop01/join/"><button class="btn btn-info btn-sm active" style="width: 288px">JOIN</button></a>
</div>
<br/>
<div id="naver_id_login" style="text-align:center"><a href="${url}"><img width="200" id="naver"  src="${pageContext.request.contextPath}/resources/imgs/NAVER.PNG"/></a>
<br/>
<br/>
</div>
<br>
 

 <%@ include file="../template2/footer.jsp" %>
      </body>    
</html>