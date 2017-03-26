<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="lead">Bike Web</p>
<c:forEach items="${categories}" var="category">
   <a href="/bikes.html?categoryid=${category.categoryId}">${category.categoryName}
    
</c:forEach>