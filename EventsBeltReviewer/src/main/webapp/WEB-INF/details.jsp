<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<title><c:out value="${show.name}"/></title>
</head>
<body>
	<div id="top">
		<h1 class="fltleft"><c:out value="${show.network}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
		
	</div>
	<div id="container">
		<div id="lftpnl">
			<h1>Users who rated this show</h1>
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
					    <th scope="col">Rating</th>
	  				</tr>
				</thead>
				<tbody>
  					<c:forEach items="${users}" var="user">
		  				<tr>
					    	<td><c:out value="${user.name}"/></td>
					    	<td><c:out value="${user.rating}"/></td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="rghtpnl">
			<h2>Message Wall</h2>
			<div id="commentbox">
                <c:forEach items="${messages}" var="msg">
                    <p>${msg.user.firstName} says: ${msg.message}</p>
                    <p>--*--*--*--*--*--*--</p>
                </c:forEach>
            </div>
                <form:form method="post" action="/events/addmsg" modelAttribute="messageObj">
                	<h5>
                		<form:input cssClass="txtbox" type="textarea" path="message"/>
					</h5>
					<form:hidden path="user" value="${user.id}"/>
					<form:hidden path="event" value="${event.id}"/>
			   		<input class="btn" type="submit" value="Submit">          
                </form:form>
               	<form:errors cssClass="red" path="message.*"/>
		</div>
	</div>
</body>
</html>