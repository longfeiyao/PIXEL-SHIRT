package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pixel.form.PanierForm;
import com.pixel.sessions.ClientDAO;
import com.pixel.sessions.PanierBean;

/**
 * Servlet implementation class Panier
 */

@WebServlet("/Panier/Gestion")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/panierGestion.jsp";
	
	@EJB
    ClientDAO user;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		
		PanierForm form = new PanierForm(user);
		form.update(request,panier);
		
		if(form.supprimerCompte()){
			session.invalidate();
	    	response.sendRedirect("/Pixel_Shirt/Articles");
	    }else{
	    	getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
	}

}
