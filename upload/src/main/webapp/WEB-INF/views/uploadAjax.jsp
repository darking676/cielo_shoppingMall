<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.fileDrop {
		width: 600px;
		height: 70px;
		border: 2px dotted gray;
		background-color: gray;
	}
</style>

<script type="text/javascript">
	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		var files = event.originalEvent.dataTransfer.files;
		var file = files[0];
		console.log(file);
		var formData = new FormData();
		formData.append("file", file);
		
		$.ajax({
			type: "POST",
			url: "${path}/upload/uploadAjax",
			data: formData,
			dataType: "text",
			processData: false,
			contentType: false,
			
			success: fuction(data){
				var str = ""; 
				// 이미지 파일이면 썸네일 이미지 출력
				if(chkeckImageType(data)){
					str = "<div><a href='${path}/upload/displayFile?fileName="getImageLink(data)+"'>";
					str += "<img src='${path}/upload/displayFile?fileName="+data+"'></a>";
				// 일반 파일이면 다운 링크
				} else {
					str = "<div><a href='${path}/upload/displayFile?fileName="+data+"'>"+getOriginalName(data)+"</a>";
				}
				
				//delete btn
				str += "<span data-src="+data+">[삭제]</span></div>";
				$(".uploadedList").append(str);
			}
		});
	}); 
	
	$(".uploadedList").on("click", "span", function(event){
	    alert("이미지 삭제")
	    var that = $(this); // 여기서 this는 클릭한 span태그
	    $.ajax({
	        url: "${path}/upload/deleteFile",
	        type: "post",
	        // data: "fileName="+$(this).attr("date-src") = {fileName:$(this).attr("data-src")}
	        // 태그.attr("속성")
	        data: {fileName:$(this).attr("data-src")}, // json방식
	        dataType: "text",
	        success: function(result){
	            if( result == "deleted" ){
	                // 클릭한 span태그가 속한 div를 제거
	                that.parent("div").remove();
	            }
	        }
	    });
	});
	
	// 원본파일이름을 목록에 출력하기 위해
	function getOriginalName(fileName) {
	    // 이미지 파일이면
	    if(checkImageType(fileName)) {
	        return; // 함수종료
	    }
	    // uuid를 제외한 원래 파일 이름을 리턴
	    var idx = fileName.indexOf("_")+1;
	    return fileName.substr(idx);
	}
	
	// 이미지파일 링크 - 클릭하면 원본 이미지를 출력해주기 위해
	function getImageLink(fileName) {
	    // 이미지파일이 아니면
	    if(!checkImageType(fileName)) { 
	        return; // 함수 종료 
	    }
	    // 이미지 파일이면(썸네일이 아닌 원본이미지를 가져오기 위해)
	    // 썸네일 이미지 파일명 - 파일경로+파일명/
	    var front = fileName.substr(0, 12); // 년원일 경로 추출
	    var end = fileName.substr(14); // 년원일 경로와 s_를 제거한 원본 파일명을 추출
	    console.log(front); 
	    console.log(end); 
	    // 원본 파일명 - /
	    return front+end; // 디렉토리를 포함한 원본파일명을 리턴
	}
	
	// 이미지파일 형식을 체크하기 위해
	function checkImageType(fileName) {
	    // i : ignore case(대소문자 무관)
	    var pattern = /jpg|gif|png|jpeg/i; // 정규표현식
	    return fileName.match(pattern); // 규칙이 맞으면 true
	}
</script>
</head>
<body>
<!-- 파일을 업로드할 영역 -->
<form id="form1" target="iframePhoto" action="${path }/upload/uploadForm" method="post" enctype="multipart/form-data">
	<input type="file" name="file" />
	<input type="submit" value="upload" />
</form>
<!-- 업로드된 파일 목록 --><!-- form-data가 이곳으로 이동 -->
<iframe name="iframePhoto"></iframe>
<script type="text/javascript">
	function addFilePath(msg) {
		console.log(msg);
		document.getElementById("form1").reset();
	}
</script>
<div id="uploadList"></div>
<body>
</body>
</html>