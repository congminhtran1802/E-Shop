<%-- 
    Document   : login
    Created on : May 17, 2023, 8:37:37 PM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
          <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </head>
    <body>
        
	<div class="container">
		<h2>Login</h2>

		<form action="login" method="post" class="login_form">
			<div class="login_form--input">
				<label>Email address</label>
				<input type="text" name="login-username" class="form-control" placeholder="Enter username">
			</div>
			<div class="login_form--input">
				<label>Password</label>
				<input type="password" name="login-password" class="form-control" placeholder="Password">
			</div>
			<div class="login_btn">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
			<p class="forgot-password">Quên mật khẩu?</p>
			<p class="register-link">Chưa có tài khoản? <a href="#">Đăng ký ngay</a></p>
		</form>
	</div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
   
</html>
