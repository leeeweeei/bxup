<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="true">
<head>
<title>showInfoAdd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("name").value = "";
	document.getElementById("photo").value = "";
	document.getElementById("age").value = "";
	document.getElementById("profile").value = "";
	document.getElementById("honor").value = "";
	document.getElementById("gym_name").value = "";
}

function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){	
		if(document.getElementById("name").value == ""){
			alert("请填写姓名");
			document.getElementById("name").focus();
			return false;
		}
		if(document.getElementById("photo").value == ""){
			alert("请填加一张照片");
			document.getElementById("photo").focus();
			return false;
		}
		if(document.getElementById("age").value == ""){
			alert("请填写年龄");
			document.getElementById("age").focus();
			return false;
		}		
		if(document.getElementById("profile").value == ""){
			alert("请填写简历");
			document.getElementById("profile").focus();
			return false;
		}        
		if(document.getElementById("honor").value == ""){
			alert("请填写个人荣誉");
			document.getElementById("honor").focus();
			return false;
		}
		if(document.getElementById("gym_name").value == ""){
			alert("请填写健身场馆名称");
			document.getElementById("gym_name").focus();
			return false;
		} 
		if (isNaN(document.getElementById("age").value)) {
			alert("年龄请输入数字！"); 
			document.getElementById("age").focus();
		    return false;
		} 
	return true;
}


function back(){
	if(window.confirm('是否返回秀场列表 ?')){
		javascript:window.location.href='show'
     }
}

</script>

</head>
<body>
	<h2>秀场提交</h2>
	<form enctype="multipart/form-data" action="showAdd" method="post">

			<table>
				<tr>
					<td style="width: 70px">用户名</td>
					<td style="width: 220px">
					<select name="user_id">
					<c:forEach var="user" items="${showInfoAdd}" varStatus="status">
						<option value="${user.user_id}">${user.nickname}</option>
					</c:forEach>
					</select>
					<input type="hidden" name="user_id" value="${user.user_id}"/>
					</td>
				</tr>
				<tr>
					<td style="width: 70px">评论</td>
					<td style="width: 220px"><textArea name="description"
							id="description" cols="30" rows="4" >${description}</textArea></td>
				</tr>			
				<tr>
					<td>图片1</td>
					<td colspan="2"><input type="file" id="photo1" name="photo1" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片2</td>
					<td colspan="2"><input type="file" id="photo2" name="photo2" size="35" />
					</td>
				</tr>
				<tr>
					<td>图片3</td>
					<td colspan="2"><input type="file" id="photo3" name="photo3" size="35" />
					</td>
				</tr>
			    <tr>
					<td>图片4</td>
					<td colspan="2"><input type="file" id="photo4" name="photo4" size="35" />
					</td>
				</tr>
				
			</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">


	</form>