<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/head.jsp"%>
<body>
	<%@include file="/WEB-INF/header.jsp"%>
	<div class="container">
		<form method="post" action="<c:url value="/category-form"/>" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="p-username">User Name</label></td>
					<td><input type="text" id="p-username" name="p-username"></td>
				</tr>
				
				<tr>
					<td><label for="p-password">Password</label></td>
					<td><input type="text" id="p-password" name="p-password"></td>
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