<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add Book</title>
</head>
<body>
    <h1>Add a Book</h1>
    <form:form modelAttribute="book" method="POST" action="add" enctype="multipart/form-data">
        <label for="title">Title:</label>
        <form:input path="title" id="title" required="true" /><br>
        <label for="author">Author:</label>
        <form:input path="author" id="author" required="true" /><br>
        <label for="publisherDate">Publication Date:</label>
        <form:input path="publisherDate" id="publisherDate" type="date" required="true" /><br>
        <label for="category">Category:</label>
        <form:input path="category" id="category" required="true" /><br>
        <label for="price">Price:</label>
        <form:input path="price" id="price" required="true" /><br>
        <label for="description">Description:</label>
        <form:textarea path="description" id="description" required="true" /><br>
        <label for="imageFile">Image:</label>
	    <input type="file" name="imageFile" id="imageFile" required="true" /><br>
	    <input type="submit" value="Add Book">
    </form:form>
</body>
</html>
