package com.bookapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		user.setEmailId(email);
		user.setPassword(password);

		UserDAO dao = new UserDAO();
		try {
			boolean flag = dao.login(user);
			if (flag) {
				response.sendRedirect("Welcome.jsp");
			} else {
				response.sendRedirect("Home.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Home.jsp");
		}

	}

}
