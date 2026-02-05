package org.travy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.travy.appmodel.Model;
import org.travy.entity.Userdets;

@WebServlet("/sitecont")
public class Sitecont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String page = request.getParameter("page");
	
	 switch (page) {
	case "Listuser": {
		
		Listuser(request, response);
		
		break;
	}
    case "Adduser": {
		
		Adduser(request, response);
		
		break;
	}
    
     case "updateuser": {
		
    	 Updateuser(request, response);
		
		break;
	}
    
     case "deleteuser": {
    	 
 	   new Model().Deleteuser(Integer.parseInt(request.getParameter("user_id")));
    	 Listuser(request, response);
    	 
		
		break;
	}
    
     
	default:
		
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String form = request.getParameter("form");
	  
	  switch (form) {
	case "operate": {
		
		Userdets detail = new Userdets(request.getParameter("username"), request.getParameter("email"));
		new Model().Adduser(detail);
		Listuser(request, response);
		
		break;
	}
	
     case "updateuseroperation": {
    	 
		Userdets updetails = new Userdets(Integer.parseInt(request.getParameter("user_id")),   request.getParameter("username"), request.getParameter("email"));
		new Model().updateuser(updetails);
		Listuser(request, response);
		
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + form);
	}
		
		
	}
	
    protected void Listuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setAttribute("title", "Listuser");
		List<Userdets> use = new Model().Userme();
		request.setAttribute("Listuser", use);
		
		request.getRequestDispatcher("Listuser.jsp").forward(request, response);
	
    	
	}
    
    protected void Adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	request.setAttribute("title", "Adduser");
    	
    	request.getRequestDispatcher("adduser.jsp").forward(request, response);
	
    	
	}
    
 protected void  Updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	request.setAttribute("title", "Updateuser");
    	
    	request.getRequestDispatcher("update.jsp").forward(request, response);
	
    	
	}
 
 

}
