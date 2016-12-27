<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
function onSubmit(cmd){
		var form = document.forms[0];
			form.action = cmd;
	
		form.submit();

		return false;
}
</script>
<head>

<title>comfirmevent.jsp</title>
</head>	
<h2>Comfirm Event </h2>	
<body>
<form enctype="multipart/form-data" action="./maineventAdd" method="post">
		<table>
				<input type="hidden" name="endDate" value="${endDate}"/>
				<input type="hidden" name="startDate" value="${startDate}"/>
				<input type="hidden" name="img_Type" value="${img_Type}"/>			
				<tr>
					<td style="width: 70px">EventName</td>
					<td style="width: 220px"><input type="text" name="event_name"
						id="eventName" size="35" maxlength="45" value="${event_name}" readonly/></td>
				</tr>
				<tr>
					<td style="width: 70px">EventStartDate</td>
					<td style="width: 220px"><input type="text" name="event_start_date"
						id="eventStartDate" size="35" maxlength="10" value="${event_start_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" readonly/></td>				
				</tr>
				<tr>
					<td style="width: 70px">EventEndDate</td>
					<td style="width: 220px"><input type="text" name="event_end_date"
						id="eventEndDate" size="35" maxlength="10" value="${event_end_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" readonly/></td>				
				</tr>			
				<tr>
					<td style="width: 70px">EventTime</td>
					<td style="width: 220px"><input type="text" name="event_time"
						id="eventTime" size="35" maxlength="4" value="${event_time}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatTime(this)" readonly/></td>	
				</tr>
				<tr>
					<td style="width: 70px">EventLink</td>
					<td style="width: 220px"><input type="text" name="event_link"
						id="eventLink" size="35" maxlength="200" value="${event_link}" readonly/></td>
				</tr>
				<tr>
					<td style="width: 70px">EventDesc</td>
					<td style="width: 220px"><textArea name="event_desc"
							id="eventDesc" cols="30" rows="4" readonly="readonly">${event_desc}</textArea></td>
				</tr>
				<tr>
					<td style="width: 70px">EventPlace</td>
					<td style="width: 220px"><input type="text" name="event_place"
						id="eventPlace" size="35" maxlength="45" value="${event_place}" readonly/></td>
				</tr>
				
				<tr>
					<td style="width: 70px">iPhone4IMGName</td>
					<td style="width: 220px"><input type="text" name="iPhone4IMGName"
						id="eventPlace" size="35" maxlength="45" value="${iPhone4IMGName}" readonly/></td>
				</tr> 
				
				<tr>
					<td style="width: 70px">iPhone5IMGName</td>
					<td style="width: 220px"><input type="text" name="iPhone5IMGName"
						id="eventPlace" size="35" maxlength="45" value="${iPhone5IMGName}" readonly/></td>
				</tr> 
				
				<tr>
					<td style="width: 70px">iPhone6IMGName</td>
					<td style="width: 220px"><input type="text" name="iPhone6IMGName"
						id="eventPlace" size="35" maxlength="45" value="${iPhone6IMGName}" readonly/></td>
				</tr> 
				
				<tr>
					<td style="width: 70px">iPhone6PIMGName</td>
					<td style="width: 220px"><input type="text" name="iPhone6PIMGName"
						id="eventPlace" size="35" maxlength="45" value="${iPhone6PIMGName}" readonly/></td>
				</tr>  
				
		</table>	
		<br><input type="submit" value="Upload" onclick="return onSubmit('./maineventAdd');" class="input">
		    <input type="submit"  class="blue_btn" value="Back" onclick="return onSubmit('./eventAdd');"/>	
           
</form>    
</body>

</html>