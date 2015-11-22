package com.pixel.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pixel.sessions.ClientDAO;
import com.pixel.sessions.PanierBean;

/**
 * Servlet implementation class Panier
 */

@WebServlet("/Panier/Gestion")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/panierGestion.jsp";
	private static final String ATT_ART= "listeArticles";
	private static final String ATT_TOT = "total";
	private static final String ATT_Q = "quantite";
	private static final String ATT_ART_ID = "article_id";
	private static final String ATT_CLIENT = "client";
	
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
		HttpSession session = request.getSession(true);
		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		
		request.setAttribute(ATT_CLIENT, panier.getClient());
		request.setAttribute(ATT_ART, panier.getArticles());
		request.setAttribute(ATT_TOT, panier.getTotal());
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PanierBean panier = (PanierBean) session.getAttribute(AccueilServlet.KEY_SESSION_BEAN);
		
		// Recupération du paramètre article_id dans la balise input de type "hidden" du fichier panierGestion.jsp
		String article_id = request.getParameter(ATT_ART_ID);
		if (request.getParameter(ATT_Q) != null) {
			// Recupération du paramètre quantite dans le fichier panierGestion.jsp
			String q = request.getParameter(ATT_Q);
			int quantite = Integer.parseInt(q);
			// Update panier (ID,TOTAL,QUANTITE)
			panier.update(article_id,quantite);

	    } else if (request.getParameter("supprimer") != null) {
	          panier.supprimer(article_id);
	    } 
		if(request.getParameter("supprimerCompte") != null){
	    	user.supprimer(panier.getClient());
	    	panier.getPanier().setClient(null);
	    	panier.remove();
	    	session.removeAttribute(AccueilServlet.KEY_SESSION_BEAN);
	    	response.sendRedirect("/Pixel_Shirt/Articles");
	    }else{
	    	request.setAttribute(ATT_CLIENT, panier.getClient());
			request.setAttribute(ATT_ART, panier.getArticles());
			request.setAttribute(ATT_TOT, panier.getTotal());
	    	getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
	}

}
