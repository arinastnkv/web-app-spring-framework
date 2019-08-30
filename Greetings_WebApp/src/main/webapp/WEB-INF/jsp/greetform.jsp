<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Greeting</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Your Name: </td>
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>Date (dd.mm format):</td>
          <td><form:input path="date_ddmm" /></td>
         </tr> 
         <tr>  
          <td>Did you greet Sharkhan today? :</td>
          <td><form:input path="hellosaid" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
