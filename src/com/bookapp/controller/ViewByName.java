package com.bookapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/ViewByName")
public class ViewByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("name");
		
		User user = new User();
		user.setName(name);
		
		UserDAO dao =new UserDAO();
		
		List<User> b;
		try {
			b = dao.findByName();
			if(b.size()>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("View By Name.jsp");
				request.setAttribute("foundbooks", b);
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("Welcome.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Welcome.jsp");
			
		}
		
		
	}

}
