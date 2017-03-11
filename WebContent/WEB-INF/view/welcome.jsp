<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<SCRIPT Language="JavaScript">

	function onSubmit1(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome1";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit2(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome2";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit3(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome3";
		form.submit();
		form.actionCmd.value = "";
    }
	
	function onSubmit4(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./welcome4";
		form.submit();
		form.actionCmd.value = "";
    }
	
</script>
</head>

<body>
	<form>
	<table>
		<tr>
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit1();">活动项目一览</a></td>
		</tr>
		
		<tr>		
	    <td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit2();">教练员信息一览</a></td>
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit3();">健身房信息一览</a></td>	
		</tr>
		<tr>	
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit4();">客户反馈信息</a></td>	
		</tr>
	</table>	
	</form>
</body>


</html>
