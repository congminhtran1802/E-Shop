<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<div class="row align-items-center py-3 px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a href="${pageContext.request.contextPath}" class="text-decoration-none">
				<h1 class="m-0 display-5 font-weight-semi-bold">
					<span class="text-primary font-weight-bold border px-3 mr-1">MTH</span>Shop
				</h1>
			</a>
		</div>
		<div class="col-lg-6 col-6 text-left">
			<form:form action="search" method="GET" id="searchForm">
				<div class="input-group">
					<input type="text" id="searchInput" name="theSearchName"
						class="form-control" placeholder="Search for products">
					<div class="input-group-append">
						<span class="input-group-text bg-transparent text-primary">
							<button type="submit" style="border: none;" id="searchButton">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</form:form>
		</div>
		<div class="col-lg-3 col-6 text-right">
			<c:if test="${sessionScope.account != null}">
               ${sessionScope.account.username}
              
                     
                    
               
                 
            </c:if>
			<a href="" class="btn border"> <i
				class="fas fa-heart text-primary"></i> <span class="badge">0</span>
			</a> <a href="${pageContext.request.contextPath}/cart/list"
				class="btn border"> <i class="fas fa-shopping-cart text-primary"></i>
				<span class="badge divcart"> <c:choose>
						<c:when test="${not empty sessionScope.cartList}">
							<c:set var="totalItems" value="0" />
							<c:forEach var="cartItem" items="${sessionScope.cartList}">
								<c:set var="totalItems"
									value="${totalItems + cartItem.quantity}" />
							</c:forEach>
				            ${totalItems}
				        </c:when>
						<c:otherwise>
				            0
				        </c:otherwise>
					</c:choose>
			</span>

			</a>
		</div>
	</div>
</div>
<!-- Topbar End -->


<!-- Navbar Start -->
<div class="container-fluid">
	<div class="row border-top px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a
				class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
				data-toggle="collapse" href="#navbar-vertical"
				style="height: 65px; margin-top: -1px; padding: 0 30px;">
				<h6 class="m-0">Categories</h6> <i
				class="fa fa-angle-down text-dark"></i>
			</a>
			<nav
				class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
				id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
				<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
					<a href="${pageContext.request.contextPath}/products/filter/Book" class="nav-item nav-link">Book</a> <a href="${pageContext.request.contextPath}/products/filter/Accessory"
						class="nav-item nav-link">Accessory</a>
				</div>
			</nav>
		</div>
		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
				<a href="" class="text-decoration-none d-block d-lg-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
					</h1>
				</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="${pageContext.request.contextPath}/products/list"
							class="nav-item nav-link active">Home</a> <a
							href="${pageContext.request.contextPath}/order/list"
							class="nav-item nav-link">Order History</a>
							
							<a href="${pageContext.request.contextPath}/order/confirm-list"
								class="nav-item nav-link">Order Confirm
								<c:if test="${not empty sessionScope.orderConfirmTotal && sessionScope.orderConfirmTotal ne 0}">
								<span class="order-count">${sessionScope.orderConfirmTotal}</span>
								</c:if>
							</a>
							
					</div>
					<div class="navbar-nav ml-auto py-0">
						<c:if test="${sessionScope.account == null}">
							<a class="nav-item nav-link "
								href="${pageContext.request.contextPath}/user/login">Login</a>
						</c:if>
						<c:if test="${sessionScope.account != null}">
							<a class="nav-item nav-link"
								href="${pageContext.request.contextPath}/admin/list">Manage
								Product</a>
							<a href="${pageContext.request.contextPath}/user/login"
								class="nav-item nav-link">Logout</a>
						</c:if>

					</div>
				</div>
			</nav>
		</div>
	</div>
</div>