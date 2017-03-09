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
	if(window.confirm('是否返回活动列表 ?')){
		javascript:window.location.href='resources'
     }
}

</script>
</head>	
<h2>反馈列表</h2>	
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
							<th>No.</th>
							<th>用户</th>
							<th>反馈内容</th>
							<th>反馈时间</th>

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
			<br><input type="button" value="返回" onclick="back();">		    
</body>
</html>