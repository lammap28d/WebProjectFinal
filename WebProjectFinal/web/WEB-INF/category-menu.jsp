<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="lead">Bike Web</p>
<c:forEach items="${categories}" var="category">
    <div> 
        <a href="<c:url value="/bikes.html?categoryId=${category.categoryId}"/>">${category.categoryName}
   </a>    
    </div>
</c:forEach>