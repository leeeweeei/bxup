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
	document.getElementById("name").value = "";
	document.getElementById("gympicture").value = "";
	document.getElementById("profile").value = "";
	document.getElementById("address").value = "";
	document.getElementById("tel").value = "";
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
		if(document.getElementById("gympicture").value == ""){
			alert("Please fill in the gympicture");
			document.getElementById("gympicture").focus();
			return false;
		}
		if(document.getElementById("profile").value == ""){
			alert("Please fill in the profile");
			document.getElementById("profile").focus();
			return false;
		}		
		if(document.getElementById("address").value == ""){
			alert("Please fill in the address");
			document.getElementById("address").focus();
			return false;
		}        
		if(document.getElementById("tel").value == ""){
			alert("Please fill in the tel");
			document.getElementById("tel").focus();
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
	<h2>健身房信息</h2>
	<form enctype="multipart/form-data" action="maingymInfoAdd" method="post">

			<table>
				<tr>
					<td style="width: 70px">名字</td>
					<td style="width: 220px"><input type="text" name="name"
						id="name" size="35" maxlength="45" value="${name}" /></td>
				</tr>			
				<tr>
					<td>图片</td>
					<td colspan="2"><input type="file" id="gympicture" name="gympicture" size="35" />
					</td>
				</tr>
				<tr>
					<td style="width: 70px">档案</td>
					<td style="width: 220px"><input type="text" name="profile"
						id="profile" size="35" value="${profile}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">地址</td>
					<td style="width: 220px"><input type="text" name="address"
						id="address" size="35" maxlength="200" value="${address}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">电话</td>
					<td style="width: 220px"><input type="text" name="tel"
						id="tel" size="35" maxlength="200" value="${tel}" /></td>
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