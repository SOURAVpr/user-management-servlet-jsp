<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstraplink.jsp" %>
<style type="text/css">
	.paint-card{
		box-shadow: 0px 0px 10px 0px gray;
	}
</style>
</head>
<body>
<%@ include file="components/indexnavbar.jsp" %>
	<!-- <h1 style="text-align: center">Register Page</h1> -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card" >
					<div class="card-body">
					<p class="fs-4 text-center">User Registration</p>
					<%-- <% 
						String msg = (String)session.getAttribute("msg");
						if(msg!=null){ %>
							
					<% 
						}%>
					<p class="fs-4 text-center-success"><%= msg %></p> --%>
						<form action="registration" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label>
								<input name="name" type="text" class="form-control" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label>
								<input name="age" type="text" class="form-control" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label>
								<input name="email" type="email" class="form-control" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input name="password" type="password" class="form-control" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label>
								<input name="mobile" type="text" class="form-control" required>					
							</div>
							<button type="submit" class="btn bg-secondary text-white col-md-12">Register</button>
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>