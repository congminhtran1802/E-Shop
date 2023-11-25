<%-- 
    Document   : order-confirm
    Created on : May 24, 2023, 7:44:01 AM
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
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Page Header Start -->
            <div class="container-fluid bg-secondary mb-5">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Order Confirm</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="${pageContext.request.contextPath}/products/list">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Order Confirm</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Cart Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Buyer</th>
                                    <th>Order Date</th>
                                    <th colspan="2">Action</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:forEach var="tempOrder" items="${orderlist}">
                                <tr>
                                    <c:forEach var="tempProduct" items="${productList}">
                                    <c:url var="linkImage" value="/resources/img/${tempProduct.image}">
									</c:url>
                                        <c:if test="${tempOrder.productId == tempProduct.id}">
                                            <td class="align-middle"><img src="${linkImage}" alt="" style="width: 100px;">${tempProduct.name}</td>
                                            <td class="align-middle">${tempProduct.price}$</td>
                                        </c:if>
                                    </c:forEach>
                            <td class="align-middle">${tempOrder.quantity}</td>
                            <td class="align-middle">${tempOrder.totalAmount}$</td>
                            <td class="align-middle">${tempOrder.buyer}$</td>
                            <td class="align-middle">${tempOrder.orderDate}</td>
                            <td><button class="btn btn-block btn-primary my-3 py-3 btn-checkout"><a href="${pageContext.request.contextPath}/order/confirm-list/${tempOrder.id}">Confirm Order</a></button></td>
                            <td><button class="btn btn-block btn-primary my-3 py-3 btn-checkout"><a href="${pageContext.request.contextPath}/order/cancel/${tempOrder.id}">Cancel Order</a></button></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Cart End -->


        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
