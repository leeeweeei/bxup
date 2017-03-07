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
<head>
<title>resources.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">

function back(){
	if(window.confirm('Are you sure return to the List screen ?')){
		javascript:window.location.href='resources'
     }
}

</script>
</head>	
<h2>FeedBack List</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br>
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>ID</th>
							<th>User</th>
							<th>Comment</th>
							<th>Create_time</th>

						</tr>
						<c:forEach items="${feedback}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td><c:out value = "${item.user_id}" /></td>
								<td><c:out value = "${item.comment}" /></td>
								<td><c:out value = "${item.create_time}" /></td>
							</tr>							
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
			<br><input type="button" value="Back" onclick="back();">		    
</body>
</html>