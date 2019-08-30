    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Sharkhan Greeting List</h1>
	<table border="2" width="60%" cellpadding="3">
	<tr><th>Id</th><th>Name</th><th>Date (dd/mm)</th><th>Sharkhan Greeting Status</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="hi" items="${list}">
    <tr>
    <td align="center">${hi.id}</td>
    <td align="center">${hi.name}</td>
    <td align="center">${hi.date_ddmm}</td>
    <td align="center">${hi.hellosaid}</td>
    <td align="center"><a href="editgreeting/${hi.id}">Edit</a></td>
    <td align="center"><a href="deletehello/${hi.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="greetform">Add New Greeting</a>