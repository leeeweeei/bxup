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

function show(r){
	if(r.value=='1'){
		alert(document.getElementById("c").border);
		document.getElementById("gender").value= "1";

	} else if(r.value=='2'){
		alert(document.getElementById("c").border);
		document.getElementById("gender").value= "2";
	} 
}

function back(){
	if(window.confirm('Are you sure return to the List screen ?')){
		javascript:window.location.href='resources'
     }
}

function clearAll(){
	document.getElementById("eventName").value = "";
	document.getElementById("eventStartDate").value = "";
	document.getElementById("eventEndDate").value = "";
	document.getElementById("eventTime").value = "";
	document.getElementById("eventLink").value = "";
	document.getElementById("eventDesc").value = "";
	document.getElementById("eventPlace").value = "";
	document.getElementById("iPhone4IMG").value = "";
	document.getElementById("iPhone5IMG").value = "";
	document.getElementById("iPhone6IMG").value = "";
	document.getElementById("iPhone6PIMG").value = "";
	
	document.getElementById("startDate").value = "";
	document.getElementById("endDate").value = "";
	document.getElementById("event_def").value = "";
	document.getElementById("fri_def").value = "";
	document.getElementById("pk_def").value = "";
	document.getElementById("metal_def").value = "";
	
	document.getElementById("coachCsv").value = "";
	document.getElementById("gymCsv").value = "";
}

function onSubmit(cmd){
	var rtn = document.getElementsByName("img_Type");
	var rtnValue = '';
	for (var i=0;i<rtn.length;i++){ 
		if(rtn[i].checked){ 
			rtnValue=rtn[i].value; 
		} 
	}	
	if(checkInput()){
		var form = document.forms[0];
		if(rtnValue=='1' || rtnValue=='2' || rtnValue=='3'){
			form.action = "./maincoachInfoAdd";
		} else if(rtnValue=='4'){
			form.action = "./coachAdd";
		} else if(rtnValue=='5'){
			form.action = "./gymAdd";
		}		
		form.submit();
	}	
		return false;
}

function checkInput(){
	
	if(document.getElementById("1").status == true || document.getElementById("2").status == true){
		if(document.getElementById("eventName").value == ""){
			alert("Please fill in the eventname");
			document.getElementById("eventName").focus();
			return false;
		}
		if(document.getElementById("eventStartDate").value == ""){
			alert("Please fill in the eventStartDate");
			document.getElementById("eventStartDate").focus();
			return false;
		}
		if(document.getElementById("eventEndDate").value == ""){
			alert("Please fill in the eventEndDate");
			document.getElementById("eventEndDate").focus();
			return false;
		}		
		if(document.getElementById("eventTime").value == ""){
			alert("Please fill in the eventtime");
			document.getElementById("eventTime").focus();
			return false;
		}        
		if(document.getElementById("eventLink").value == ""){
			alert("Please fill in the eventLink");
			document.getElementById("eventLink").focus();
			return false;
		}
		if(document.getElementById("eventDesc").value == ""){
			alert("Please fill in the eventdesc");
			document.getElementById("eventDesc").focus();
			return false;
		} 
	
		if(document.getElementById("eventPlace").value == ""){
			alert("Please fill in the eventplace");
			document.getElementById("eventPlace").focus();
			return false;
		}
	} else if(document.getElementById("3").status == true) {
		if(document.getElementById("startDate").value == ""){
			alert("Please fill in the startdate");
			document.getElementById("startDate").focus();
			return false;
		}      
	
		if(document.getElementById("endDate").value == ""){
			alert("Please fill in the enddate");
			document.getElementById("endDate").focus();
			return false;
		}  
	} else if(document.getElementById("4").status == true){
		if(document.getElementById("coachCsv").value == ""){
			alert("Please fill in the coachCsv");
			return false;
		}
		if(document.getElementById("coachCsv").value.indexOf(".csv") == -1 ) {
			alert("Please fill in the .csv file");
			return false;
		}
		
	} else if(document.getElementById("5").status == true){
		if(document.getElementById("gymCsv").value == ""){
			alert("Please fill in the gymCsv");
			return false;
		}
		if(document.getElementById("gymCsv").value.indexOf(".csv") == -1 ) {
			alert("Please fill in the .csv file");
			return false;
		}
	}

	return true;
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
					<td colspan="2"><input type="file" id="iPhone4IMG" name="iPhone4IMG" size="35" />
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
					<td style="width: 220px"><input type="radio" name="approved" id="approved" value="1">通过
                                             <input type="radio" name="approved" id="approved" value="2">未通过</td>
				</tr>
				
			</table>

		<br> <input type="submit" value="Upload"
			onclick="return onSubmit('Comfirm');" class="input">
			<input type="button" value="Back" onclick="back();">
			 <input type="button" value="Reset" onclick="clearAll();">

	</form>