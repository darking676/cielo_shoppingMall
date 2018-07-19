<style>
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic');

body { font-family: 'Nanum Gothic', sans-serif;}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../template/header.jsp" %>
</head>
<body>
<%@ include file="../template/header2.jsp" %>
<h1>Review BBS</h1>
<form id="frm" enctype="multipart/form-data" >
        <table class="board_view">
            <colgroup>
                <col width="15%" >
                <col width="*" >
            </colgroup>
            <caption>후기 작성</caption>
            <tbody>
                <tr>
                    <th scope="row">제목</th>
                    <td><input type="text"  name="TITLE" class="wdp_90" /></td>
                </tr>
                <tr>
                    <th scope="row">내용</th>
                    <td><textarea cols="100" rows="20" id="CONTENTS" name="CONTENTS" title="내용"></textarea></td>
                </tr>
            </tbody>
        </table>
        <div id="fileDiv">
            <p>
                <input type="file" name="file_0"/>
                <a href="#" name="delete" class="btn">삭제하기</a>
            </p> 
        </div>
        <br/><br/>
        <a href="#" id="add" class="btn">파일 추가하기</a>
        <a href="#" id="list" class="btn">목록으로</a>
        <a href="#" id="write" class="btn">글쓰기</a>
    </form>
    <script type="text/javascript">
        var g_count =1;
        $(document).ready(function(){
            $("#list").on("click",function(e){
                e.preventDefault();
                fn_openBoardList();
            });
            $("#write").on("click",function(e){
                e.preventDefault();
                fn_writeBoard();
            });
            $("a[name='delete']").on("click",function(e){
                e.preventDefault();
                fn_fileDelete($(this));
            });
            $("#add").on("click",function(e){
                e.preventDefault();
                fn_fileAdd();
            });
        });
         
         
        function fn_openBoardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/rev/openBoardList'/>");
            comSubmit.submit();
        }
         
        function fn_writeBoard(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value='/rev/writeBoard'/>");
            comSubmit.submit();
        }
        function fn_fileDelete(obj){
            obj.parent().remove();
        }
        function fn_fileAdd(){
            var str = "<p><input type='file' name='file_"+(g_count++)+"'/><a href='#' name='delete' class='btn'>삭제하기</a></p> ";
            $("#fileDiv").append(str);
             
            $("a[name='delete']").on("click",function(e){
                e.preventDefault();
                fn_fileDelete($(this));         
            });
        }
    </script>
<%@ include file="../template/footer.jsp" %>
</body>
</html>