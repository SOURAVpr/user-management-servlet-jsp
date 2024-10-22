<%@page import="com.org.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

<%@ include file="components/bootstraplink.jsp"%>
<!-- Bootstrap CSS link -->
<style type="text/css">
	.paint-card{
		box-shadow: 0px 0px 10px 0px gray;
	}
</style>
</head>
<body>
<% User user1 = (User) session.getAttribute("userObj"); 
	if(user1 == null){
		response.sendRedirect("login.jsp");
	}
	else{
%>
	<%@ include file="components/usernavbar.jsp"%>
	<!-- Navigation bar -->
	<h1 class="text-center">Welcome to Home Page</h1>

	<%
	UserDao dao = new UserDao();
	List<User> list = dao.fetchAllUsers(); // Fetch all users from the database
	%>

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<table class="table">
							<thead>
								<tr>
									<!-- <th>ID</th> -->
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<!-- <th>Password</th> -->
									<th>Mobile</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (User user : list) {
								%>
								<tr>
									<%-- <td><%= user.getId() %></td> --%>
									<td><%=user.getName()%></td>
									<td><%=user.getAge()%></td>
									<td><%=user.getEmail()%></td>
									<%-- <td><%= user.getPassword() %></td> --%>
									<td><%=user.getMobile()%></td>
									<td>
									 <a class="btn btn-md btn-primary" href="profile.jsp?id=<%=user.getId()%>">Update</a>
									 <a class="btn btn-md btn-danger" href="delete_profile?id=<%=user.getId()%>">Delete</a> 
									</td>
								</tr>
								<%} %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	</table>
	</div>
<% } %>
</body>
</html>
