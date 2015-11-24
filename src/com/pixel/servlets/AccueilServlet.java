package com.pixel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;

import com.pixel.sessions.PanierBean;
import com.pixel.tools.Banque;
=======
>>>>>>> branch 'master' of https://github.com/Vivien-Michel/PIXEL-SHIRT.git

@WebServlet(urlPatterns = { "/Accueil" })
public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = 2476044219517722019L;
	private static final String VUE = "/WEB-INF/accueil.jsp";
	public static final String KEY_SESSION_BEAN = "panier";
	// Initialisation (instance sur server)unique de la banque de l'entreprise pour tout les clients
	public static final Banque banque = new Banque("Pixel_Shirt","Pixel_Shirt");

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
