<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.fileDrop {
	    width:600px;
	    height: 200px;
	    border: 1px dotted blue;
	}
	
	small {
	    margin-left: 3px;
	    font-weight: bold;
	    color: gray;
	}
</style>
<script>
	$(document).ready(function() {
		$(".fileDrop").on("dragenter dragover", function(event){
			event.preventDefault();
		});
		$(".fileDrop").on("drop", function(event){
			event.preventDefault();
			var files = event.originalEvent.dataTransfer.files; //드래그된 파일 정보
			var file = files[0]; //1st 파일
			console.log(file);
			
			//Ajax로 전달할 폼 객체
			var formData = new FormData();
			formData.append("file", file);	//폼 객체에 파일추가, append("변수명", 값)
			
			$.ajax({
				type: "post",
				url: "${path}/upload/uploadAjax",
				data: formData,
				dataType: "text",
				processData: false,
				contentType: false,
				success: function(data){
					var str = "";
					if(checkImageType(data)){	//이미지 파일이면 썸네일 이미지 출력
						str = "<div><a href='${path }/upload/displayFile?fileName='+getOriginalName(data)+"'>";
						str += "<img src='${path }/upload/displayFileName?fileName="+data+"'></a>"; 
					}else{		//파일이면 다운
						str = "<div><a href='${path }/upload/displayFile?fileName="+data+"'>"+getOriginalName(data)+"</a>";
					}
					
					//삭제
					str += "<span data-src="+data+">[삭제]</span></div>";
					$(".uploadedList").append(str);
				}
			});
		});
		
		function getOriginalNAme() {
			if(checkImageType(fileName)){
				return;
			}
			
			var idx = fileName.indexOf("_")+1;
			return fileName.substr(idx);
		}
		
		//이미지 파일 링크
		function getImageLink(fileName) {
			if(!checkImageType(fileName)){
				return;
			}			
			var front = fileName.substr(0,12);	//년월일 경로 추출
			var end = fileName.substr(14);		//년월일 경로와 s_를 제거한 원본 파일명 추출
			console.log(front);
			console.log(end);
			
			return front+end; //디렉토리를 포함한 원본파일명 리턴
		}
		
		function chckImageType(fileName() {
			var pattern = /jpg|gif|png|jpeg/i;		//i:ignore case
			return fileName.match(pattern);			//규칙이 맞으면 true
		}
	});
</script>
</head>
<body> 
	<h2>Ajax File Upload</h2>
	<!-- 업로드할 영역 -->
	<form id="form1" target="iframePhoto" action="/shop01/upload/uploadForm" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit" value="up" />
		<div class="fileDrop"></div>
	</form><br/>
	<iframe name="iframePhoto"></iframe>
	
	<script type="text/javascript">
		function addFilePath(msg) {
			console.log(msg);
			document.getElementById("form1").reset();	//iframe에 업로드된 결과를 출력 후 form에 저장된 데이터 초기화
		}
	</script>
	
	<!-- 업로드된 파일 목록 -->
	<div class="uploadList"></div>
</body>
</html>