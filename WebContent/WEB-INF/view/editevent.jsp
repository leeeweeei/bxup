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
			form.action = "../event_update/{id}";
	
		form.submit();

		return false;
}
</script>
<head>

<title>editevent.jsp</title>
</head>	
<h2>Edit Event </h2>	
<body>
<form enctype="multipart/form-data" action="resources/event_update/{id}" method="post">
<br> <input type="submit" value="Save"
			onclick="return onSubmit('Save');" class="input">
	<input type="button"  class="blue_btn" value="Back" onclick="javascript:window.location.href='<%=basePath%>resources'"/>	
		<table>	
				<input type="hidden" name="id" value="${id}"/>

				<tr>
					<td style="width: 70px">EventName</td>
					<td style="width: 220px"><input type="text" name="event_name"
						id="eventName" size="35" maxlength="45" value="${event_name}"/></td>
				</tr>
				<tr>
					<td style="width: 70px">EventStartDate</td>
					<td style="width: 220px"><input type="text" name="event_start_date"
						id="eventStartDate" size="35" maxlength="10" value="${event_start_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*Please write by yyyymmdd</td>
				</tr>
				<tr>
					<td style="width: 70px">EventEndDate</td>
					<td style="width: 220px"><input type="text" name="event_end_date"
						id="eventEndDate" size="35" maxlength="10" value="${event_end_date}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatDate(this)" /></td>
					<td>*Please write by yyyymmdd</td>
				</tr>
				
				<tr>
					<td style="width: 70px">EventTime</td>
					<td style="width: 220px"><input type="text" name="event_time"
						id="eventTime" size="35" maxlength="4" value="${event_time}"
						onfocus="this.style.imeMode='disabled'"
						onchange="formatTime(this)" /></td>
					<td>*Please write by hhmm (24-hour)</td>
				</tr>
				<tr>
					<td style="width: 70px">EventLink</td>
					<td style="width: 220px"><input type="text" name="event_link"
						id="eventLink" size="35" maxlength="200" value="${event_link}" /></td>
				</tr>
				<tr>
					<td style="width: 70px">EventDesc</td>
					<td style="width: 220px"><textArea name="event_desc"
							id="eventDesc" cols="30" rows="4">${event_desc}</textArea></td>
				</tr>
				<tr>
					<td style="width: 70px">EventPlace</td>
					<td style="width: 220px"><input type="text" name="event_place"
						id="eventPlace" size="35" maxlength="45" value="${event_place}" /></td>
				</tr>
								<tr>
					<td>iPhone4IMG:${iphone4_img}</td><td><input type="hidden" name="iphone4_img"
						id="iphone4_img" value="${iphone4_img}" />
				</tr>
				<tr>		
					<td><input type="file" id="iPhone4IMG" name="iPhone4IMG" size="30" />				
				<tr>
					<td>iPhone5IMG:${iphone5_img}</td><td><input type="hidden" name="iphone5_img"
						id="iphone5_img" value="${iphone5_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone5IMG" name="iPhone5IMG" size="30" />
				</tr>
				<tr>
					<td>iPhone6IMG:${iphone6_img}</td><td><input type="hidden" name="iphone6_img"
						id="iphone6_img" value="${iphone6_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone6IMG" name="iPhone6IMG" size="30" />
				</tr> 
								<tr>
					<td>iPhone6PIMG:${iphone6p_img}</td><td><input type="hidden" name="iphone6p_img"
						id="iphone6p_img" value="${iphone6p_img}" />		
				</tr>
				<tr>
					<td colspan="2"><input type="file" id="iPhone6PIMG" name="iPhone6PIMG" size="30" />
				</tr> 
		</table>		
           
</form>    
</body>

</html>