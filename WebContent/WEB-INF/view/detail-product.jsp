<%-- 
    Document   : detail-book
    Created on : May 10, 2023, 5:53:52 PM
    Author     : pc asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<!-- Customized Bootstrap Stylesheet -->
<link rel="stylesheet"
	href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/modules/2c5504ab9a86164db22a92dc8793843d.min.css">
<link rel="stylesheet" id="roboto-subset.css-css"
	href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5"
	type="text/css" media="all">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid py-5">
		<div class="row px-xl-5">
			<div class="col-lg-5 pb-5">
				<img class="img-fluid w-100"
					src="${pageContext.request.contextPath}/resources/img/${product.image}"
					alt="">
			</div>

			<div class="col-lg-7 pb-5">
				<h3 class="font-weight-semi-bold">${product.name}</h3>
				<div class="d-flex mb-3">
					<div class="text-primary mr-2">
						<small class="fas fa-star"></small> <small class="fas fa-star"></small>
						<small class="fas fa-star"></small> <small
							class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
					</div>
					<small class="pt-1">(50 Reviews)</small>
				</div>
				<h3 class="font-weight-semi-bold mb-4">${product.price}$</h3>
				<h3 class="font-weight-semi-bold mb-4">Seller:
					${product.seller}</h3>
				<h5 class="font-weight-semi-bold mb-4">Category:
					${product.category}</h5>
				<p class="mb-4">
					<b>Product Description:</b> ${product.description}
				</p>
				<div class="d-flex align-items-center mb-4 pt-2">
					<div class="input-group quantity mr-3" style="width: 130px;">
						<div class="input-group-btn">
							<button class="btn btn-primary btn-minus">
								<i class="fa fa-minus"></i>
							</button>
						</div>
						<input type="text" class="form-control bg-secondary text-center"
							value="1">
						<div class="input-group-btn">
							<button class="btn btn-primary btn-plus">
								<i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<button class="btn btn-primary px-3 btn-checkout">
						<a
							href="${pageContext.request.contextPath}/cart/addToCart?id=${product.id}"><i
							class="fa fa-shopping-cart mr-1"></i> Add To Cart</a>
					</button>
				</div>
				<div class="d-flex pt-2">
					<p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
					<div class="d-inline-flex">
						<a class="text-dark px-2" href=""> <i
							class="fab fa-facebook-f"></i>
						</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-linkedin-in"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-pinterest"></i>
						</a>
					</div>
				</div>
			</div>
		</div>


		<!--         Review -->


		<section style="background-color: #e7effd;">
			<div class="container my-5 py-5">
				<div class="row d-flex justify-content-center">
					<div class="col-md-12 col-lg-10">
						<div class="card text-dark">
							<div class="card-body p-4">
								<div class="text-center mb-4">
									<h2 class="section-title px-5">
										<span class="px-2">Reviews</span>
									</h2>
								</div>
								<c:if test="${checkOrder}">
									<form:form action="/BookShopSpring/review/add/${product.id}"
										modelAttribute="review" method="POST" accept-charset="UTF-8">
										<div class="card-footer py-3 border-0"
											style="background-color: #f8f9fa;">
											<div class="d-flex flex-start w-100">
												<img class="rounded-circle shadow-1-strong me-3"
													src="${pageContext.request.contextPath}/resources/img/acc.png"
													alt="avatar" width="40" height="40" />
												<div class="form-outline w-100">
													<textarea class="form-control" id="textAreaExample"
														rows="4" style="background: #fff;" name="content"></textarea>
													<label class="form-label" for="textAreaExample">Message</label>
												</div>
											</div>
											<div class="d-flex justify-content-between mt-3">
												<div></div>
												<input type="submit" value="Send" class="save" />
											</div>
										</div>
									</form:form>
									<br>
								</c:if>
								<c:forEach var="tempReview" items="${reviews}">
									<div class="d-flex flex-start">
										<img class="rounded-circle shadow-1-strong me-3"
											src="${pageContext.request.contextPath}/resources/img/acc.png"
											alt="avatar" width="60" height="60" />
										<div>
											<h6 style="margin-left: -10px;" class="fw-bold mb-1">${tempReview.userName}</h6>
											<div class="mb-3">
												<p class="mb-0">${tempReview.reviewDate}</p>
											</div>
											<p class="mb-3">${tempReview.content}</p>
										</div>
									</div>
								</c:forEach>
							</div>


						</div>
					</div>
				</div>
			</div>
		</section>


	</div>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
