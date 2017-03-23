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
<title>subscribeInfoadd.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function clearAll(){
	document.getElementById("title").value = "";
	document.getElementById("tab").value = "";
	document.getElementById("url").value = "";
}

function onSubmit(cmd){
	if(checkInput()){
		var form = document.forms[0];	
		form.submit();
	}	
		return false;
}

function checkInput(){
		if(document.getElementById("subscribe_type").value == ""){
			alert("请选择要添加的类型");
			document.getElementById("subscribe_type").focus();
			return false;
		}
		if(document.getElementById("title").value == ""){
			alert("请填写标题");
			document.getElementById("title").focus();
			return false;
		}
		if(document.getElementById("tab").value == ""){
			alert("请填写简介");
			document.getElementById("tab").focus();
			return false;
		}
		if(document.getElementById("url").value == ""){
			alert("请填写URL");
			document.getElementById("url").focus();
			return false;
		}		
	return true;
}


function back(){
	if(window.confirm('是否返回健身房列表 ?')){
		javascript:window.location.href='gym'
     }
}

</script>

</head>
<body>
	<h2></h2>
	<form enctype="multipart/form-data" action="subscribeInfoAdd" method="post">

			<table>
			    <tr>
			   		<td style="width: 70px">选择添加项目类型</td>
			   		<td>
					<select id="subscribe_type" name="subscribe_type">  
					<option value="2">知道</option>  
					<option value="0">变形头条</option>
					<option value="3">精选</option>  
					</select></td>  
			    </tr>
				<tr>
					<td style="width: 70px">标题</td>
					<td style="width: 220px"><input type="text" name="title"
						id="title" size="35" maxlength="45" value="${title}" /></td>
				</tr>			
				<tr>
					<td style="width: 70px">简介</td>
					<td style="width: 220px"><input type="text" name="tab"
						id="tab" size="35" value="${tab}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">URL</td>
					<td style="width: 220px"><input type="text" name="url"
						id="url" size="35" maxlength="200" value="${url}" /></td>
				</tr>
				<tr>
					<td>图片</td>
					<td colspan="2"><input type="file" id="knownpicture" name="knownpicture" size="35" />
					</td>
				</tr>			
			</table>
		<br> <input type="submit" value="上传"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="返回" onclick="back();">
			 <input type="button" value="重置" onclick="clearAll();">

	</form>