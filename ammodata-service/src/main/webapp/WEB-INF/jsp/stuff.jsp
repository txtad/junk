<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

	<title>Hi!</title>
	<body>Hi
	
	<c:forEach items="${recipes}" var="recipe">
		<p><c:out value="${recipe.recipeID}" /> - <c:out value="${recipe.name}" /></p>
	</c:forEach>
	
	
	<form:form modelAttribute="recipe">
	
		<form:input path="name" />
		<form:button value="submit" />
	</form:form>
	
	!</body>
</html>