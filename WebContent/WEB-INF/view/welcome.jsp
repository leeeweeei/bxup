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

	function onSubmit(){
		var form = document.forms[0];
		
		form.actionCmd.value = "Init";
		form.target = "_top";
		form.action = "./eventAdd";
		form.submit();
		form.actionCmd.value = "";
    }
	
</script>
</head>

<body>
	<form>
		<input type="hidden" id="actionCmd" name="actionCmd"></input> <a
			href="#" onclick="onSubmit();">Link to EventAddAction</a>

	</form>
</body>


</html>
