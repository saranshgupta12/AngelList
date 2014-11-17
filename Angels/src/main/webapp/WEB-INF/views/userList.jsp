<%@include file="/WEB-INF/JSP/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UCLA USER's LIST</title>
</head>
<body>
<center><H1 style="background-color:blue"> <font color="yellow">UCLA STARTUPS @ ANGEL LIST</font></H1></center>
<table border="1">
<tr style="background-color: lightgray"> 
	<td><B>ID</B></td> 
	<td><B>NAME</B></td>
	<td><B>PIC</B></td>
	<td><B>URL</B></td>
	<td><B>TYPE</B></td>
</tr>
<c:forEach items="${model.searchResponseList}" var="searchResponse">
	<tr>
	<td><c:out value="${searchResponse.id}" /> </td>
	<td><c:out value="${searchResponse.name}"/></td>
	<td><img alt="No Image" src="${searchResponse.pic}"/></td>
	<td><a href="${searchResponse.url}"><c:out value="${searchResponse.url}" /></a></td>
	<td> <c:out value="${searchResponse.type}"/></td>
	</tr>
</c:forEach>
</table> 
</body>
</html>