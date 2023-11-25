<%-- 
    Document   : admin
    Created on : May 17, 2023, 8:44:08 PM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
         <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </head>
    <body>
	<div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="table-responsive mb-5">
                    <input type="submit" value="Add Product"
               onclick="window.location.href = 'showFormAdd';
                           return
                           false;"
               class="add-book-button"/>
        <button><a href="${pageContext.request.contextPath }/products/list" style="text-decoration: none; color:black">Back to list</a></button>
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                <th scope="col">ID</th>
                <th scope="col">Image</th>
                <th scope="col">Name</th>
                <th scope="col">Seller</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col" colspan="2">Action</th>
            </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:forEach var="tempProduct" items="${productlist}">
                            <c:url var="updateLink" value="/admin/showFormForUpdate">
						<c:param name="productId" value="${ tempProduct.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/admin/delete">
						<c:param name="productId" value="${ tempProduct.id}"></c:param>
					</c:url>
                 <c:url var="linkImage" value="/resources/img/${tempProduct.image}">
					</c:url>
                                <tr>
                            <td class="align-middle">${tempProduct.id}</td>
                            <td class="align-middle"><img  src="${linkImage}"width="50px" height="50px"/></td>
                            <td class="align-middle">${tempProduct.name}</td>
                            <td class="align-middle">${tempProduct.seller}</td>
                            <td class="align-middle">${tempProduct.category}</td>
                            <td class="align-middle">${tempProduct.price}</td>
                            <td><button class="col-lg-6 mb-4 border-0 mx-1 bg-info"><a href="${updateLink}" style="color:white;">Update</a></button></td>
                            <td><button class="col-lg-6 mb-4 border-0 bg-danger"> <a href="${deleteLink}" style="color:white;"
                                                                                 onclick="if (!(confirm('Sure?')))
                                               return false"

                                                                                 >Delete</a></button></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>
