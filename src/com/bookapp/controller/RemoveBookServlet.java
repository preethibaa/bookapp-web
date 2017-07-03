package com.bookapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("name");
		
		User user = new User();
		user.setName(name);
		
		UserDAO dao =new UserDAO();
		try {
			dao.delete(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Welcome.jsp");
		}
		
		
		
	}

}
