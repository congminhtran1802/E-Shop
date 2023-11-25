<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add Book</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-book.css">
</head>
<body>
<button><a href="${pageContext.request.contextPath }/admin/list" style="text-decoration: none; color:black">Back to list</a></button>
    <h1>Add a Book</h1>
    <form:form action="add" modelAttribute="product"
				method="POST" enctype="multipart/form-data">
				<form:hidden path="image"/>
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><lable>Name</lable></td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><lable>Category</lable></td>
							<td><form:input path="category" /></td>
						</tr>
						<tr>
							<td><lable>Price</lable></td>
							<td><form:input path="price" /></td>
						</tr>
						<tr>
							<td><lable>Description</lable></td>
							<td><form:input path="description" /></td>
						</tr>
						<tr>
							<td><label for="imageFile">Image:</label></td>
        					<td><input type="file" id="imageFile" name="imageFile" required></td>
						</tr>
						<tr>
						<td></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
</body>
</html>
