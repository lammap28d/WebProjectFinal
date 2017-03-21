<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html>

<%@ include file="/WEB-INF/head.jsp"%>

<%@include file="/WEB-INF/header.jsp"%>
<c:url value='/resources/3rdParty/ckeditor' var="url"/>
<form method="post" action="<c:url value="/bike-form.jsp?action=update"/>" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label for="p-name">Product Name</label></td>
            <td><input type="text" id="p-name" name="p-name" value="${bike.bikeName}"></td>
        </tr>
        <tr>
            <td><label for="p-price">Product Price</label></td>
            <td><input type="number" id="p-price" name="p-price" value="${bike.price}" ></td>
        </tr>
        <tr>
            <td><label for="p-name">Product Description</label></td>
            <td> <textarea cols="80" id="p-description" name="p-description" rows="10" value="${bike.description}"></textarea></td>


        </tr>
        <tr>
            <td><label for="p-name">Product Brand</label></td>
            <td><input type="text" id="p-brand" name="p-brand" value="${bike.brand}"></td>                                     
        </tr>          
        <tr>
            <td><label for="p-name">Product Color</label></td>
            <td><input type="text" id="p-color" name="p-color" value="${bike.color}"></td>                                     
        </tr>          
        <tr>
            <td><label for="p-img">Product Image</label></td>
            <td><input type="file" id="p-img" name="p-img" value="${bike.imageBase64}"></td>
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
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>
<ckeditor:replace replace="p-description" basePath="${url}" />

<div class="container">
    <%@include file="/WEB-INF/footer.jsp"%>
</div>


