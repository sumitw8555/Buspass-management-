package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.validation;
@WebServlet("/firstlink")
public class loginpage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		

		validation v1=new validation();
	     boolean status=v1.Validation(user, password);
	     if(status) {
	    	 resp.sendRedirect("createpass.html");
	     }else {
	    	 resp.sendRedirect("index.html");
	     }
		}

		
	}


