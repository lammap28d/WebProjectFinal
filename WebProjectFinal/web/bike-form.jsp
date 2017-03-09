<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/head.jsp"%>
<body>
	<%@include file="/WEB-INF/header.jsp"%>
	<div class="container">
		<form method="post" action="<c:url value="/bike-form"/>" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="p-name">Product Name</label></td>
					<td><input type="text" id="p-name" name="p-name"></td>
				</tr>
				<tr>
					<td><label for="p-price">Product Price</label></td>
					<td><input type="number" id="p-price" name="p-price"></td>
				</tr>
                                <tr>
					<td><label for="p-name">Product Description</label></td>
					<td><input type="text" id="p-description" name="p-description"></td>                                     
				</tr>
                                 <tr>
					<td><label for="p-name">Product Brand</label></td>
					<td><input type="text" id="p-brand" name="p-brand"></td>                                     
				</tr>          
                                 <tr>
					<td><label for="p-name">Product Color</label></td>
					<td><input type="text" id="p-color" name="p-color"></td>                                     
				</tr>          
				<tr>
					<td><label for="p-img">Product Image</label></td>
					<td><input type="file" id="p-img" name="p-img"></td>
				</tr>
				<tr>
					<td><label for="p-category">Category</label></td>
					<td><select name="p-category" id="p-category">
                                    <c:forEach items="${categories}" var="category">
                                    	<option value="${category.categoryId}">${category.categoryName}</option>
                                    </c:forEach>
							
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="container">
		<%@include file="/WEB-INF/footer.jsp"%>
	</div>
</body>
</html>
