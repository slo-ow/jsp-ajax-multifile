<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<title>jQuery ajax fileupload (ajax 파일업로드)</title>

<!-- jQuery import -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- jQuery Form Plugin 이용 -->
<script src="../js/jquery.form.min.js"></script>


<style type="text/css">
	#test {text-align: center;}
</style>
</head>

<body>
<h3>jQuery ajax fileupload (ajax 파일업로드)</h3>
<form name="multiform" id="multiform" action="${pageContext.request.contextPath}/MultiController" 
method="POST" enctype="multipart/form-data">
<table width="20%" cellpadding="5" cellspacing="0" border="1" align="center" 
style="border-collapse:collapse; border:1px gray solid;">
	<tr>
		<td>
		title: <input type="text" name="title"  value="" style="margin-left:26px;"/>	
		</td>
	</tr>
	<tr>
		<td>
		content :<input type="text" name="content"  value="" />
		</td>
	</tr>
	<tr id="test2">
		<td>
		 <!-- 단일 파일업로드 -->
    	<input type="file" name="file" />
    	<input type="button" class="addFile" value="추가"/>
		</td>
	</tr>
	<tr>
		<td id="test">
    	<input type="submit" id="btnSubmit" value="전송"/>
		</td>
	</tr>
</table>     
   
</form>    


<div id="result">
    
</div>

<script>
/*jQuery form 플러그인을 사용하여 폼데이터를 ajax로 전송*/

var downGroupCnt =0; //다운로드그룹 개수카운트

$(function(){
    
	//동적버튼추가
	$(".addFile").click(function(){
		var codeHTML;
		codeHTML += "<tr><td><input type='file' name='file'/>";
		/* codeHTML += "<input type='button' class='addFile' value='추가'/></td></tr>"; */
		$("#test2").after(codeHTML);
	});
	
});

</script>

</body>
</html>