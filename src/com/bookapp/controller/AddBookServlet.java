package com.bookapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		User user =new User();
		user.setName(name);
		user.setPrice(price);
		
		UserDAO dao = new UserDAO();
		 try {
			dao.update(user);
			response.sendRedirect("Welcome.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		
	}

}
