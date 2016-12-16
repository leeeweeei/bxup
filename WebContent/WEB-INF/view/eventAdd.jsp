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

function show(r){
   if(r.status){  
	   
		if(r.value=='1' || r.value=='2'){
			//alert(document.getElementById("c").border);
			document.getElementById("c").style.display ='block';// 
			document.getElementById("d").style.display ='none';
			document.EventAddForm.eventName.value = "";
			document.EventAddForm.eventDate.value = "";
			document.EventAddForm.eventTime.value = "";
			document.EventAddForm.eventDesc.value = "";
			document.EventAddForm.eventPlace.value = "";
		} else if(r.value=='3'){
			//alert(document.getElementById("c").border);
			document.getElementById("d").style.display ='block';//
			document.getElementById("c").style.display ='none';
			document.EventAddForm.startDate.value = "";
			document.EventAddForm.endDate.value = ""; 
		} else {
			document.getElementById("c").style.display ='none';
			document.getElementById("d").style.display ='none';
			}
   }   
}

function onSubmit(cmd){

	if(checkInput()){
		var form = document.forms[0];
		form.action = "./maineventAdd";
		form.submit();
		form.actionCmd.value = "";
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
		if(document.getElementById("eventDate").value == ""){
			alert("Please fill in the eventdate");
			document.getElementById("eventDate").focus();
			return false;
		}
		if(document.getElementById("eventTime").value == ""){
			alert("Please fill in the eventtime");
			document.getElementById("eventTime").focus();
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
	} else if(document.getElementById("3").status == true){
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
	} 

	return true;
}

	
function formatDate(date){ 
	if(date.value.length == 8){
		var value = date.value;
		var reg=/^\d+$/;
		var ret=/^(?:(?!0000)[0-9]{4}\/(?:(?:0[1-9]|1[0-2])\/(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])\/(?:29|30)|(?:0[13578]|1[02])\/31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)\/02\/29)$/;
		if(reg.test(value)==true){			
				var y = date.value.substring(0,4);
			    if(y<1800 || y > 2051){
			    	alert("We could't support so far away time!");
			    	date.value = "";
			    	date.focus();
			    	return false;
			    	}	
			    var m = date.value.substring(4,6);	      			       	     
			    var d = date.value.substring(6,8);
			    var eventDate  = y + '/' + m + '/' + d;
				    if(ret.test(eventDate)==true) {
				    	date.value = eventDate;
						return true;
					}else{
						alert("Please write by the regular rule");
						date.value = "";
						date.focus();
						return false;
						}    		    			       
		}else{
		    alert("Please write by the number of 0-9");
		    date.value = "";
		    date.focus();
		    return false;
		}	  
	}else{
		alert(" Please write by yyyymmdd");
		date.value = "";
		date.focus();
    	return false;
		} 
}

function formatTime(time){
	if(time.value.length == 4){
		var value = time.value;
		var reg=/^\d+$/;
		var ret=/^(([0-1]\d)|(2[0-4]))[0-5]\d$/;
		if(reg.test(value)== true){			
				    if(ret.test(value)==true) {
				    	time.value = value;
						return true;
					}else{
						alert("Please write by the regular rule");
						time.value = "";
						time.focus();
						return false;
						}    		    			       
		}else{
		    alert("Please write by the number of 0-9");
		    time.value = "";
		    time.focus();
		    return false;
		}	  
	}else{
		alert(" Please write by hhmm");
		time.value = "";
		time.focus();
    	return false;
		} 
}


</script>

</head>
<body>
	<h2>Picture Upload</h2>
	<form enctype="multipart/form-data" action="maineventAdd" method="post">

		<input type="radio" name="img_Type" id="1" value="1"
			onclick="show(this)">Event <input type="radio"
			name="img_Type" id="2" value="2" onclick="show(this)">Banner
		<input type="radio" name="img_Type" id="3" value="3"
			onclick="show(this)">Icon

		<div id="c" style="margin: 20px; border: 2px; display: none">
			<table>
				<tr>
					<td style="width: 70px">EventName</td>
					<td style="width: 220px"><input type="text" name="eventName"
						id="eventName" size="35" maxlength="45" value="" /></td>
				</tr>
				<tr>
					<td style="width: 70px">EventDate</td>
					<td style="width: 220px"><input type="text" name="eventDate"
						id="eventDate" size="35" maxlength="10" value=""
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*Please write by yyyymmdd</td>
				</tr>
				<tr>
					<td style="width: 70px">EventTime</td>
					<td style="width: 220px"><input type="text" name="eventTime"
						id="eventTime" size="35" maxlength="4" value=""
						onfocus="this.style.imeMode='disabled'"
						onchange="formatTime(this)" /></td>
					<td>*Please write by hhmm (24-hour)</td>
				</tr>
				<tr>
					<td style="width: 70px">EventDesc</td>
					<td style="width: 220px"><textArea name="eventDesc"
							id="eventDesc" cols="30" rows="4"></textArea></td>
				</tr>
				<tr>
					<td style="width: 70px">EventPlace</td>
					<td style="width: 220px"><input type="text" name="eventPlace"
						id="eventPlace" size="35" maxlength="45" value="" /></td>
				</tr>
				<tr>
					<td>iPhone4IMG</td>
					<td colspan="2"><input type="file" name="iPhone4IMG" size="35" />
					</td>
				</tr>
				<tr>
					<td>iPhone5IMG</td>
					<td colspan="2"><input type="file" name="iPhone5IMG" size="35" />
					</td>
				</tr>
				<tr>
					<td>iPhone6IMG</td>
					<td colspan="2"><input type="file" name="iPhone6IMG" size="35" />
					</td>
				</tr>
				<tr>
					<td>iPhone6PIMG</td>
					<td colspan="2"><input type="file" name="iPhone6PIMG"
						size="35" /></td>
				</tr>
			</table>
		</div>
		<div id="d" style="margin: 20px; border: 2px; display: none">
			<table border="0">
				<tr>
					<td style="width: 70px">StartDate</td>
					<td style="width: 220px"><input type="text" name="startDate"
						id="startDate" size="35" maxlength="10" value=""
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*Please write by yyyymmdd</td>
				</tr>
				<tr>
					<td>EndDate</td>
					<td><input type="text" name="endDate" id="endDate" size="35"
						maxlength="10" value="" onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*Please write by yyyymmdd</td>
				</tr>
				<tr>
					<td>event_def</td>
					<td colspan="2"><input type="file" name="event_def" size="35">
					</td>
				</tr>
				<tr>
					<td>fri_def</td>
					<td colspan="2"><input type="file" name="fri_def" size="35">
					</td>
				</tr>
				<tr>
					<td>pk_def</td>
					<td colspan="2"><input type="file" name="pk_def" size="35">
					</td>
				</tr>
				<tr>
					<td>metal_def</td>
					<td colspan="2"><input type="file" name="metal_def" size="35">
					</td>
				</tr>
			</table>
		</div>
		<br> <input type="submit" value="Upload"
			onclick="return onSubmit('Upload');" class="input"></input> <input
			type="reset" value="Reset">

	</form>