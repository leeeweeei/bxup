<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="true">
<head>
<title>eventadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	alert("33333!");
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
			alert("Please fill in the name");
			document.getElementById("name").focus();
			return false;
		}
		if(document.getElementById("photo").value == ""){
			alert("Please fill in the photo");
			document.getElementById("photo").focus();
			return false;
		}
		if(document.getElementById("age").value == ""){
			alert("Please fill in the age");
			document.getElementById("age").focus();
			return false;
		}		
		if(document.getElementById("profile").value == ""){
			alert("Please fill in the profile");
			document.getElementById("profile").focus();
			return false;
		}        
		if(document.getElementById("honor").value == ""){
			alert("Please fill in the honor");
			document.getElementById("honor").focus();
			return false;
		}
		if(document.getElementById("gym_name").value == ""){
			alert("Please fill in the eventdesc");
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
	if(window.confirm('Are you sure return to the List screen ?')){
		javascript:window.location.href='resources'
     }
}

</script>

</head>
<body onload="load()">
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
						id="age" size="35" maxlength="4" value="${age}"/></td>
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
					<td style="width: 220px"><input type="text" name="gym_name"
							id="gym_name" size="35" value="${gym_name}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">认证</td>
					<td style="width: 220px"><input type="radio" name="approved" id="approved" value="1" checked>通过
                                             <input type="radio" name="approved" id="approved" value="2">未通过</td>
				</tr>
				
			</table>

		<br> <input type="submit" value="Upload"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="Back" onclick="back();">
			 <input type="button" value="Reset" onclick="clearAll();">

	</form>