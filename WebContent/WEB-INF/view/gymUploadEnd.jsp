<%@ page language="java" contentType="text/html;charset=MS932"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="true">
<head>
<title>gymUploadEnd.jsp</title>

</head>

<body>
	<table>
		<tr>
			<td><h2>gym upload has been successfully data</h2></td>
		</tr>
		<tr>
			<td>
				<div style="overflow:scroll;width:1000px; height:300px;">
					<table border="1">
						<tr>
							<th>avatar</th>							
							<th>name</th>
							<th>contact</th>
							<th>location</th>
							<th>approved</th>
							<th>delete_status</th>
						</tr>
						<c:forEach items="${success}" var="item">
							<tr>
								<td><c:out value = "${item.avatar}" /></td>								
								<td><c:out value = "${item.name}" /></td>
								<td><c:out value = "${item.contact}" /></td>
								<td><c:out value = "${item.location}" /></td>
								<td><c:out value = "${item.approved}" /></td>
								<td><c:out value = "${item.delete_status}" /></td>
							</tr>							
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
		<tr>
			<td><h2>gym upload has been falure data</h2></td>
		</tr>
		<tr>
			<td>
				<div style="overflow:scroll;width:1000px; height:300px;">
					<table border="1">
						<tr>
							<th>cowNum</th>
							<th>errData</th>
							<th>errMsg</th>
						</tr>
						<c:forEach items="${falure}" var="item">
							<tr>
								<td><c:out value = "${item.lineCount}" /></td>
								<td><c:out value = "${item.errorData}" /></td>
								<td>
									<c:forEach items="${item.errorMsg}" var="errorMsg">
										<c:out value = "${errorMsg}" /></br>
									</c:forEach>
								</td>
							</tr>							
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
    <br><input type="button"  class="blue_btn" value="Back" onclick="javascript:window.location.href='./eventAdd'"/>
</body>

</html>