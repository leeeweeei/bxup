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
<title>eventadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("name").value = "";
	document.getElementById("photo").value = "";
	document.getElementById("age").value = "";
	document.getElementById("profile").value = "";
	document.getElementById("honor").value = "";
	document.getElementById("gym_name").value = "";
	document.getElementById("tab").value = "";
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
		if (isNaN(document.getElementById("tab").value)) {
			alert("请添加标签！"); 
			document.getElementById("tab").focus();
		    return false;
		} 
	return true;
}


function back(){
	if(window.confirm('是否返回教练员列表 ?')){
		javascript:window.location.href='coach'
     }
}

</script>

</head>
<body>
	<h2>教练信息</h2>
	<form enctype="multipart/form-data" action="maincoachInfoAdd" method="post">

			<table>
				<tr>
					<td style="width: 70px">名字</td>
					<td style="width: 220px"><input type="text" name="name"
						id="name" size="35" maxlength="45" value="${name}" /></td>
				</tr>			
				<tr>
					<td>头像</td>
					<td colspan="2"><input type="file" id="photo" name="photo" size="35" />
					</td>
				</tr>
				<tr>
					<td style="width: 70px">性别</td>
				    <td style="width: 220px"><input type="radio" name="gendar" id="gendar" value="1" checked>男
                                             <input type="radio" name="gendar" id="gendar" value="2">女</td>
				</tr>
				<tr>
					<td style="width: 70px">年龄</td>
					<td style="width: 220px"><input type="text" name="age"
						id="age" size="35" maxlength="2" value="${age}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">档案</td>
					<td style="width: 220px"><input type="text" name="profile"
						id="profile" size="35" value="${profile}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">荣誉</td>
					<td style="width: 220px"><input type="text" name="honor"
						id="honor" size="35" maxlength="200" value="${honor}" /></td>
				</tr>
				<tr>
					<td style="width: 75px">就职健身房</td>
					<td style="width: 220px">
					<select name="gym_id">
					<c:forEach var="gym" items="${coachInfoAdd}" varStatus="status">
						<option value="${gym.id}">${gym.name}</option>
					</c:forEach>
					</select>
					<input type="hidden" name="gym_id" value="${gym.id}"/>
					</td>
				</tr>
				<tr>
					<td style="width: 70px">认证</td>
					<td style="width: 220px"><input type="radio" name="approved" id="approved" value="1" checked>通过
                                             <input type="radio" name="approved" id="approved" value="2">未通过</td>
				</tr>
				<tr>
					<td style="width: 70px">标签</td>
					<td style="width: 220px"><input type="text" name="tab"
						id="tab" size="35" maxlength="200" value="${tab}" /></td>
				</tr>
				
			</table>

		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">
			 <input type="button" value="重置" onclick="clearAll();">

	</form>