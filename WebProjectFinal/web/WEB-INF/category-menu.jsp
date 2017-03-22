<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="lead">Bike Web</p>
<c:forEach items="${categories}" var="category">
   <span><a href="/BikeFormServlet?categoryid=${category.categoryId}">${category.categoryName}</span>
    
</c:forEach>