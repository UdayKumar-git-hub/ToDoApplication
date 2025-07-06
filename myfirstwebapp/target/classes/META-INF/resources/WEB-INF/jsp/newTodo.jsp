<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<%@ include file = "common/header.jspf"%>
	<%@ include file = "common/navigation.jspf"%>
	
	<div class = "container">
	<h1>Add New Todo:</h1>
	<form:form method = "post" modelAttribute = "todoDesc">
		
					<fieldset class = "mb-3">
						<form:label path = "description">Description</form:label>
						<form:input type = "text" path = "description" required = "required"/>
		             	<form:errors path = "description" cssClass = "text-warning"/>
					</fieldset>		
				
					
					<fieldset class = "mb-3">	
								
						<form:label path = "targetDate">Target Date</form:label>
						<form:input type = "text" path = "targetDate" required = "required"/>
						<form:errors path = "targetDate" cssClass = "text-warning"/>
					</fieldset>
					
						<input type = "Submit" class = "btn btn-success">
						
		</form:form>
		</div>
	<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>  
	<script src = "webjars/jquery/3.6.0/jquery.min.js"></script> 
	<script src = "webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>
</body>
</html>