<%-- 
    Document   : home
    Created on : May 9, 2023, 10:16:06 AM
    Author     : pc asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <!-- Customized Bootstrap Stylesheet -->
        <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/search.js"></script>
	
    </head>
    <body>
        
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Products Start -->
            <div class="container-fluid pt-5">
                <div class="text-center mb-4">
                    <h2 class="section-title px-5"><span class="px-2">All Products</span></h2>
                </div>
                <div class="row px-xl-5 pb-3">
                    <c:forEach var="tempProduct" items="${productList}">
                    <c:url var="linkImage" value="/resources/img/${tempProduct.image}">
					</c:url>
                    
                    <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                        <div class="card product-item border-1 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0" style="height: 300px">
                                <img class="img-fluid w-100" src="${linkImage}" alt="" >
                            </div>
                            <div class="card-body border-left border-right text-start p-0 pt-4 pb-3" style="height: 175px">
                                <h6 class="text-truncate mb-3">${tempProduct.name}</h6>
                                <div class="d-flex justify-content-sm-between">
                                    <h6>Price: </h6><h6 style="color: red">${tempProduct.price}$</h6>
                                </div>
                                <div class="d-flex justify-content-sm-between">
                                    <h6>Author: </h6><h6 style="color: red">${tempProduct.seller}</h6>
                                </div>
                                
                            </div>
                            <div class="card-footer d-flex justify-content-between bg-light border-1">
                                <a href="${pageContext.request.contextPath}/products/${tempProduct.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                <a href="${pageContext.request.contextPath}/cart/addToCart?id=${tempProduct.id}" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    </body>
</html>
