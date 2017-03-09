<%@ page language="java" contentType="text/html;charset=MS932"%>
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
</script>
</head>

<body>
	<form>
		<tr>
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit1();">Link to ShowAllEvent</a></td>
	    <td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit2();">Link to ShowAllCoach</a></td>
		<td><input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit3();">Link to ShowAllGym</a></td>	
		</tr>
	</form>
</body>


</html>
