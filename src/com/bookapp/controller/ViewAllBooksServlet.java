package com.bookapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

@WebServlet("/ViewAllBooksServlet")
public class ViewAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		User user = new User();
		
		UserDAO dao=new UserDAO();
		List<User> booklist=new ArrayList<>();
		try {
			booklist = dao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("Welcome.jsp");
			
		}
		 if (booklist.size()>0)
	{
		RequestDispatcher rd= request.getRequestDispatcher("View All Books.jsp");
		request.setAttribute("books", booklist);
		rd.forward(request, response);
		
	}
		 else
		 {
			 response.sendRedirect("Welcome.jsp");
		 }

		
	}

}
