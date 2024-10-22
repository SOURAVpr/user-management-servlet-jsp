<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstraplink.jsp"%>
<style type="text/css">
	.paint-card{
		box-shadow: 0px 0px 10px 0px gray;
	}
</style>
</head>
<% User user1 = (User) session.getAttribute("userObj"); 
	if(user1 == null){
		response.sendRedirect("login.jsp");
	}
	else{
%>
<body>
<%@ include file="components/usernavbar.jsp" %>
<% 
	int id= Integer.parseInt(request.getParameter("id"));
	UserDao dao = new UserDao();
	User user = dao.fetchUserById(id);
%>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card" >
					<div class="card-body">
					<p class="fs-4 text-center"><%=user.getName()%>'s Profile</p>
					
					<%-- <p class="fs-4 text-center-success"><%=  %></p> --%>
						<form action="update_profile" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label>
								<input name="name" type="text" class="form-control" value="<%=user.getName()%>" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label>
								<input name="age" type="text" class="form-control" value="<%=user.getAge()%>" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label>
								<input name="email" type="email" class="form-control" value="<%=user.getEmail()%>" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input name="password" type="password" class="form-control" value="<%=user.getPassword()%>" required>					
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label>
								<input name="mobile" type="text" class="form-control" value="<%=user.getMobile()%>" required>					
							</div>
							<button type="submit" class="btn bg-secondary text-white col-md-12">Update</button>
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%} %>
</html>