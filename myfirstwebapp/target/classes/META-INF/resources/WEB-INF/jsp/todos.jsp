<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<%@ include file = "common/header.jspf"%>
	<%@ include file = "common/navigation.jspf"%>
	
	<div class = "container">
	    <h1>Your todos are:</h1>
	    <br>
	    <table class = "table">
	        <thead>
	            <tr>
	                
	                
	                <th>Description</th>
	                <th>Target Date</th>
	                <th>Done?</th>
					<th>Delete</th>
					<th>Update</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${todos}" var="todo">
	                <tr>
	                    
	                    <td>${todo.description}</td>
	                    <td>${todo.targetDate}</td>
	                    <td>${todo.done}</td>
						<td ><a href = "delete-button?id=${todo.id}" class = "btn btn-warning">Delete </td>
						<td><a href = "update-button?id=${todo.id}" class = "btn btn-success">Update</td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table> 
		<a href = "add-Todo" class = "btn btn-success"> Add Todo </a>
	</div>
	<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>  
	<script src = "/META-INF/resources/webjars/jquery/3.6.0/jquery.min.js"></script> 
	
</body>
</html>