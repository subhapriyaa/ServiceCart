<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="view">View</a>
<%-- <P>  The time on the server is ${serverTime}. </P>
 --%>
<form:form id="myForm" action="company" method="post" modelAttribute="company">
<span style="color: red">${message}</span><br><br>
	Username: <form:input type="text" path="username" required="required"/><br><br>
	Password: <form:textarea path="password" required="required"/>
	<form:button value="Submit">Submit</form:button>
</form:form>


</body>
</html>
