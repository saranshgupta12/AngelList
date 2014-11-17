<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Redirecting..  
	<a href="/saransh/userList">User List</a>
	<c:redirect url="/userList"></c:redirect>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
