package com.org.dao;
//it is app an where we can perform all the crud application and we can do registration and login
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.org.dto.User;

public class UserDao {

	public void saveUser(User user) {
//		insert
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
			pstmt = con.prepareStatement("INSERT INTO user_table(name, age, email, password, mobile) VALUES(?,?,?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getMobile());
			int row = pstmt.executeUpdate();
//			System.out.println(row + " row is inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public User fetchUserById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
			pstmt = con.prepareStatement("SELECT * FROM user_table WHERE id="+id);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				String name = rst.getString("name");
				int age = rst.getInt("age");
				String email = rst.getString("email");
				String password = rst.getString("password");
				long mobile = rst.getLong("mobile");
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(mobile);
				return user;
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<User> fetchAllUsers() {
		
		User user = new User();
		List<User> allUsers = new ArrayList<>();		
		try {
//		load and register
			Class.forName("com.mysql.cj.jdbc.Driver");
//			esta
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM user_table");
			ResultSet rst = stmt.executeQuery();
			while(rst.next()) {
				
				int id = rst.getInt("id");
				String name = rst.getString("name");
				int age = rst.getInt("age");
				String email = rst.getString("email");
				String password = rst.getString("password");
				long mobile = rst.getLong("mobile");
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(mobile);
				
				allUsers.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allUsers;
	}

	public void updateUserById(int id, User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//		establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
//		create statement
//			PreparedStatement stmt = con.prepareStatement("select * from student where (email='"+email+"')");
			PreparedStatement stmt = con.prepareStatement("update user_table set name=?,age=?,mobile=?,email=? where id=?");
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAge());
			stmt.setLong(3, user.getMobile());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, id);
//		execute query
			int i = stmt.executeUpdate();
			

			
						
//		close connection
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUserById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//		establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
//		create statement
//			PreparedStatement stmt = con.prepareStatement("select * from student where (email='"+email+"')");
			PreparedStatement stmt = con.prepareStatement("delete from user_table where id=?");
			stmt.setInt(1, id);
//		execute query
			int i = stmt.executeUpdate();
			
			
//		close connection
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		
//		load and register driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//		establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management?user=root&password=root");
//		create statement
//			PreparedStatement stmt = con.prepareStatement("select * from student where (email='"+email+"')");
			PreparedStatement stmt = con.prepareStatement("select * from user_table where (email=? and password=?)");
			stmt.setString(1, email);
			stmt.setString(2, password);
//		execute query
			ResultSet rst = stmt.executeQuery();
			
			if(rst.next()) {
//				System.out.println("Login successful");
				int id = rst.getInt("id");
				String name = rst.getString("name");
				int age = rst.getInt("age");
				long mobile = rst.getLong("mobile");
				
				
				User user = new User();
				user.setId(id);
				user.setAge(age);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setMobile(mobile);
				
				return user;
			}
						
//		close connection
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
