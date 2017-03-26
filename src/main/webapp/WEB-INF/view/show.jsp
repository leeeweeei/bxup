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
<title>show.jsp</title>
<script type="text/javascript" src="./js/test.js"></script>
<SCRIPT Language="JavaScript">
function show(r){
	if(r.value=='1' || r.value=='2'){
		//alert(document.getElementById("c").border);
		document.getElementById("c").style.display ='block';// 
		document.getElementById("d").style.display ='none';
		clearAll();
	} else if(r.value=='3'){
		//alert(document.getElementById("c").border);
		document.getElementById("d").style.display ='block';//
		document.getElementById("c").style.display ='none';
		clearAll(); 
	} else {
		document.getElementById("c").style.display ='none';
		document.getElementById("d").style.display ='none';
	}
}
function delConfirm(itemId){	
	if(window.confirm('Are you sure delete the event?')){
		javascript:window.location.href='resources/event_delete/' + itemId
    }
}

function back(){
	if(window.confirm('是否返回导航画面 ?')){
		javascript:window.location.href='/BXAdmin'
     }
}
</script>
</head>	
<h2>秀场一览</h2>	
<body>
<c:if test="${not empty message}">
	<div role="alert">
		<p>${message}</p>
	</div>
</c:if>
<br><input type="button"  class="blue_btn" value="新建秀场" onclick="javascript:window.location.href='./showInfoAdd'"/>
	<input type="button" value="返回" onclick="back();"/>
	<table>
		<tr>
			<td>
				<div id="global">
					<table border="1">
						<tr>
							<th>No.</th>
							<th>评论</th>
							<th>图片1</th>
							<th>图片2</th>
							<th>图片3</th>
							<th>图片4</th>
							<th>日期</th>
			
						</tr>
						<c:forEach items="${show}" var="item" varStatus="status">
							<tr>
								<td><c:out value = "${status.count}" /></td>
								<td><c:out value = "${item.description}" /></td>
								<td><c:out value = "${item.img}" /></td>	
								<td><c:out value = "${item.createTime}" /></td>																											
<%-- 								<td><input type="button" onclick="javascript:window.location.href='resources/event_edit/${item.id}'" value="编辑"></td>
								<td><input type="button" onclick="delConfirm(${item.id});" value="删除"></td> --%>
							</tr>
						</c:forEach>
					</table>	
				</div>
			</td>
		</tr>
	</table>
    
</body>
</html>