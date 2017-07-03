package com.bookapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/ChangeBookPriceServlet")
public class ChangeBookPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		User user = new User();
		user.setName(name);
		user.setPrice(price);
		
		UserDAO dao =new UserDAO();
		try {
			dao.updateprice(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Welcome.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
