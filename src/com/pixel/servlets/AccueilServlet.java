package com.pixel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Accueil" })
public class AccueilServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2476044219517722019L;
	private static final String VUE = "/WEB-INF/accueil.jsp";
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
